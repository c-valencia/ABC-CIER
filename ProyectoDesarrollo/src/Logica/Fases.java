/** 
 * Nombre del Archivo: Fases.java 
 * Fecha de Creacion: 27/04/2015 
 * Autores: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750) 
 */

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


@Entity
@Table(name = "fases")
@NamedQueries({
    @NamedQuery(name = "Fases.findAll", query = "SELECT f FROM Fases f")})
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
    @Column(name = "estado")
    private Boolean estado;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

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
