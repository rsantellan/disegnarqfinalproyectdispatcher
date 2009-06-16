/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.arq.obligatorio.miws;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import uy.edu.ort.arq.obligatorio.dominio.Servicios;
import uy.edu.ort.arq.obligatorio.implementaciones.WSTemperaturaLocal;
import uy.edu.ort.arq.obligatorio.publicacion.PublicacionLocal;

/**
 *
 * @author rodrigo
 */
@Stateless
@WebService
public class DispachadorClienteWebServiceBean implements DispachadorClienteWebServiceLocal {

    //@EJB
    //private WebServiceTemperaturaLocal wsTemperatura;
    @EJB
    private WSTemperaturaLocal wsTemperatura;

    @WebMethod(operationName = "invocar")
    public Object invocarServicio(String nombre, String parametro) {
        return this.logicaNegocio(nombre, parametro);
    }

    @WebMethod(operationName = "todos")
    public List<Servicios> obtenerServiciosActivos() {
        List<Servicios> salida = publicar.listaServicioActivos();
        for (Servicios a : salida) {
            System.out.println(a.toString());
        }
        return salida;
    }
    @EJB
    private PublicacionLocal publicar;

    private Object logicaNegocio(String nombre, String parametro) {
        Servicios s = new Servicios();
        s.setNombreServicio(nombre);
        List<Servicios> aux = publicar.listaServicioActivos();
        if (aux.contains(s)) {
            boolean encontro = false;
            int x = 0;
            while (!encontro && x< aux.size()) {
                if (aux.get(x).equals(s)) {
                    s = aux.get(x);
                    encontro = true;
                }
                x++;
            }
            if (nombre.equalsIgnoreCase("temperaturaFarenheitToCelsius")) {
                try {
                    double a = Double.parseDouble(parametro);
                    System.out.println("Estoy aca");
                    System.out.println(a);
                    return wsTemperatura.convertirCelsius(s, a);
                } catch (Exception e) {
                    System.out.println("Error");
                    System.out.println("Error " + e.getMessage());
                }
            }
            if (nombre.equalsIgnoreCase("temperaturaCelsiusToFarenheit")) {
                try {
                    double a = Double.parseDouble(parametro);
                    System.out.println("Estoy aca");
                    System.out.println(a);
                    return wsTemperatura.convertirFarenheit(s, a);
                } catch (Exception e) {
                    System.out.println("Error");
                    System.out.println("Error " + e.getMessage());
                }
            }
        }

        return null;
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
}
