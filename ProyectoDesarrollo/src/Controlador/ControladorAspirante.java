/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ExcepcionDatos;
import Excepciones.Validaciones;
import Logica.Aspirante;
import Logica.HistorialAspirante;
import Persistencia.Conexion;
import Persistencia.DaoAspirante;
import Persistencia.DaoHistorialAspirante;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julian
 */
public class ControladorAspirante {
    private static ControladorAspirante controladorAspirante;
    private Validaciones validador;
    private DaoHistorialAspirante daoHistorialAspirante;
    private Conexion conexion;
    private DaoAspirante daoAspirante;
    
    
    public ControladorAspirante () { 
        conexion = Conexion.getInstance();
        this.validador = new Validaciones ();
        daoHistorialAspirante = new DaoHistorialAspirante(conexion.getCon());
        daoAspirante = new DaoAspirante(conexion.getCon());
    }
    
    public static ControladorAspirante getInstance() {
        if (controladorAspirante == null) {
            controladorAspirante = new ControladorAspirante();
        }
        return controladorAspirante;
    }
    
    public String crearAspirante(String cedula, String nombres, String apellidos, String correo, String celular,
            String direccion, String sedePertenece, String intitucion, String codigoDaneIntitucion,
            String grado, String secretariaEducacion, String municipio, String departamento,
            String areaInscripcion, boolean tutorPta, boolean usuarioColombiaAprende, boolean estado) {
        String result = "";
        try {
            validador.validarCamposVacios(cedula, nombres, apellidos, correo,celular,direccion,sedePertenece,intitucion,
                                          codigoDaneIntitucion,grado,secretariaEducacion,municipio,departamento);
            Aspirante nuevoAspirante = new Aspirante(cedula, nombres, apellidos, correo, celular, direccion, sedePertenece, intitucion, codigoDaneIntitucion, grado, secretariaEducacion, municipio, departamento, areaInscripcion, tutorPta, usuarioColombiaAprende, estado);
            daoAspirante.create(nuevoAspirante);
            result = "Se creo el aspirante con exito";
        } catch (ExcepcionDatos ex) {
            result = ex.getMessage();

        } catch (NullPointerException ex) {

            result = "Ingreso un objeto vacio";       
        } catch (Exception ex) {
            Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            result = "No se realizo la operacion";
        }
        return result;
    }
    
    public String crearHistorialAspirante(String cedulaAs, String idCurso, Date fechaInscripcion, boolean estado) {
        String result = "";

        try {
            validador.validarCamposVacios(cedulaAs, idCurso);
            HistorialAspirante nuevoHistorialAspirante = new HistorialAspirante(cedulaAs, idCurso, fechaInscripcion);
            daoHistorialAspirante.insertarHistorialaspirante(cedulaAs, idCurso, fechaInscripcion);
            result = "Se creo el historial aspirante con exito";
        } catch (ExcepcionDatos ex) {
            result = ex.getMessage();

        } catch (NullPointerException ex) {

            result = "Ingreso un objeto vacio";    
        } catch (Exception ex) {
            Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            result = "No se realizo la operacion";
        }
        return result;
    }
    
}
