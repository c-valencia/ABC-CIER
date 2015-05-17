package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Nombre del Archivo: Fases.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Entity
@Table(name = "fases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fases.findAll", query = "SELECT f FROM Fases f"),
    @NamedQuery(name = "Fases.findByIdFase", query = "SELECT f FROM Fases f WHERE f.idFase = :idFase"),
    @NamedQuery(name = "Fases.findByNumeroHoras", query = "SELECT f FROM Fases f WHERE f.numeroHoras = :numeroHoras"),
    @NamedQuery(name = "Fases.findByNumeroSemanas", query = "SELECT f FROM Fases f WHERE f.numeroSemanas = :numeroSemanas"),
    @NamedQuery(name = "Fases.findByTipo", query = "SELECT f FROM Fases f WHERE f.tipo = :tipo"),
    @NamedQuery(name = "Fases.findByContenido", query = "SELECT f FROM Fases f WHERE f.contenido = :contenido"),
    @NamedQuery(name = "Fases.findByEstado", query = "SELECT f FROM Fases f WHERE f.estado = :estado")})
public class Fases implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_fase")
    private String idFase;
    @Column(name = "numero_horas")
    private Integer numeroHoras;
    @Column(name = "numero_semanas")
    private Integer numeroSemanas;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "contenido")
    private String contenido;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private Curso idCurso;
    @OneToMany(mappedBy = "idFase")
    private List<Practica> practicaList;

    public Fases() {
    }

    public Fases(String idFase) {
        this.idFase = idFase;
    }

    public Fases(String idFase, boolean estado) {
        this.idFase = idFase;
        this.estado = estado;
    }

    public Fases(Curso curso, Integer numeroHoras, Integer numeroSemanas, String tipo, String contenido, boolean estado) {
        this.idCurso = curso;
        this.numeroHoras = numeroHoras;
        this.numeroSemanas = numeroSemanas;
        this.tipo = tipo;
        this.contenido = contenido;
        this.estado = estado;
    }

    
    
    public String getIdFase() {
        return idFase;
    }

    public void setIdFase(String idFase) {
        this.idFase = idFase;
    }

    public Integer getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(Integer numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public Integer getNumeroSemanas() {
        return numeroSemanas;
    }

    public void setNumeroSemanas(Integer numeroSemanas) {
        this.numeroSemanas = numeroSemanas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    @XmlTransient
    public List<Practica> getPracticaList() {
        return practicaList;
    }

    public void setPracticaList(List<Practica> practicaList) {
        this.practicaList = practicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFase != null ? idFase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fases)) {
            return false;
        }
        Fases other = (Fases) object;
        if ((this.idFase == null && other.idFase != null) || (this.idFase != null && !this.idFase.equals(other.idFase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Fases[ idFase=" + idFase + " ]";
    }

} // Fin de la clase Fases
