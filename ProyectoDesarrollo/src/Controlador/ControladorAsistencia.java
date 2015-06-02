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
import Logica.Cohorte;
import Logica.Curso;
import Persistencia.Conexion;
import Persistencia.DaoAsistencia;
import Persistencia.DaoCohorte;
import Persistencia.DaoCurso;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author juliangr
 */
public class ControladorAsistencia {
    private static ControladorAsistencia controlAsistencia;
    private Validaciones validador;
    private DaoAsistencia daoAsistencia;
    private DaoCohorte daoCohorte;
    private DaoCurso daoCurso;
    private Conexion conexion;
    
    public ControladorAsistencia () { 
        conexion = Conexion.getInstance();
        this.validador = new Validaciones ();
        daoAsistencia = new DaoAsistencia(conexion.getCon());
        daoCohorte = new DaoCohorte (conexion.getCon());
        daoCurso = new DaoCurso (conexion.getCon());
    }
    
    public static ControladorAsistencia getInstance() {
        if (controlAsistencia == null) {
            controlAsistencia = new ControladorAsistencia();
        }
        return controlAsistencia;
    }
    
    public Vector listaTarea (AsistenciaPK asistenciaPK, boolean asistio) {

        List<Asistencia> listaTareas = daoAsistencia.buscarAsistencia(asistenciaPK.getCedulaLt(),asistenciaPK.getIdCurso(),asistenciaPK.getIdCohorte()) ;
        Vector Asistencias = new Vector();
        Asistencias = (Vector<Asistencia>) listaTareas;
        return Asistencias;
    }
    
    public ArrayList <String> listarCohorte_asistenciaJoinMatricula (String cedula) {  
        List<Cohorte> listaCohorte = daoCohorte.buscarCohorte_AsistenciaJoinMatricula(cedula);
        ArrayList <String> IdCohorte = new ArrayList <>();
        for (int i = 0; i< listaCohorte.size(); i++) {
            IdCohorte.add(listaCohorte.get(i).getIdCohorte());
        }
        return IdCohorte;
    }
    
    public ArrayList <String> listarCurso_asistenciaJoinMatricula (String cedula) {  
        List<Curso> ListaCurso = daoCurso.buscarCurso_AsistenciaJoinMatricula(cedula);
        ArrayList <String> IdCurso = new ArrayList <>();
        for (int i = 0; i< ListaCurso.size(); i++) {
            String idNombre = "" + ListaCurso.get(i).getIdCurso() + " " + ListaCurso.get(i).getNombre();
            IdCurso.add(idNombre);
        }
        return IdCurso;
    }
    
    public String crearAsistencia(String cedula, String cohorte,String curso,Date fecha,boolean asistio) {
        String result = "";
        try {
            validador.validarCamposVacios(cedula,  cohorte, curso);
            Asistencia asistencia = new Asistencia(new AsistenciaPK ( cedula, cohorte,  curso, fecha),asistio);
            daoAsistencia.create(asistencia);
            result = "Se creo la asistencia con exito";
        } catch (PreexistingEntityException ex) {
            result = "Ya existe esta asistencia";        
        } catch (ExcepcionDatos ex) {
            result = "Todos los campos deben ser llenados";
        } catch (NullPointerException ex) {
            result = "Ingreso un objeto vacio";       
        } catch (Exception ex) {
            //Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            result =  " No se realizo la operacion, intente llenar primero la tabla matricula";
            //result = "Ya existe un master teacher con cedula o correo igual"; 

        }
        return result;
    }
    
}
