/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p")
    , @NamedQuery(name = "Preguntas.findByIdpreguntas", query = "SELECT p FROM Preguntas p WHERE p.idpreguntas = :idpreguntas")
    , @NamedQuery(name = "Preguntas.findByIdcatpreguntas", query = "SELECT p FROM Preguntas p WHERE p.idcatpreguntas = :idcatpreguntas")
    , @NamedQuery(name = "Preguntas.findByPregunta", query = "SELECT p FROM Preguntas p WHERE p.pregunta = :pregunta")
    , @NamedQuery(name = "Preguntas.findByPorcentaje", query = "SELECT p FROM Preguntas p WHERE p.porcentaje = :porcentaje")
    , @NamedQuery(name = "Preguntas.findByCumplimiento", query = "SELECT p FROM Preguntas p WHERE p.cumplimiento = :cumplimiento")})
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpreguntas")
    private Integer idpreguntas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pregunta")
    private String pregunta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private BigDecimal porcentaje;
    @Column(name = "cumplimiento")
    private BigDecimal cumplimiento;
    @JoinColumn(name = "idcatpreguntas", referencedColumnName = "idcatpreguntas")
    @ManyToOne(optional = false)
    private Catpreguntas idcatpreguntas;

    public Preguntas() {
    }

    public Preguntas(Integer idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public Preguntas(Integer idpreguntas, String pregunta) {
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

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public BigDecimal getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(BigDecimal cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    public Catpreguntas getIdcatpreguntas() {
        return idcatpreguntas;
    }

    public void setIdcatpreguntas(Catpreguntas idcatpreguntas) {
        this.idcatpreguntas = idcatpreguntas;
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
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.idpreguntas == null && other.idpreguntas != null) || (this.idpreguntas != null && !this.idpreguntas.equals(other.idpreguntas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Preguntas[ idpreguntas=" + idpreguntas + " ]";
    }
    
}
