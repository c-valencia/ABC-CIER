/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "curso_cohorte")
@NamedQueries({
    @NamedQuery(name = "CursoCohorte.findAll", query = "SELECT c FROM CursoCohorte c")})
public class CursoCohorte implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursoCohortePK cursoCohortePK;
    @Basic(optional = false)
    @Column(name = "num_estudiantes")
    private int numEstudiantes;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "id_cohorte", referencedColumnName = "id_cohorte", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cohorte cohorte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoCohorte")
    private List<Matricula> matriculaList;

    public CursoCohorte() {
    }

    public CursoCohorte(CursoCohortePK cursoCohortePK) {
        this.cursoCohortePK = cursoCohortePK;
    }

    public CursoCohorte(CursoCohortePK cursoCohortePK, int numEstudiantes) {
        this.cursoCohortePK = cursoCohortePK;
        this.numEstudiantes = numEstudiantes;
    }

    public CursoCohorte(String idCohorte, String idCurso) {
        this.cursoCohortePK = new CursoCohortePK(idCohorte, idCurso);
    }

    public CursoCohortePK getCursoCohortePK() {
        return cursoCohortePK;
    }

    public void setCursoCohortePK(CursoCohortePK cursoCohortePK) {
        this.cursoCohortePK = cursoCohortePK;
    }

    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    public void setNumEstudiantes(int numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Cohorte getCohorte() {
        return cohorte;
    }

    public void setCohorte(Cohorte cohorte) {
        this.cohorte = cohorte;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoCohortePK != null ? cursoCohortePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoCohorte)) {
            return false;
        }
        CursoCohorte other = (CursoCohorte) object;
        if ((this.cursoCohortePK == null && other.cursoCohortePK != null) || (this.cursoCohortePK != null && !this.cursoCohortePK.equals(other.cursoCohortePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.CursoCohorte[ cursoCohortePK=" + cursoCohortePK + " ]";
    }
    
}
