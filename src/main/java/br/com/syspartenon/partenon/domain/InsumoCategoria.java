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
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "insumo_categoria")
@SequenceGenerator(name="InsumoCategoriaGen" , allocationSize=1)
public class InsumoCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ict_id")
    @GeneratedValue(generator="InsumoCategoriaGen", strategy= GenerationType.SEQUENCE)
    private Integer ictId;
    
    @Column(name = "ict_descricao")
    private String ictDescricao;
    
    @Column(name = "ict_cobravel")
    private Boolean ictCobravel;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumoCategoria")
    private List<Insumo> insumoList;
    
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne(optional = false)
    private Entidade entidade;
    

    public InsumoCategoria() {
    }

    public InsumoCategoria(Integer ictId) {
        this.ictId = ictId;
    }

    public Integer getIctId() {
        return ictId;
    }

    public void setIctId(Integer ictId) {
        this.ictId = ictId;
    }

    public String getIctDescricao() {
        return ictDescricao;
    }

    public void setIctDescricao(String ictDescricao) {
        this.ictDescricao = ictDescricao;
    }

    public Boolean getIctCobravel() {
        return ictCobravel;
    }

    public void setIctCobravel(Boolean ictCobravel) {
        this.ictCobravel = ictCobravel;
    }

    @XmlTransient
    public List<Insumo> getInsumoList() {
        return insumoList;
    }

    public void setInsumoList(List<Insumo> insumoList) {
        this.insumoList = insumoList;
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
        hash += (ictId != null ? ictId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsumoCategoria)) {
            return false;
        }
        InsumoCategoria other = (InsumoCategoria) object;
        if ((this.ictId == null && other.ictId != null) || (this.ictId != null && !this.ictId.equals(other.ictId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.InsumoCategoria[ ictId=" + ictId + " ]";
    }
    
}
