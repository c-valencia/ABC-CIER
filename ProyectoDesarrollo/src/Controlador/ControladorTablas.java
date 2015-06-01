/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Vector;
import Patrones.*;
import Logica.*;
/**
 *
 * @author cristian
 * Clase que resive una coleccion y por medio de un iterador lo descompone en una matriz disponible luego para construir una tabla
 */
public class ControladorTablas {
    private Vector titulo;
    private Vector cuerpo;
    private ObjectColeccion iterador;
    
   /*
    * Construye el titulo de la tabla de pendiendo de que tipo de objeto de vaya a listar
    */ 
    
   public ControladorTablas(Vector datos){
//              Aspirante a = new Aspirante("1","","","","","","","","","","",true,"",true);
//        Aspirante b = new Aspirante("2","","","","","","","","","","",true,"",true);
//        Aspirante c = new Aspirante("3","","","","","","","","","","",true,"",true);
//        Vector prueba = new Vector();
//        prueba.add(a.toArray());
//        prueba.add(b.toArray());
//        prueba.add(c.toArray());
//       datos = prueba;
       
       titulo = new Vector();
       cuerpo = new Vector();
       System.out.println("tamaño del vector dentro del iterador"+datos.size());
       iterador = new ObjectColeccion(datos);
   }
    
    public Vector titulos(int tipo){
        switch (tipo) {
            case 1: {
                titulo.add("Nombre");
                titulo.add("Apellido");
                titulo.add("Documento");
                titulo.add("Correo");
                titulo.add("Celular");
                titulo.add("Sede");
                titulo.add("Código Dane");
                titulo.add("Grado");
                titulo.add("Secretaria");
                titulo.add("Municipio");
                titulo.add("Area");
                titulo.add("Actualmente es tutor PTA");
                titulo.add("Usuario Colombia Aprende");
                titulo.add("Estado");
                
               
            };break;
            case 2 : {
                titulo.add("Documento");
                titulo.add("Nombres");
                titulo.add("Apellidos");
                titulo.add("Correo");
                titulo.add("SI/NO");
            };break;
            case 3 : {
               titulo.add("Practica"); 
               titulo.add("Porcentaje Practica"); 
               titulo.add("Notas");
            };break;
            case 4:
                titulo.add("CODIGO");
                titulo.add("FECHA INICIO");
                titulo.add("FECHA FIN");
                titulo.add("MODIFICAR (UNO)");
                break;
            default: {
                System.out.println("Titulos invalidos");
            };
        }
        return titulo;
    }
    
    /*
    * descompone la coleccion que llego por medio de un iterador y luego lo pasa a una matriz que es el cuerpo de la tabla
    */ 
    
    public Vector contruirCuerpo(int obj){
        ObjetoIterador libroIterator = iterador.iterator();
        
        switch(obj){
            case 1:
                System.out.println("se agrego al objeto");
                while (libroIterator.hasNext()) {
                    Object objeto = libroIterator.next();

                    cuerpo.add(objeto);
                }
                
            case 2:
                int i = 0;
                while (libroIterator.hasNext()) {
                    Aspirante objeto = (Aspirante) libroIterator.next();
                    //Object objeto = libroIterator.next();
                    Vector objetos = new Vector();
                    
                    objetos.add(objeto.getCedula());
                    objetos.add(objeto.getNombres());
                    objetos.add(objeto.getApellidos());
                    objetos.add(objeto.getCorreo());
                    objetos.add(false);
                    cuerpo.add(objetos);
                    System.out.println(cuerpo.get(i));
                    i++;
                }
                System.out.println("se agrego al objeto aspirante");
                break;
            case 3:
                int j = 0;
                while (libroIterator.hasNext()) {
                    Tarea objeto = (Tarea) libroIterator.next();
                    //Object objeto = libroIterator.next();
                    Vector objetos2 = new Vector();
                    objetos2.add(objeto.getPractica().getNombre());
                    objetos2.add(objeto.getPractica().getPorcentaje());
                    objetos2.add(objeto.getNota());
                    cuerpo.add(objetos2);
                    System.out.println(cuerpo.get(j));
                    j++;
                }
                System.out.println("se agrego al objeto 2");
                break;
            case 4:
                while (libroIterator.hasNext()) {
                    Cohorte objeto = (Cohorte) libroIterator.next();
                    //Object objeto = libroIterator.next();
                    Vector objetos2 = new Vector();
                    objetos2.add(objeto.getIdCohorte());
                    objetos2.add(objeto.getFechaInicio());
                    objetos2.add(objeto.getFechaFin());
                    objetos2.add(false);
                    cuerpo.add(objetos2);
                }
                break;
        }
        return cuerpo;
    }
    
    
    
}
