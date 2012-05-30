package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movimentacao")
@SequenceGenerator(name="MovimentacaoGen" , allocationSize=1)
public class Movimentacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "mvm_id")
    @GeneratedValue(generator="MovimentacaoGen", strategy= GenerationType.SEQUENCE)
    private Integer mvmId;
    
    @Column(name = "mvm_descricao")
    private String mvmDescricao;
    
    @Column(name = "mvm_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mvmData = new Date();
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mvm_valor")
    private BigDecimal mvmValor;
    
    @Column(name = "mvm_codigo_origem")
    private Integer mvmCodigoOrigem;
    
    @Column(name = "mvm_tipo")
    private Character mvmTipo;// E ou S
    
    @JoinColumn(name = "mvo_id", referencedColumnName = "mvo_id")
    @ManyToOne(optional = false)
    private MovimentacaoOrigem movimentacaoOrigem;
    
    @JoinColumn(name = "evt_id", referencedColumnName = "evt_id")
    @ManyToOne(optional = false)
    private Evento evento;

    public Movimentacao() {
    }

    public Movimentacao(Integer mvmId) {
        this.mvmId = mvmId;
    }

    public Integer getMvmId() {
        return mvmId;
    }

    public void setMvmId(Integer mvmId) {
        this.mvmId = mvmId;
    }

    public String getMvmDescricao() {
        return mvmDescricao;
    }

    public void setMvmDescricao(String mvmDescricao) {
        this.mvmDescricao = mvmDescricao;
    }

    public Date getMvmData() {
        return mvmData;
    }

    public void setMvmData(Date mvmData) {
        this.mvmData = mvmData;
    }

    public BigDecimal getMvmValor() {
        return mvmValor;
    }

    public void setMvmValor(BigDecimal mvmValor) {
        this.mvmValor = mvmValor;
    }

    public Integer getMvmCodigoOrigem() {
        return mvmCodigoOrigem;
    }

    public void setMvmCodigoOrigem(Integer mvmCodigoOrigem) {
        this.mvmCodigoOrigem = mvmCodigoOrigem;
    }

    public Character getMvmTipo() {
        return mvmTipo;
    }

    public void setMvmTipo(Character mvmTipo) {
        this.mvmTipo = mvmTipo;
    }

    public MovimentacaoOrigem getMovimentacaoOrigem() {
        return movimentacaoOrigem;
    }

    public void setMovimentacaoOrigem(MovimentacaoOrigem movimentacaoOrigem) {
        this.movimentacaoOrigem = movimentacaoOrigem;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mvmId != null ? mvmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.mvmId == null && other.mvmId != null) || (this.mvmId != null && !this.mvmId.equals(other.mvmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Movimentacao[ mvmId=" + mvmId + " ]";
    }
    
}
