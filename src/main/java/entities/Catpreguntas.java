/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "catpreguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catpreguntas.findAll", query = "SELECT c FROM Catpreguntas c")
    , @NamedQuery(name = "Catpreguntas.findByIdcatpreguntas", query = "SELECT c FROM Catpreguntas c WHERE c.idcatpreguntas = :idcatpreguntas")
    , @NamedQuery(name = "Catpreguntas.findByCategoria", query = "SELECT c FROM Catpreguntas c WHERE c.categoria = :categoria")
    , @NamedQuery(name = "Catpreguntas.findByDescripci\u00f3n", query = "SELECT c FROM Catpreguntas c WHERE c.descripci\u00f3n = :descripci\u00f3n")
    , @NamedQuery(name = "Catpreguntas.findByPorcentaje", query = "SELECT c FROM Catpreguntas c WHERE c.porcentaje = :porcentaje")})
public class Catpreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcatpreguntas")
    private Integer idcatpreguntas;
    @Size(max = 30)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 50)
    @Column(name = "descripci\u00f3n")
    private String descripción;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private BigDecimal porcentaje;
    @JoinColumns({
        @JoinColumn(name = "idversion", referencedColumnName = "idversion")
        , @JoinColumn(name = "idfichero", referencedColumnName = "idfichero")})
    @ManyToOne
    private Versionfichero versionfichero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcatpreguntas")
    private Collection<Preguntas> preguntasCollection;

    public Catpreguntas() {
    }

    public Catpreguntas(Integer idcatpreguntas) {
        this.idcatpreguntas = idcatpreguntas;
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

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Versionfichero getVersionfichero() {
        return versionfichero;
    }

    public void setVersionfichero(Versionfichero versionfichero) {
        this.versionfichero = versionfichero;
    }

    @XmlTransient
    public Collection<Preguntas> getPreguntasCollection() {
        return preguntasCollection;
    }

    public void setPreguntasCollection(Collection<Preguntas> preguntasCollection) {
        this.preguntasCollection = preguntasCollection;
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
        if (!(object instanceof Catpreguntas)) {
            return false;
        }
        Catpreguntas other = (Catpreguntas) object;
        if ((this.idcatpreguntas == null && other.idcatpreguntas != null) || (this.idcatpreguntas != null && !this.idcatpreguntas.equals(other.idcatpreguntas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Catpreguntas[ idcatpreguntas=" + idcatpreguntas + " ]";
    }
    
}
