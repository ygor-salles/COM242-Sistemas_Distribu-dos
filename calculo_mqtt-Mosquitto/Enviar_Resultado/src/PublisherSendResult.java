
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class PublisherSendResult {

	//String que enviar� a conta para o outro sistema
    String message;
    
    //Construtor da classe
	public PublisherSendResult(String msg){
		this.message = msg;
	}

	//M�todo para enviar a mensagem para o mosquitto
	public void enviarMensagemResultado() throws MqttException {
		
		//Local para onde ser� enviado a mensagem (broker)
		ConfigServer endIp = new ConfigServer();
		
		MqttClient client = new MqttClient(endIp.getEnderecoServidor(),
				MqttClient.generateClientId());
		
		//abre conex�o com o broker (Mosquitto)
		client.connect();
		
		//objeto de envio de mensagem do broker
		MqttMessage mqttMessage = new MqttMessage();
		
		//Payload, conteudo da mensagem que ser� enviada ao broker
		mqttMessage.setPayload(message.getBytes());
		
		//QoS - A mensagem � sempre entregue exatamente uma vez.
		mqttMessage.setQos(2);
		
		//Mensagem ficar� retida no Broker (ultima mensagem fica retida)
		mqttMessage.setRetained(true);
		
	    //Publica a mensagem, com seu t�pico (para algu�m se inscrever neste t�pico) e a mensagem montada
	    client.publish("enviar_resultado", mqttMessage);
	    
	    //Encerra conex�o
	    client.disconnect();
	}	
}
