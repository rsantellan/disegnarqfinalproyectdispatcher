/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.arq.obligatorio.popularbase;

import javax.ejb.Remote;
import uy.edu.ort.arq.obligatorio.dominio.Servicios;

/**
 *
 * @author rodrigo
 */
@Remote
public interface PopularBaseRemote {

    void popular(Servicios dato);
    
}
