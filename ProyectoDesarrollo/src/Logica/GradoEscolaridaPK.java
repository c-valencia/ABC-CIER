package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Nombre del Archivo: GradoEscolaridaPK.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Embeddable
public class GradoEscolaridaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cedula_lt")
    private String cedulaLt;
    @Basic(optional = false)
    @Column(name = "grado_escolarida")
    private String gradoEscolarida;

    public GradoEscolaridaPK() {
    }

    public GradoEscolaridaPK(String cedulaLt, String gradoEscolarida) {
        this.cedulaLt = cedulaLt;
        this.gradoEscolarida = gradoEscolarida;
    }

    public String getCedulaLt() {
        return cedulaLt;
    }

    public void setCedulaLt(String cedulaLt) {
        this.cedulaLt = cedulaLt;
    }

    public String getGradoEscolarida() {
        return gradoEscolarida;
    }

    public void setGradoEscolarida(String gradoEscolarida) {
        this.gradoEscolarida = gradoEscolarida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaLt != null ? cedulaLt.hashCode() : 0);
        hash += (gradoEscolarida != null ? gradoEscolarida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradoEscolaridaPK)) {
            return false;
        }
        GradoEscolaridaPK other = (GradoEscolaridaPK) object;
        if ((this.cedulaLt == null && other.cedulaLt != null) || (this.cedulaLt != null && !this.cedulaLt.equals(other.cedulaLt))) {
            return false;
        }
        if ((this.gradoEscolarida == null && other.gradoEscolarida != null) || (this.gradoEscolarida != null && !this.gradoEscolarida.equals(other.gradoEscolarida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.GradoEscolaridaPK[ cedulaLt=" + cedulaLt + ", gradoEscolarida=" + gradoEscolarida + " ]";
    }

} // Fin de la clase GradoEscolaridaPK
