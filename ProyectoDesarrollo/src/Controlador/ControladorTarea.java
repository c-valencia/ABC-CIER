/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.Validaciones;
import Logica.Tarea;
import Persistencia.Conexion;
import Persistencia.DaoTarea;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julian
 */
public class ControladorTarea {
    private static ControladorTarea controladorTarea;
    private Validaciones validador;
    private DaoTarea daoTarea;
    private Conexion conexion;
    
    public ControladorTarea () { 
        conexion = Conexion.getInstance();
        this.validador = new Validaciones ();
        daoTarea = new DaoTarea(conexion.getCon());
    }
    
    public static ControladorTarea getInstance() {
        if (controladorTarea == null) {
            controladorTarea = new ControladorTarea();
        }
        return controladorTarea;
    }
    
    public ArrayList<Tarea> listaTarea (String curso, String cohorte, String Cedula_lt) {

        List<Tarea> listaTareas = daoTarea.buscarTareas(curso,  cohorte,  Cedula_lt);
        ArrayList<Tarea> tareas = new ArrayList<>();
        
        if (listaTareas.size() != 0) {
            for (int i = 0; i < listaTareas.size(); i++) {
                tareas.add(listaTareas.get(i));
            }
        } else {

            cohorte = null;
        }
        return tareas;
    }
    
}
