/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.arq.obligatorio.implementaciones;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.omg.CORBA.ORB;
import uy.edu.ort.arq.corba.idl.CorbaPalabrasInterface;
import uy.edu.ort.arq.corba.idl.CorbaPalabrasInterfaceHelper;
import uy.edu.ort.arq.obligatorio.dominio.Servicios;

/**
 *
 * @author rodrigo
 */
@Stateless
public class CobraPalabrasBean implements CobraPalabrasLocal {

    @EJB
    RegistroContadorLocal contador;

    public String modificarPalabra(Servicios s, String palabra){
        System.out.println("----------------------------------------");
        System.out.println("| UTILIZANDO OBJETOS REMOTOS VIA CORBA |");
        System.out.println("----------------------------------------");
        try {
            // Crear e inicializar el ORB
            String[] ORBparam = {"-ORBInitRef","ConvertirPalabra=corbaloc:iiop:1.2@localhost:1060/ConvertirPalabra"};
            ORB orb = ORB.init(ORBparam,null);

            // Obtengo la referencia a través del nombre del servicio publicado
            // en el server.
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("ConvertirPalabra");

            // A través del helper apuntamos al servicio INS corba
            CorbaPalabrasInterface convertPalabra = CorbaPalabrasInterfaceHelper.narrow(objRef);

            System.out.println(convertPalabra.convertirPalabra("hola"));
            System.out.println(convertPalabra.convertirPalabra("hosla"));
            System.out.println(convertPalabra.convertirPalabra("hoAlFa"));
            System.out.println(convertPalabra.convertirPalabra("GGolFa"));
            System.out.println(convertPalabra.convertirPalabra("333333333  5  fdshola"));
            String aux = convertPalabra.convertirPalabra(palabra);
            contador.sumarContador(s);
            return aux;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
 
}
