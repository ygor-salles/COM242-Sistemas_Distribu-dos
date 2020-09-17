package envia_soma;

import javax.swing.JOptionPane;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Subscriber implements MqttCallback {
	
	//Método chamado quando cai conexão com o serviodr	
	public void connectionLost(Throwable throwable) {
		System.out.println("Sem conexão com o sevidor!");
	}
	
	//Método invocado quando chega uma mensagem do broker
	public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {	
		
		//Recebe a mensagem do broker
		String mensagem = new String(mqttMessage.getPayload());

		//Exibe resultado na tela
		//JOptionPane.showMessageDialog(null, mensagem ,"Resultado Recebido",
				//JOptionPane.INFORMATION_MESSAGE);			
	}
	
	//Chamado quando a entrega de uma mensagem foi concluída e todas as 
	//confirmações foram recebidas
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {		
	}			
}
