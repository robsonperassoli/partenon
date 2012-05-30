package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "evento_entidade")
public class EventoEntidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EventoEntidadePK eventoEntidadePK;

    public EventoEntidade() {
    }

    public EventoEntidade(EventoEntidadePK eventoEntidadePK) {
        this.eventoEntidadePK = eventoEntidadePK;
    }

    public EventoEntidade(int evtId, int entId) {
        this.eventoEntidadePK = new EventoEntidadePK(evtId, entId);
    }

    public EventoEntidadePK getEventoEntidadePK() {
        return eventoEntidadePK;
    }

    public void setEventoEntidadePK(EventoEntidadePK eventoEntidadePK) {
        this.eventoEntidadePK = eventoEntidadePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventoEntidadePK != null ? eventoEntidadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoEntidade)) {
            return false;
        }
        EventoEntidade other = (EventoEntidade) object;
        if ((this.eventoEntidadePK == null && other.eventoEntidadePK != null) || (this.eventoEntidadePK != null && !this.eventoEntidadePK.equals(other.eventoEntidadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.EventoEntidade[ eventoEntidadePK=" + eventoEntidadePK + " ]";
    }
    
}
