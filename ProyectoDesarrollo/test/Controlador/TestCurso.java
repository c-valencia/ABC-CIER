/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Curso;
import Persistencia.Conexion;
import Persistencia.DaoCurso;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oscar Steven Romero Beron - 1326750
 */
public class TestCurso {
    
    private Conexion objConexion;
    private ControladorAdministrador contAdministrador;
    private DaoCurso daoCurso;
    
    public TestCurso() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Inicio Test");
        this.objConexion = Conexion.getInstance();
        this.contAdministrador = new ControladorAdministrador();       
        this.daoCurso = new DaoCurso(objConexion.getCon());
    }
    
    @After
    public void tearDown() {
        try {
            System.out.println("Final Test");
            Curso objCurso = daoCurso.buscarCurso("nombre", "Curso 1");
            daoCurso.destroy(objCurso.getIdCurso());
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(TestCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(TestCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Test
    public void testCrearCurso() {
        // Ingreso  con exito
        System.out.println("Camino uno");
        String nombre = "Curso 1";
        String nombreCorto = "Cur_1";
        String descripcion = "Primer curso";
        String contenido = "Item 1\nItem 2\n Item 3";
        boolean estado = true;                        
        String expResult = "Se ingreso un curso con éxito";
        String result = contAdministrador.crearCurso(nombre, nombreCorto, descripcion, contenido, estado);
        assertEquals(expResult, result);               
        
        System.out.println("Camino dos");
        nombre = "";
        nombreCorto = "";
        descripcion = "";
        contenido = "";
        estado = true;
        
        
    } // Fin del metodo testCrearCurso
    
//    public String crearCurso(String nombre, String nombreCorto, String descripcion, String contenido, boolean estado) {
//        String result = "";
//        try {
//            validador.validarCamposVacios(nombre, nombreCorto, descripcion, contenido);
//            Curso curso = new Curso();
//            curso.setNombre(nombre);
//            curso.setNombreCorto(nombreCorto);
//            curso.setDescripcion(descripcion);
//            curso.setContenido(contenido);
//            curso.setEstado(estado);
//            daoCurso.insertarCurso(curso);
//            //notificar();
//
//            
//            result = "Se ingreso un curso con éxito";
//        } catch (ExcepcionDatos ex) {
//            result = ex.getMessage();
//
//        } catch (NullPointerException ex) {
//
//            result = "Ingreso un objeto vacio";
//        } catch (Exception ex) {
//            Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
//            result = "No se pudo insertar el curso";
//        }
//
//        return result;
//    }
//        
} // Fin de la clase TestCurso
