package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProgramaEntidadePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "prg_id")
    private int prgId;
    @Basic(optional = false)
    @Column(name = "ent_id")
    private int entId;

    public ProgramaEntidadePK() {
    }

    public ProgramaEntidadePK(int prgId, int entId) {
        this.prgId = prgId;
        this.entId = entId;
    }

    public int getPrgId() {
        return prgId;
    }

    public void setPrgId(int prgId) {
        this.prgId = prgId;
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
        hash += (int) prgId;
        hash += (int) entId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaEntidadePK)) {
            return false;
        }
        ProgramaEntidadePK other = (ProgramaEntidadePK) object;
        if (this.prgId != other.prgId) {
            return false;
        }
        if (this.entId != other.entId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.ProgramaEntidadePK[ prgId=" + prgId + ", entId=" + entId + " ]";
    }
    
}
