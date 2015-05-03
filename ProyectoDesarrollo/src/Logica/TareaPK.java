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
public class TareaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_practica")
    private String idPractica;
    @Basic(optional = false)
    @Column(name = "cedula_lt")
    private String cedulaLt;

    public TareaPK() {
    }

    public TareaPK(String idPractica, String cedulaLt) {
        this.idPractica = idPractica;
        this.cedulaLt = cedulaLt;
    }

    public String getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(String idPractica) {
        this.idPractica = idPractica;
    }

    public String getCedulaLt() {
        return cedulaLt;
    }

    public void setCedulaLt(String cedulaLt) {
        this.cedulaLt = cedulaLt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPractica != null ? idPractica.hashCode() : 0);
        hash += (cedulaLt != null ? cedulaLt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaPK)) {
            return false;
        }
        TareaPK other = (TareaPK) object;
        if ((this.idPractica == null && other.idPractica != null) || (this.idPractica != null && !this.idPractica.equals(other.idPractica))) {
            return false;
        }
        if ((this.cedulaLt == null && other.cedulaLt != null) || (this.cedulaLt != null && !this.cedulaLt.equals(other.cedulaLt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.TareaPK[ idPractica=" + idPractica + ", cedulaLt=" + cedulaLt + " ]";
    }
    
}
