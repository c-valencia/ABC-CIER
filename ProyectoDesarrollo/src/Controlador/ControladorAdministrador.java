/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ExcepcionDatos;
import Excepciones.Validaciones;
import Logica.Curso;
import Logica.*;
import Patrones.Observador;
import Patrones.Sujeto;
import Persistencia.Conexion;
import Persistencia.DaoAspirante;
import Persistencia.DaoEmpleado;
import java.util.logging.Level;
import java.util.logging.Logger;
import Persistencia.DaoCurso;
import Persistencia.DaoFases;
import Persistencia.DaoHistorialAspirante;
import Persistencia.DaoMasterTeacher;
import Persistencia.DaoPractica;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author Julian
 */
public class ControladorAdministrador implements Sujeto {
    
    //patron observador
    private ArrayList listObservadores;
    

    private DaoEmpleado daoEmpleado;
    private DaoCurso daoCurso;
    private DaoFases daoFase;
    private DaoPractica daoPractica;
    private DaoAspirante daoAspirante;
    private Conexion conexion;
    private DaoMasterTeacher daoMasterTeacher;
    private DaoHistorialAspirante daoHistorialAspirante;
    private static ControladorAdministrador controladorAdministrador;
    private Validaciones validador;
    private ArrayList <String> idNombreCurso;
    private ArrayList <String> idNombreFases;
    private ArrayList <String> idNombreFasesPorCurso;
    
    private Curso curso;
    private Fases fase;

    public ControladorAdministrador() {
        conexion = Conexion.getInstance();
        daoEmpleado = new DaoEmpleado(conexion.getCon());
        daoCurso = new DaoCurso(conexion.getCon());
        daoFase = new DaoFases(conexion.getCon());
        daoPractica = new DaoPractica(conexion.getCon());
        daoAspirante = new DaoAspirante(conexion.getCon());
        daoMasterTeacher = new DaoMasterTeacher(conexion.getCon());
        daoHistorialAspirante = new DaoHistorialAspirante(conexion.getCon());
        idNombreCurso = new ArrayList<String>();
        idNombreFases = new ArrayList<String>();
        idNombreFasesPorCurso = new ArrayList<String>();
        validador = new Validaciones();
        curso = new Curso();
        fase = new Fases();
        //patron observador, lista de observador
        listObservadores = new ArrayList();
    }
    
   

    public static ControladorAdministrador getInstance() {
        if (controladorAdministrador == null) {
            controladorAdministrador = new ControladorAdministrador();
        }
        return controladorAdministrador;
    }

    public String modificarEmpleado(String cedula, String nombres, String apellidos, String email,
            String cargo, String direcion, String telefono, boolean estado) {

        String result = "";
        try {
            Empleado empleado = new Empleado(cedula, nombres, apellidos, email, cargo, direcion, telefono, estado);
            daoEmpleado.edit(empleado);
            result = "1";
        } catch (NullPointerException ex) {

            result = "Ingreso un objeto vacio";
        } catch (Exception ex) {
            Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            result = "No se pudo insertar el curso";
        }

        return result;
    }

    public ArrayList<Empleado> listaEmpleados() {

        List<Empleado> listaEmpleados = daoEmpleado.findEmpleadoEntities();
        ArrayList<Empleado> empleados = new ArrayList<>();

        if (listaEmpleados.size() != 0) {

            for (int i = 0; i < listaEmpleados.size(); i++) {
                empleados.add(listaEmpleados.get(i));
            }
        } else {

            empleados = null;
        }
        return empleados;
    }

    public Empleado buscarEmpleadoPorCedula(String id) {
        return daoEmpleado.findEmpleado(id);
    }

    

    // Getters and Setters
    public DaoCurso getDaoCurso() {
        return daoCurso;
    }

    //

    
    
    

    public String crearEmpleado(String cedula, String nombres, String apellidos, String email,
            String cargo, String direccion, String telefono, boolean estado) {
        String result = "";
        try {
            Empleado nuevoEmpleado = new Empleado(cedula, nombres, apellidos, email,
                    cargo, direccion, telefono, estado);
            daoEmpleado.create(nuevoEmpleado);
            result = "1";
        } // Fin del metodo crearAspirante
        catch (Exception ex) {
            Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            result = "No se realizo la operacion";
        }
        return result;
    }

    public MasterTeacher buscarMasterTeacherPorCedula(String id) {
        return daoMasterTeacher.findMasterTeacher(id);
    }

    public ArrayList<MasterTeacher> listaMasterTeacher() {

        List<MasterTeacher> listaMt = daoMasterTeacher.findMasterTeacherEntities();
        ArrayList<MasterTeacher> mt = new ArrayList<>();

        if (listaMt.size() != 0) {

            for (int i = 0; i < listaMt.size(); i++) {
                mt.add(listaMt.get(i));
            }
        } else {

            mt = null;
        }
        return mt;
    }

    public String modificarMasterTeacher(String cedula, String nombre, String apellido, String correo,
            String ciudad, String pais, boolean estado, Curso idCurso) { ////////////////////////////777

        String result = "";
        try {
            MasterTeacher master = new MasterTeacher(cedula, nombre, apellido, correo, ciudad, pais, estado, idCurso);
            daoMasterTeacher.edit(master);
            result = "1";
        } catch (NullPointerException ex) {

            result = "Ingreso un objeto vacio";
        } catch (Exception ex) {
            Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            result = "No se pudo insertar el curso";
        }

        return result;
    }

    public String crearMasterTeacher(String cedula, String nombre, String apellido, String correo,
            String ciudad, String pais, boolean estado, Curso IdCurso) {
        String result = "";
        try {
            MasterTeacher nuevoMasterTeacher = new MasterTeacher(cedula, nombre, apellido, correo,
                    ciudad, pais, estado, IdCurso);
            daoMasterTeacher.create(nuevoMasterTeacher);
            result = "1";
        } // Fin del metodo crearAspirante
        catch (Exception ex) {
            Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            result = "No se realizo la operacion";
        }
        return result;
    }

    public String validarDatosCoordinador(String cedula, String nombres, String apellidos, String email, String cargo,
            String direccion, String telefono) {
        String respuesta = "1";

        if (cedula.equals("") || nombres.equals("") || apellidos.equals("") || email.equals("")
                || cargo.equals("") || direccion.equals("") || telefono.equals("")) {
            respuesta = "Debes llenar todos los campos";
        } else {
            int a = 0;
            try {
                a = Integer.parseInt(cedula);
                a = Integer.parseInt(telefono);
            } catch (Exception ex) {
                respuesta = "Los campos como la Cedula y el telefono se debe llenar solo con numeros";
            }
        }
        return respuesta;
    }

    public String validarDatosMasterTeacher(String cedula, String nombres, String apellidos, String email, String ciudad, String pais,
            Curso curso) {
        String respuesta = "1";
        if (cedula.equals("") || nombres.equals("") || apellidos.equals("") || email.equals("")
                || ciudad.equals("") || pais.equals("") || curso == null) {
            respuesta = "Debes llenar todos los campos";
        } else {
            int a = 0;
            try {
                a = Integer.parseInt(cedula);
            } catch (Exception ex) {
                respuesta = "El campo cedula  se debe llenar solo con numeros";
            }
        }
        return respuesta;
    }

    public ArrayList<String> listaCursosIds() {

        List<Curso> cursos = daoCurso.findCursoEntities();
        ArrayList<String> idNombreCurso = new ArrayList<String>();

        if (cursos.size() != 0) {

            for (int i = 0; i < cursos.size(); i++) {
                String idNombre = "" + cursos.get(i).getIdCurso() + " " + cursos.get(i).getNombre();
                idNombreCurso.add(idNombre);
            }
        } else {

            idNombreCurso = null;
        }
        return idNombreCurso;
    }

    
    // CRISTIAN
    
    public String crearCurso(String nombre, String nombreCorto, String descripcion, String contenido, boolean estado) {
        String result = "";
        try {
            validador.validarCamposVacios(nombre, nombreCorto, descripcion, contenido);
            Curso curso = new Curso();
            curso.setNombre(nombre);
            curso.setNombreCorto(nombreCorto);
            curso.setDescripcion(descripcion);
            curso.setContenido(contenido);
            curso.setEstado(estado);
            daoCurso.insertarCurso(curso);
            result = "Se ingreso un curso con éxito";
        }catch (PreexistingEntityException ex) {
            result = ex.getMessage();       
        }
        catch (ExcepcionDatos ex) {
            result = ex.getMessage();
        } catch (NullPointerException ex) {
            result = "Ingreso un objeto vacio";
        } catch (Exception ex) {
            result = "No se pudo insertar el curso";
        }

        return result;
    }
    

    public String buscarCurso(String campo, String valor){
        String result = "";
        try{
            validador.validarCamposVacios(valor);
            validador.validarStringNull(campo,"Campos curso");
            Curso curso = daoCurso.buscarCurso(campo, valor);
             this.curso = curso;
             result = "El curso fue encontrado";
        }catch(NoResultException ex){
            result = ex.getMessage();
        }
        
        catch(ExcepcionDatos ex){
            result = ex.getMessage();
        }
        return result;
    }
    
    public String modificarCurso(String nombreCorto, String descripcion, String contenido){
        String result = "";
        try{
            validador.validarCamposVacios(nombreCorto,descripcion,contenido);
            curso.setNombreCorto(nombreCorto);
            curso.setDescripcion(descripcion);
            curso.setContenido(contenido);
            daoCurso.edit(curso);
            result = "El curso con el id "+curso.getIdCurso()+" fue modificado con exito";
            
        }catch(ExcepcionDatos ex){
            result = ex.getMessage();
        }catch(NonexistentEntityException ex){
            result = ex.getMessage();
        }catch(Exception ex){
            result = ex.getMessage();
        }
        return result;
    }

    public ArrayList<String> getIdNombreCurso() {
        return idNombreCurso;
    }

    public void setIdNombreCurso(ArrayList<String> idNombreCurso) {
        this.idNombreCurso = idNombreCurso;
    }

    public String listaCursoCodigos() {
        String result = "";
        try {
            List<Curso> cursos = daoCurso.findCursoEntities();
            System.out.print("el tamaño de la lista es "+cursos.size());
            validador.validarColeccion(cursos, "curso");
            result = "Se listaron los cursos con exito";
            idNombreCurso = new ArrayList<String>();
            for (int i = 0; i < cursos.size(); i++) {
                if (cursos.get(i).getEstado() != false) {
                    String idNombre = "" + cursos.get(i).getIdCurso() + " " + cursos.get(i).getNombre();
                    idNombreCurso.add(idNombre);
                }
            }
        } catch (ExcepcionDatos ex) {
            result = ex.getMessage();
        }
        return result;
    }

    public String crearFases(String idCurso, String numeroHoras, String numeroSemanas, String tipo, String contenido, boolean estado) {
        String result = "";

        try {

            validador.validarCamposVacios(idCurso, tipo, contenido, numeroHoras, numeroSemanas);
            Curso temp = new Curso();
            temp.setIdCurso(idCurso);
            Fases fase = new Fases();
            fase.setIdCurso(temp);
            fase.setTipo(tipo);
            fase.setContenido(contenido);

            validador.validarConversionInteger(numeroHoras, numeroSemanas);
                fase.setNumeroHoras(Integer.parseInt(numeroHoras));
                fase.setNumeroSemanas(Integer.parseInt(numeroSemanas));
            
            fase.setEstado(estado);
            daoFase.insertarFase(fase);
            result = "La fase fue adicionada con exito";
        } catch (ExcepcionDatos ex) {
            result = ex.getMessage();
        } catch (Exception ex) {
            result = "No se pudo ingresar la fase";
        }

        return result;
    }

    public String crearPractica(String idFase, String nombre, String descripcion, String porcentaje, boolean estado) {
        String result = "";
        try {
            validador.validarCamposVacios(idFase, nombre, descripcion, porcentaje);
            Fases temp = new Fases();
            temp.setIdFase(idFase);
            Practica practica = new Practica();
            practica.setIdFase(temp);
            practica.setNombre(nombre);
            practica.setDescripcion(descripcion);
            validador.validarConversionDouble(porcentaje);
            practica.setPorcentaje(Double.parseDouble(porcentaje));

            daoPractica.insertarPractica(practica);

            result = "La practica fue ingrezada con exito";
        } catch (ExcepcionDatos ex) {
            result = ex.getMessage();
        } catch (Exception ex) {
            result = "No se pudo ingresar la practica";
        }
        return result;
    }

    public String buscarFase(String idFase){
        String result = "";
        
        try{
            validador.validarStringNull(idFase,"Fase");
            validador.validarCamposVacios(idFase);
           Fases fase = daoFase.findFases(idFase);
             this.fase = fase;
             result = "El fase fue encontrado";
        }catch(NoResultException ex){
            result = ex.getMessage();
        }
        
        catch(ExcepcionDatos ex){
            result = ex.getMessage();
        }
        return result;
    }
    
    public String modificarFase(String numeroHoras, String numeroSemanas, String tipo, String contenido){
        String result = "";
        try{
            validador.validarCamposVacios(numeroHoras,numeroSemanas,contenido, tipo);
            validador.validarConversionInteger(numeroHoras,numeroSemanas);
            fase.setNumeroHoras(Integer.parseInt(numeroHoras));
            fase.setNumeroSemanas(Integer.parseInt(numeroSemanas));
            fase.setTipo(tipo);
            fase.setContenido(contenido);
            daoFase.edit(fase);
            result = "La fase  con el id "+fase.getIdFase()+" fue modificado con exito";
            
        }catch(ExcepcionDatos ex){
            result = ex.getMessage();
        }catch(NonexistentEntityException ex){
            result = ex.getMessage();
        }catch(Exception ex){
            result = ex.getMessage();
        }
        return result;
    }

    public Fases getFase() {
        return fase;
    }

    public void setFase(Fases fase) {
        this.fase = fase;
    }
    
    public ArrayList<String> getIdNombreFases() {
        return idNombreFases;
    }

    public void setIdNombreFases(ArrayList<String> idNombreFases) {
        this.idNombreFases = idNombreFases;
    }

    public ArrayList<String> getIdNombreFasesPorCurso() {
        return idNombreFasesPorCurso;
    }

    public void setIdNombreFasesPorCurso(ArrayList<String> idNombreFasesPorCurso) {
        this.idNombreFasesPorCurso = idNombreFasesPorCurso;
    }

    public String listFasesIdsPorCurso(String idCurso) {
        String result = "";
        try {
            List<Fases> fases = daoFase.findFasesEntities();
            validador.validarColeccion(fases, "fases");
            result = "Se listaron las fases con exito";
            idNombreFasesPorCurso = new ArrayList<String>();

            for (int i = 0; i < fases.size(); i++) {
                if (fases.get(i).getEstado() != false && fases.get(i).getIdCurso().getIdCurso().equals(idCurso)) {
                    String idNombre = "" + fases.get(i).getIdFase();
                    idNombreFasesPorCurso.add(idNombre);
                }
            }
            System.out.println("-------------------> "+idNombreFasesPorCurso.size());
            if(idNombreFasesPorCurso.size()==0){
                result = "El curso seleccionado no tiene fases asignadas";
            }

        } catch (ExcepcionDatos ex) {
            result = ex.getMessage();
        }
        return result;
    }
    
     public String listFasesIds() {
        String result = "";
        try {
            List<Fases> fases = daoFase.findFasesEntities();
            validador.validarColeccion(fases, "fases");
            result = "Se listaron las fases con exito";
            idNombreFases = new ArrayList<String>();

            for (int i = 0; i < fases.size(); i++) {
                if (fases.get(i).getEstado() != false) {
                    String idNombre = "" + fases.get(i).getIdFase();
                    idNombreFases.add(idNombre);
                }
            }

        } catch (ExcepcionDatos ex) {
            result = ex.getMessage();
        }
        return result;
    }
    

    @Override
    public void adscribir(Observador objObservador) {        
        listObservadores.add(objObservador);
        System.out.println("Adscribir->" + listObservadores.size());
        //notificar();
    }

    public Curso getCurso() {
        return curso;
    }

    @Override
    public void quitar(Observador objObservador) {
        listObservadores.remove(objObservador);
    }

    @Override
    public void notificar() {
        System.out.print("\nme actualice la cantida de observadores son "+listObservadores.size());
        for (int x = 0; x < listObservadores.size(); x++) {
            Observador objObservador = (Observador) listObservadores.get(x);
         
            objObservador.actualizar(this);
        }
    }
    
}
