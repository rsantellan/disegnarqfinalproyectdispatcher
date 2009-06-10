/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ort.lab.arqsoft.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author rodrigo
 */
public class RemoteConvertTemImplementacion extends UnicastRemoteObject implements  RemoteConvertTempInterface{

    public String convertFar2Cel(double fah) throws RemoteException {
        return String.valueOf((fah / 1.6) - 32);
    }

    public String convertCel2Fah(double cel) throws RemoteException {
        return String.valueOf((cel * 1.6) + 32);
    }

    public RemoteConvertTemImplementacion() throws RemoteException{
    }


    public static void main(String[] arg){
        try{
            RemoteConvertTemImplementacion convertidor = new RemoteConvertTemImplementacion();
            java.rmi.Naming.bind("//"+ java.net.InetAddress.getLocalHost().getHostAddress() + ":"+arg[0] + "/PruebaRMI", convertidor);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
