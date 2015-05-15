/** 
 * Nombre del Archivo: Sesion.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */

package Logica;

/**
 * Esta se usa para el implementar el patron SINGLETON
 */ 
public class Sesion {
    
    private String login;
    private String password;
    private String tipo;
    private String cedulaUsuario;    
    
    private static Sesion instanciaSesion;
    
    //SOLO PARA TERCERA ENTRAGA DE PATRONES DE DISEÑO    
    public static int cantObjetoSesion = 0;
    
    private Sesion(String login, String password){
        this.login = login;
        this.password = password;
        cantObjetoSesion++;
    } // Constructor
    
    public static Sesion getInstance(String login, String password){
        if (instanciaSesion == null) {
            instanciaSesion = new Sesion(login, password);
        }
        return instanciaSesion;
    } // Fin del metodo getInstance

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }
} // Fin de la clase Sesion
