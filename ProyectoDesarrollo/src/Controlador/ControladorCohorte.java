/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Aspirante;
import Logica.Cohorte;
import Logica.Curso;
import Persistencia.DaoCohorte;
import Persistencia.Conexion;
import Persistencia.DaoCurso;
import Persistencia.DaoAspirante;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author ubuntu
 */
public class ControladorCohorte {
    private Conexion conn;
    
    public ControladorCohorte() {
        conn =  Conexion.getInstance();
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
    
    public boolean modificarCohorte(){
        
        return false;
    }
    
    public List <Curso> buscarCursos(){
        Vector <Curso> listado = new Vector<>();
        DaoCurso daoCurso = new DaoCurso(conn.getCon());
        System.out.println("esta iniciando...");
        
        listado = (Vector<Curso>) daoCurso.findCursoEntities();
        
        System.out.println("tamaño = " + listado.size());
        return listado;
    }
    
    public Vector <Aspirante> listarAspirantes(String area, String departamento){
        Vector <Aspirante> listado = new Vector<>();
        DaoAspirante daoAspirante = new DaoAspirante(conn.getCon());
        listado = (Vector <Aspirante>)daoAspirante.buscarAspirantes(area, departamento);
        return listado;
    }
}