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
@Table(name = "lt_etnoeducacion")
@NamedQueries({
    @NamedQuery(name = "LtEtnoeducacion.findAll", query = "SELECT l FROM LtEtnoeducacion l")})
public class LtEtnoeducacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LtEtnoeducacionPK ltEtnoeducacionPK;
    @JoinColumn(name = "cedula_lt", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LeaderTeacher leaderTeacher;

    public LtEtnoeducacion() {
    }

    public LtEtnoeducacion(LtEtnoeducacionPK ltEtnoeducacionPK) {
        this.ltEtnoeducacionPK = ltEtnoeducacionPK;
    }

    public LtEtnoeducacion(String cedulaLt, String etnoeducacion) {
        this.ltEtnoeducacionPK = new LtEtnoeducacionPK(cedulaLt, etnoeducacion);
    }

    public LtEtnoeducacionPK getLtEtnoeducacionPK() {
        return ltEtnoeducacionPK;
    }

    public void setLtEtnoeducacionPK(LtEtnoeducacionPK ltEtnoeducacionPK) {
        this.ltEtnoeducacionPK = ltEtnoeducacionPK;
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
        hash += (ltEtnoeducacionPK != null ? ltEtnoeducacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtEtnoeducacion)) {
            return false;
        }
        LtEtnoeducacion other = (LtEtnoeducacion) object;
        if ((this.ltEtnoeducacionPK == null && other.ltEtnoeducacionPK != null) || (this.ltEtnoeducacionPK != null && !this.ltEtnoeducacionPK.equals(other.ltEtnoeducacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.LtEtnoeducacion[ ltEtnoeducacionPK=" + ltEtnoeducacionPK + " ]";
    }
    
}
