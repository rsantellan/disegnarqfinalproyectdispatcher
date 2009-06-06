/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.arq.obligatorio.webservices.cliente;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author rodrigo
 */
@WebService
@Stateless
public class DispatcherClientesBean implements DispatcherClientesLocal {

    @WebMethod(operationName="test")
    public void testeoWebService() {
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")


}
