/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ExcepcionDatos;
import Excepciones.Validaciones;
import Logica.AreaFormacion;
import Logica.GradoEscolarida;
import Logica.LeaderTeacher;
import Logica.LtEnfasis;
import Logica.LtEtnoeducacion;
import Logica.LtNivelEscolaridad;
import Persistencia.Conexion;
import Persistencia.DaoAreaFormacion;
import Persistencia.DaoAspirante;
import Persistencia.DaoGradoEscolarida;
import Persistencia.DaoLeaderTeacher;
import Persistencia.DaoLtEnfasis;
import Persistencia.DaoLtEtnoeducacion;
import Persistencia.DaoLtNivelEscolaridad;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscarsrb
 */
public class ControladorCoordinador {
    
    private Conexion conexion;
    
    // DAOS
    private DaoAspirante daoAspirante;
    private DaoLeaderTeacher daoLeaderTeacher;
    private DaoLtEnfasis daoLtEnfasis;
    private DaoLtEtnoeducacion daoLtEtnoeducacion;
    private DaoLtNivelEscolaridad daoLtNivelEscolaridad;
    private DaoAreaFormacion daoAreaFormacion;
    private DaoGradoEscolarida daoGradoEscolarida;
    
    private LeaderTeacher leaderTeacherBuscado;
    private List <LtEtnoeducacion> lt_etnoeducacion;
    private List <LtNivelEscolaridad> lt_nivel_escolaridad;
    private List <LtEnfasis> lt_enfasis;
    private List <AreaFormacion> area_formacion;
    private List <GradoEscolarida> grado_escolarida;
                    
    
    private static ControladorCoordinador controladorCoordinador;
    
    private ControladorCoordinador() {
        conexion = Conexion.getInstance();
        daoAspirante = new DaoAspirante(conexion.getCon());
        daoLeaderTeacher = new DaoLeaderTeacher(conexion.getCon());   
        daoLtEnfasis = new DaoLtEnfasis(conexion.getCon());
        daoLtEtnoeducacion = new DaoLtEtnoeducacion(conexion.getCon());
        daoLtNivelEscolaridad = new DaoLtNivelEscolaridad(conexion.getCon());
        daoAreaFormacion = new DaoAreaFormacion(conexion.getCon());
        daoGradoEscolarida = new DaoGradoEscolarida(conexion.getCon());    
    } // Fin del Constructor
    
    public static ControladorCoordinador getInstance(){
        if (controladorCoordinador == null) {
            controladorCoordinador = new ControladorCoordinador();
        }
        return controladorCoordinador;
    } // getInstance

    public LeaderTeacher getLeaderTeacherBuscado() {
        return leaderTeacherBuscado;
    }

    public void setLeaderTeacherBuscado(LeaderTeacher leaderTeacherBuscado) {
        this.leaderTeacherBuscado = leaderTeacherBuscado;
    }        
        
    public String consultarLeaderTeacher(int option, String date){
        this.leaderTeacherBuscado = null;
        String result = "OK";        
        try {
            Validaciones.validarCamposVacios(date);
            if (option == 0) {
                LeaderTeacher objLeaderTeacher = daoLeaderTeacher.findLeaderTeacher(date);
                if (objLeaderTeacher!= null) {
                    if (objLeaderTeacher.getEstado() ) {
                        this.leaderTeacherBuscado = objLeaderTeacher;
                    }                    
                }
            } else if (option == 1) {
                LeaderTeacher objLeaderTeacher = daoLeaderTeacher.findLeaderTeacherCorreo(date);
                if (objLeaderTeacher!= null) {
                    if (objLeaderTeacher.getEstado() ) {
                        this.leaderTeacherBuscado = objLeaderTeacher;
                    }                    
                }
            }
            if (leaderTeacherBuscado != null && leaderTeacherBuscado.getEstado()) {
                lt_etnoeducacion
                        = daoLtEtnoeducacion.findLtEtnoeducacionAll(leaderTeacherBuscado.getCedula());

                lt_nivel_escolaridad
                        = daoLtNivelEscolaridad.findLtNivelEscolaridadAll(leaderTeacherBuscado.getCedula());

                area_formacion
                        = daoAreaFormacion.findAreaFormacionAll(leaderTeacherBuscado.getCedula());

                grado_escolarida
                        = daoGradoEscolarida.findGradoEscolaridaAll(leaderTeacherBuscado.getCedula());
                lt_enfasis
                        = daoLtEnfasis.findLtEnfasisaAll(leaderTeacherBuscado.getCedula());
            }
        } catch (ExcepcionDatos excepcionDatos) {
            result = excepcionDatos.getMessage();
        }
        return result;
    } // Fin del metodo consultar LeaderTeacher
            
    public String actualizarLeaderTeacher (String cedula, String nombres, 
            String apellidos, String correo, String celular, String direccion, 
            Date fechanacimiento, String sexo, String zona, 
            String modalidad, String nivelEducacion, String experienciaPreescolar, 
            String experienciaPrimaria, String experienciaSecundaria, 
            String experienciaMedia, String experienciaSuperior, 
            String experienciaRural, String experienciaUrbana, 
            String experienciaSectorPublico, String experienciaSectorPrivado, 
            String experienciaTotal, ArrayList <String> gradoEscolaridadList,                       
            ArrayList<String> ltNivelEscolaridadList, ArrayList<String> ltEtnoeducacionList, 
            ArrayList<String> areaFormacionList, ArrayList<String> ltEnfasisList)  
    {
        String result = "FAIL";
        try {  
            Validaciones.validarCamposVacios(nombres, apellidos, correo, experienciaPreescolar,
                    experienciaPrimaria, experienciaSecundaria, experienciaMedia,
                    experienciaSuperior, experienciaRural, experienciaUrbana,
                    experienciaSectorPublico, experienciaSectorPrivado, experienciaTotal);
            Validaciones.validarConversionInteger(experienciaPreescolar,
                    experienciaPrimaria, experienciaSecundaria, experienciaMedia,
                    experienciaSuperior, experienciaRural, experienciaUrbana,
                    experienciaSectorPublico, experienciaSectorPrivado, experienciaTotal);
            // HACER VALIDACION DE CAMPOS  
            leaderTeacherBuscado.setCedula(cedula);
            leaderTeacherBuscado.setNombres(nombres);
            leaderTeacherBuscado.setApellidos(apellidos);
            leaderTeacherBuscado.setCorreo(correo);
            leaderTeacherBuscado.setCelular(celular);
            leaderTeacherBuscado.setDireccion(direccion);
            leaderTeacherBuscado.setFechanacimiento(fechanacimiento);
            leaderTeacherBuscado.setSexo(sexo);
            leaderTeacherBuscado.setZona(zona);
            leaderTeacherBuscado.setModalidad(modalidad);
            leaderTeacherBuscado.setNivelEducacion(nivelEducacion);
            leaderTeacherBuscado.setExperienciaPreescolar(Integer.parseInt(experienciaPreescolar));
            leaderTeacherBuscado.setExperienciaPrimaria(Integer.parseInt(experienciaPrimaria));
            leaderTeacherBuscado.setExperienciaSecundaria(Integer.parseInt(experienciaSecundaria));
            leaderTeacherBuscado.setExperienciaMedia(Integer.parseInt(experienciaMedia));
            leaderTeacherBuscado.setExperienciaSuperior(Integer.parseInt(experienciaSuperior));
            leaderTeacherBuscado.setExperienciaRural(Integer.parseInt(experienciaRural));
            leaderTeacherBuscado.setExperienciaUrbana(Integer.parseInt(experienciaUrbana));
            leaderTeacherBuscado.setExperienciaSectorPublico(Integer.parseInt(experienciaSectorPublico));
            leaderTeacherBuscado.setExperienciaSectorPribado(Integer.parseInt(experienciaSectorPrivado));
            leaderTeacherBuscado.setExperienciaTotal(Integer.parseInt(experienciaTotal));
            leaderTeacherBuscado.setEstado(true); 
            // Se borra la informacion de los atributos multivaluados
            daoGradoEscolarida.destroyAll(cedula);
            daoLtNivelEscolaridad.destroyAll(cedula);
            daoLtEtnoeducacion.destroyAll(cedula);
            daoAreaFormacion.destroyAll(cedula);
            daoLtEnfasis.destroyAll(cedula);
            for (String gradoEscolaridad: gradoEscolaridadList) {                
                daoGradoEscolarida.create(new GradoEscolarida(cedula, gradoEscolaridad));
            }
            for (String nivEscolaridad: ltNivelEscolaridadList) {               
                daoLtNivelEscolaridad.create(new LtNivelEscolaridad(cedula, nivEscolaridad));
            }
            for (String etno: ltEtnoeducacionList) {                
                daoLtEtnoeducacion.create(new LtEtnoeducacion(cedula, etno));
            }
            for (String areaFormacion: areaFormacionList) {                
                daoAreaFormacion.create(new AreaFormacion(cedula, areaFormacion));
            }
            for (String enfasis: ltEnfasisList) {                
                daoLtEnfasis.create(new LtEnfasis(cedula, enfasis));
            }                            
            daoLeaderTeacher.edit(leaderTeacherBuscado);
            result = "OK";
        } 
        catch (ExcepcionDatos excepcionDatos) {
            result = excepcionDatos.getMessage();
        }
        catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorCoordinador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladorCoordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    } // Fin del metodo actualizarLeaderTeacher   
    
    
    public String eliminarLeaderTeacher(String cedula){
        String result = "";
        int resultOperation = daoLeaderTeacher.updateStatus(cedula, "FALSE");
        if (resultOperation == 1) {
            result = "Operacion Exitosa";
        }
        return result;
    } // Fin del metodo eliminarLeaderTeacher
    
    public List<LtEtnoeducacion> getLt_etnoeducacion() {
        return lt_etnoeducacion;
    }

    public List<LtNivelEscolaridad> getLt_nivel_escolaridad() {
        return lt_nivel_escolaridad;
    }

    public List<LtEnfasis> getLt_enfasis() {
        return lt_enfasis;
    }

    public List<AreaFormacion> getArea_formacion() {
        return area_formacion;
    }

    public List<GradoEscolarida> getGrado_escolarida() {
        return grado_escolarida;
    }           
} // Fin de la clase ControladorCoordinador
