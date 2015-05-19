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
        System.out.println("Inicio Test\n");
        this.objConexion = Conexion.getInstance();
        this.contAdministrador = new ControladorAdministrador();       
        this.daoCurso = new DaoCurso(objConexion.getCon());
    }
    
    @After
    public void tearDown() {
        try {
            System.out.println("\nFinal Test");
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
        System.out.println("TEST CREAR CURSO");
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
        System.out.println("\nResultado Operacion: " + result);
        
        // Campos vacios        
        System.out.println("Camino dos");
        nombre = "";
        nombreCorto = "";
        descripcion = "";
        contenido = "";
        estado = true;
        expResult = "Debe llenar todos los campos";
        result = contAdministrador.crearCurso(nombre, nombreCorto, descripcion, contenido, estado);
        assertEquals(expResult, result);   
        System.out.println("Resultado Operacion: " + result);        
        
        // Registro repetido
//        System.out.println("Camino tres");
//        nombre = "Curso 1";
//        nombreCorto = "Cur_1";
//        descripcion = "Primer curso";
//        contenido = "Item 1\nItem 2\n Item 3";
//        estado = true;
//        expResult = "No se pudo insertar el curso";
//        result = contAdministrador.crearCurso(nombre, nombreCorto, descripcion, contenido, estado);
//        assertEquals(expResult, result);   
//        System.out.println("Resultado Operacion: " + result);           
    } // Fin del metodo testCrearCurso

//    @Test
//    public void testDBuscarCurso(){
//        System.out.println("TEST BUSCAR CURSO");
//        String campo = "nombre"; 
//        String valor = "Curso Pollo";
//// IC23     | Curso Pollo                              | Curso Pollo        | Curso Pollo         | Curso Pollo                     | t
//        
//        String expResult = "El curso fue encontrado";
//        String result = contAdministrador.buscarCurso(campo, valor);
//        assertEquals(expResult, result);
//        System.out.println("Resultado Operacion: " + result);
//
//    } // Fin del metodo testBuscarCurso
//    
} // Fin de la clase TestCurso
