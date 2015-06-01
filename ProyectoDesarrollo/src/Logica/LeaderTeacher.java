package Logica;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * Nombre del Archivo: LeaderTeacher.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Entity
@Table(name = "leader_teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaderTeacher.findAll", query = "SELECT l FROM LeaderTeacher l"),
    @NamedQuery(name = "LeaderTeacher.findByCedula", query = "SELECT l FROM LeaderTeacher l WHERE l.cedula = :cedula"),
    @NamedQuery(name = "LeaderTeacher.findByNombres", query = "SELECT l FROM LeaderTeacher l WHERE l.nombres = :nombres"),
    @NamedQuery(name = "LeaderTeacher.findByApellidos", query = "SELECT l FROM LeaderTeacher l WHERE l.apellidos = :apellidos"),
    @NamedQuery(name = "LeaderTeacher.findByCorreo", query = "SELECT l FROM LeaderTeacher l WHERE l.correo = :correo"),
    @NamedQuery(name = "LeaderTeacher.findByCelular", query = "SELECT l FROM LeaderTeacher l WHERE l.celular = :celular"),
    @NamedQuery(name = "LeaderTeacher.findByDireccion", query = "SELECT l FROM LeaderTeacher l WHERE l.direccion = :direccion"),
    @NamedQuery(name = "LeaderTeacher.findByFechanacimiento", query = "SELECT l FROM LeaderTeacher l WHERE l.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "LeaderTeacher.findBySexo", query = "SELECT l FROM LeaderTeacher l WHERE l.sexo = :sexo"),
    @NamedQuery(name = "LeaderTeacher.findByMunicipio", query = "SELECT l FROM LeaderTeacher l WHERE l.municipio = :municipio"),
    @NamedQuery(name = "LeaderTeacher.findByDepartamento", query = "SELECT l FROM LeaderTeacher l WHERE l.departamento = :departamento"),
    @NamedQuery(name = "LeaderTeacher.findBySedePertenece", query = "SELECT l FROM LeaderTeacher l WHERE l.sedePertenece = :sedePertenece"),
    @NamedQuery(name = "LeaderTeacher.findByIntitucion", query = "SELECT l FROM LeaderTeacher l WHERE l.intitucion = :intitucion"),
    @NamedQuery(name = "LeaderTeacher.findByCodigoDaneIntitucion", query = "SELECT l FROM LeaderTeacher l WHERE l.codigoDaneIntitucion = :codigoDaneIntitucion"),
    @NamedQuery(name = "LeaderTeacher.findByGrado", query = "SELECT l FROM LeaderTeacher l WHERE l.grado = :grado"),
    @NamedQuery(name = "LeaderTeacher.findBySecretariaEducacion", query = "SELECT l FROM LeaderTeacher l WHERE l.secretariaEducacion = :secretariaEducacion"),
    @NamedQuery(name = "LeaderTeacher.findByAreaInscripcion", query = "SELECT l FROM LeaderTeacher l WHERE l.areaInscripcion = :areaInscripcion"),
    @NamedQuery(name = "LeaderTeacher.findByTutorPta", query = "SELECT l FROM LeaderTeacher l WHERE l.tutorPta = :tutorPta"),
    @NamedQuery(name = "LeaderTeacher.findByUsuarioColombiaAprende", query = "SELECT l FROM LeaderTeacher l WHERE l.usuarioColombiaAprende = :usuarioColombiaAprende"),
    @NamedQuery(name = "LeaderTeacher.findByZona", query = "SELECT l FROM LeaderTeacher l WHERE l.zona = :zona"),
    @NamedQuery(name = "LeaderTeacher.findByModalidad", query = "SELECT l FROM LeaderTeacher l WHERE l.modalidad = :modalidad"),
    @NamedQuery(name = "LeaderTeacher.findByNivelEducacion", query = "SELECT l FROM LeaderTeacher l WHERE l.nivelEducacion = :nivelEducacion"),
    @NamedQuery(name = "LeaderTeacher.findByExperienciaPreescolar", query = "SELECT l FROM LeaderTeacher l WHERE l.experienciaPreescolar = :experienciaPreescolar"),
    @NamedQuery(name = "LeaderTeacher.findByExperienciaPrimaria", query = "SELECT l FROM LeaderTeacher l WHERE l.experienciaPrimaria = :experienciaPrimaria"),
    @NamedQuery(name = "LeaderTeacher.findByExperienciaSecundaria", query = "SELECT l FROM LeaderTeacher l WHERE l.experienciaSecundaria = :experienciaSecundaria"),
    @NamedQuery(name = "LeaderTeacher.findByExperienciaMedia", query = "SELECT l FROM LeaderTeacher l WHERE l.experienciaMedia = :experienciaMedia"),
    @NamedQuery(name = "LeaderTeacher.findByExperienciaSuperior", query = "SELECT l FROM LeaderTeacher l WHERE l.experienciaSuperior = :experienciaSuperior"),
    @NamedQuery(name = "LeaderTeacher.findByExperienciaRural", query = "SELECT l FROM LeaderTeacher l WHERE l.experienciaRural = :experienciaRural"),
    @NamedQuery(name = "LeaderTeacher.findByExperienciaUrbana", query = "SELECT l FROM LeaderTeacher l WHERE l.experienciaUrbana = :experienciaUrbana"),
    @NamedQuery(name = "LeaderTeacher.findByExperienciaSectorPublico", query = "SELECT l FROM LeaderTeacher l WHERE l.experienciaSectorPublico = :experienciaSectorPublico"),
    @NamedQuery(name = "LeaderTeacher.findByExperienciaSectorPribado", query = "SELECT l FROM LeaderTeacher l WHERE l.experienciaSectorPribado = :experienciaSectorPribado"),
    @NamedQuery(name = "LeaderTeacher.findByExperienciaTotal", query = "SELECT l FROM LeaderTeacher l WHERE l.experienciaTotal = :experienciaTotal"),
    @NamedQuery(name = "LeaderTeacher.findByEstado", query = "SELECT l FROM LeaderTeacher l WHERE l.estado = :estado")})
public class LeaderTeacher implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaderTeacher")
    private Collection<Matricula> matriculaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @Column(name = "departamento")
    private String departamento;
    @Basic(optional = false)
    @Column(name = "sede_pertenece")
    private String sedePertenece;
    @Basic(optional = false)
    @Column(name = "intitucion")
    private String intitucion;
    @Basic(optional = false)
    @Column(name = "codigo_dane_intitucion")
    private String codigoDaneIntitucion;
    @Basic(optional = false)
    @Column(name = "grado")
    private String grado;
    @Basic(optional = false)
    @Column(name = "secretaria_educacion")
    private String secretariaEducacion;
    @Basic(optional = false)
    @Column(name = "area_inscripcion")
    private String areaInscripcion;
    @Basic(optional = false)
    @Column(name = "tutor_pta")
    private boolean tutorPta;
    @Basic(optional = false)
    @Column(name = "usuario_colombia_aprende")
    private boolean usuarioColombiaAprende;
    @Column(name = "zona")
    private String zona;
    @Column(name = "modalidad")
    private String modalidad;
    @Column(name = "nivel_educacion")
    private String nivelEducacion;
    @Column(name = "experiencia_preescolar")
    private Integer experienciaPreescolar;
    @Column(name = "experiencia_primaria")
    private Integer experienciaPrimaria;
    @Column(name = "experiencia_secundaria")
    private Integer experienciaSecundaria;
    @Column(name = "experiencia_media")
    private Integer experienciaMedia;
    @Column(name = "experiencia_superior")
    private Integer experienciaSuperior;
    @Column(name = "experiencia_rural")
    private Integer experienciaRural;
    @Column(name = "experiencia_urbana")
    private Integer experienciaUrbana;
    @Column(name = "experiencia_sector_publico")
    private Integer experienciaSectorPublico;
    @Column(name = "experiencia_sector_pribado")
    private Integer experienciaSectorPribado;
    @Column(name = "experiencia_total")
    private Integer experienciaTotal;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

    public LeaderTeacher() {
    }

    public LeaderTeacher(String cedula) {
        this.cedula = cedula;
    }

    public LeaderTeacher(String cedula, String nombres, String apellidos, String correo, String celular, String direccion, String municipio, String departamento, String sedePertenece, String intitucion, String codigoDaneIntitucion, String grado, String secretariaEducacion, String areaInscripcion, boolean tutorPta, boolean usuarioColombiaAprende, boolean estado) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
        this.municipio = municipio;
        this.departamento = departamento;
        this.sedePertenece = sedePertenece;
        this.intitucion = intitucion;
        this.codigoDaneIntitucion = codigoDaneIntitucion;
        this.grado = grado;
        this.secretariaEducacion = secretariaEducacion;
        this.areaInscripcion = areaInscripcion;
        this.tutorPta = tutorPta;
        this.usuarioColombiaAprende = usuarioColombiaAprende;
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getSedePertenece() {
        return sedePertenece;
    }

    public void setSedePertenece(String sedePertenece) {
        this.sedePertenece = sedePertenece;
    }

    public String getIntitucion() {
        return intitucion;
    }

    public void setIntitucion(String intitucion) {
        this.intitucion = intitucion;
    }

    public String getCodigoDaneIntitucion() {
        return codigoDaneIntitucion;
    }

    public void setCodigoDaneIntitucion(String codigoDaneIntitucion) {
        this.codigoDaneIntitucion = codigoDaneIntitucion;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSecretariaEducacion() {
        return secretariaEducacion;
    }

    public void setSecretariaEducacion(String secretariaEducacion) {
        this.secretariaEducacion = secretariaEducacion;
    }

    public String getAreaInscripcion() {
        return areaInscripcion;
    }

    public void setAreaInscripcion(String areaInscripcion) {
        this.areaInscripcion = areaInscripcion;
    }

    public boolean getTutorPta() {
        return tutorPta;
    }

    public void setTutorPta(boolean tutorPta) {
        this.tutorPta = tutorPta;
    }

    public boolean getUsuarioColombiaAprende() {
        return usuarioColombiaAprende;
    }

    public void setUsuarioColombiaAprende(boolean usuarioColombiaAprende) {
        this.usuarioColombiaAprende = usuarioColombiaAprende;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public Integer getExperienciaPreescolar() {
        return experienciaPreescolar;
    }

    public void setExperienciaPreescolar(Integer experienciaPreescolar) {
        this.experienciaPreescolar = experienciaPreescolar;
    }

    public Integer getExperienciaPrimaria() {
        return experienciaPrimaria;
    }

    public void setExperienciaPrimaria(Integer experienciaPrimaria) {
        this.experienciaPrimaria = experienciaPrimaria;
    }

    public Integer getExperienciaSecundaria() {
        return experienciaSecundaria;
    }

    public void setExperienciaSecundaria(Integer experienciaSecundaria) {
        this.experienciaSecundaria = experienciaSecundaria;
    }

    public Integer getExperienciaMedia() {
        return experienciaMedia;
    }

    public void setExperienciaMedia(Integer experienciaMedia) {
        this.experienciaMedia = experienciaMedia;
    }

    public Integer getExperienciaSuperior() {
        return experienciaSuperior;
    }

    public void setExperienciaSuperior(Integer experienciaSuperior) {
        this.experienciaSuperior = experienciaSuperior;
    }

    public Integer getExperienciaRural() {
        return experienciaRural;
    }

    public void setExperienciaRural(Integer experienciaRural) {
        this.experienciaRural = experienciaRural;
    }

    public Integer getExperienciaUrbana() {
        return experienciaUrbana;
    }

    public void setExperienciaUrbana(Integer experienciaUrbana) {
        this.experienciaUrbana = experienciaUrbana;
    }

    public Integer getExperienciaSectorPublico() {
        return experienciaSectorPublico;
    }

    public void setExperienciaSectorPublico(Integer experienciaSectorPublico) {
        this.experienciaSectorPublico = experienciaSectorPublico;
    }

    public Integer getExperienciaSectorPribado() {
        return experienciaSectorPribado;
    }

    public void setExperienciaSectorPribado(Integer experienciaSectorPribado) {
        this.experienciaSectorPribado = experienciaSectorPribado;
    }

    public Integer getExperienciaTotal() {
        return experienciaTotal;
    }

    public void setExperienciaTotal(Integer experienciaTotal) {
        this.experienciaTotal = experienciaTotal;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
        if (!(object instanceof LeaderTeacher)) {
            return false;
        }
        LeaderTeacher other = (LeaderTeacher) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.LeaderTeacher[ cedula=" + cedula + " ]";
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

} // Fin de la clase LeaderTeacher
