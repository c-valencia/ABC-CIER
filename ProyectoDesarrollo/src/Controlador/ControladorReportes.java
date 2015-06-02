package Controlador;

import Excepciones.ExcepcionDatos;
import Excepciones.Validaciones;
import Logica.Cohorte;
import Logica.Curso;
import Persistencia.Conexion;
import Persistencia.DaoCohorte;
import Persistencia.DaoCurso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
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
    private DaoCurso daoCurso;
    private DaoCohorte daoCohorte;
    private static ControladorReportes contReportes;
    private JasperPrint informe;
    
    
    private ControladorReportes(){       
        conexion = Conexion.getInstance();
        daoCurso = new DaoCurso(conexion.getCon());
        daoCohorte = new DaoCohorte(conexion.getCon());
    }
    
    
    public static ControladorReportes getInstance(){
        if (contReportes == null) {
            contReportes = new ControladorReportes();            
        }
        return contReportes;        
    }          
    
    
    // Detalle de estudiantes en un curso por departamentos - (TABLA)	  	  
    public String reporteEstCurDepart(String idCurso, String departamento){
        EntityManager em = null;
        informe= null;
        String result = "";
        try {
            Validaciones.validarCamposVacios(idCurso, departamento);
            String codCurso = obtenerCodCurso(idCurso);                        
            em = conexion.getCon().createEntityManager();
            em.getTransaction().begin();
            java.sql.Connection connection = em.unwrap(java.sql.Connection.class);                        
            Map parametros = new HashMap();  // Parametros del Reporte             
            parametros.put("idCurso", codCurso);
            parametros.put("depart", departamento);
            JasperReport jasperReport = null;
            String path = "./src/Reporte/ReportCurEstDepar.jasper";
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
    } // Fin del metodo reporteEstCurDepart
    
    
    // Detalle del reporte de notas por	estudiante- (TABLA)
    public String reporteNotasEstudiante (String cedula) {
        EntityManager em = null;
        informe= null;
        String result = "";
        try {
            Validaciones.validarCamposVacios(cedula);
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
            result = "OK";
        } catch (JRException ex) {
            //Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
            result = "Problema al generar el Reporte";
        }catch (ExcepcionDatos excepcionDatos) {
            result = excepcionDatos.getMessage();
        } 
        finally {
            if (em != null) {
                em.close();
            }
        }                 
        return result;        
    } // Fin del metodo reporteNotasEstudiante
    
    
    // Cursos con mayor asistencia en el mes (Top 10) - (GRAFICO)
    public String reporteCursosMayorAsistencia(int anio, int mes) {
        EntityManager em = null;
        String result = "";
        informe= null;
        try {
            Validaciones.validarCamposVacios(""+anio, ""+mes);            
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
            result = "OK";
        } catch (JRException ex) {
            // Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
            result = "Problema al generar el Reporte";
        }catch (ExcepcionDatos excepcionDatos) {
            result = excepcionDatos.getMessage();
        }   finally {
            if (em != null) {
                em.close();
            }
        }                 
        return result;   
    } // Fin del metodo reporteCursosMayorAsistencia
    
    
    // Historico de estudiantes que ha ganado un Curso - (TABLA)
    public String reporteHistoricoEstudCurso(String codCurso){
       EntityManager em = null;
       informe= null;
       String result = "";
        try {
            Validaciones.validarCamposVacios(codCurso);   
            String idCurso = obtenerCodCurso(codCurso);
            em = conexion.getCon().createEntityManager();
            em.getTransaction().begin();
            java.sql.Connection connection = em.unwrap(java.sql.Connection.class);                        
            Map parametros = new HashMap();  // Parametros del Reporte             
            parametros.put("codCurso", idCurso);
            JasperReport jasperReport = null;
            String path = "./src/Reporte/ReportHistEstCursoGanaron.jasper";
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);
            informe = JasperFillManager.fillReport(jasperReport, parametros, connection);
            em.getTransaction().commit();     
            result = "OK";
        } catch (JRException ex) {
            // Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
            result = "Problema al generar el Reporte";
        }catch (ExcepcionDatos excepcionDatos) {
            result = excepcionDatos.getMessage();
        }   finally {
            if (em != null) {
                em.close();
            }
        }                 
        return result;                
    } // Fin del metodo reporteHistoricoEstudCurso

    
    // Curso con menos potencial de avance (TOP 5) - (GRAFICO)
    public String reporteCursoMenosAvance(String codCohorte) {
       EntityManager em = null;
       
       informe= null;
       String result = "";
        try {
            Validaciones.validarCamposVacios(codCohorte);   
            em = conexion.getCon().createEntityManager();
            em.getTransaction().begin();
            java.sql.Connection connection = em.unwrap(java.sql.Connection.class);                        
            Map parametros = new HashMap();  // Parametros del Reporte             
            parametros.put("codCohorte", codCohorte);
            JasperReport jasperReport = null;
            String path = "./src/Reporte/ReportHistEstCursoGanaron.jasper";
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);
            informe = JasperFillManager.fillReport(jasperReport, parametros, connection);
            em.getTransaction().commit();  
            result = "OK";
        } catch (JRException ex) {
            // Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
            result = "Problema al generar el Reporte";
        }catch (ExcepcionDatos excepcionDatos) {
            result = excepcionDatos.getMessage();
        }   finally {
            if (em != null) {
                em.close();
            }
        }            
        return result;     
    } // Fin del metodo reporteCursoMenosAvance
    
    
    // Estudiantes que han llegado en el mes por departamento - (GRAFICO)
    public String reporteEstMesDepart(int anio, int mes){
       EntityManager em = null;
       informe= null;
       String result = "";
        try {
            Validaciones.validarCamposVacios(""+anio, ""+mes); 
            em = conexion.getCon().createEntityManager();
            em.getTransaction().begin();
            java.sql.Connection connection = em.unwrap(java.sql.Connection.class);                        
            Map parametros = new HashMap();  // Parametros del Reporte             
            parametros.put("anio", anio);
            parametros.put("mes", mes);
            JasperReport jasperReport = null;
            String path = "./src/Reporte/ReportEstMesDepart.jasper";
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);
            informe = JasperFillManager.fillReport(jasperReport, parametros, connection);
            em.getTransaction().commit();            
            result = "OK";
        } catch (JRException ex) {
            // Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
            result = "Problema al generar el Reporte";
        }catch (ExcepcionDatos excepcionDatos) {
            result = excepcionDatos.getMessage();
        }   finally {
            if (em != null) {
                em.close();
            }
        }                
        return result;            
    } 

    public ArrayList<String> listarCursos(){
        ArrayList <String> result = null;
        List<Curso> listaCursos = daoCurso.findCursoEntities();
        if (listaCursos.size() > 0) {
            result = new ArrayList <String>();
            for (Curso objCurso : listaCursos) {
                String curso = objCurso.getIdCurso() + " " + objCurso.getNombreCorto();
                result.add(curso);
            }
        }
        return result;
    } // Fin del metodo listarCursos
    
    public ArrayList<String> listarCohortes(){
        ArrayList <String> result = null;
        List<Cohorte> listCohorte = daoCohorte.findCohorteEntities();
        if (listCohorte.size() > 0) {
            result = new ArrayList <String>();
            for (Cohorte objCohorte : listCohorte) {
                String cohorte = objCohorte.getIdCohorte();
                result.add(cohorte);
            }
        }
        return result;
    } // Fin del metodo listarCursos
    
    private String obtenerCodCurso(String infoCurso) {
        String result = "";
        StringTokenizer tokens = new StringTokenizer(infoCurso, " ");
        result = tokens.nextToken();
        return result;
    }
    
    public JasperPrint getInforme() {
        return informe;
    }      
} // Fin de la clase ControladorReportes