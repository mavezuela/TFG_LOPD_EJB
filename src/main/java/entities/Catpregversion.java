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
@Table(name = "catpregversion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catpregversion.findAll", query = "SELECT c FROM Catpregversion c")
    , @NamedQuery(name = "Catpregversion.findByIdcatpreguntas", query = "SELECT c FROM Catpregversion c WHERE c.idcatpreguntas = :idcatpreguntas")
    , @NamedQuery(name = "Catpregversion.findByIdversion", query = "SELECT c FROM Catpregversion c WHERE c.idversion = :idversion")   
    , @NamedQuery(name = "Catpregversion.findByCategoria", query = "SELECT c FROM Catpregversion c WHERE c.categoria = :categoria")
    , @NamedQuery(name = "Catpregversion.findByDescripcion", query = "SELECT c FROM Catpregversion c WHERE c.descripcion = :descripcion")})
public class Catpregversion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcatpreguntas")
    private Integer idcatpreguntas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idversion", referencedColumnName = "idversion")
    @ManyToOne(optional = false)
    private Version idversion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcatpregversion")
    private Collection<Preguntasversion> preguntasversionCollection;

    public Catpregversion() {
    }

    public Catpregversion(Integer idcatpreguntas) {
        this.idcatpreguntas = idcatpreguntas;
    }

    public Catpregversion(Integer idcatpreguntas, String categoria) {
        this.idcatpreguntas = idcatpreguntas;
        this.categoria = categoria;
    }

    public Integer getIdcatpreguntas() {
        return idcatpreguntas;
    }

    public void setIdcatpreguntas(Integer idcatpreguntas) {
        this.idcatpreguntas = idcatpreguntas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Version getIdversion() {
        return idversion;
    }

    public void setIdversion(Version idversion) {
        this.idversion = idversion;
    }

    @XmlTransient
    public Collection<Preguntasversion> getPreguntasversionCollection() {
        return preguntasversionCollection;
    }

    public void setPreguntasversionCollection(Collection<Preguntasversion> preguntasversionCollection) {
        this.preguntasversionCollection = preguntasversionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatpreguntas != null ? idcatpreguntas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catpregversion)) {
            return false;
        }
        Catpregversion other = (Catpregversion) object;
        if ((this.idcatpreguntas == null && other.idcatpreguntas != null) || (this.idcatpreguntas != null && !this.idcatpreguntas.equals(other.idcatpreguntas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Catpregversion[ idcatpreguntas=" + idcatpreguntas + " ]";
    }
    
}
