/* COM242 - SISTEMAS DISTRIBUIDOS 
   RMI - Exemplo de implementação. 
         Programa que utiliza funções remotas para realizar operacoes matemáticas.
   14/04/2020
*/

import java.rmi.*;
import java.rmi.server.*;

// Classe no servidor que implementa os métodos remotos
public class ServidorMat extends UnicastRemoteObject implements InterfaceServidorMat
{
    public ServidorMat() throws RemoteException
    {
        System.out.println("Novo Servidor instanciado...");
    }
	
    public double soma(double a, double b) throws RemoteException
    {
        System.out.println("Valores recebidos do cliente: x = " + a + " e y = " + b);
		return a+b;
    }
	
    public double subtrai(double a, double b) throws RemoteException
    {
        System.out.println("Valores recebidos do cliente: x = " + a + " e y = " + b);
		return a-b;
    }
	
    public double multiplica(double a, double b) throws RemoteException
    {
        System.out.println("Valores recebidos do cliente: x = " + a + " e y = " + b);
		return a*b;
    }
	
    public double divide(double a, double b) throws RemoteException
    {
        System.out.println("Valores recebidos do cliente: x = " + a + " e y = " + b);
		return a/b;
    }
} 