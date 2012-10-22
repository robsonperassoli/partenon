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
@Table(name = "evento_insumo_categoria")
@SequenceGenerator(name="EventoInsumoCategoriaGen" , allocationSize=1)
public class EventoInsumoCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "eic_id")
    @GeneratedValue(generator="EventoInsumoCategoriaGen", strategy= GenerationType.SEQUENCE)
    private Integer eicId;
    
    @Column(name = "eic_descricao")
    private String eicDescricao;
    
    @Column(name = "eic_cobravel")
    private Boolean eicCobravel;
    
    @Column(name = "eic_limita_periodo")
    private Boolean eicLimitaPeriodo;
    
    @Column(name = "eic_alocavel")
    private Boolean eicAlocavel;
    
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne(optional = false)
    private Entidade entidade;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoInsumoCategoria")
    private List<EventoInsumo> eventoInsumoList;

    public EventoInsumoCategoria() {
    }

    public EventoInsumoCategoria(Integer eicId) {
        this.eicId = eicId;
    }

    public Integer getEicId() {
        return eicId;
    }

    public void setEicId(Integer eicId) {
        this.eicId = eicId;
    }

    public String getEicDescricao() {
        return eicDescricao;
    }

    public void setEicDescricao(String eicDescricao) {
        this.eicDescricao = eicDescricao;
    }

    public Boolean getEicCobravel() {
        return eicCobravel;
    }

    public void setEicCobravel(Boolean eicCobravel) {
        this.eicCobravel = eicCobravel;
    }

    public Boolean getEicLimitaPeriodo() {
        return eicLimitaPeriodo;
    }

    public void setEicLimitaPeriodo(Boolean eicLimitaPeriodo) {
        this.eicLimitaPeriodo = eicLimitaPeriodo;
    }

    public Boolean getEicAlocavel() {
        return eicAlocavel;
    }

    public void setEicAlocavel(Boolean eicAlocavel) {
        this.eicAlocavel = eicAlocavel;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    @XmlTransient
    public List<EventoInsumo> getEventoInsumoList() {
        return eventoInsumoList;
    }

    public void setEventoInsumoList(List<EventoInsumo> eventoInsumoList) {
        this.eventoInsumoList = eventoInsumoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eicId != null ? eicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoInsumoCategoria)) {
            return false;
        }
        EventoInsumoCategoria other = (EventoInsumoCategoria) object;
        if ((this.eicId == null && other.eicId != null) || (this.eicId != null && !this.eicId.equals(other.eicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.EventoInsumoCategoria[ eicId=" + eicId + " ]";
    }
    
}
