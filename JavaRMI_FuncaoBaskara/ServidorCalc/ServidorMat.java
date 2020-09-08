/* COM242 - SISTEMAS DISTRIBUIDOS 
   RMI - Exemplo de implementação. 
         Programa que utiliza funções remotas para realizar operacoes matemáticas.
   14/04/2020
*/

import static java.lang.Math.sqrt;
import java.rmi.*;
import java.rmi.server.*;

// Classe no servidor que implementa os métodos remotos
public class ServidorMat extends UnicastRemoteObject implements InterfaceServidorMat
{
    public ServidorMat() throws RemoteException
    {
        System.out.println("Novo Servidor instanciado...");
    }
	
    public String funcaoSegundoGrau(double a, double b, double c) throws RemoteException
    {
        float delta, x1, x2;
		
		System.out.println("Valores recebidos do cliente: a = " + a + " b = " + b + " c = "+ c);
		
		if (a != 0) {
            delta = (float) (Math.pow(b,2) - 4*a*c);
            
            if (delta>0){
                x1 = (float) ((-b +Math.sqrt(delta))/(2*a));
                x2 = (float) ((-b -Math.sqrt(delta))/(2*a));
				return "Equação possui duas raízes reais: \n X': "+x1+"\n X'': "+x2;
            }
            else if (delta==0){
                x1 = (float) ((-b +sqrt(delta))/(2*a));
				return "\nEquação possui uma raiz real: \n X: "+x1;
            }
            else
                return "\nEquação não possui raízes reais!\n";
        }
        else
            return "\nA deve ser diferente de Zero!";
    }
	
    
} 