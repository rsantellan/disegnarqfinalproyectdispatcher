/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.arq.obligatorio.publicacion;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uy.edu.ort.arq.obligatorio.dominio.Servicios;

/**
 *
 * @author rodrigo
 */
@Stateful
public class PublicacionBean implements PublicacionLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

    private List<Servicios> servicios = null;

    @PersistenceContext
    private EntityManager em;
    
    public List<Servicios> getServicios() {
        //if(servicios == null){
            servicios = new ArrayList<Servicios>();
            Query q = em.createQuery("SELECT e FROM Servicios e WHERE e.activo = true");
            this.servicios = q.getResultList();
       // }
        return servicios;
    }

    public void setServicios(List<Servicios> servicios) {
        this.servicios = servicios;
    }


    public List listaServicioActivos() {
        return this.getServicios();
    }


}
