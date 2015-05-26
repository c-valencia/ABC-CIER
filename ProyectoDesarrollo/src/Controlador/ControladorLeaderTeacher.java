/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ExcepcionDatos;
import Excepciones.Validaciones;
import Logica.Curso;
import Persistencia.Conexion;
import Persistencia.DaoCurso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author oscar
 */
public class ControladorLeaderTeacher {
    
   
    private Conexion conexion;
    
    // DAOS            
    private DaoCurso daoCurso;                    
    
    // Informacion
    private String[] listaCursosLT;
    private ArrayList<Curso> listCursos;
    private JasperPrint informe;
    private static ControladorLeaderTeacher controladorLT;
    
    private ControladorLeaderTeacher() {
        conexion = Conexion.getInstance();   
        daoCurso = new DaoCurso(conexion.getCon());
    } // Fin del Constructor
    
    public static ControladorLeaderTeacher getInstance(){
        if (controladorLT == null) {
            controladorLT = new ControladorLeaderTeacher();
        }
        return controladorLT;
    } // getInstance
    
    public String listarCursos(String idCedula){ 
        listaCursosLT = new String[0];        
        
        List <Curso> resultOperation = daoCurso.listarCursosLeaderTeacher(idCedula);
        if (resultOperation != null) {
            listCursos = new ArrayList<Curso>();
            listCursos.addAll(daoCurso.listarCursosLeaderTeacher(idCedula)); 
        }
              
        String result = "";
        try {
            Validaciones.validarCamposVacios(idCedula);
            if (listCursos != null) {
                listaCursosLT = new String[listCursos.size()];
                for (int x = 0; x < listCursos.size(); x++) {
                    Curso objCurso = listCursos.get(x);
                    String curso = objCurso.getIdCurso() + " " + objCurso.getNombre();
                    listaCursosLT[0] = curso;
                }
                result = "OK";
            }            
        } catch (ExcepcionDatos excepcionDatos) {
            result = excepcionDatos.getMessage();
        }        
        return result;
    } // Fin del metodo listarCursos

    
    public String reporteCalificaciones(String cedula, int indexCurso){
        EntityManager em = null;
        informe= null;
        String result = "";
        Curso objCurso = listCursos.get(indexCurso);                
        try {
            Validaciones.validarCamposVacios(cedula);
            em = conexion.getCon().createEntityManager();
            em.getTransaction().begin();
            java.sql.Connection connection = em.unwrap(java.sql.Connection.class);                        
            Map parametros = new HashMap();  // Parametros del Reporte             
            parametros.put("cedulaLT", cedula);
            parametros.put("idCurso", objCurso.getIdCurso());
            JasperReport jasperReport = null;
            String path = "./src/Reporte/ReporteNotaLT.jasper";
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);
            informe = JasperFillManager.fillReport(jasperReport, parametros, connection);
            em.getTransaction().commit();  
            result = "OK";
        } catch (JRException ex) {
            // Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
            result = "Problema al generar el Reporte";
        } catch (ExcepcionDatos excepcionDatos) {
            result = excepcionDatos.getMessage();
        } 
        finally {
            if (em != null) {
                em.close();
            }
        }                 
        return result;    
    } // Fin del metodo reporteCalificaciones 
    public String[] getListaCursosLT() {
        return listaCursosLT;
    }       

    public JasperPrint getInforme() {
        return informe;
    }        
} // Fin de la clase ControladorLeaderTeacher
