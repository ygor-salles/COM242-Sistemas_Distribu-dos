/* COM242 - SISTEMAS DISTRIBUIDOS 
   RMI - Exemplo de implementação. 
         Programa que utiliza funções remotas para realizar operacoes matemáticas.
   14/04/2020
*/

import java.rmi.*;

// Definição da interface que descreve os objetos remotos que poderao ser acessados pelo cliente
public interface InterfaceServidorMat extends Remote
{
    public String funcaoSegundoGrau(double a, double b, double c) throws RemoteException;
}