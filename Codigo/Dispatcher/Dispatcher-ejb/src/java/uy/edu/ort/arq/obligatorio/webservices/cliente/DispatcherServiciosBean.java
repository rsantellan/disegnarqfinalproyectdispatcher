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
public class DispatcherServiciosBean implements DispatcherServiciosLocal {

    @WebMethod(operationName="test")
    public void testeoServicioDispatcher() {
        System.out.println("HOLA");
    }
    
    @WebMethod(operationName="consultaCantidad")
    public int cosultarCantidadConsultas(String nombreServicio){
        return 1;
    }

    @WebMethod(operationName="consultarServicio")
    public String consultarServicio(String nombreServicio){
        String retorno = "[Test]";

        return retorno;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")


}
