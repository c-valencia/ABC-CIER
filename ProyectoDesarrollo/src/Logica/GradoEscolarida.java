/** 
 * Nombre del Archivo: GradoEscolarida.java 
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
@Table(name = "grado_escolarida")
@NamedQueries({
    @NamedQuery(name = "GradoEscolarida.findAll", query = "SELECT g FROM GradoEscolarida g")})
public class GradoEscolarida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GradoEscolaridaPK gradoEscolaridaPK;
    @JoinColumn(name = "cedula_lt", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LeaderTeacher leaderTeacher;

    public GradoEscolarida() {
    }

    public GradoEscolarida(GradoEscolaridaPK gradoEscolaridaPK) {
        this.gradoEscolaridaPK = gradoEscolaridaPK;
    }

    public GradoEscolarida(String cedulaLt, String gradoEscolarida) {
        this.gradoEscolaridaPK = new GradoEscolaridaPK(cedulaLt, gradoEscolarida);
    }

    public GradoEscolaridaPK getGradoEscolaridaPK() {
        return gradoEscolaridaPK;
    }

    public void setGradoEscolaridaPK(GradoEscolaridaPK gradoEscolaridaPK) {
        this.gradoEscolaridaPK = gradoEscolaridaPK;
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
        hash += (gradoEscolaridaPK != null ? gradoEscolaridaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradoEscolarida)) {
            return false;
        }
        GradoEscolarida other = (GradoEscolarida) object;
        if ((this.gradoEscolaridaPK == null && other.gradoEscolaridaPK != null) || (this.gradoEscolaridaPK != null && !this.gradoEscolaridaPK.equals(other.gradoEscolaridaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.GradoEscolarida[ gradoEscolaridaPK=" + gradoEscolaridaPK + " ]";
    }

} // Fin de la clase GradoEscolarida
