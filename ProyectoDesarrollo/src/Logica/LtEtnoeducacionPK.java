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
public class LtEtnoeducacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cedula_lt")
    private String cedulaLt;
    @Basic(optional = false)
    @Column(name = "etnoeducacion")
    private String etnoeducacion;

    public LtEtnoeducacionPK() {
    }

    public LtEtnoeducacionPK(String cedulaLt, String etnoeducacion) {
        this.cedulaLt = cedulaLt;
        this.etnoeducacion = etnoeducacion;
    }

    public String getCedulaLt() {
        return cedulaLt;
    }

    public void setCedulaLt(String cedulaLt) {
        this.cedulaLt = cedulaLt;
    }

    public String getEtnoeducacion() {
        return etnoeducacion;
    }

    public void setEtnoeducacion(String etnoeducacion) {
        this.etnoeducacion = etnoeducacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaLt != null ? cedulaLt.hashCode() : 0);
        hash += (etnoeducacion != null ? etnoeducacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtEtnoeducacionPK)) {
            return false;
        }
        LtEtnoeducacionPK other = (LtEtnoeducacionPK) object;
        if ((this.cedulaLt == null && other.cedulaLt != null) || (this.cedulaLt != null && !this.cedulaLt.equals(other.cedulaLt))) {
            return false;
        }
        if ((this.etnoeducacion == null && other.etnoeducacion != null) || (this.etnoeducacion != null && !this.etnoeducacion.equals(other.etnoeducacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.LtEtnoeducacionPK[ cedulaLt=" + cedulaLt + ", etnoeducacion=" + etnoeducacion + " ]";
    }
    
}
