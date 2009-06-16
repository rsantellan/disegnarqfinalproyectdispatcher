/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.arq.obligatorio.miws;

import javax.ejb.Local;

/**
 *
 * @author rodrigo
 */
@Local
public interface DispachadorClienteWebServiceLocal {

    Object invocarServicio(String nombre, String parametro);
    
}
