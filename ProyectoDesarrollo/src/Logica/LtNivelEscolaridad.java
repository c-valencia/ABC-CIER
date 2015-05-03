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
@Table(name = "lt_nivel_escolaridad")
@NamedQueries({
    @NamedQuery(name = "LtNivelEscolaridad.findAll", query = "SELECT l FROM LtNivelEscolaridad l")})
public class LtNivelEscolaridad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LtNivelEscolaridadPK ltNivelEscolaridadPK;
    @JoinColumn(name = "cedula_lt", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LeaderTeacher leaderTeacher;

    public LtNivelEscolaridad() {
    }

    public LtNivelEscolaridad(LtNivelEscolaridadPK ltNivelEscolaridadPK) {
        this.ltNivelEscolaridadPK = ltNivelEscolaridadPK;
    }

    public LtNivelEscolaridad(String cedulaLt, String nivelEscolaridad) {
        this.ltNivelEscolaridadPK = new LtNivelEscolaridadPK(cedulaLt, nivelEscolaridad);
    }

    public LtNivelEscolaridadPK getLtNivelEscolaridadPK() {
        return ltNivelEscolaridadPK;
    }

    public void setLtNivelEscolaridadPK(LtNivelEscolaridadPK ltNivelEscolaridadPK) {
        this.ltNivelEscolaridadPK = ltNivelEscolaridadPK;
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
        hash += (ltNivelEscolaridadPK != null ? ltNivelEscolaridadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtNivelEscolaridad)) {
            return false;
        }
        LtNivelEscolaridad other = (LtNivelEscolaridad) object;
        if ((this.ltNivelEscolaridadPK == null && other.ltNivelEscolaridadPK != null) || (this.ltNivelEscolaridadPK != null && !this.ltNivelEscolaridadPK.equals(other.ltNivelEscolaridadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.LtNivelEscolaridad[ ltNivelEscolaridadPK=" + ltNivelEscolaridadPK + " ]";
    }
    
}
