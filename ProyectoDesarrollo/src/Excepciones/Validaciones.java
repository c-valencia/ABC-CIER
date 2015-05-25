package Excepciones;

import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cristian
 */
public class Validaciones {               
    
    public static void validarConversionInteger(String... campo ) throws ExcepcionDatos {
     for (String elemento : campo){ 
        try{
            Integer.parseInt(elemento);
            
        }catch(NumberFormatException e){
            throw new ExcepcionDatos("El dato -"+campo+"- no es un número");
        }
      }
   }
    
   
    public static void validarCamposVacios(String... campo ) throws ExcepcionDatos {
       for (String elemento : campo){
           if(elemento.equals("")){
               throw new ExcepcionDatos("Debe llenar todos los campos");
           }
       }  
    }
    
    public static void validarConversionDouble(String... campo ) throws ExcepcionDatos {
     for (String elemento : campo){ 
        try{
            Double.parseDouble(elemento);
            
        }catch(NumberFormatException e){
            throw new ExcepcionDatos("El dato -"+elemento+"- no es un decimal");
        }
      }
   }
    
   public  void validarColeccion(List array, String  tipo) throws ExcepcionDatos {
    if(array == null){
            throw new ExcepcionDatos("No se encuentran "+tipo+" registrados en la base de datos");
       }
   } 
   
    public static  void validarObjeto(Object object, String  tipo) throws ExcepcionDatos {
    if(object == null){
            throw new ExcepcionDatos("El "+tipo+"  no se encuentra registrados en la base de datos");
       }
    } 
   
    public static  void validarStringNull(String campo, String  tipo) throws ExcepcionDatos {
    if(campo == null){
            throw new ExcepcionDatos("El campo "+tipo+"  no se ha seleccionado");
       }
    } 
    
    public static void validarFechas(Date fechaFinal, Date fechaInicial){
        if (fechaFinal.before(fechaInicial)){
            throw new ExcepcionDatos("El fecha final debe ser mayor a la fecha incial");
        }
        
    }
   
} // Fin de la clase Validaciones
