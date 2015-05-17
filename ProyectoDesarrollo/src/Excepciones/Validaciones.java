package Excepciones;

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
            throw new ExcepcionDatos("El dato -"+campo+"- no es un decimal");
        }
      }
   }
    
   public  void validarColeccion(List array, String  tipo) throws ExcepcionDatos {
    if(array.isEmpty()){
            throw new ExcepcionDatos("No se encuentran "+tipo+" registrados en la base de datos");
       }
   }         
} // Fin de la clase Validaciones
