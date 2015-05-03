/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "area_formacion")
@NamedQueries({
    @NamedQuery(name = "AreaFormacion.findAll", query = "SELECT a FROM AreaFormacion a")})
public class AreaFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AreaFormacionPK areaFormacionPK;
    @JoinColumn(name = "cedula_lt", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LeaderTeacher leaderTeacher;

    public AreaFormacion() {
    }

    public AreaFormacion(AreaFormacionPK areaFormacionPK) {
        this.areaFormacionPK = areaFormacionPK;
    }

    public AreaFormacion(String cedulaLt, String areaFormacion) {
        this.areaFormacionPK = new AreaFormacionPK(cedulaLt, areaFormacion);
    }

    public AreaFormacionPK getAreaFormacionPK() {
        return areaFormacionPK;
    }

    public void setAreaFormacionPK(AreaFormacionPK areaFormacionPK) {
        this.areaFormacionPK = areaFormacionPK;
    }

    public LeaderTeacher getLeaderTeacher() {
        return leaderTeacher;
    }

    public void setLeaderTeacher(LeaderTeacher leaderTeacher) {
        this.leaderTeacher = leaderTeacher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaFormacionPK != null ? areaFormacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaFormacion)) {
            return false;
        }
        AreaFormacion other = (AreaFormacion) object;
        if ((this.areaFormacionPK == null && other.areaFormacionPK != null) || (this.areaFormacionPK != null && !this.areaFormacionPK.equals(other.areaFormacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.AreaFormacion[ areaFormacionPK=" + areaFormacionPK + " ]";
    }
    
}
