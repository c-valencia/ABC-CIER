/** 
 * Nombre del Archivo: Conexion.java 
 * Fecha de Creacion: 27/04/2015 
 * Autores: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750) 
 */

package Persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {
    private EntityManagerFactory conn;
        
    public Conexion(){
        conn = Persistence.createEntityManagerFactory("persistencia");
    }
    
    public EntityManagerFactory getCon() {
        return conn;
    }
}
