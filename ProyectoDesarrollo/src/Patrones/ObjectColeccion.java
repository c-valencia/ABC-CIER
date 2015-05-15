/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Patrones;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author cristian
 */
public class ObjectColeccion implements TablaColeccion{

    Vector datos;
    
    public ObjectColeccion(Vector datos){
        this.datos=datos;
        
    }
    
    @Override
    public ObjetoIterador iterator() {
        return new ObjetoColeccionIterador();
    }
    
    private class ObjetoColeccionIterador implements ObjetoIterador {
        private int index;
        @Override
        public boolean hasNext() {
           if(index < datos.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Vector next() {
             System.out.print("se agrego al objeto iterador");
            return (Vector) datos.get(index++);
            
        }
        
        
        
    }
}
