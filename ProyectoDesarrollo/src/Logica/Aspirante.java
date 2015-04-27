/** 
 * Nombre del Archivo: Aspirante.java 
 * Fecha de Creacion: 27/04/2015 
 * Autores: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750) 
 */

package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "aspirante")
@NamedQueries({
    @NamedQuery(name = "Aspirante.findAll", query = "SELECT a FROM Aspirante a")})
public class Aspirante implements Serializable {
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
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @Column(name = "departamento")
    private String departamento;
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
    @Column(name = "estado")
    private boolean estado;

    public Aspirante() {
    }

    public Aspirante(String cedula) {
        this.cedula = cedula;
    }

    public Aspirante(String cedula, String nombres, String apellidos, String correo, String celular, String direccion, String sedePertenece, String intitucion, String codigoDaneIntitucion, String grado, String secretariaEducacion, String municipio, String departamento, String areaInscripcion, boolean tutorPta, boolean usuarioColombiaAprende, boolean estado) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
        this.sedePertenece = sedePertenece;
        this.intitucion = intitucion;
        this.codigoDaneIntitucion = codigoDaneIntitucion;
        this.grado = grado;
        this.secretariaEducacion = secretariaEducacion;
        this.municipio = municipio;
        this.departamento = departamento;
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
        if (!(object instanceof Aspirante)) {
            return false;
        }
        Aspirante other = (Aspirante) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Aspirante[ cedula=" + cedula + " ]";
    }

} // Fin de la clase Aspirante
