package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "local_programacao")
public class LocalProgramacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected LocalProgramacaoPK localProgramacaoPK = new LocalProgramacaoPK();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localProgramacao")
    private List<ControleEntrada> controleEntradaList;
    
    @JoinColumn(name = "prm_id", referencedColumnName = "prm_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Programacao programacao;
    
    @JoinColumn(name = "lcl_id", referencedColumnName = "lcl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Local local;

    public LocalProgramacao() {
    }

    public LocalProgramacao(LocalProgramacaoPK localProgramacaoPK) {
        this.localProgramacaoPK = localProgramacaoPK;
    }

    public LocalProgramacao(int prmId, int lclId) {
        this.localProgramacaoPK = new LocalProgramacaoPK(prmId, lclId);
    }

    public LocalProgramacaoPK getLocalProgramacaoPK() {
        return localProgramacaoPK;
    }

    public void setLocalProgramacaoPK(LocalProgramacaoPK localProgramacaoPK) {
        this.localProgramacaoPK = localProgramacaoPK;
    }

    @XmlTransient
    public List<ControleEntrada> getControleEntradaList() {
        return controleEntradaList;
    }

    public void setControleEntradaList(List<ControleEntrada> controleEntradaList) {
        this.controleEntradaList = controleEntradaList;
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localProgramacaoPK != null ? localProgramacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalProgramacao)) {
            return false;
        }
        LocalProgramacao other = (LocalProgramacao) object;
        if ((this.localProgramacaoPK == null && other.localProgramacaoPK != null) || (this.localProgramacaoPK != null && !this.localProgramacaoPK.equals(other.localProgramacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.LocalProgramacao[ localProgramacaoPK=" + localProgramacaoPK + " ]";
    }
    
}
