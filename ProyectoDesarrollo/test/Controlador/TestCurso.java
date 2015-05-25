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
        System.out.println("\nFin Test\n");
    }
   
    @Test
    public void testCrearCurso() {

        System.out.println("TEST CREAR CURSO");
        // Ingreso  con exito
        System.out.println("\nCamino uno");
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
        System.out.println("Camino tres");
        nombre = "Curso 1";
        nombreCorto = "Cur_1";
        descripcion = "Primer curso";
        contenido = "Item 1\nItem 2\n Item 3";
        estado = true;
        expResult = "El Curso con el nombre Curso 1 ya esta registrado.";
        result = contAdministrador.crearCurso(nombre, nombreCorto, descripcion, contenido, estado);
        assertEquals(expResult, result);
        System.out.println("Resultado Operacion: " + result);
//        try {
//            Curso objCurso = daoCurso.buscarCurso("nombre", "Curso 1");
//            daoCurso.destroy(objCurso.getIdCurso());
//        } catch (IllegalOrphanException ex) {
//            Logger.getLogger(TestCurso.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(TestCurso.class.getName()).log(Level.SEVERE, null, ex);
//        }
    } // Fin del metodo testCrearCurso

    @Test
    public void testDBuscarCurso(){
        System.out.println("TEST BUSCAR CURSO");
        
        // Curso encontrado
        System.out.println("\nCamino uno");
        String campo = "nombre"; 
        String valor = "Curso Pollo";        
        String expResult = "El curso fue encontrado";
        String result = contAdministrador.buscarCurso(campo, valor);
        assertEquals(expResult, result);
        System.out.println("Resultado Operacion: " + result);
        
        // Campos vacios
        System.out.println("\nCamino dos");
        campo = ""; 
        valor = "";        
        expResult = "Debe llenar todos los campos";
        result = contAdministrador.buscarCurso(campo, valor);
        assertEquals(expResult, result);
        System.out.println("Resultado Operacion: " + result);    
        
        // Campo igual a null
        System.out.println("\nCamino tres");
        campo = null;
        valor = "Curso Pollo";
        expResult = "El campo Campos curso  no se ha selecccionado";
        result = contAdministrador.buscarCurso(campo, valor);
        assertEquals(expResult, result);        
        System.out.println("Resultado Operacion: " + result); 
        
    } // Fin del metodo testBuscarCurso
    
} // Fin de la clase TestCurso
