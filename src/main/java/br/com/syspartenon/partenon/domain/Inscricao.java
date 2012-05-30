package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inscricao")
@SequenceGenerator(name="InscricaoGen" , allocationSize=1)
public class Inscricao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "inc_id")
    @GeneratedValue(generator="InscricaoGen", strategy= GenerationType.SEQUENCE)
    private Integer incId;
    
    @Column(name = "inc_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incData;
    
    @ManyToMany(mappedBy="inscricoes")
    private List<Pacote> pacotes = new ArrayList<Pacote>();
    
    @JoinColumn(name = "frp_id", referencedColumnName = "frp_id")
    @ManyToOne(optional = false)
    private FormaPagamento formaPagamento;
    
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne(optional = false)
    private Entidade entidade;

    public Inscricao() {
    }

    public Inscricao(Integer incId) {
        this.incId = incId;
    }

    public Integer getIncId() {
        return incId;
    }

    public void setIncId(Integer incId) {
        this.incId = incId;
    }

    public Date getIncData() {
        return incData;
    }

    public void setIncData(Date incData) {
        this.incData = incData;
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = pacotes;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
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
        hash += (incId != null ? incId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscricao)) {
            return false;
        }
        Inscricao other = (Inscricao) object;
        if ((this.incId == null && other.incId != null) || (this.incId != null && !this.incId.equals(other.incId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Inscricao[ incId=" + incId + " ]";
    }
    
}
