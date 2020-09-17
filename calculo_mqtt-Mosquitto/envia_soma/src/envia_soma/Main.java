package envia_soma;

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

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttClient;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					
					ConfigServer endIp = new ConfigServer();
					
					MqttClient client = new MqttClient(endIp.getEnderecoServidor(), 
							MqttClient.generateClientId());	
					
					/*Utiliza��o da interface MqttCallback
					 * Permite que um aplicativo seja notificado 
					 * quando ocorrerem eventos ass�ncronos relacionados ao cliente*/
					client.setCallback(new Subscriber());
					
					//Cria conex�o com o servidor
					client.connect();
					
					//subscribe no t�pico para receber os valores para realiza��o da opera��o
					client.subscribe("enviar_resultado");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor l:");
		lblNewLabel.setBounds(101, 51, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Valor 2:");
		lblNewLabel_2.setBounds(101, 114, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(150, 48, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 111, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 83, 86, 20);
		comboBox.addItem("+");
		comboBox.addItem("-");
		comboBox.addItem("/");
		comboBox.addItem("*");
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validateNumericField(textField) && validateNumericField(textField_1)) {
					
					//Monta a mensagem que ser� enviada para o broker
					String msg = textField.getText() + " " +
							comboBox.getSelectedItem().toString() + " " +
							textField_1.getText();
					
					//Criando objeto para publicar a mensagem
					Publisher publisher = new Publisher(msg);
					
					try {
						//Envia mensagem
						publisher.sendMessageToAccount();
					}catch(MqttException ex) {
						System.out.println(ex);
					}
				}
			}
		});
		
		btnNewButton.setBounds(150, 156, 89, 23);
		contentPane.add(btnNewButton);
		
	}
	
	//M�todos para validar campos num�ricos
	public boolean validateNumericField(JTextField field) {
		long value;
		
		if(field.getText().length() != 0) {
			try {
				value = Long.parseLong(field.getText());
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Digite um valor v�lido!", "Erro de valor",
						JOptionPane.INFORMATION_MESSAGE);
				field.grabFocus();
				return false;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Digite um n�mero!", "Erro de valor",
					JOptionPane.INFORMATION_MESSAGE);
			field.grabFocus();
			return false;
		}
		
		return true;
	}
}
