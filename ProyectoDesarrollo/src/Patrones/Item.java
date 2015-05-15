/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */

package Patrones;

/**
 * Esta clase se utiliza para implementar el patron COMPOSITE
 * y Representa la interfaz de Comportamiento
 */

public interface Item {
    
    public void insertarItem(Item nuevoObjeto);
    public int obtenerItem(Object...list);
    public void eliminarItem(Object...list);
    
} // Fin de la interface Item
