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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "comodo_status")
@SequenceGenerator(name="ComodoStatusGen" , allocationSize=1)
public class ComodoStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "cms_id")
    @GeneratedValue(generator="ComodoStatusGen", strategy= GenerationType.SEQUENCE)
    private Integer cmsId;
    
    @Column(name = "cms_descricao")
    private String cmsDescricao;
        
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comodoStatus")
    private List<Comodo> comodoList;
    
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne(optional = false)
    private Entidade entidade;

    public ComodoStatus() {
    }

    public ComodoStatus(Integer cmsId) {
        this.cmsId = cmsId;
    }

    public Integer getCmsId() {
        return cmsId;
    }

    public void setCmsId(Integer cmsId) {
        this.cmsId = cmsId;
    }

    public String getCmsDescricao() {
        return cmsDescricao;
    }

    public void setCmsDescricao(String cmsDescricao) {
        this.cmsDescricao = cmsDescricao;
    }

    public List<Comodo> getComodoList() {
        return comodoList;
    }

    public void setComodoList(List<Comodo> comodoList) {
        this.comodoList = comodoList;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmsId != null ? cmsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComodoStatus)) {
            return false;
        }
        ComodoStatus other = (ComodoStatus) object;
        if ((this.cmsId == null && other.cmsId != null) || (this.cmsId != null && !this.cmsId.equals(other.cmsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.ComodoStatus[ cmsId=" + cmsId + " ]";
    }
    
}
