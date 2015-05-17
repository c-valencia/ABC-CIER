/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Vista;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cristian
 */
public class TablaModel extends DefaultTableModel {
    
    private DefaultTableModel modelo;
    
    /**
     *
     * @param cuerpo
     * @param String
     */
    public TablaModel(Vector cuerpo, Vector  titulo){
         modelo = new DefaultTableModel(cuerpo, titulo);
         
    }
   
    public DefaultTableModel getModelo(){
        return modelo;
    }
    
    }
