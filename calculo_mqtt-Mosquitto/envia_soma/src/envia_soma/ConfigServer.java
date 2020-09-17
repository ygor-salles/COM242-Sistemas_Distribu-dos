package envia_soma;

public class ConfigServer {

	String enderecoServidor = "tcp://192.168.0.102:1883";
	
	//recupera endereco ip
	public String getEnderecoServidor() {
		return enderecoServidor;
	}
	
	//altera endereco ip
	public void setEnderecoServidor(String enderecoServidor) {
		this.enderecoServidor = enderecoServidor;
	}
}
