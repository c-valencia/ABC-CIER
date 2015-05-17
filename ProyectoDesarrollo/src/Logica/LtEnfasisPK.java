package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Nombre del Archivo: LtEnfasisPK.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
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

} // Fin de la clase LtEnfasisPK
