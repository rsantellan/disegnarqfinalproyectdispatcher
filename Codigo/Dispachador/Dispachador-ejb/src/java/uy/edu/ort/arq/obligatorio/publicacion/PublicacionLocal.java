/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.arq.obligatorio.publicacion;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rodrigo
 */
@Local
public interface PublicacionLocal {

    List listaServicioActivos();
    
}
