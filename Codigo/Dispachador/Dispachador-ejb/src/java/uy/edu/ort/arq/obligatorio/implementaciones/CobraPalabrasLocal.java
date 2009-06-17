/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.arq.obligatorio.implementaciones;

import javax.ejb.Local;
import uy.edu.ort.arq.obligatorio.dominio.Servicios;

/**
 *
 * @author rodrigo
 */
@Local
public interface CobraPalabrasLocal {

    public java.lang.String modificarPalabra(Servicios s, java.lang.String palabra);
    
}
