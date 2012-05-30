package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "galeria")
@SequenceGenerator(name="GaleriaGen" , allocationSize=1)
public class Galeria implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "gal_id")
    @GeneratedValue(generator = "GaleriaGen", strategy = GenerationType.SEQUENCE)
    private Integer galId;
    
    @Column(name = "gal_descricao")
    private String galDescricao;
    
    @Column(name = "gal_data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date galData = new Date();
    
    @JoinColumn(name = "sit_id", referencedColumnName = "sit_id")
    @ManyToOne(optional = false)
    private Site site;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "galeria")
    private List<Foto> fotos;

    public Galeria() {
    }

    public Galeria(Integer galId) {
        this.galId = galId;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Site getSite() {
        return site;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public String getGalDescricao() {
        return galDescricao;
    }

    public void setGalDescricao(String galDescricao) {
        this.galDescricao = galDescricao;
    }

    public Integer getGalId() {
        return galId;
    }

    public void setGalId(Integer galId) {
        this.galId = galId;
    }

    public Date getGalData() {
        return galData;
    }

    public void setGalData(Date galData) {
        this.galData = galData;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (galId != null ? galId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Galeria)) {
            return false;
        }
        Galeria other = (Galeria) object;
        if ((this.galId == null && other.galId != null) || (this.galId != null && !this.galId.equals(other.galId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Galeria[ galId=" + galId + " ]";
    }
}