/** 
 * Nombre del Archivo: FactoryIF.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Patrones;

import javax.swing.JPanel;

public interface FactoryIF {
    
    public JPanel createProduct(Object discriminador);
    
} // Fin la interfae FactoryIF