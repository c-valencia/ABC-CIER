/** 
 * Nombre del Archivo: LtEnfasis.java 
 * Fecha de Creacion: 27/04/2015 
 * Autores: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750) 
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


@Entity
@Table(name = "lt_enfasis")
@NamedQueries({
    @NamedQuery(name = "LtEnfasis.findAll", query = "SELECT l FROM LtEnfasis l")})
public class LtEnfasis implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LtEnfasisPK ltEnfasisPK;
    @JoinColumn(name = "cedula_lt", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LeaderTeacher leaderTeacher;

    public LtEnfasis() {
    }

    public LtEnfasis(LtEnfasisPK ltEnfasisPK) {
        this.ltEnfasisPK = ltEnfasisPK;
    }

    public LtEnfasis(String cedulaLt, String enfasis) {
        this.ltEnfasisPK = new LtEnfasisPK(cedulaLt, enfasis);
    }

    public LtEnfasisPK getLtEnfasisPK() {
        return ltEnfasisPK;
    }

    public void setLtEnfasisPK(LtEnfasisPK ltEnfasisPK) {
        this.ltEnfasisPK = ltEnfasisPK;
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
        hash += (ltEnfasisPK != null ? ltEnfasisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtEnfasis)) {
            return false;
        }
        LtEnfasis other = (LtEnfasis) object;
        if ((this.ltEnfasisPK == null && other.ltEnfasisPK != null) || (this.ltEnfasisPK != null && !this.ltEnfasisPK.equals(other.ltEnfasisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.LtEnfasis[ ltEnfasisPK=" + ltEnfasisPK + " ]";
    }

} // Fin de la clase LtEnfasis
