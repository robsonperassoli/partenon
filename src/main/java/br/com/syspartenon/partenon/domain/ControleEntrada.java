package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "controle_entrada")
@SequenceGenerator(name="ControleEntradaGen" , allocationSize=1)
public class ControleEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "cte_id")
    @GeneratedValue(generator="ControleEntradaGen", strategy= GenerationType.SEQUENCE)
    private Integer cteId;
    
    @Column(name = "cte_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cteEntrada;
    
    @Column(name = "cte_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cteSaida;
    
    @JoinColumns({
        @JoinColumn(name = "prm_id", referencedColumnName = "prm_id"),
        @JoinColumn(name = "lcl_id", referencedColumnName = "lcl_id")})
    @ManyToOne(optional = false)
    private LocalProgramacao localProgramacao;
    
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne(optional = false)
    private Entidade entidade;

    public ControleEntrada() {
    }

    public ControleEntrada(Integer cteId) {
        this.cteId = cteId;
    }

    public Integer getCteId() {
        return cteId;
    }

    public void setCteId(Integer cteId) {
        this.cteId = cteId;
    }

    public Date getCteEntrada() {
        return cteEntrada;
    }

    public void setCteEntrada(Date cteEntrada) {
        this.cteEntrada = cteEntrada;
    }

    public Date getCteSaida() {
        return cteSaida;
    }

    public void setCteSaida(Date cteSaida) {
        this.cteSaida = cteSaida;
    }

    public LocalProgramacao getLocalProgramacao() {
        return localProgramacao;
    }

    public void setLocalProgramacao(LocalProgramacao localProgramacao) {
        this.localProgramacao = localProgramacao;
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
        hash += (cteId != null ? cteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControleEntrada)) {
            return false;
        }
        ControleEntrada other = (ControleEntrada) object;
        if ((this.cteId == null && other.cteId != null) || (this.cteId != null && !this.cteId.equals(other.cteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.ControleEntrada[ cteId=" + cteId + " ]";
    }
    
}
