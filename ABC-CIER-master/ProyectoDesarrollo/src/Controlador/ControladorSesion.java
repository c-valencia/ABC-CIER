/** 
 * Nombre del Archivo: ControladorSesion.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Controlador;

import Logica.Sesion;

/**
 *
 * @author oscar
 */
public class ControladorSesion {

    public Sesion ingresar(String usuario, String contrasena){
        Sesion nuevaSesion = null;
        /**
         * Con usuario y contrasena va y consulta a la base de datos (Tabla Usuario)
         * si el Usuario no tiene mas sesiones si no esta crea un Objeto Sesion
         * y si esta retorna un null
         */
        nuevaSesion = Sesion.getInstance(usuario, contrasena);
        // nuevaSesion.setTipo("Administrador");
        return nuevaSesion;
    } // Fin del metodo login
    
} // Fin de controlador Login
