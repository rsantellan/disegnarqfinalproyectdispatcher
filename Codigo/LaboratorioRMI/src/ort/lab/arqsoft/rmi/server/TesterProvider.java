/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ort.lab.arqsoft.rmi.server;

import java.rmi.RemoteException;

/**
 *
 * @author rodrigo
 */
public class TesterProvider {

        public static void main(String[] arg){
        try{
             RemoteConvertTemImplementacion convertidor = new RemoteConvertTemImplementacion();
             String[] campos = new String[1];
             campos[0] = "9090";
            convertidor.main(campos);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
