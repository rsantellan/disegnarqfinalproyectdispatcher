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
import uy.edu.ort.arq.obligatorio.implementaciones.RegistroContadorLocal;
import uy.edu.ort.arq.obligatorio.publicacion.PublicacionLocal;
import uy.edu.ort.arq.obligatorio.registro.RegistroServicioLocal;

/**
 *
 * @author rodrigo
 */
@Stateless
@WebService
public class DispachadorProovedorWebServiceBean implements DispachadorProovedorWebServiceLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

    @WebMethod(operationName="test")
    public void testeoServicioDispatcher() {
        System.out.println("HOLA");
    }

    @WebMethod(operationName="registro")
    public int registrar(String nombreEmpresa, String nombreServicio, String uri, String tecnologia){
        if(this.registroConcreto(nombreEmpresa, nombreServicio, uri, tecnologia)){
            return 0;
        }
        return 1;
    }

    @WebMethod(operationName="consultaCantidad")
    public int cosultarCantidadConsultas(String nombreServicio){
        return this.devolverCantidaServicio(this.devolverServicio(nombreServicio));
    }

    @WebMethod(operationName="consultarServicio")
    public String consultarServicio(String nombreServicio){
        return this.consultaDelServicio(nombreServicio);
    }

    @EJB
    private PublicacionLocal publicar;

    @EJB
    private RegistroContadorLocal contador;

    private int devolverCantidaServicio(Servicios s){
        return contador.cantidadServicio(s);
    }
    
    private Servicios devolverServicio(String nombre) {
         Servicios s = new Servicios();
        s.setNombreServicio(nombre);
        List<Servicios> aux = publicar.listaServicioActivos();
        boolean encontro = false;
        int x = 0;
        while (!encontro && x < aux.size()) {
            if (aux.get(x).equals(s)) {
                s = aux.get(x);
                encontro = true;
            }
            x++;
        }

        return s;
    }

    @EJB
    private RegistroServicioLocal registro;

    private boolean registroConcreto(String nombreEmpresa, String nombreServicio, String uri, String tecnologia){
        return registro.registrarServicio(nombreEmpresa, nombreServicio, uri, tecnologia);
    }

    private String consultaDelServicio(String nombreServicio){
        Servicios s = new Servicios();
        s.setNombreServicio(nombreServicio);
        return registro.existeServicio(s);
    }
}
