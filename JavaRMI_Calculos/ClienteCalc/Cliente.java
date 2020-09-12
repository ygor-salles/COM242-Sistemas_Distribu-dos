/* COM242 - SISTEMAS DISTRIBUIDOS 
   RMI - Exemplo de implementação. 
         Programa que utiliza funções remotas para realizar operacoes matemáticas.
   14/04/2020
*/

import java.rmi.*;
import java.util.Scanner;

public class Cliente
{
	public Cliente()
	{
		System.out.println("Executando Cliente... \n");
		try
		{   // Acessa o servidor de nomes para localização das funções remotas
			msi = (InterfaceServidorMat) Naming.lookup("rmi://192.168.0.18/ServidorMat_1");
		}
		catch (Exception e)
		{
			System.out.println("Falhou a execucao do Cliente.\n"+e);				
			System.out.println("Certifique se a aplicacao no servidor esta em execucao.\n");				
			System.exit(0);
		}
	}
	
	public static void main (String[] argv)
	{
		Cliente c = new Cliente();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Entre com valores de x e y separados por espaco:");
		double x = keyboard.nextDouble();
		double y = keyboard.nextDouble();
		System.out.println("");
		
		try
		{   // Cada chamada de uma função remota é uma instância da classe Cliente
			System.out.println("Soma (x+y): " + c.add(x,y));
			System.out.println("Subtracao (x-y): " + c.sub(x,y));
			System.out.println("Multiplicacao (x*y): " + c.mult(x,y));
			System.out.println("Divisao (x/y): " + c.div(x,y));
		}
		catch (Exception e)
		{
			System.out.println("Excepção durante chamadas remotas:" +e);
		}
	}

	private InterfaceServidorMat msi; // A interface para o objecto remoto
	
	
	// Chamada as funções remotas para realização das operações matemáticas
	public double add(double a, double b) throws RemoteException{
		 return msi.soma(a,b);	
	}

	public double sub(double a, double b) throws RemoteException{
		return msi.subtrai(a,b);
	}
	
	public double mult(double a, double b) throws RemoteException{
		return msi.multiplica(a,b);
	}
	
	public double div(double a, double b) throws RemoteException{
		return msi.divide(a,b);
	}
}