/** 
 * Nombre del Archivo: AreaFormacionPK.java 
 * Fecha de Creacion: 27/04/2015 
 * Autores: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750) 
 */

package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


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

} // Fin de la clase AreaFormacionPK
