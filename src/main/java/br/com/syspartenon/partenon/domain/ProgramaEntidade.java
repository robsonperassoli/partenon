package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "programa_entidade")
public class ProgramaEntidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ProgramaEntidadePK programaEntidadePK;

    public ProgramaEntidade() {
    }

    public ProgramaEntidade(ProgramaEntidadePK programaEntidadePK) {
        this.programaEntidadePK = programaEntidadePK;
    }

    public ProgramaEntidade(int prgId, int entId) {
        this.programaEntidadePK = new ProgramaEntidadePK(prgId, entId);
    }

    public ProgramaEntidadePK getProgramaEntidadePK() {
        return programaEntidadePK;
    }

    public void setProgramaEntidadePK(ProgramaEntidadePK programaEntidadePK) {
        this.programaEntidadePK = programaEntidadePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programaEntidadePK != null ? programaEntidadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaEntidade)) {
            return false;
        }
        ProgramaEntidade other = (ProgramaEntidade) object;
        if ((this.programaEntidadePK == null && other.programaEntidadePK != null) || (this.programaEntidadePK != null && !this.programaEntidadePK.equals(other.programaEntidadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.ProgramaEntidade[ programaEntidadePK=" + programaEntidadePK + " ]";
    }
    
}
