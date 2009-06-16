/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.arq.obligatorio.registro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uy.edu.ort.arq.obligatorio.dominio.Servicios;
import uy.edu.ort.arq.obligatorio.dominio.TiposServicios;

/**
 *
 * @author rodrigo
 */
@Stateless
public class RegistroServicioBean implements RegistroServicioLocal {

    @PersistenceContext
    private EntityManager em;
    
    public Boolean registrarServicio(String nombreEmpresa, String nombreServicio, String uri, String tecnologia) {
        Boolean salida = false;
        Servicios servicio = new Servicios();
        servicio.setActivo(false);
        servicio.setNombreEmpresa(nombreEmpresa);
        servicio.setNombreServicio(nombreServicio);
        servicio.setUri(uri);
        if(TiposServicios.CORBA.toString().equalsIgnoreCase(tecnologia)){
            servicio.setServicio(TiposServicios.CORBA);
            salida = true;
        }
        if(TiposServicios.RMI.toString().equalsIgnoreCase(tecnologia)){
            servicio.setServicio(TiposServicios.RMI);
            salida = true;
        }
        if(TiposServicios.WEBSERVICE.toString().equalsIgnoreCase(tecnologia)){
            servicio.setServicio(TiposServicios.WEBSERVICE);
            salida = true;
        }
        if(!existeServicio(servicio).isEmpty()){
             em.persist(servicio);
        }
        return salida;
    }


    public String existeServicio(Servicios s){
        String salida = "";
        Query q = em.createQuery("SELECT e FROM Servicios e WHERE e.nombreServicio = :nombreServicio");
        q.setParameter("nombreServicio", s.getNombreServicio());
        s = (Servicios) q.getSingleResult();
        if(s!=null){
            salida = s.toString();
        }
        return salida;
    }

    
}
