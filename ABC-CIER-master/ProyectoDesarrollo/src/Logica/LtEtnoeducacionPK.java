package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Nombre del Archivo: LtEtnoeducacionPK.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Embeddable
public class LtEtnoeducacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cedula_lt")
    private String cedulaLt;
    @Basic(optional = false)
    @Column(name = "etnoeducacion")
    private String etnoeducacion;

    public LtEtnoeducacionPK() {
    }

    public LtEtnoeducacionPK(String cedulaLt, String etnoeducacion) {
        this.cedulaLt = cedulaLt;
        this.etnoeducacion = etnoeducacion;
    }

    public String getCedulaLt() {
        return cedulaLt;
    }

    public void setCedulaLt(String cedulaLt) {
        this.cedulaLt = cedulaLt;
    }

    public String getEtnoeducacion() {
        return etnoeducacion;
    }

    public void setEtnoeducacion(String etnoeducacion) {
        this.etnoeducacion = etnoeducacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaLt != null ? cedulaLt.hashCode() : 0);
        hash += (etnoeducacion != null ? etnoeducacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtEtnoeducacionPK)) {
            return false;
        }
        LtEtnoeducacionPK other = (LtEtnoeducacionPK) object;
        if ((this.cedulaLt == null && other.cedulaLt != null) || (this.cedulaLt != null && !this.cedulaLt.equals(other.cedulaLt))) {
            return false;
        }
        if ((this.etnoeducacion == null && other.etnoeducacion != null) || (this.etnoeducacion != null && !this.etnoeducacion.equals(other.etnoeducacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.LtEtnoeducacionPK[ cedulaLt=" + cedulaLt + ", etnoeducacion=" + etnoeducacion + " ]";
    }

} // Fin de la clase LtEtnoeducacionPK
