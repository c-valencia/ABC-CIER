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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "curso")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")})
public class Curso implements Serializable, Item {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_curso")
    private String idCurso;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "contenido")
    private String contenido;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(mappedBy = "idCurso")
    private List<Fases> fasesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<CursoCohorte> cursoCohorteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso")
    private List<MasterTeacher> masterTeacherList;
    
    private ArrayList <Item> listFases;

   

    public Curso() {
    }

    public Curso(String idCurso) {
        this.idCurso = idCurso;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Fases> getFasesList() {
        return fasesList;
    }

    public void setFasesList(List<Fases> fasesList) {
        this.fasesList = fasesList;
    }

    public List<CursoCohorte> getCursoCohorteList() {
        return cursoCohorteList;
    }

    public void setCursoCohorteList(List<CursoCohorte> cursoCohorteList) {
        this.cursoCohorteList = cursoCohorteList;
    }

    public List<MasterTeacher> getMasterTeacherList() {
        return masterTeacherList;
    }

    public void setMasterTeacherList(List<MasterTeacher> masterTeacherList) {
        this.masterTeacherList = masterTeacherList;
    }

     public ArrayList<Item> getListFases() {
        return listFases;
    }

    public void setListFases(ArrayList<Item> listFases) {
        this.listFases = listFases;
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

    @Override
    public void insertarItem(Item nuevoObjeto) {
         listFases.add(nuevoObjeto);
    }

    @Override
    public int obtenerItem(Object... list) {
        String codigoFase = (String)list[0];
        int posicion = -1;
        for (int x = 0; x < listFases.size(); x++) {
            Fases fase = (Fases)listFases.get(x);
            if (fase.getIdFase().equals(codigoFase)) {
                posicion = x; 
            }
        }
        return posicion;
    }

    @Override
    public void eliminarItem(Object... list) {
        String codigoFase = (String)list[0];
        int posicion = obtenerItem(codigoFase);
        if (posicion != -1) {
            listFases.remove(posicion);
        }
    }
    
}
