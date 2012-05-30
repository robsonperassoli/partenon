package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocalProgramacaoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "prm_id")
    private int prmId;
    @Basic(optional = false)
    @Column(name = "lcl_id")
    private int lclId;

    public LocalProgramacaoPK() {
    }

    public LocalProgramacaoPK(int prmId, int lclId) {
        this.prmId = prmId;
        this.lclId = lclId;
    }

    public int getPrmId() {
        return prmId;
    }

    public void setPrmId(int prmId) {
        this.prmId = prmId;
    }

    public int getLclId() {
        return lclId;
    }

    public void setLclId(int lclId) {
        this.lclId = lclId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prmId;
        hash += (int) lclId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalProgramacaoPK)) {
            return false;
        }
        LocalProgramacaoPK other = (LocalProgramacaoPK) object;
        if (this.prmId != other.prmId) {
            return false;
        }
        if (this.lclId != other.lclId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.LocalProgramacaoPK[ prmId=" + prmId + ", lclId=" + lclId + " ]";
    }
    
}
