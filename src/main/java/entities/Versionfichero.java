/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "versionfichero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Versionfichero.findAll", query = "SELECT v FROM Versionfichero v")
    , @NamedQuery(name = "Versionfichero.findByIdversion", query = "SELECT v FROM Versionfichero v WHERE v.versionficheroPK.idversion = :idversion")
    , @NamedQuery(name = "Versionfichero.findByIdfichero", query = "SELECT v FROM Versionfichero v WHERE v.versionficheroPK.idfichero = :idfichero")
    , @NamedQuery(name = "Versionfichero.findByVersion", query = "SELECT v FROM Versionfichero v WHERE v.version = :version")
    , @NamedQuery(name = "Versionfichero.findByDescripcion", query = "SELECT v FROM Versionfichero v WHERE v.descripcion = :descripcion")})
public class Versionfichero implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VersionficheroPK versionficheroPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "version")
    private String version;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "versionfichero")
    private Collection<Catpreguntas> catpreguntasCollection;
    @JoinColumn(name = "idfichero", referencedColumnName = "idfichero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ficheros ficheros;
    @JoinColumn(name = "idversion", referencedColumnName = "idversion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Version version1;

    public Versionfichero() {
    }

    public Versionfichero(VersionficheroPK versionficheroPK) {
        this.versionficheroPK = versionficheroPK;
    }

    public Versionfichero(VersionficheroPK versionficheroPK, String version) {
        this.versionficheroPK = versionficheroPK;
        this.version = version;
    }

    public Versionfichero(int idversion, int idfichero) {
        this.versionficheroPK = new VersionficheroPK(idversion, idfichero);
    }

    public VersionficheroPK getVersionficheroPK() {
        return versionficheroPK;
    }

    public void setVersionficheroPK(VersionficheroPK versionficheroPK) {
        this.versionficheroPK = versionficheroPK;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Catpreguntas> getCatpreguntasCollection() {
        return catpreguntasCollection;
    }

    public void setCatpreguntasCollection(Collection<Catpreguntas> catpreguntasCollection) {
        this.catpreguntasCollection = catpreguntasCollection;
    }

    public Ficheros getFicheros() {
        return ficheros;
    }

    public void setFicheros(Ficheros ficheros) {
        this.ficheros = ficheros;
    }

    public Version getVersion1() {
        return version1;
    }

    public void setVersion1(Version version1) {
        this.version1 = version1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (versionficheroPK != null ? versionficheroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Versionfichero)) {
            return false;
        }
        Versionfichero other = (Versionfichero) object;
        if ((this.versionficheroPK == null && other.versionficheroPK != null) || (this.versionficheroPK != null && !this.versionficheroPK.equals(other.versionficheroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Versionfichero[ versionficheroPK=" + versionficheroPK + " ]";
    }
    
}
