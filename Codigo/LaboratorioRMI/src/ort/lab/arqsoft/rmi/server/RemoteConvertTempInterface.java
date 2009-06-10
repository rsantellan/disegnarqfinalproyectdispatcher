/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ort.lab.arqsoft.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author rodrigo
 */
public interface RemoteConvertTempInterface extends Remote{

    public String convertFar2Cel(double fah) throws RemoteException;

    public String convertCel2Fah(double cel) throws RemoteException;

    
}
