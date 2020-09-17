package envia_soma;

//Imports para utilizar o protocolo MQTT
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {
	
	String sendMessage;
	
	//Construtor da classe
	public Publisher(String msg) {
		this.sendMessage = msg;
	}
	
	public void sendMessageToAccount() throws MqttException{
		
		//Local para onde ser� enviado a mensagem (broker)
		ConfigServer endIp = new ConfigServer();
				
		MqttClient client = new MqttClient(endIp.getEnderecoServidor(), 
				MqttClient.generateClientId());
		
		//Abrindo conex�o com o broker
		client.connect();
		
		//Criando objeto para envio da mensagem
		MqttMessage message = new MqttMessage();
		
		//Conte�do da msg que ser� enviada ao broker (Payload)
		message.setPayload(sendMessage.getBytes());
		
		//Publica a mensagem, com seu t�pico
		client.publish("enviar_conta", message);
		
		//Encerra conex�o
		client.disconnect();
	}

}
