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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "entrada_agenda")
@SequenceGenerator(name="EntradaAgendaGen" , allocationSize=1)
public class EntradaAgenda implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "eag_id")
    @GeneratedValue(generator = "EntradaAgendaGen", strategy = GenerationType.SEQUENCE)
    private Integer eagId;
    
    @Column(name = "eag_descricao")
    private String eagDescricao;
    
    @Column(name = "eag_data_inicio")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date eagDataInicio;
    
    @Column(name = "eag_data_fim")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date eagDataFim;
    
    @JoinColumn(name = "evt_id", referencedColumnName = "evt_id")
    @ManyToOne(optional = false)
    private Evento evento;
    
    public EntradaAgenda() {
    }

    public EntradaAgenda(Integer eagId) {
        this.eagId = eagId;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Date getEagDataFim() {
        return eagDataFim;
    }

    public void setEagDataFim(Date eagDataFim) {
        this.eagDataFim = eagDataFim;
    }

    public Date getEagDataInicio() {
        return eagDataInicio;
    }

    public void setEagDataInicio(Date eagDataInicio) {
        this.eagDataInicio = eagDataInicio;
    }

    public String getEagDescricao() {
        return eagDescricao;
    }

    public void setEagDescricao(String eagDescricao) {
        this.eagDescricao = eagDescricao;
    }

    public Integer getEagId() {
        return eagId;
    }

    public void setEagId(Integer eagId) {
        this.eagId = eagId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eagId != null ? eagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaAgenda)) {
            return false;
        }
        EntradaAgenda other = (EntradaAgenda) object;
        if ((this.eagId == null && other.eagId != null) || (this.eagId != null && !this.eagId.equals(other.eagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.EntradaAgenda[ eagId=" + eagId + " ]";
    }
}
