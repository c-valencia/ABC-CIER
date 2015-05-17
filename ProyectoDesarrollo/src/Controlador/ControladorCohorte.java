/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Aspirante;
import Logica.Cohorte;
import Logica.Curso;
import Logica.CursoCohorte;
import Logica.CursoCohortePK;
import Persistencia.DaoCohorte;
import Persistencia.Conexion;
import Persistencia.DaoCurso;
import Persistencia.DaoAspirante;
import Persistencia.DaoCursoCohorte;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class ControladorCohorte {
    private Conexion conn;
    
    public ControladorCohorte() {
        conn =  Conexion.getInstance();
    }
    
    public List <Curso> buscarCursos(){
        Vector <Curso> listado = new Vector<>();
        DaoCurso daoCurso = new DaoCurso(conn.getCon());
        System.out.println("esta iniciando...");
        
        listado = (Vector<Curso>) daoCurso.findCursoEntities();
        
        System.out.println("tamaño = " + listado.size());
        return listado;
    }
    
    public Cohorte buscarUnaCohorte(Date fechaInicio, Date fechaFin){
        Cohorte cohorte = new Cohorte();
        DaoCohorte daoCohorte = new DaoCohorte(conn.getCon());
        
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
        DaoCursoCohorte dcc = new DaoCursoCohorte(conn.getCon());
        
        try {
            dcc.destroy(ccpk);
            //return false;
        } catch (IllegalOrphanException ex) {
            System.err.println("error en guardar IllegalOrphanException = " + ex.getLocalizedMessage());
        } catch (NonexistentEntityException ex) {
            System.err.println("error en guardar NonexistentEntityException = " + ex.getLocalizedMessage());
        }
    }
    
    public boolean ingresarCohorte(Date fechaInicio, Date fechaFin){
        Cohorte cohorte = new Cohorte();
        DaoCohorte daoCohorte = new DaoCohorte(conn.getCon());
        
        cohorte.setFechaInicio(fechaInicio);
        cohorte.setFechaFin(fechaFin);
        cohorte.setEstado(true);
        
        try {
            daoCohorte.insertCohorte(cohorte);
            return true;
        } catch (Exception ex) {
            System.err.println("error en guardar cohorte = " + ex.getLocalizedMessage());
        }
        return false;
    }
    
    public boolean ingresarCursosCohorte(String cohorte, String curso){
        CursoCohorte cc = new CursoCohorte();
        DaoCursoCohorte dcc = new DaoCursoCohorte(conn.getCon());
        
        cc.setCohorte(new Cohorte(cohorte));
        cc.setCurso(new Curso(curso));
        cc.setNumEstudiantes(0);
        
        try {
            dcc.create(cc);
            return true;
        } catch (Exception ex) {
            System.err.println("error en guardar ingresarCursosCohorte = " + ex.getLocalizedMessage());
        }
        
        return false;
    }
    
    public boolean ingresarMatricula(){
        
        return false;
    }
    
    public Vector <Aspirante> listarAspirantes(String area, String departamento){
        Vector <Aspirante> listado = new Vector<>();
        DaoAspirante daoAspirante = new DaoAspirante(conn.getCon());
        listado = (Vector <Aspirante>)daoAspirante.buscarAspirantes(area, departamento);
        return listado;
    }
    
    public boolean modificarCohorte(){
        
        return false;
    }
}