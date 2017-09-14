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
@Table(name = "version")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Version.findAll", query = "SELECT v FROM Version v")
    , @NamedQuery(name = "Version.findByIdversion", query = "SELECT v FROM Version v WHERE v.idversion = :idversion")
    , @NamedQuery(name = "Version.findByVersion", query = "SELECT v FROM Version v WHERE v.version = :version")})
public class Version implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idversion")
    private Integer idversion;
    @Size(max = 30)
    @Column(name = "version")
    private String version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idversion")
    private Collection<Catpregversion> catpregversionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "version1")
    private Collection<Versionfichero> versionficheroCollection;

    public Version() {
    }

    public Version(Integer idversion) {
        this.idversion = idversion;
    }

    public Integer getIdversion() {
        return idversion;
    }

    public void setIdversion(Integer idversion) {
        this.idversion = idversion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<Catpregversion> getCatpregversionCollection() {
        return catpregversionCollection;
    }

    public void setCatpregversionCollection(Collection<Catpregversion> catpregversionCollection) {
        this.catpregversionCollection = catpregversionCollection;
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
        hash += (idversion != null ? idversion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Version)) {
            return false;
        }
        Version other = (Version) object;
        if ((this.idversion == null && other.idversion != null) || (this.idversion != null && !this.idversion.equals(other.idversion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Version[ idversion=" + idversion + " ]";
    }
    
}
