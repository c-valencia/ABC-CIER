/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Patrones.Item;
import java.io.Serializable;
import java.util.ArrayList;
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

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "fases")
@NamedQueries({
    @NamedQuery(name = "Fases.findAll", query = "SELECT f FROM Fases f")})
public class Fases implements Serializable, Item {
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
    
    private ArrayList <Item> listPracticas; 

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

    @Override
    public void insertarItem(Item nuevoObjeto) {
        listPracticas.add(nuevoObjeto);
    }

    @Override
    public int obtenerItem(Object... list) {
        String codigoPractica = (String)list[0];
        int posicion = -1;
        for (int x = 0; x < listPracticas.size(); x++) {
            Practica practica = (Practica)listPracticas.get(x);
            if (practica.getIdPractica().equals(codigoPractica)) {
                posicion = x; 
            }
        }
        return posicion;     
    }

    @Override
    public void eliminarItem(Object... list) {
        String codigoPractica = (String)list[0];
        int posicion = obtenerItem(codigoPractica);
        if (posicion != -1) {
            listPracticas.remove(posicion);
        } 
    }
    
}
