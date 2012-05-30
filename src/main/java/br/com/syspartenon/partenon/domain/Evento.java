package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "evento")
@SequenceGenerator(name="EventoGen" , allocationSize=1)
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "evt_id")
    @GeneratedValue(generator="EventoGen", strategy=GenerationType.SEQUENCE)
    private Integer evtId;
    
    @Column(name = "evt_nome")
    private String evtNome;
    
    @Column(name = "evt_descricao")
    private String evtDescricao;
    
    @Column(name = "evt_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date evtInicio = new Date();
    
    @Column(name = "evt_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date evtFim = new Date();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private List<Imovel> imovelList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private List<Movimentacao> movimentacaoList;
    
    @OneToOne(optional=false, cascade={CascadeType.ALL})
    @JoinColumn(name="lcl_id", referencedColumnName = "lcl_id", unique=true, nullable=false, updatable=false, insertable=true)
    private Local local;
 
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private List<Programacao> programacaoList = new ArrayList<Programacao>();
    
    @OneToOne(optional = false, cascade = {CascadeType.ALL}, mappedBy="evento", fetch= FetchType.EAGER)
    private Site site;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private List<EventoInsumo> eventoInsumoList;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="evento")
    private List<Local> localList = new ArrayList<Local>();
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="evento")
    private List<Pacote> pacoteList = new ArrayList<Pacote>();

    public Evento() {
    }

    public Evento(Integer evtId) {
        this.evtId = evtId;
    }

    public Integer getEvtId() {
        return evtId;
    }

    public void setEvtId(Integer evtId) {
        this.evtId = evtId;
    }

    public List<Pacote> getPacoteList() {
        return pacoteList;
    }

    public void setPacoteList(List<Pacote> pacoteList) {
        this.pacoteList = pacoteList;
    }

    public String getEvtNome() {
        return evtNome;
    }

    public void setEvtNome(String evtNome) {
        this.evtNome = evtNome;
    }

    public String getEvtDescricao() {
        return evtDescricao;
    }

    public void setEvtDescricao(String evtDescricao) {
        this.evtDescricao = evtDescricao;
    }

    public Date getEvtInicio() {
        return evtInicio;
    }

    public void setEvtInicio(Date evtInicio) {
        this.evtInicio = evtInicio;
    }

    public Date getEvtFim() {
        return evtFim;
    }

    public void setEvtFim(Date evtFim) {
        this.evtFim = evtFim;
    }

    @XmlTransient
    public List<Imovel> getImovelList() {
        return imovelList;
    }

    public void setImovelList(List<Imovel> imovelList) {
        this.imovelList = imovelList;
    }

    @XmlTransient
    public List<Movimentacao> getMovimentacaoList() {
        return movimentacaoList;
    }

    public void setMovimentacaoList(List<Movimentacao> movimentacaoList) {
        this.movimentacaoList = movimentacaoList;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @XmlTransient
    public List<Programacao> getProgramacaoList() {
        return programacaoList;
    }

    public void setProgramacaoList(List<Programacao> programacaoList) {
        this.programacaoList = programacaoList;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @XmlTransient
    public List<EventoInsumo> getEventoInsumoList() {
        return eventoInsumoList;
    }

    public void setEventoInsumoList(List<EventoInsumo> eventoInsumoList) {
        this.eventoInsumoList = eventoInsumoList;
    }

    @XmlTransient
    public List<Local> getLocalList() {
        return localList;
    }

    public void setLocalList(List<Local> localList) {
        this.localList = localList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evtId != null ? evtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.evtId == null && other.evtId != null) || (this.evtId != null && !this.evtId.equals(other.evtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Evento[ evtId=" + evtId + " ]";
    }
    
}
