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
@Table(name = "insumo_locacao")
@SequenceGenerator(name="InsumoLocacaoGen" , allocationSize=1)
public class InsumoLocacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "inl_id")
    @GeneratedValue(generator="InsumoLocacaoGen", strategy= GenerationType.SEQUENCE)
    private Integer inlId;
    
    @Column(name = "inl_programacao")
    private String inlProgramacao;
    
    @JoinColumn(name = "lcl_id", referencedColumnName = "lcl_id")
    @ManyToOne(optional = false)
    private Local local;
    
    @JoinColumn(name = "evi_id", referencedColumnName = "evi_id")
    @ManyToOne(optional = false)
    private EventoInsumo eventoInsumo;
    
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne(optional = false)
    private Entidade entidade;

    public InsumoLocacao() {
    }

    public InsumoLocacao(Integer inlId) {
        this.inlId = inlId;
    }

    public Integer getInlId() {
        return inlId;
    }

    public void setInlId(Integer inlId) {
        this.inlId = inlId;
    }

    public String getInlProgramacao() {
        return inlProgramacao;
    }

    public void setInlProgramacao(String inlProgramacao) {
        this.inlProgramacao = inlProgramacao;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public EventoInsumo getEventoInsumo() {
        return eventoInsumo;
    }

    public void setEventoInsumo(EventoInsumo eventoInsumo) {
        this.eventoInsumo = eventoInsumo;
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
        hash += (inlId != null ? inlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsumoLocacao)) {
            return false;
        }
        InsumoLocacao other = (InsumoLocacao) object;
        if ((this.inlId == null && other.inlId != null) || (this.inlId != null && !this.inlId.equals(other.inlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.InsumoLocacao[ inlId=" + inlId + " ]";
    }
    
}
