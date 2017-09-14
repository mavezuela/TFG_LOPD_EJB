/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author usuario
 */
@Embeddable
public class VersionficheroPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idversion")
    private int idversion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfichero")
    private int idfichero;

    public VersionficheroPK() {
    }

    public VersionficheroPK(int idversion, int idfichero) {
        this.idversion = idversion;
        this.idfichero = idfichero;
    }

    public int getIdversion() {
        return idversion;
    }

    public void setIdversion(int idversion) {
        this.idversion = idversion;
    }

    public int getIdfichero() {
        return idfichero;
    }

    public void setIdfichero(int idfichero) {
        this.idfichero = idfichero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idversion;
        hash += (int) idfichero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VersionficheroPK)) {
            return false;
        }
        VersionficheroPK other = (VersionficheroPK) object;
        if (this.idversion != other.idversion) {
            return false;
        }
        if (this.idfichero != other.idfichero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VersionficheroPK[ idversion=" + idversion + ", idfichero=" + idfichero + " ]";
    }
    
}
