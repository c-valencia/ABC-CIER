package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Nombre del Archivo: CursoCohortePK.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Embeddable
public class CursoCohortePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_cohorte")
    private String idCohorte;
    @Basic(optional = false)
    @Column(name = "id_curso")
    private String idCurso;

    public CursoCohortePK() {
    }

    public CursoCohortePK(String idCohorte, String idCurso) {
        this.idCohorte = idCohorte;
        this.idCurso = idCurso;
    }

    public String getIdCohorte() {
        return idCohorte;
    }

    public void setIdCohorte(String idCohorte) {
        this.idCohorte = idCohorte;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCohorte != null ? idCohorte.hashCode() : 0);
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoCohortePK)) {
            return false;
        }
        CursoCohortePK other = (CursoCohortePK) object;
        if ((this.idCohorte == null && other.idCohorte != null) || (this.idCohorte != null && !this.idCohorte.equals(other.idCohorte))) {
            return false;
        }
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.CursoCohortePK[ idCohorte=" + idCohorte + ", idCurso=" + idCurso + " ]";
    }

} // Fin de la clase CursoCohortePK
