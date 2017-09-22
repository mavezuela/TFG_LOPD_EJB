/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "ficheros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ficheros.findAll", query = "SELECT f FROM Ficheros f")
    , @NamedQuery(name = "Ficheros.findByIddepartamento", query = "SELECT f FROM Ficheros f WHERE f.iddepartamento = :iddepartamento")
    , @NamedQuery(name = "Ficheros.findByIdfichero", query = "SELECT f FROM Ficheros f WHERE f.idfichero = :idfichero")
    , @NamedQuery(name = "Ficheros.findByNombre", query = "SELECT f FROM Ficheros f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Ficheros.findByDescripcion", query = "SELECT f FROM Ficheros f WHERE f.descripcion = :descripcion")})
public class Ficheros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfichero")
    private Integer idfichero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "iddepartamento", referencedColumnName = "iddepartamento")
    @ManyToOne(optional = false)
    private Departamento iddepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficheros")
    private Collection<Versionfichero> versionficheroCollection;

    public Ficheros() {
    }

    public Ficheros(Integer idfichero) {
        this.idfichero = idfichero;
    }

    public Ficheros(Integer idfichero, String nombre) {
        this.idfichero = idfichero;
        this.nombre = nombre;
    }

    public Integer getIdfichero() {
        return idfichero;
    }

    public void setIdfichero(Integer idfichero) {
        this.idfichero = idfichero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Departamento getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Departamento iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    @XmlTransient
    public Collection<Versionfichero> getVersionficheroCollection() {
        return versionficheroCollection;
    }

    public void setVersionficheroCollection(Collection<Versionfichero> versionficheroCollection) {
        this.versionficheroCollection = versionficheroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfichero != null ? idfichero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficheros)) {
            return false;
        }
        Ficheros other = (Ficheros) object;
        if ((this.idfichero == null && other.idfichero != null) || (this.idfichero != null && !this.idfichero.equals(other.idfichero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ficheros[ idfichero=" + idfichero + " ]";
    }
    
}
