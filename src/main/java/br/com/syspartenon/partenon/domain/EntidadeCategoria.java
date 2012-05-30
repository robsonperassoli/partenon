package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "entidade_categoria")
@SequenceGenerator(name="EntidadeCategoriaGen" , allocationSize=1)
public class EntidadeCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "enc_id")
    @GeneratedValue(generator="EntidadeCategoriaGen", strategy=GenerationType.SEQUENCE)
    private Integer encId;
    
    @Column(name = "enc_descricao")
    private String encDescricao;
    
    @ManyToMany(mappedBy = "entidadeCategoriaList", cascade=CascadeType.ALL)
    private List<Entidade> entidadeList = new ArrayList<Entidade>();
    
    public EntidadeCategoria() {
    }

    public EntidadeCategoria(Integer encId) {
        this.encId = encId;
    }

    public List<Entidade> getEntidadeList() {
        return entidadeList;
    }

    public void setEntidadeList(List<Entidade> entidadeList) {
        this.entidadeList = entidadeList;
    }

    public Integer getEncId() {
        return encId;
    }

    public void setEncId(Integer encId) {
        this.encId = encId;
    }

    public String getEncDescricao() {
        return encDescricao;
    }

    public void setEncDescricao(String encDescricao) {
        this.encDescricao = encDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encId != null ? encId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadeCategoria)) {
            return false;
        }
        EntidadeCategoria other = (EntidadeCategoria) object;
        if ((this.encId == null && other.encId != null) || (this.encId != null && !this.encId.equals(other.encId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.EntidadeCategoria[ encId=" + encId + " ]";
    }
    
}
