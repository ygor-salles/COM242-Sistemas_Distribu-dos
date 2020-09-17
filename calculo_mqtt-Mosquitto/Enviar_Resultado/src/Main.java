
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws MqttException{
		
		System.out.println("Programa aguardado dados para realizar cálculo!");
		
		//Local para onde será enviado a mensagem (broker)
		ConfigServer endIp = new ConfigServer();
		
		MqttClient client = new MqttClient(endIp.getEnderecoServidor(), 
			MqttClient.generateClientId());
		
		//Interface MqttCalback
		//Permite que um aplicativo seje notificado quando ocorrem
		//eventos assíncronos relacionados ao cliente
		client.setCallback(new VerifyStatusServer());
		
		client.connect();
		
		client.subscribe("enviar_conta");
		
	}	
}
