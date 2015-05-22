/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Curso;
import Logica.Empleado;
import Logica.MasterTeacher;
import Patrones.Observador;
import Persistencia.DaoCurso;
import java.util.ArrayList;
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
public class ControladorAdministradorTest {
    
    public ControladorAdministradorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class ControladorAdministrador.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ControladorAdministrador expResult = null;
        ControladorAdministrador result = ControladorAdministrador.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarEmpleado method, of class ControladorAdministrador.
     */
    @Test
    public void testModificarEmpleado() {
        System.out.println("modificarEmpleado");
        String cedula = "";
        String nombres = "";
        String apellidos = "";
        String email = "";
        String cargo = "";
        String direcion = "";
        String telefono = "";
        boolean estado = false;
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.modificarEmpleado(cedula, nombres, apellidos, email, cargo, direcion, telefono, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaEmpleados method, of class ControladorAdministrador.
     */
    @Test
    public void testListaEmpleados() {
        System.out.println("listaEmpleados");
        ControladorAdministrador instance = new ControladorAdministrador();
        ArrayList<Empleado> expResult = null;
        ArrayList<Empleado> result = instance.listaEmpleados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarEmpleadoPorCedula method, of class ControladorAdministrador.
     */
    @Test
    public void testBuscarEmpleadoPorCedula() {
        System.out.println("buscarEmpleadoPorCedula");
        String id = "";
        ControladorAdministrador instance = new ControladorAdministrador();
        Empleado expResult = null;
        Empleado result = instance.buscarEmpleadoPorCedula(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDaoCurso method, of class ControladorAdministrador.
     */
    @Test
    public void testGetDaoCurso() {
        System.out.println("getDaoCurso");
        ControladorAdministrador instance = new ControladorAdministrador();
        DaoCurso expResult = null;
        DaoCurso result = instance.getDaoCurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearEmpleado method, of class ControladorAdministrador.
     */
    @Test
    public void testCrearEmpleado() {
        System.out.println("crearEmpleado");
        String cedula = "";
        String nombres = "";
        String apellidos = "";
        String email = "";
        String cargo = "";
        String direccion = "";
        String telefono = "";
        boolean estado = false;
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.crearEmpleado(cedula, nombres, apellidos, email, cargo, direccion, telefono, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarMasterTeacherPorCedula method, of class ControladorAdministrador.
     */
    @Test
    public void testBuscarMasterTeacherPorCedula() {
        System.out.println("buscarMasterTeacherPorCedula");
        String id = "";
        ControladorAdministrador instance = new ControladorAdministrador();
        MasterTeacher expResult = null;
        MasterTeacher result = instance.buscarMasterTeacherPorCedula(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaMasterTeacher method, of class ControladorAdministrador.
     */
    @Test
    public void testListaMasterTeacher() {
        System.out.println("listaMasterTeacher");
        ControladorAdministrador instance = new ControladorAdministrador();
        ArrayList<MasterTeacher> expResult = null;
        ArrayList<MasterTeacher> result = instance.listaMasterTeacher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarMasterTeacher method, of class ControladorAdministrador.
     */
    @Test
    public void testModificarMasterTeacher() {
        System.out.println("modificarMasterTeacher");
        String cedula = "";
        String nombre = "";
        String apellido = "";
        String correo = "";
        String ciudad = "";
        String pais = "";
        boolean estado = false;
        Curso idCurso = null;
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.modificarMasterTeacher(cedula, nombre, apellido, correo, ciudad, pais, estado, idCurso);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearMasterTeacher method, of class ControladorAdministrador.
     */
    @Test
    public void testCrearMasterTeacher() {
        System.out.println("crearMasterTeacher");
        String cedula = "";
        String nombre = "";
        String apellido = "";
        String correo = "";
        String ciudad = "";
        String pais = "";
        boolean estado = false;
        Curso IdCurso = null;
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.crearMasterTeacher(cedula, nombre, apellido, correo, ciudad, pais, estado, IdCurso);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarDatosCoordinador method, of class ControladorAdministrador.
     */
    @Test
    public void testValidarDatosCoordinador() {
        System.out.println("validarDatosCoordinador");
        String cedula = "";
        String nombres = "";
        String apellidos = "";
        String email = "";
        String cargo = "";
        String direccion = "";
        String telefono = "";
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.validarDatosCoordinador(cedula, nombres, apellidos, email, cargo, direccion, telefono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarDatosMasterTeacher method, of class ControladorAdministrador.
     */
    @Test
    public void testValidarDatosMasterTeacher() {
        System.out.println("validarDatosMasterTeacher");
        String cedula = "";
        String nombres = "";
        String apellidos = "";
        String email = "";
        String ciudad = "";
        String pais = "";
        Curso curso = null;
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.validarDatosMasterTeacher(cedula, nombres, apellidos, email, ciudad, pais, curso);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaCursosIds method, of class ControladorAdministrador.
     */
    @Test
    public void testListaCursosIds() {
        System.out.println("listaCursosIds");
        ControladorAdministrador instance = new ControladorAdministrador();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.listaCursosIds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearCurso method, of class ControladorAdministrador.
     */
    @Test
    public void testCrearCurso() {
        System.out.println("crearCurso");
        String nombre = "";
        String nombreCorto = "";
        String descripcion = "";
        String contenido = "";
        boolean estado = false;
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.crearCurso(nombre, nombreCorto, descripcion, contenido, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCurso method, of class ControladorAdministrador.
     */
    @Test
    public void testBuscarCurso() {
        System.out.println("buscarCurso");
        String campo = "";
        String valor = "";
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.buscarCurso(campo, valor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdNombreCurso method, of class ControladorAdministrador.
     */
    @Test
    public void testGetIdNombreCurso() {
        System.out.println("getIdNombreCurso");
        ControladorAdministrador instance = new ControladorAdministrador();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getIdNombreCurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdNombreCurso method, of class ControladorAdministrador.
     */
    @Test
    public void testSetIdNombreCurso() {
        System.out.println("setIdNombreCurso");
        ArrayList<String> idNombreCurso = null;
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.setIdNombreCurso(idNombreCurso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaCursoCodigos method, of class ControladorAdministrador.
     */
    @Test
    public void testListaCursoCodigos() {
        System.out.println("listaCursoCodigos");
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.listaCursoCodigos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearFases method, of class ControladorAdministrador.
     */
    @Test
    public void testCrearFases() {
        System.out.println("crearFases");
        String idCurso = "";
        String numeroHoras = "";
        String numeroSemanas = "";
        String tipo = "";
        String contenido = "";
        boolean estado = false;
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.crearFases(idCurso, numeroHoras, numeroSemanas, tipo, contenido, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearPractica method, of class ControladorAdministrador.
     */
    @Test
    public void testCrearPractica() {
        System.out.println("crearPractica");
        String idFase = "";
        String nombre = "";
        String descripcion = "";
        String porcentaje = "";
        boolean estado = false;
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.crearPractica(idFase, nombre, descripcion, porcentaje, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdNombreFases method, of class ControladorAdministrador.
     */
    @Test
    public void testGetIdNombreFases() {
        System.out.println("getIdNombreFases");
        ControladorAdministrador instance = new ControladorAdministrador();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getIdNombreFases();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdNombreFases method, of class ControladorAdministrador.
     */
    @Test
    public void testSetIdNombreFases() {
        System.out.println("setIdNombreFases");
        ArrayList<String> idNombreFases = null;
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.setIdNombreFases(idNombreFases);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listFasesIds method, of class ControladorAdministrador.
     */
    @Test
    public void testListFasesIds() {
        System.out.println("listFasesIds");
        ControladorAdministrador instance = new ControladorAdministrador();
        String expResult = "";
        String result = instance.listFasesIds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adscribir method, of class ControladorAdministrador.
     */
    @Test
    public void testAdscribir() {
        System.out.println("adscribir");
        Observador objObservador = null;
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.adscribir(objObservador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitar method, of class ControladorAdministrador.
     */
    @Test
    public void testQuitar() {
        System.out.println("quitar");
        Observador objObservador = null;
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.quitar(objObservador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notificar method, of class ControladorAdministrador.
     */
    @Test
    public void testNotificar() {
        System.out.println("notificar");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.notificar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
