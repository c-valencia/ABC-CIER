package Logica;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Nombre del Archivo: Curso.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByIdCurso", query = "SELECT c FROM Curso c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "Curso.findByNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Curso.findByNombreCorto", query = "SELECT c FROM Curso c WHERE c.nombreCorto = :nombreCorto"),
    @NamedQuery(name = "Curso.findByDescripcion", query = "SELECT c FROM Curso c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Curso.findByContenido", query = "SELECT c FROM Curso c WHERE c.contenido = :contenido"),
    @NamedQuery(name = "Curso.findByEstado", query = "SELECT c FROM Curso c WHERE c.estado = :estado")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_curso")
    private String idCurso;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "contenido")
    private String contenido;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(mappedBy = "idCurso")
    private List<Fases> fasesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<CursoCohorte> cursoCohorteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso")
    private List<MasterTeacher> masterTeacherList;

    public Curso() {
    }

    public Curso(String idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(String idCurso, String nombre, String nombreCorto, boolean estado) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
        this.estado = estado;
    }

    public Curso( String nombre, String nombreCorto, String descripcion, String contenido, boolean estado) {
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.estado = estado;
    }

    
    
    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @XmlTransient
    public List<Fases> getFasesList() {
        return fasesList;
    }

    public void setFasesList(List<Fases> fasesList) {
        this.fasesList = fasesList;
    }

    @XmlTransient
    public List<CursoCohorte> getCursoCohorteList() {
        return cursoCohorteList;
    }

    public void setCursoCohorteList(List<CursoCohorte> cursoCohorteList) {
        this.cursoCohorteList = cursoCohorteList;
    }

    @XmlTransient
    public List<MasterTeacher> getMasterTeacherList() {
        return masterTeacherList;
    }

    public void setMasterTeacherList(List<MasterTeacher> masterTeacherList) {
        this.masterTeacherList = masterTeacherList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Curso[ idCurso=" + idCurso + " ]";
    }

} // Fin de la clase Curso
