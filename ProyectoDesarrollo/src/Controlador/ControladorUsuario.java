/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Controlador;

import Logica.Usuario;

/**
 *
 * @author oscar
 */
public class ControladorUsuario {
    
    public boolean ingresarUsuario(String login, String password, String tipo, String cedulaUsuario) {
        boolean respuesta = false;
        Usuario nuevoUsuario = new Usuario(login, password, tipo, cedulaUsuario);
        /**
         * Utilizar el ORM para guardar a la base de datos segun el resultado
         * de la operacion se retorna true o false
         */
        return respuesta;
    } // Fin del metodo ingresarUsuario
           
} // Fin ControladorUsuario
