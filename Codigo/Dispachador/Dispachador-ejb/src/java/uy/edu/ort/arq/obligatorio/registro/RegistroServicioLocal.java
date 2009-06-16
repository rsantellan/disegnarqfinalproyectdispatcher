/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.arq.obligatorio.registro;

import javax.ejb.Local;

/**
 *
 * @author rodrigo
 */
@Local
public interface RegistroServicioLocal {

    Boolean registrarServicio(String nombreEmpresa, String nombreServicio, String uri, String tecnologia);

    public java.lang.String existeServicio(uy.edu.ort.arq.obligatorio.dominio.Servicios s);

   
}
