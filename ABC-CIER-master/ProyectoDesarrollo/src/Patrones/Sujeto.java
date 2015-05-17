/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

/**
 *
 * @author Cristian Valencia
 * Esta clase equivale el observables, es el objeto que es observado y al realizar un cambio en el, se notifica a la lista de observadores
 */
public interface Sujeto {
    //Ingresa a la lista de obsevadores un observador
    public void adscribir(Observador objObservador);
    // remueve un observador de la lista de observadores
    public void quitar(Observador objObservador);
    // notifica a la lista de observadores que se produjo un evento y que se va a realizar una actualizacion
    public void notificar();       
} // Fin de la interfaz Sujeto

