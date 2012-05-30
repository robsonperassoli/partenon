package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "evento_insumo")
@SequenceGenerator(name="EventoInsumoGen" , allocationSize=1)
public class EventoInsumo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "evi_id")
    @GeneratedValue(generator="EventoInsumoGen", strategy= GenerationType.SEQUENCE)
    private Integer eviId;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "evi_valor")
    private BigDecimal eviValor;
    
    @Column(name = "evi_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eviInicio;
    
    @Column(name = "evi_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eviFim;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoInsumo")
    private List<InsumoLocacao> insumoLocacaoList;
    
    @JoinColumn(name = "ins_id", referencedColumnName = "ins_id")
    @ManyToOne(optional = false)
    private Insumo insumo;
    
    @JoinColumn(name = "eic_id", referencedColumnName = "eic_id")
    @ManyToOne(optional = false)
    private EventoInsumoCategoria eventoInsumoCategoria;
    
    @JoinColumn(name = "evt_id", referencedColumnName = "evt_id")
    @ManyToOne(optional = false)
    private Evento evento;
    
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne(optional = false)
    private Entidade entidade;

    public EventoInsumo() {
    }

    public EventoInsumo(Integer eviId) {
        this.eviId = eviId;
    }

    public Integer getEviId() {
        return eviId;
    }

    public void setEviId(Integer eviId) {
        this.eviId = eviId;
    }

    public BigDecimal getEviValor() {
        return eviValor;
    }

    public void setEviValor(BigDecimal eviValor) {
        this.eviValor = eviValor;
    }

    public Date getEviInicio() {
        return eviInicio;
    }

    public void setEviInicio(Date eviInicio) {
        this.eviInicio = eviInicio;
    }

    public Date getEviFim() {
        return eviFim;
    }

    public void setEviFim(Date eviFim) {
        this.eviFim = eviFim;
    }

    @XmlTransient
    public List<InsumoLocacao> getInsumoLocacaoList() {
        return insumoLocacaoList;
    }

    public void setInsumoLocacaoList(List<InsumoLocacao> insumoLocacaoList) {
        this.insumoLocacaoList = insumoLocacaoList;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public EventoInsumoCategoria getEventoInsumoCategoria() {
        return eventoInsumoCategoria;
    }

    public void setEventoInsumoCategoria(EventoInsumoCategoria eventoInsumoCategoria) {
        this.eventoInsumoCategoria = eventoInsumoCategoria;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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
        hash += (eviId != null ? eviId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoInsumo)) {
            return false;
        }
        EventoInsumo other = (EventoInsumo) object;
        if ((this.eviId == null && other.eviId != null) || (this.eviId != null && !this.eviId.equals(other.eviId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.EventoInsumo[ eviId=" + eviId + " ]";
    }
    
}
