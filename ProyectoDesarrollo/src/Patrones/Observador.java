/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

/**
 *
 * @author oscar
 */
public interface Observador {
    //actualiza el estado del observador dependiendo si este es notificado o no por el sujeto
    public void actualizar(Sujeto objSujeto);
}
