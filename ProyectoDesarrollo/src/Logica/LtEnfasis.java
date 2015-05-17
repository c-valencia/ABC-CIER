package Logica;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Nombre del Archivo: LtEnfasis.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Entity
@Table(name = "lt_enfasis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LtEnfasis.findAll", query = "SELECT l FROM LtEnfasis l"),
    @NamedQuery(name = "LtEnfasis.findByCedulaLt", query = "SELECT l FROM LtEnfasis l WHERE l.ltEnfasisPK.cedulaLt = :cedulaLt"),
    @NamedQuery(name = "LtEnfasis.findByEnfasis", query = "SELECT l FROM LtEnfasis l WHERE l.ltEnfasisPK.enfasis = :enfasis")})
public class LtEnfasis implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LtEnfasisPK ltEnfasisPK;

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
