/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ubuntu
 */
@Embeddable
public class HistorialAspirantePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cedula_as")
    private String cedulaAs;
    @Basic(optional = false)
    @Column(name = "id_curso")
    private String idCurso;
    @Basic(optional = false)
    @Column(name = "fecha_inscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;

    public HistorialAspirantePK() {
    }

    public HistorialAspirantePK(String cedulaAs, String idCurso, Date fechaInscripcion) {
        this.cedulaAs = cedulaAs;
        this.idCurso = idCurso;
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getCedulaAs() {
        return cedulaAs;
    }

    public void setCedulaAs(String cedulaAs) {
        this.cedulaAs = cedulaAs;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaAs != null ? cedulaAs.hashCode() : 0);
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        hash += (fechaInscripcion != null ? fechaInscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialAspirantePK)) {
            return false;
        }
        HistorialAspirantePK other = (HistorialAspirantePK) object;
        if ((this.cedulaAs == null && other.cedulaAs != null) || (this.cedulaAs != null && !this.cedulaAs.equals(other.cedulaAs))) {
            return false;
        }
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        if ((this.fechaInscripcion == null && other.fechaInscripcion != null) || (this.fechaInscripcion != null && !this.fechaInscripcion.equals(other.fechaInscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.HistorialAspirantePK[ cedulaAs=" + cedulaAs + ", idCurso=" + idCurso + ", fechaInscripcion=" + fechaInscripcion + " ]";
    }
    
}
