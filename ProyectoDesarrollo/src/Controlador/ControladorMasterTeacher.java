/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ExcepcionDatos;
import Excepciones.Validaciones;
import Logica.Asistencia;
import Logica.AsistenciaPK;
import Logica.LeaderTeacher;
import Logica.Matricula;
import Logica.MatriculaPK;
import Logica.Practica;
import Logica.Tarea;
import Persistencia.Conexion;
import Persistencia.DaoAsistencia;
import Persistencia.DaoLeaderTeacher;
import Persistencia.DaoMatricula;
import Persistencia.DaoPractica;
import Persistencia.DaoTarea;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;

/**
 *
 * @author juliangr
 */
public class ControladorMasterTeacher {   
    
    private DaoTarea daoTarea;
    private DaoLeaderTeacher daoLeaderTeacher;
    private DaoPractica daoPractica ;
    private DaoMatricula daoMatricula;
    private DaoAsistencia daoAsistencia;
    private Conexion conexion;
    private static ControladorMasterTeacher controladorMasterTeacher;
    private Validaciones validador;
    
    private ControladorMasterTeacher(){
        conexion = Conexion.getInstance();
        daoTarea = new DaoTarea(conexion.getCon());
        daoMatricula = new DaoMatricula(conexion.getCon());
        daoPractica = new  DaoPractica (conexion.getCon());
        daoLeaderTeacher = new DaoLeaderTeacher(conexion.getCon());
        daoAsistencia = new DaoAsistencia(conexion.getCon());
        validador = new Validaciones();
    }
    
    public static ControladorMasterTeacher getInstance(){
        if (controladorMasterTeacher == null) {
            controladorMasterTeacher = new ControladorMasterTeacher ();
        }
        return controladorMasterTeacher;
    }
    
    // Getters and Setters
    public DaoTarea getDaoTarea() {
        return daoTarea;
    }
    public DaoLeaderTeacher getDaoLeaderTeacher() {
        return daoLeaderTeacher;
    }

    public DaoPractica getDaoPractica() {
        return daoPractica;
    }
    //
    
    public Matricula buscarMatricula (String cedulaLt, String idCohorte, String idCurso)  throws ExcepcionDatos {

        Matricula matricula = new Matricula ();
        try{
            validador.validarCamposVacios(cedulaLt,idCohorte, idCurso);
            matricula = daoMatricula.findMatricula(new MatriculaPK (cedulaLt,idCohorte,idCurso));
            
        } catch(Exception ex){
            throw ex;
        }
        return matricula;
    }
    
    public String modificarTarea(Tarea tarea) { 
        String result = "";
        try { 
            daoTarea.edit(tarea);
            result = "Se Modificaron los Datos con Exito";
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
    
    public String modificarMAtricula(Matricula matricula) { 
        String result = "";
        try { 
            daoMatricula.edit(matricula);
            result = "Se Modificaron los Datos con Exito";
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
    
    public String crearTarea(Practica practica, LeaderTeacher leaderTeacher, float nota) 
    {
        String result = "";
//        try {                        
//            Tarea nuevaTarea = new Tarea (practica, leaderTeacher, nota);
//            daoTarea.create(nuevaTarea);            
//            result = "1";
//        } // Fin del metodo crearAspirante
//        catch (Exception ex) {
//            Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
//            result =  "No se realizo la operacion";
//        }
       return result;
    }
    
    
    
    
}
