
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.arq.obligatorio.implementaciones;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;
import uy.edu.ort.arq.obligatorio.dominio.Servicios;
import uy.edu.ort.arq.webservice.NewTemperaturaWebService;
import uy.edu.ort.arq.webservice.NewTemperaturaWebServiceService;

/**
 *
 * @author rodrigo
 */
@Stateless
public class WSTemperaturaBean implements WSTemperaturaLocal {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/TemperaturaWS/NewTemperaturaWebServiceService?wsdl")
    private NewTemperaturaWebServiceService service;
    @EJB
    RegistroContadorLocal contador;

    public Double convertirCelsius(Servicios s, Double farenheit) {
        System.out.println("Creando el port");
        NewTemperaturaWebService port = service.getNewTemperaturaWebServicePort();
        System.out.println("invocacion");
        Double a = port.pasarFarenheitCelsius(farenheit);
        System.out.println("Guardo en base");
        contador.sumarContador(s);
        return a;
    }

    public Double convertirFarenheit(Servicios s, Double Celsius) {
        System.out.println("Creando el port");
        NewTemperaturaWebService port = service.getNewTemperaturaWebServicePort();
        System.out.println("invocacion");
        Double a = port.pasarCelciusFarenheit(Celsius);
        System.out.println("Guardo en base");
        contador.sumarContador(s);
        return a;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
}
