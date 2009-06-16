/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.arq.obligatorio.implementaciones;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uy.edu.ort.arq.obligatorio.dominio.Contador;
import uy.edu.ort.arq.obligatorio.dominio.Servicios;

/**
 *
 * @author rodrigo
 */
@Stateless
public class RegistroContadorBean implements RegistroContadorLocal {

    @PersistenceContext
    private EntityManager em;

    public void sumarContador(Servicios servicio) {
        Contador c = new Contador();
        c.setServicio(servicio);
        c.setFechaUsado(new GregorianCalendar().getTime());
        em.persist(c);
    }

    public int cantidadServicio(Servicios servicio) {
        Query q = em.createQuery("SELECT e FROM Contador e WHERE e.servicio = :servicio AND e.fechaUsado >= :fechaUsado");
        q.setParameter("servicio", servicio);
        GregorianCalendar c =  new GregorianCalendar();
        c.add(Calendar.MONTH, -1);
        q.setParameter("fechaUsado",c.getTime());
        return q.getResultList().size();
    }

 
}
