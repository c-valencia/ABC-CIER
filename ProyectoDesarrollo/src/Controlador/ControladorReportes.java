package Controlador;

import Persistencia.Conexion;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;


/**
 * Nombre del Archivo: ControladorReportes.java
 * Fecha de Creacion: 21/05/2015
 * Autor: Oscar Steven Romero Beron - 1326750
 */

public class ControladorReportes {
    
    private Conexion conexion;        
    private static ControladorReportes contReportes;
    
    private ControladorReportes(){
        conexion = Conexion.getInstance();
    }
    
    public static ControladorReportes getInstance(){
        if (contReportes == null) {
            contReportes = new ControladorReportes();
        }
        return contReportes;        
    }
    
    public JasperPrint pruebaReporte(String ano, String mes) {
        EntityManager em = null;
        JasperPrint informe= null;
        try {
            em = conexion.getCon().createEntityManager();
            em.getTransaction().begin();
            java.sql.Connection connection = em.unwrap(java.sql.Connection.class);                        
            Map parametros = new HashMap();  // Parametros del Reporte                     
            JasperReport jasperReport = null;
            String path = "./src/Reporte/report1.jasper";
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);
            informe = JasperFillManager.fillReport(jasperReport, parametros, connection);
            em.getTransaction().commit();            
        } catch (JRException ex) {
            Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            if (em != null) {
                em.close();
            }
        }                 
        return informe;
    }// Fin del metodo reporteCursosMayorAsistencia
    
    
    // Detalle de estudiantes en un curso por departamentos (TABLA)	  	  
    public JasperPrint reporteEstCurDepart(String idCurso, String departamento){
        EntityManager em = null;
        JasperPrint informe= null;
        try {
            em = conexion.getCon().createEntityManager();
            em.getTransaction().begin();
            java.sql.Connection connection = em.unwrap(java.sql.Connection.class);                        
            Map parametros = new HashMap();  // Parametros del Reporte             
            parametros.put("idCurso", idCurso);
            parametros.put("depart", departamento);
            JasperReport jasperReport = null;
            String path = "./src/Reporte/ReportCurEstDepar.jasper";
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);
            informe = JasperFillManager.fillReport(jasperReport, parametros, connection);
            em.getTransaction().commit();            
        } catch (JRException ex) {
            Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            if (em != null) {
                em.close();
            }
        }                 
        return informe;    
    } // Fin del metodo reporteEstCurDepart
    
    // Detalle del reporte de notas por	estudiante.	
    public JasperPrint reporteNotasEstudiante (String cedula) {
        EntityManager em = null;
        JasperPrint informe= null;
        try {
            em = conexion.getCon().createEntityManager();
            em.getTransaction().begin();
            java.sql.Connection connection = em.unwrap(java.sql.Connection.class);                        
            Map parametros = new HashMap();  // Parametros del Reporte             
            parametros.put("cedula_lt", cedula);
            JasperReport jasperReport = null;
            String path = "./src/Reporte/ReportEstNotas.jasper";
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);
            informe = JasperFillManager.fillReport(jasperReport, parametros, connection);
            em.getTransaction().commit();            
        } catch (JRException ex) {
            Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            if (em != null) {
                em.close();
            }
        }                 
        return informe;        
    } // Fin del metodo reporteNotasEstudiante
    
    
    public JasperPrint reporteCursosMayorAsistencia(int anio, int mes) {
        EntityManager em = null;
        JasperPrint informe= null;
        try {
            em = conexion.getCon().createEntityManager();
            em.getTransaction().begin();
            java.sql.Connection connection = em.unwrap(java.sql.Connection.class);                        
            Map parametros = new HashMap();  // Parametros del Reporte             
            parametros.put("anio", anio);
            parametros.put("mes", mes);
            JasperReport jasperReport = null;
            String path = "./src/Reporte/ReportCurMayorAsis.jasper";
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);
            informe = JasperFillManager.fillReport(jasperReport, parametros, connection);
            em.getTransaction().commit();            
        } catch (JRException ex) {
            Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            if (em != null) {
                em.close();
            }
        }                 
        return informe;   
    }
    
  // EntityManager em = emf.createEntityManager();   
//Map parameters = new HashMap();
// EntityManager em = emf.createEntityManager();
// parameters.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER, em);
// JasperRunManager.runReportToPdfFile(fileName, parameters);    
} // Fin de la clase ControladorReportes

//entityManager.getTransaction().begin();
//java.sql.Connection connection = entityManager.unwrap(java.sql.Connection.class);
// ...
//entityManager.getTransaction().commit();


//    private void visualizarReporteTotalInscritosConvocatoria(String nombre_reporte, int id_convocatoria){
//        
//        try {
//            Map parametro_id_convocatoria = new HashMap();
//            parametro_id_convocatoria.put("id_convocatoria",id_convocatoria);
//            JasperReport jasperReport = null;
//            String path = "./src/reportes/"+nombre_reporte;
//            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro_id_convocatoria, this.conexionDB.obtenerConexion());
//            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
//            jasperViewer.setZoomRatio((float) 0.65);
//            
//            Container contenedorViwer = jasperViewer.getContentPane();
//            contenedorViwer.setBounds(0,78,900,501);
//            contenedorViwer.setSize(this.getSize());
//            
//            JFrame ventanaReporte = new JFrame("Reportes");
//            JMenuBar barraMenu = jasperViewer.getJMenuBar();
//            ventanaReporte.setJMenuBar(barraMenu);
//            ventanaReporte.setSize(800, 600);
//            ventanaReporte.getContentPane().add(contenedorViwer);
//            ventanaReporte.setLocationRelativeTo(null);
//            ventanaReporte.setVisible(true);
//           
//        } catch (JRException ex) {
//             JOptionPane.showMessageDialog(
//                    this, "No fue posible visuaizar el Reporte Total Aspirantes Inscritos: \n" +ex.getMessage(), 
//                    "Reporte Total Aspirantes Inscritos", JOptionPane.ERROR_MESSAGE);
//        }
//    }