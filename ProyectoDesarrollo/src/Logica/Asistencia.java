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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juliangr
 */
@Entity
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a"),
    @NamedQuery(name = "Asistencia.findByCedulaLt", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.cedulaLt = :cedulaLt"),
    @NamedQuery(name = "Asistencia.findByIdCohorte", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.idCohorte = :idCohorte"),
    @NamedQuery(name = "Asistencia.findByIdCurso", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.idCurso = :idCurso"),
    @NamedQuery(name = "Asistencia.findByFecha", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.fecha = :fecha"),
    @NamedQuery(name = "Asistencia.findByAsistio", query = "SELECT a FROM Asistencia a WHERE a.asistio = :asistio")})
public class Asistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciaPK asistenciaPK;
    @Basic(optional = false)
    @Column(name = "asistio")
    private boolean asistio;
    @JoinColumns({
        @JoinColumn(name = "cedula_lt", referencedColumnName = "cedula_lt", insertable = false, updatable = false),
        @JoinColumn(name = "id_cohorte", referencedColumnName = "id_cohorte", insertable = false, updatable = false),
        @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Matricula matricula;

    public Asistencia() {
    }

    public Asistencia(AsistenciaPK asistenciaPK) {
        this.asistenciaPK = asistenciaPK;
    }

    public Asistencia(AsistenciaPK asistenciaPK, boolean asistio) {
        this.asistenciaPK = asistenciaPK;
        this.asistio = asistio;
        this.matricula = new Matricula (asistenciaPK.getCedulaLt(),asistenciaPK.getIdCohorte(),asistenciaPK.getIdCurso());
    }

    public Asistencia(String cedulaLt, String idCohorte, String idCurso, Date fecha) {
        this.asistenciaPK = new AsistenciaPK(cedulaLt, idCohorte, idCurso, fecha);
    }

    public AsistenciaPK getAsistenciaPK() {
        return asistenciaPK;
    }

    public void setAsistenciaPK(AsistenciaPK asistenciaPK) {
        this.asistenciaPK = asistenciaPK;
    }

    public boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistenciaPK != null ? asistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.asistenciaPK == null && other.asistenciaPK != null) || (this.asistenciaPK != null && !this.asistenciaPK.equals(other.asistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Asistencia[ asistenciaPK=" + asistenciaPK + " ]";
    }
    
}
