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
public class LtEnfasisPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cedula_lt")
    private String cedulaLt;
    @Basic(optional = false)
    @Column(name = "enfasis")
    private String enfasis;

    public LtEnfasisPK() {
    }

    public LtEnfasisPK(String cedulaLt, String enfasis) {
        this.cedulaLt = cedulaLt;
        this.enfasis = enfasis;
    }

    public String getCedulaLt() {
        return cedulaLt;
    }

    public void setCedulaLt(String cedulaLt) {
        this.cedulaLt = cedulaLt;
    }

    public String getEnfasis() {
        return enfasis;
    }

    public void setEnfasis(String enfasis) {
        this.enfasis = enfasis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaLt != null ? cedulaLt.hashCode() : 0);
        hash += (enfasis != null ? enfasis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtEnfasisPK)) {
            return false;
        }
        LtEnfasisPK other = (LtEnfasisPK) object;
        if ((this.cedulaLt == null && other.cedulaLt != null) || (this.cedulaLt != null && !this.cedulaLt.equals(other.cedulaLt))) {
            return false;
        }
        if ((this.enfasis == null && other.enfasis != null) || (this.enfasis != null && !this.enfasis.equals(other.enfasis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.LtEnfasisPK[ cedulaLt=" + cedulaLt + ", enfasis=" + enfasis + " ]";
    }
    
}
