package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EventoEntidadePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "evt_id")
    private int evtId;
    @Basic(optional = false)
    @Column(name = "ent_id")
    private int entId;

    public EventoEntidadePK() {
    }

    public EventoEntidadePK(int evtId, int entId) {
        this.evtId = evtId;
        this.entId = entId;
    }

    public int getEvtId() {
        return evtId;
    }

    public void setEvtId(int evtId) {
        this.evtId = evtId;
    }

    public int getEntId() {
        return entId;
    }

    public void setEntId(int entId) {
        this.entId = entId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) evtId;
        hash += (int) entId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoEntidadePK)) {
            return false;
        }
        EventoEntidadePK other = (EventoEntidadePK) object;
        if (this.evtId != other.evtId) {
            return false;
        }
        if (this.entId != other.entId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.EventoEntidadePK[ evtId=" + evtId + ", entId=" + entId + " ]";
    }
    
}
