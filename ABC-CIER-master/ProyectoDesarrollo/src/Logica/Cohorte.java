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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Nombre del Archivo: Cohorte.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Entity
@Table(name = "cohorte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cohorte.findAll", query = "SELECT c FROM Cohorte c"),
    @NamedQuery(name = "Cohorte.findByIdCohorte", query = "SELECT c FROM Cohorte c WHERE c.idCohorte = :idCohorte"),
    @NamedQuery(name = "Cohorte.findByFechaInicio", query = "SELECT c FROM Cohorte c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Cohorte.findByFechaFin", query = "SELECT c FROM Cohorte c WHERE c.fechaFin = :fechaFin"),
    @NamedQuery(name = "Cohorte.findByEstado", query = "SELECT c FROM Cohorte c WHERE c.estado = :estado")})
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
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cohorte")
    private List<CursoCohorte> cursoCohorteList;

    public Cohorte() {
    }

    public Cohorte(String idCohorte) {
        this.idCohorte = idCohorte;
    }

    public Cohorte(String idCohorte, boolean estado) {
        this.idCohorte = idCohorte;
        this.estado = estado;
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
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

} // Fin de la clase Cohorte
