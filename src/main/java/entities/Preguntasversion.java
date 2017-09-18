/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "preguntasversion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntasversion.findAll", query = "SELECT p FROM Preguntasversion p")
    , @NamedQuery(name = "Preguntasversion.findByIdpreguntas", query = "SELECT p FROM Preguntasversion p WHERE p.idpreguntas = :idpreguntas")
    , @NamedQuery(name = "Preguntasversion.findByPregunta", query = "SELECT p FROM Preguntasversion p WHERE p.pregunta = :pregunta")})
public class Preguntasversion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpreguntas")
    private Integer idpreguntas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pregunta")
    private String pregunta;
    @JoinColumn(name = "idcatpregversion", referencedColumnName = "idcatpreguntas")
    @ManyToOne(optional = false)
    private Catpregversion idcatpregversion;

    public Preguntasversion() {
    }

    public Preguntasversion(Integer idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public Preguntasversion(Integer idpreguntas, String pregunta) {
        this.idpreguntas = idpreguntas;
        this.pregunta = pregunta;
    }

    public Integer getIdpreguntas() {
        return idpreguntas;
    }

    public void setIdpreguntas(Integer idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Catpregversion getIdcatpregversion() {
        return idcatpregversion;
    }

    public void setIdcatpregversion(Catpregversion idcatpregversion) {
        this.idcatpregversion = idcatpregversion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpreguntas != null ? idpreguntas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preguntasversion)) {
            return false;
        }
        Preguntasversion other = (Preguntasversion) object;
        if ((this.idpreguntas == null && other.idpreguntas != null) || (this.idpreguntas != null && !this.idpreguntas.equals(other.idpreguntas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Preguntasversion[ idpreguntas=" + idpreguntas + " ]";
    }
    
}
