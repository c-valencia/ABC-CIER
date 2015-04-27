/** 
 * Nombre del Archivo: FabricaPanelesUsuario.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Patrones;

import Vista.PanelAdministrador;
import Vista.PanelAspirante;
import Vista.PanelCoordinador;
import Vista.PanelLT;
import Vista.PanelMT;
import javax.swing.JPanel;

public class FabricaPanelesUsuario implements FactoryIF{
    
    @Override
    public JPanel createProduct(Object discriminador) {
        String id = discriminador.toString();
        if (id.equals("Administrador")) {
            return new PanelAdministrador();
        } else if (id.equals("Master Teacher")) {
             return new PanelMT();
        } else if (id.equals("Leader Teacher")) {             
             return new PanelLT();
        } else if (id.equals("Coordinador")) {             
             return new PanelCoordinador();
        } else if (id.equals("Aspirante")) {
            return new PanelAspirante();
        }
        return null;        
    } // Fin del metodo createProduct    
    
} // Fin de la clase FabricaPanelesUsuario
