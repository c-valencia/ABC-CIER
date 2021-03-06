package Logica;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Nombre del Archivo: LtEtnoeducacion.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Entity
@Table(name = "lt_etnoeducacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LtEtnoeducacion.findAll", query = "SELECT l FROM LtEtnoeducacion l"),
    @NamedQuery(name = "LtEtnoeducacion.findByCedulaLt", query = "SELECT l FROM LtEtnoeducacion l WHERE l.ltEtnoeducacionPK.cedulaLt = :cedulaLt"),
    @NamedQuery(name = "LtEtnoeducacion.findByEtnoeducacion", query = "SELECT l FROM LtEtnoeducacion l WHERE l.ltEtnoeducacionPK.etnoeducacion = :etnoeducacion")})
public class LtEtnoeducacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LtEtnoeducacionPK ltEtnoeducacionPK;

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

} // Fin de la clase LtEtnoeducacion
