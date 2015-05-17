package Logica;

import java.io.Serializable;
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
 * Nombre del Archivo: Matricula.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Entity
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByCedulaLt", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.cedulaLt = :cedulaLt"),
    @NamedQuery(name = "Matricula.findByIdCohorte", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.idCohorte = :idCohorte"),
    @NamedQuery(name = "Matricula.findByIdCurso", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.idCurso = :idCurso"),
    @NamedQuery(name = "Matricula.findByNota", query = "SELECT m FROM Matricula m WHERE m.nota = :nota")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculaPK matriculaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota")
    private Float nota;
    @JoinColumns({
        @JoinColumn(name = "id_cohorte", referencedColumnName = "id_cohorte", insertable = false, updatable = false),
        @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CursoCohorte cursoCohorte;

    public Matricula() {
    }

    public Matricula(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public Matricula(String cedulaLt, String idCohorte, String idCurso) {
        this.matriculaPK = new MatriculaPK(cedulaLt, idCohorte, idCurso);
    }

    public MatriculaPK getMatriculaPK() {
        return matriculaPK;
    }

    public void setMatriculaPK(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public CursoCohorte getCursoCohorte() {
        return cursoCohorte;
    }

    public void setCursoCohorte(CursoCohorte cursoCohorte) {
        this.cursoCohorte = cursoCohorte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaPK != null ? matriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.matriculaPK == null && other.matriculaPK != null) || (this.matriculaPK != null && !this.matriculaPK.equals(other.matriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Matricula[ matriculaPK=" + matriculaPK + " ]";
    }

} // Fin de la clase Matricula
