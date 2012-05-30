package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "unidade")
@SequenceGenerator(name="UnidadeGen" , allocationSize=1)
public class Unidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "und_id")
    @GeneratedValue(generator="UnidadeGen", strategy= GenerationType.SEQUENCE)
    private Integer undId;
    
    @Column(name = "und_descricao")
    private String undDescricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidade")
    private List<Insumo> insumoList;

    public Unidade() {
    }

    public Unidade(Integer undId) {
        this.undId = undId;
    }

    public Integer getUndId() {
        return undId;
    }

    public void setUndId(Integer undId) {
        this.undId = undId;
    }

    public String getUndDescricao() {
        return undDescricao;
    }

    public void setUndDescricao(String undDescricao) {
        this.undDescricao = undDescricao;
    }

    @XmlTransient
    public List<Insumo> getInsumoList() {
        return insumoList;
    }

    public void setInsumoList(List<Insumo> insumoList) {
        this.insumoList = insumoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (undId != null ? undId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.undId == null && other.undId != null) || (this.undId != null && !this.undId.equals(other.undId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Unidade[ undId=" + undId + " ]";
    }
    
}
