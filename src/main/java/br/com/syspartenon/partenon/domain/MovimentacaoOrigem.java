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
@Table(name = "movimentacao_origem")
@SequenceGenerator(name="MovimentacaoOrigemGen" , allocationSize=1)
public class MovimentacaoOrigem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "mvo_id")
    @GeneratedValue(generator="MovimentacaoOrigemGen", strategy= GenerationType.SEQUENCE)
    private String mvoId;
    
    @Column(name = "mvo_descricao")
    private String mvoDescricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movimentacaoOrigem")
    private List<Movimentacao> movimentacaoList;

    public MovimentacaoOrigem() {
    }

    public MovimentacaoOrigem(String mvoId) {
        this.mvoId = mvoId;
    }

    public String getMvoId() {
        return mvoId;
    }

    public void setMvoId(String mvoId) {
        this.mvoId = mvoId;
    }

    public String getMvoDescricao() {
        return mvoDescricao;
    }

    public void setMvoDescricao(String mvoDescricao) {
        this.mvoDescricao = mvoDescricao;
    }

    @XmlTransient
    public List<Movimentacao> getMovimentacaoList() {
        return movimentacaoList;
    }

    public void setMovimentacaoList(List<Movimentacao> movimentacaoList) {
        this.movimentacaoList = movimentacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mvoId != null ? mvoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentacaoOrigem)) {
            return false;
        }
        MovimentacaoOrigem other = (MovimentacaoOrigem) object;
        if ((this.mvoId == null && other.mvoId != null) || (this.mvoId != null && !this.mvoId.equals(other.mvoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.MovimentacaoOrigem[ mvoId=" + mvoId + " ]";
    }
    
}
