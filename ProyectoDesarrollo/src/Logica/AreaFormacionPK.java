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
public class AreaFormacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cedula_lt")
    private String cedulaLt;
    @Basic(optional = false)
    @Column(name = "area_formacion")
    private String areaFormacion;

    public AreaFormacionPK() {
    }

    public AreaFormacionPK(String cedulaLt, String areaFormacion) {
        this.cedulaLt = cedulaLt;
        this.areaFormacion = areaFormacion;
    }

    public String getCedulaLt() {
        return cedulaLt;
    }

    public void setCedulaLt(String cedulaLt) {
        this.cedulaLt = cedulaLt;
    }

    public String getAreaFormacion() {
        return areaFormacion;
    }

    public void setAreaFormacion(String areaFormacion) {
        this.areaFormacion = areaFormacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaLt != null ? cedulaLt.hashCode() : 0);
        hash += (areaFormacion != null ? areaFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaFormacionPK)) {
            return false;
        }
        AreaFormacionPK other = (AreaFormacionPK) object;
        if ((this.cedulaLt == null && other.cedulaLt != null) || (this.cedulaLt != null && !this.cedulaLt.equals(other.cedulaLt))) {
            return false;
        }
        if ((this.areaFormacion == null && other.areaFormacion != null) || (this.areaFormacion != null && !this.areaFormacion.equals(other.areaFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.AreaFormacionPK[ cedulaLt=" + cedulaLt + ", areaFormacion=" + areaFormacion + " ]";
    }
    
}
