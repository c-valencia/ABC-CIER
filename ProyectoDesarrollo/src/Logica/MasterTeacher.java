package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Nombre del Archivo: MasterTeacher.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Entity
@Table(name = "master_teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MasterTeacher.findAll", query = "SELECT m FROM MasterTeacher m"),
    @NamedQuery(name = "MasterTeacher.findByCedula", query = "SELECT m FROM MasterTeacher m WHERE m.cedula = :cedula"),
    @NamedQuery(name = "MasterTeacher.findByNombre", query = "SELECT m FROM MasterTeacher m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MasterTeacher.findByApellido", query = "SELECT m FROM MasterTeacher m WHERE m.apellido = :apellido"),
    @NamedQuery(name = "MasterTeacher.findByCorreo", query = "SELECT m FROM MasterTeacher m WHERE m.correo = :correo"),
    @NamedQuery(name = "MasterTeacher.findByCiudad", query = "SELECT m FROM MasterTeacher m WHERE m.ciudad = :ciudad"),
    @NamedQuery(name = "MasterTeacher.findByPais", query = "SELECT m FROM MasterTeacher m WHERE m.pais = :pais"),
    @NamedQuery(name = "MasterTeacher.findByEstado", query = "SELECT m FROM MasterTeacher m WHERE m.estado = :estado")})
public class MasterTeacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Curso idCurso;

    public MasterTeacher() {
    }

    public MasterTeacher(String cedula) {
        this.cedula = cedula;
    }

    public MasterTeacher(String cedula, String nombre, String apellido, String correo, String ciudad, String pais, boolean estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.estado = estado;
    }

    public MasterTeacher(String cedula, String nombre, String apellido, String correo, String ciudad, String pais, boolean estado, Curso idCurso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.estado = estado;
        this.idCurso = idCurso;
    }
    
    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasterTeacher)) {
            return false;
        }
        MasterTeacher other = (MasterTeacher) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.MasterTeacher[ cedula=" + cedula + " ]";
    }

} // Fin de la clase MasterTeacher
