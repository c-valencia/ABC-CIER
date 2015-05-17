/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.LeaderTeacher;
import Logica.Practica;
import Logica.Tarea;
import Persistencia.Conexion;
import Persistencia.DaoLeaderTeacher;
import Persistencia.DaoPractica;
import Persistencia.DaoTarea;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliangr
 */
public class ControladorMasterTeacher {   
    
    private DaoTarea daoTarea;
    private DaoLeaderTeacher daoLeaderTeacher;
    private DaoPractica daoPractica ;
    private Conexion conexion;
    private static ControladorMasterTeacher controladorMasterTeacher;
    
    private ControladorMasterTeacher(){
        conexion = Conexion.getInstance();
        daoTarea = new DaoTarea(conexion.getCon());
        daoPractica = new  DaoPractica (conexion.getCon());
        daoLeaderTeacher = new DaoLeaderTeacher(conexion.getCon());
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
