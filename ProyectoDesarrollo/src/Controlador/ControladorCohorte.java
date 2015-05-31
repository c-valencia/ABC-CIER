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
import Logica.HistorialAspirante;
import Logica.HistorialAspirantePK;
import Logica.LeaderTeacher;
import Logica.Matricula;
import Logica.MatriculaPK;
import Logica.Practica;
import Logica.SendEmail;
import Logica.Tarea;
import Logica.Usuario;
import Persistencia.DaoCohorte;
import Persistencia.Conexion;
import Persistencia.DaoCurso;
import Persistencia.DaoAspirante;
import Persistencia.DaoCursoCohorte;
import Persistencia.DaoHistorialAspirante;
import Persistencia.DaoLeaderTeacher;
import Persistencia.DaoMatricula;
import Persistencia.DaoPractica;
import Persistencia.DaoTarea;
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
    private DaoPractica daoPractica;
    private DaoAspirante daoAspirante;
    private DaoTarea daoTarea;
    private DaoHistorialAspirante daoHistorial;
    private Validaciones validador;
    private DaoMatricula daoMatricula;
    
    public ControladorCohorte() {
        conn =  Conexion.getInstance();
        daoCohorte = new DaoCohorte(conn.getCon());
        daoCurso = new DaoCurso(conn.getCon());
        daoCursoCohorte = new DaoCursoCohorte(conn.getCon());
        daoAspirante = new DaoAspirante(conn.getCon());
        daoPractica = new DaoPractica(conn.getCon());
        daoTarea = new DaoTarea(conn.getCon());
        daoMatricula = new DaoMatricula(conn.getCon());
        daoHistorial = new DaoHistorialAspirante(conn.getCon());
        validador = new Validaciones();
    }
    
    public List <Curso> buscarCursos(){
        Vector <Curso> listado = new Vector<>();
        
        listado = (Vector<Curso>) daoCurso.findCursoEntities();
        return listado;
    }
    
    // busquedas de cohorte
    public Cohorte buscarCohorte(Date fechaInicio, Date fechaFin)
    {
        Cohorte cohorte = new Cohorte();
        
        cohorte.setFechaInicio(fechaInicio);
        cohorte.setFechaFin(fechaFin);
        cohorte.setEstado(true);
        cohorte = daoCohorte.buscarCohorte(cohorte);
        return cohorte;
    }
    
    public Cohorte buscarCohorte(String idCohorte)
    {
        Cohorte cohorte = new Cohorte();
        cohorte = daoCohorte.findCohorte(idCohorte);
        
        return cohorte;
    }
    
    public Vector <Cohorte> buscarCohorte()
    {
        Vector <Cohorte> lista = new Vector<>();
        lista = (Vector<Cohorte>)daoCohorte.findCohorteEntities();
        return lista;
    }
    
    public boolean eliminarCohorte(){
        
        return false;
    }
    
    public void eliminaCursoCohorte(String cohorte, String curso){
        CursoCohortePK ccpk = new CursoCohortePK(cohorte, curso);
        
        try {
            daoCursoCohorte.destroy(ccpk);
            //return false;
        } catch (IllegalOrphanException ex) {
            System.err.println("error en guardar IllegalOrphanException = " + ex.getMessage());
        } catch (NonexistentEntityException ex) {
            System.err.println("error en guardar NonexistentEntityException = " + ex.getMessage());
        }
    }
    
    // OJO REVISAR
    public String ingresarCohorte(Date fechaInicio, Date fechaFin){
        String result = "Error en elguardado";
        
        try{
            Date inicio = buscarCohorte(fechaInicio ,fechaFin).getFechaInicio();

            Date fin = buscarCohorte(fechaInicio ,fechaFin).getFechaFin();
            
            validador.validarCamposVacios(fechaInicio.toString() ,fechaFin.toString());
            validador.validarFechas(fechaFin, fechaInicio);
            
            Cohorte cohorte = new Cohorte();
            cohorte.setFechaInicio(fechaInicio);
            cohorte.setFechaFin(fechaFin);
            cohorte.setEstado(true); 
            
            daoCohorte.insertCohorte(cohorte);
            result = "Guardado exitoso";

            return result;
            
        } catch(ExcepcionDatos ex){
            result = ex.getMessage();
        }catch (Exception ex) {
            System.err.println("error en guardar cohorte = " + ex.getLocalizedMessage());
        }
        return result;
    }

    public Vector<CursoCohorte> buscarCursoCohorte(String idCohorte)
    {
        Vector<CursoCohorte> listado = new Vector<>();
        listado = daoCursoCohorte.buscarCursoCohorte(idCohorte);
        
        return listado;
    }
    
    public boolean ingresarCursosCohorte(String cohorte, String curso){
        CursoCohorte cursoCohorte = new CursoCohorte();
       
        cursoCohorte.setCohorte(new Cohorte(cohorte));
        cursoCohorte.setCurso(new Curso(curso));
        cursoCohorte.setNumEstudiantes(0);
        
        try {
            daoCursoCohorte.create(cursoCohorte);
            return true;
        } catch (Exception ex) {
            System.err.println("error en guardar ingresarCursosCohorte = " + ex.getLocalizedMessage());
        }
        
        return false;
    }
    
    public boolean ingresarMatricula(String cohorte, String curso, String idLT){
        try {
            daoMatricula.ingresarMatricula(cohorte, curso, idLT);
            
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControladorCohorte.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public void eliminarMatricula(String cedulaLt, String idCohorte, String idCurso)
    {
        try {
            daoMatricula.destroy(new MatriculaPK(cedulaLt, idCohorte, idCurso));
        } catch (NonexistentEntityException ex) {
            System.out.println("no existe la matricula = " + cedulaLt + ", " + idCohorte + ", " + idCurso);;
        }
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
    
    public void modificarAspirante(String idCurso, String cedulaAspirante, boolean estado){
        try {
            daoHistorial.modificarHistorial(idCurso, cedulaAspirante, estado);
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
    
    public boolean modificarCohorte(String idCohorte, Date fechaInicio, Date fechaFin){
        Cohorte cohorte = new Cohorte();
        cohorte.setIdCohorte(idCohorte);
        cohorte.setFechaInicio(fechaInicio);
        cohorte.setFechaFin(fechaFin);
        cohorte.setEstado(true);
        try {
            daoCohorte.edit(cohorte);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorCohorte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladorCohorte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Cohorte> listaCohorte () {

        List<Cohorte> listaCohorte = daoCohorte.findCohorteEntities();
        ArrayList<Cohorte> cohorte = new ArrayList<>();

        if (listaCohorte.size() != 0) {

            for (int i = 0; i < listaCohorte.size(); i++) {
                cohorte.add(listaCohorte.get(i));
            }
        } else {

            cohorte = null;
        }
        return cohorte;
    }
    
    public void crearTarea(String cedulaLT, String cursoID){
        Vector <Practica> practicas = new Vector<>();
        practicas = buscarPractica(cursoID);
        
        try {
            for(int i = 0; i < practicas.size(); i++){
                Tarea tarea = new Tarea(practicas.get(i).getIdPractica(), cedulaLT);
                System.out.println("tarea id = " + tarea.getTareaPK().getIdPractica() + " cedula = " + tarea.getTareaPK().getCedulaLt());
                tarea.setNota(new Float("0"));
                System.out.println("nota = " + tarea.getNota());
                daoTarea.crearTarea(tarea);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ControladorCohorte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Vector<Practica> buscarPractica(String cursoID){
        Vector <Practica> practicas = new Vector<>();
        practicas = daoPractica.buscarPracticas(cursoID);
        return practicas;
    }
    
    public void enviarCorreos(String correoLT, String nombre, String cedula)
    {
        SendEmail envio = new SendEmail();
        envio.start("goedi-22@hotmail.com", "Diego Bedoya", "1144039258");
    }
}
