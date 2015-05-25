/** 
 * Nombre del Archivo: ControladorSesion.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Controlador;

import Logica.Sesion;
import Logica.Usuario;
import Persistencia.Conexion;
import Persistencia.DaoUsuario;

public class ControladorSesion {

    
    private Conexion conexion;
    private DaoUsuario daoUsuario;
    private Usuario objUsuario;
    
    public ControladorSesion () {
        conexion = Conexion.getInstance();
        daoUsuario = new DaoUsuario(conexion.getCon());
    } // Fin del Constructor
    
    
    public Sesion iniciarSesion(String usuario, String contrasena){ 
        objUsuario = daoUsuario.buscarUsuario(usuario, contrasena);
        Sesion objSesion =  null;
        if (objUsuario != null) {
            objSesion = Sesion.getInstance(objUsuario.getLogin(), objUsuario.getPasswd());      
            objSesion.setTipo(objUsuario.getTipo());        
        }
        return objSesion;
    } // Fin del metodo ingresar
} // Fin de controlador Login
