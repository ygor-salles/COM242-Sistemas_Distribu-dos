import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class VerifyStatusServer implements MqttCallback{

	//M�todo chamado quando cai a conex�o com o servidor
	public void connectionLost(Throwable throwable) {
		System.out.println("Sem conex�o com o servidor");
	}
	
	//M�todo chamado quando chega uma mensagem do broker
	public void messageArrived(String s, MqttMessage mqttMessage) throws Exception{
		
		//Recebe a mensagem do broker
		String message = new String(mqttMessage.getPayload());
		System.out.println("Mensagem:\t" + message);
		
		//TODO "3+9-8"
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    
	    try {
			//System.out.println(engine.eval(message));
			JOptionPane.showMessageDialog(null, engine.eval(message), "Resultado",
					JOptionPane.INFORMATION_MESSAGE);
			
			//Instancia classe para enviar o resultado para Envia_Calculo
			PublisherSendResult publisherSendResult = 
					new PublisherSendResult(engine.eval(message).toString());
			
			//tratamento para envio de mensagem
			try {
				//chama m�todo da classe PublisherEnviarResultado para enviar a mensagem
				publisherSendResult.enviarMensagemResultado();	
			}catch(MqttException e) {
				//imprime exce��o no console
				System.out.println(e);
			}
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//M�todo chamado quando a entrega da mensagem foi conclu�da e todas as confirma��es foram recebidas
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
	}
}
