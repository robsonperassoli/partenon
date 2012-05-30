package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "foto")
@SequenceGenerator(name="FotoGen" , allocationSize=1)
public class Foto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "fot_id")
    @GeneratedValue(generator="FotoGen",strategy= GenerationType.SEQUENCE)
    private Integer fotId;
    
    @Column(name = "fot_nome")
    private String fotNome;
    
    @Column(name = "fot_descricao")
    private String fotDescricao;
    
    @JoinColumn(name = "gal_id", referencedColumnName = "gal_id")
    @ManyToOne(optional = false)
    private Galeria galeria;
    
    public Foto() {
    }

    public String getFotDescricao() {
        return fotDescricao;
    }

    public void setFotDescricao(String fotDescricao) {
        this.fotDescricao = fotDescricao;
    }

    public Integer getFotId() {
        return fotId;
    }

    public void setFotId(Integer fotId) {
        this.fotId = fotId;
    }

    public String getFotNome() {
        return fotNome;
    }

    public void setFotNome(String fotNome) {
        this.fotNome = fotNome;
    }

    public Galeria getGaleria() {
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fotId != null ? fotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foto)) {
            return false;
        }
        Foto other = (Foto) object;
        if ((this.fotId == null && other.fotId != null) || (this.fotId != null && !this.fotId.equals(other.fotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Foto[ fotId=" + fotId + " ]";
    }
    
}
