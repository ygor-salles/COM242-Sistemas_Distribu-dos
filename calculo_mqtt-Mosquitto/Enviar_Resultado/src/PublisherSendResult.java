
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class PublisherSendResult {

	//String que enviará a conta para o outro sistema
    String message;
    
    //Construtor da classe
	public PublisherSendResult(String msg){
		this.message = msg;
	}

	//Método para enviar a mensagem para o mosquitto
	public void enviarMensagemResultado() throws MqttException {
		
		//Local para onde será enviado a mensagem (broker)
		ConfigServer endIp = new ConfigServer();
		
		MqttClient client = new MqttClient(endIp.getEnderecoServidor(),
				MqttClient.generateClientId());
		
		//abre conexão com o broker (Mosquitto)
		client.connect();
		
		//objeto de envio de mensagem do broker
		MqttMessage mqttMessage = new MqttMessage();
		
		//Payload, conteudo da mensagem que será enviada ao broker
		mqttMessage.setPayload(message.getBytes());
		
		//QoS - A mensagem é sempre entregue exatamente uma vez.
		mqttMessage.setQos(2);
		
		//Mensagem ficará retida no Broker (ultima mensagem fica retida)
		mqttMessage.setRetained(true);
		
	    //Publica a mensagem, com seu tópico (para alguém se inscrever neste tópico) e a mensagem montada
	    client.publish("enviar_resultado", mqttMessage);
	    
	    //Encerra conexão
	    client.disconnect();
	}	
}
