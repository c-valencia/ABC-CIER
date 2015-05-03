/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author cristian
 */
@Embeddable
public class LtNivelEscolaridadPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cedula_lt")
    private String cedulaLt;
    @Basic(optional = false)
    @Column(name = "nivel_escolaridad")
    private String nivelEscolaridad;

    public LtNivelEscolaridadPK() {
    }

    public LtNivelEscolaridadPK(String cedulaLt, String nivelEscolaridad) {
        this.cedulaLt = cedulaLt;
        this.nivelEscolaridad = nivelEscolaridad;
    }

    public String getCedulaLt() {
        return cedulaLt;
    }

    public void setCedulaLt(String cedulaLt) {
        this.cedulaLt = cedulaLt;
    }

    public String getNivelEscolaridad() {
        return nivelEscolaridad;
    }

    public void setNivelEscolaridad(String nivelEscolaridad) {
        this.nivelEscolaridad = nivelEscolaridad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaLt != null ? cedulaLt.hashCode() : 0);
        hash += (nivelEscolaridad != null ? nivelEscolaridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtNivelEscolaridadPK)) {
            return false;
        }
        LtNivelEscolaridadPK other = (LtNivelEscolaridadPK) object;
        if ((this.cedulaLt == null && other.cedulaLt != null) || (this.cedulaLt != null && !this.cedulaLt.equals(other.cedulaLt))) {
            return false;
        }
        if ((this.nivelEscolaridad == null && other.nivelEscolaridad != null) || (this.nivelEscolaridad != null && !this.nivelEscolaridad.equals(other.nivelEscolaridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.LtNivelEscolaridadPK[ cedulaLt=" + cedulaLt + ", nivelEscolaridad=" + nivelEscolaridad + " ]";
    }
    
}
