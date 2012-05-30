package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
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

@Entity
@Table(name = "programa")
@SequenceGenerator(name="ProgramaGen" , allocationSize=1)
public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "prg_id")
    @GeneratedValue(generator="ProgramaGen", strategy=GenerationType.SEQUENCE)
    private Integer prgId;
    
    @Column(name = "prg_descricao")
    private String prgDescricao;
    
    @JoinColumn(name = "prm_id", referencedColumnName = "prm_id")
    @ManyToOne(optional = false)
    private Programacao programacao;
    

    public Programa() {
    }

    public Programa(Integer prgId) {
        this.prgId = prgId;
    }

    public Integer getPrgId() {
        return prgId;
    }

    public void setPrgId(Integer prgId) {
        this.prgId = prgId;
    }

    public String getPrgDescricao() {
        return prgDescricao;
    }

    public void setPrgDescricao(String prgDescricao) {
        this.prgDescricao = prgDescricao;
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prgId != null ? prgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.prgId == null && other.prgId != null) || (this.prgId != null && !this.prgId.equals(other.prgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Programa[ prgId=" + prgId + " ]";
    }
    
}
