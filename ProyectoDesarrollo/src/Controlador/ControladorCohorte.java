/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ExcepcionDatos;
import Excepciones.Validaciones;
import Logica.Aspirante;
import Logica.Cohorte;
import Logica.Curso;
import Logica.CursoCohorte;
import Logica.CursoCohortePK;
import Logica.LeaderTeacher;
import Logica.Matricula;
import Logica.MatriculaPK;
import Logica.Usuario;
import Persistencia.DaoCohorte;
import Persistencia.Conexion;
import Persistencia.DaoCurso;
import Persistencia.DaoAspirante;
import Persistencia.DaoCursoCohorte;
import Persistencia.DaoLeaderTeacher;
import Persistencia.DaoMatricula;
import Persistencia.DaoUsuario;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ubuntu
 */
public class ControladorCohorte {
    private Conexion conn;
    private DaoCohorte daoCohorte;
    private DaoCurso daoCurso;
    private DaoCursoCohorte daoCursoCohorte;
    private DaoAspirante daoAspirante;
    private Validaciones validador;
    
    public ControladorCohorte() {
        conn =  Conexion.getInstance();
        daoCohorte = new DaoCohorte(conn.getCon());
        daoCurso = new DaoCurso(conn.getCon());
        daoCursoCohorte = new DaoCursoCohorte(conn.getCon());
        daoAspirante = new DaoAspirante(conn.getCon());
        validador = new Validaciones();
    }
    
    public List <Curso> buscarCursos(){
        Vector <Curso> listado = new Vector<>();
        System.out.println("esta iniciando...");
        
        listado = (Vector<Curso>) daoCurso.findCursoEntities();
        
        System.out.println("tamaño = " + listado.size());
        return listado;
    }
    
    public Cohorte buscarUnaCohorte(Date fechaInicio, Date fechaFin){
        Cohorte cohorte = new Cohorte();
        
        cohorte.setFechaInicio(fechaInicio);
        cohorte.setFechaFin(fechaFin);
        cohorte.setEstado(true);
        cohorte = daoCohorte.buscarCohorte(cohorte);
        return cohorte;
    }
    
    public boolean eliminarCohorte(){
        
        return false;
    }
    
    public void eliminaCursoCohorte(String cohorte, String curso){
        CursoCohortePK ccpk = new CursoCohortePK(cohorte, curso);
       // DaoCursoCohorte daoCursoCohorte = new DaoCursoCohorte(conn.getCon());
        
        try {
            daoCursoCohorte.destroy(ccpk);
            //return false;
        } catch (IllegalOrphanException ex) {
            System.err.println("error en guardar IllegalOrphanException = " + ex.getLocalizedMessage());
        } catch (NonexistentEntityException ex) {
            System.err.println("error en guardar NonexistentEntityException = " + ex.getLocalizedMessage());
        }
    }
    
    public String ingresarCohorte(Date fechaInicio, Date fechaFin){
        String result = "Error en elguardado";
        
        try{
            Date inicio = buscarUnaCohorte(fechaInicio ,fechaFin).getFechaInicio();
            Date fin = buscarUnaCohorte(fechaInicio ,fechaFin).getFechaFin();
            
            if(inicio){
            validador.validarFechas(fechaFin, fechaInicio);
            Cohorte cohorte = new Cohorte();
            cohorte.setFechaInicio(fechaInicio);
            cohorte.setFechaFin(fechaFin);
            cohorte.setEstado(true);
        
        
            daoCohorte.insertCohorte(cohorte);
            result = "Guardado exitoso";
            }
            return result;
            
        } catch(ExcepcionDatos ex){
            result = ex.getMessage();
        }catch (Exception ex) {
            System.err.println("error en guardar cohorte = " + ex.getLocalizedMessage());
        }
        return result;
    }
    
    public boolean ingresarCursosCohorte(String cohorte, String curso){
        CursoCohorte cc = new CursoCohorte();
       
        cc.setCohorte(new Cohorte(cohorte));
        cc.setCurso(new Curso(curso));
        cc.setNumEstudiantes(0);
        
        try {
            daoCursoCohorte.create(cc);
            return true;
        } catch (Exception ex) {
            System.err.println("error en guardar ingresarCursosCohorte = " + ex.getLocalizedMessage());
        }
        
        return false;
    }
    
    public boolean ingresarMatricula(String cohorte, String curso, String idLT){
        try {
            DaoMatricula dm = new DaoMatricula(conn.getCon());
            
            dm.ingresarMatricula(cohorte, curso, idLT);
            
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControladorCohorte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public  boolean ingresarLT(Aspirante aspirante){
        LeaderTeacher objLeaderTeacher = null;
        DaoLeaderTeacher dlt = new DaoLeaderTeacher(conn.getCon());
        try {  
            // leaderTeacherBuscado
            // HACER VALIDACION DE CAMPOS
            objLeaderTeacher = new LeaderTeacher();                                    
            objLeaderTeacher.setCedula(aspirante.getCedula());
            objLeaderTeacher.setNombres(aspirante.getNombres());
            objLeaderTeacher.setApellidos(aspirante.getApellidos());
            objLeaderTeacher.setCorreo(aspirante.getCorreo());
            objLeaderTeacher.setCelular(aspirante.getCelular());
            objLeaderTeacher.setDireccion(aspirante.getDireccion());
            objLeaderTeacher.setMunicipio(aspirante.getMunicipio());
            objLeaderTeacher.setDepartamento(aspirante.getDepartamento());
            objLeaderTeacher.setSedePertenece(aspirante.getSedePertenece());                     
            objLeaderTeacher.setIntitucion(aspirante.getIntitucion());
            objLeaderTeacher.setCodigoDaneIntitucion(aspirante.getCodigoDaneIntitucion());

            objLeaderTeacher.setGrado(aspirante.getGrado());
            objLeaderTeacher.setSecretariaEducacion(aspirante.getSecretariaEducacion());

            objLeaderTeacher.setAreaInscripcion(aspirante.getAreaInscripcion());
            objLeaderTeacher.setTutorPta(aspirante.getTutorPta());

            objLeaderTeacher.setUsuarioColombiaAprende(aspirante.getUsuarioColombiaAprende());
            objLeaderTeacher.setEstado(true);
            dlt.create(objLeaderTeacher);
        } catch (Exception ex) {
            Logger.getLogger(ControladorCoordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Vector <Aspirante> listarAspirantes(String area, String departamento){
        Vector <Aspirante> listado = new Vector<>();
        listado = (Vector <Aspirante>)daoAspirante.buscarAspirantes(area, departamento);
        return listado;
    }
    
    public void modificarAspirante(Aspirante  aspirante){
        aspirante.setEstado(false);
        try {
            daoAspirante.edit(aspirante);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorCohorte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladorCohorte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearUsuario(Aspirante  aspirante){
        String login = aspirante.getCedula();
        String pass = aspirante.getCedula();
        DaoUsuario daoUsario = new DaoUsuario(conn.getCon());
        try {
            daoUsario.create(new Usuario(login, pass, "Leader Teacher", aspirante.getCedula()));
        } catch (Exception ex) {
            Logger.getLogger(ControladorCohorte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean modificarCohorte(){
        
        return false;
    }
}