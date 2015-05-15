/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ubuntu
 */
@Entity
@Table(name = "historial_aspirante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialAspirante.findAll", query = "SELECT h FROM HistorialAspirante h"),
    @NamedQuery(name = "HistorialAspirante.findByCedulaAs", query = "SELECT h FROM HistorialAspirante h WHERE h.historialAspirantePK.cedulaAs = :cedulaAs"),
    @NamedQuery(name = "HistorialAspirante.findByIdCurso", query = "SELECT h FROM HistorialAspirante h WHERE h.historialAspirantePK.idCurso = :idCurso"),
    @NamedQuery(name = "HistorialAspirante.findByFechaInscripcion", query = "SELECT h FROM HistorialAspirante h WHERE h.historialAspirantePK.fechaInscripcion = :fechaInscripcion")})
public class HistorialAspirante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistorialAspirantePK historialAspirantePK;
    @JoinColumn(name = "cedula_as", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aspirante aspirante;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;

    public HistorialAspirante() {
    }

    public HistorialAspirante(HistorialAspirantePK historialAspirantePK) {
        this.historialAspirantePK = historialAspirantePK;
    }

    public HistorialAspirante(String cedulaAs, String idCurso, Date fechaInscripcion) {
        this.historialAspirantePK = new HistorialAspirantePK(cedulaAs, idCurso, fechaInscripcion);
    }

    public HistorialAspirantePK getHistorialAspirantePK() {
        return historialAspirantePK;
    }

    public void setHistorialAspirantePK(HistorialAspirantePK historialAspirantePK) {
        this.historialAspirantePK = historialAspirantePK;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historialAspirantePK != null ? historialAspirantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialAspirante)) {
            return false;
        }
        HistorialAspirante other = (HistorialAspirante) object;
        if ((this.historialAspirantePK == null && other.historialAspirantePK != null) || (this.historialAspirantePK != null && !this.historialAspirantePK.equals(other.historialAspirantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.HistorialAspirante[ historialAspirantePK=" + historialAspirantePK + " ]";
    }
    
}
