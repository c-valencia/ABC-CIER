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
@Table(name = "leader_teacher")
@NamedQueries({
    @NamedQuery(name = "LeaderTeacher.findAll", query = "SELECT l FROM LeaderTeacher l")})
public class LeaderTeacher implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Basic(optional = false)
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
    @Basic(optional = false)
    @Column(name = "zona")
    private String zona;
    @Basic(optional = false)
    @Column(name = "modalidad")
    private String modalidad;
    @Basic(optional = false)
    @Column(name = "nivel_educacion")
    private String nivelEducacion;
    @Basic(optional = false)
    @Column(name = "experiencia_preescolar")
    private int experienciaPreescolar;
    @Basic(optional = false)
    @Column(name = "experiencia_primaria")
    private int experienciaPrimaria;
    @Basic(optional = false)
    @Column(name = "experiencia_secundaria")
    private int experienciaSecundaria;
    @Basic(optional = false)
    @Column(name = "experiencia_media")
    private int experienciaMedia;
    @Basic(optional = false)
    @Column(name = "experiencia_superior")
    private int experienciaSuperior;
    @Basic(optional = false)
    @Column(name = "experiencia_rural")
    private int experienciaRural;
    @Basic(optional = false)
    @Column(name = "experiencia_urbana")
    private int experienciaUrbana;
    @Basic(optional = false)
    @Column(name = "experiencia_sector_publico")
    private int experienciaSectorPublico;
    @Basic(optional = false)
    @Column(name = "experiencia_sector_pribado")
    private int experienciaSectorPribado;
    @Basic(optional = false)
    @Column(name = "experiencia_total")
    private int experienciaTotal;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaderTeacher")
    private List<GradoEscolarida> gradoEscolaridaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaderTeacher")
    private List<Matricula> matriculaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaderTeacher")
    private List<LtNivelEscolaridad> ltNivelEscolaridadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaderTeacher")
    private List<LtEtnoeducacion> ltEtnoeducacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaderTeacher")
    private List<Tarea> tareaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaderTeacher")
    private List<AreaFormacion> areaFormacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaderTeacher")
    private List<LtEnfasis> ltEnfasisList;

    public LeaderTeacher() {
    }

    public LeaderTeacher(String cedula) {
        this.cedula = cedula;
    }

    public LeaderTeacher(String cedula, String nombres, String apellidos, String correo, String celular, String direccion, Date fechanacimiento, String sexo, String municipio, String departamento, String sedePertenece, String intitucion, String codigoDaneIntitucion, String grado, String secretariaEducacion, String areaInscripcion, boolean tutorPta, boolean usuarioColombiaAprende, String zona, String modalidad, String nivelEducacion, int experienciaPreescolar, int experienciaPrimaria, int experienciaSecundaria, int experienciaMedia, int experienciaSuperior, int experienciaRural, int experienciaUrbana, int experienciaSectorPublico, int experienciaSectorPribado, int experienciaTotal) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
        this.fechanacimiento = fechanacimiento;
        this.sexo = sexo;
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
        this.zona = zona;
        this.modalidad = modalidad;
        this.nivelEducacion = nivelEducacion;
        this.experienciaPreescolar = experienciaPreescolar;
        this.experienciaPrimaria = experienciaPrimaria;
        this.experienciaSecundaria = experienciaSecundaria;
        this.experienciaMedia = experienciaMedia;
        this.experienciaSuperior = experienciaSuperior;
        this.experienciaRural = experienciaRural;
        this.experienciaUrbana = experienciaUrbana;
        this.experienciaSectorPublico = experienciaSectorPublico;
        this.experienciaSectorPribado = experienciaSectorPribado;
        this.experienciaTotal = experienciaTotal;
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

    public int getExperienciaPreescolar() {
        return experienciaPreescolar;
    }

    public void setExperienciaPreescolar(int experienciaPreescolar) {
        this.experienciaPreescolar = experienciaPreescolar;
    }

    public int getExperienciaPrimaria() {
        return experienciaPrimaria;
    }

    public void setExperienciaPrimaria(int experienciaPrimaria) {
        this.experienciaPrimaria = experienciaPrimaria;
    }

    public int getExperienciaSecundaria() {
        return experienciaSecundaria;
    }

    public void setExperienciaSecundaria(int experienciaSecundaria) {
        this.experienciaSecundaria = experienciaSecundaria;
    }

    public int getExperienciaMedia() {
        return experienciaMedia;
    }

    public void setExperienciaMedia(int experienciaMedia) {
        this.experienciaMedia = experienciaMedia;
    }

    public int getExperienciaSuperior() {
        return experienciaSuperior;
    }

    public void setExperienciaSuperior(int experienciaSuperior) {
        this.experienciaSuperior = experienciaSuperior;
    }

    public int getExperienciaRural() {
        return experienciaRural;
    }

    public void setExperienciaRural(int experienciaRural) {
        this.experienciaRural = experienciaRural;
    }

    public int getExperienciaUrbana() {
        return experienciaUrbana;
    }

    public void setExperienciaUrbana(int experienciaUrbana) {
        this.experienciaUrbana = experienciaUrbana;
    }

    public int getExperienciaSectorPublico() {
        return experienciaSectorPublico;
    }

    public void setExperienciaSectorPublico(int experienciaSectorPublico) {
        this.experienciaSectorPublico = experienciaSectorPublico;
    }

    public int getExperienciaSectorPribado() {
        return experienciaSectorPribado;
    }

    public void setExperienciaSectorPribado(int experienciaSectorPribado) {
        this.experienciaSectorPribado = experienciaSectorPribado;
    }

    public int getExperienciaTotal() {
        return experienciaTotal;
    }

    public void setExperienciaTotal(int experienciaTotal) {
        this.experienciaTotal = experienciaTotal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<GradoEscolarida> getGradoEscolaridaList() {
        return gradoEscolaridaList;
    }

    public void setGradoEscolaridaList(List<GradoEscolarida> gradoEscolaridaList) {
        this.gradoEscolaridaList = gradoEscolaridaList;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    public List<LtNivelEscolaridad> getLtNivelEscolaridadList() {
        return ltNivelEscolaridadList;
    }

    public void setLtNivelEscolaridadList(List<LtNivelEscolaridad> ltNivelEscolaridadList) {
        this.ltNivelEscolaridadList = ltNivelEscolaridadList;
    }

    public List<LtEtnoeducacion> getLtEtnoeducacionList() {
        return ltEtnoeducacionList;
    }

    public void setLtEtnoeducacionList(List<LtEtnoeducacion> ltEtnoeducacionList) {
        this.ltEtnoeducacionList = ltEtnoeducacionList;
    }

    public List<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(List<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

    public List<AreaFormacion> getAreaFormacionList() {
        return areaFormacionList;
    }

    public void setAreaFormacionList(List<AreaFormacion> areaFormacionList) {
        this.areaFormacionList = areaFormacionList;
    }

    public List<LtEnfasis> getLtEnfasisList() {
        return ltEnfasisList;
    }

    public void setLtEnfasisList(List<LtEnfasis> ltEnfasisList) {
        this.ltEnfasisList = ltEnfasisList;
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
    
}
