package Logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Nombre del Archivo: Tarea.java
 * Fecha de Creacion: 6/05/2015
 * Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

@Entity
@Table(name = "tarea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t"),
    @NamedQuery(name = "Tarea.findByIdPractica", query = "SELECT t FROM Tarea t WHERE t.tareaPK.idPractica = :idPractica"),
    @NamedQuery(name = "Tarea.findByCedulaLt", query = "SELECT t FROM Tarea t WHERE t.tareaPK.cedulaLt = :cedulaLt"),
    @NamedQuery(name = "Tarea.findByNota", query = "SELECT t FROM Tarea t WHERE t.nota = :nota")})
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TareaPK tareaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota")
    private Float nota;
    @JoinColumn(name = "id_practica", referencedColumnName = "id_practica", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Practica practica;

    public Tarea() {
    }

    public Tarea(TareaPK tareaPK) {
        this.tareaPK = tareaPK;
    }

    public Tarea(String idPractica, String cedulaLt) {
        this.tareaPK = new TareaPK(idPractica, cedulaLt);
    }

    public TareaPK getTareaPK() {
        return tareaPK;
    }

    public void setTareaPK(TareaPK tareaPK) {
        this.tareaPK = tareaPK;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tareaPK != null ? tareaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.tareaPK == null && other.tareaPK != null) || (this.tareaPK != null && !this.tareaPK.equals(other.tareaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Tarea[ tareaPK=" + tareaPK + " ]";
    }

} // Fin de la clase Tarea
