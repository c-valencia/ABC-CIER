/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "cohorte")
@NamedQueries({
    @NamedQuery(name = "Cohorte.findAll", query = "SELECT c FROM Cohorte c")})
public class Cohorte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cohorte")
    private String idCohorte;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cohorte")
    private List<CursoCohorte> cursoCohorteList;

    public Cohorte() {
    }

    public Cohorte(String idCohorte) {
        this.idCohorte = idCohorte;
    }

    public String getIdCohorte() {
        return idCohorte;
    }

    public void setIdCohorte(String idCohorte) {
        this.idCohorte = idCohorte;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<CursoCohorte> getCursoCohorteList() {
        return cursoCohorteList;
    }

    public void setCursoCohorteList(List<CursoCohorte> cursoCohorteList) {
        this.cursoCohorteList = cursoCohorteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCohorte != null ? idCohorte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cohorte)) {
            return false;
        }
        Cohorte other = (Cohorte) object;
        if ((this.idCohorte == null && other.idCohorte != null) || (this.idCohorte != null && !this.idCohorte.equals(other.idCohorte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Cohorte[ idCohorte=" + idCohorte + " ]";
    }
    
}
