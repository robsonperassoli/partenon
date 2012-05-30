package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "programacao")
@SequenceGenerator(name="ProgramacaoGen" , allocationSize=1)
public class Programacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "prm_id")
    @GeneratedValue(generator="ProgramacaoGen", strategy=GenerationType.SEQUENCE)
    private Integer prmId;
    
    @Column(name = "prm_nome")
    private String prmNome;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prm_preco")
    private BigDecimal prmPreco;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programacao")
    private List<Programa> programaList = new ArrayList<Programa>();
    
    @ManyToMany(mappedBy="programacaoList",cascade= CascadeType.ALL)
    private List<Pacote> pacoteList = new ArrayList<Pacote>();
    
    @JoinColumn(name = "evt_id", referencedColumnName = "evt_id")
    @ManyToOne(optional = false)
    private Evento evento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programacao")
    private List<LocalProgramacao> localProgramacaoList = new ArrayList<LocalProgramacao>();

    public Programacao() {
    }

    public Programacao(Integer prmId) {
        this.prmId = prmId;
    }

    public Integer getPrmId() {
        return prmId;
    }

    public void setPrmId(Integer prmId) {
        this.prmId = prmId;
    }

    public String getPrmNome() {
        return prmNome;
    }

    public void setPrmNome(String prmNome) {
        this.prmNome = prmNome;
    }

    public BigDecimal getPrmPreco() {
        return prmPreco;
    }

    public void setPrmPreco(BigDecimal prmPreco) {
        this.prmPreco = prmPreco;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    public List<Pacote> getPacoteList() {
        return pacoteList;
    }

    public void setPacoteList(List<Pacote> pacoteList) {
        this.pacoteList = pacoteList;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @XmlTransient
    public List<LocalProgramacao> getLocalProgramacaoList() {
        return localProgramacaoList;
    }

    public void setLocalProgramacaoList(List<LocalProgramacao> localProgramacaoList) {
        this.localProgramacaoList = localProgramacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prmId != null ? prmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programacao)) {
            return false;
        }
        Programacao other = (Programacao) object;
        if ((this.prmId == null && other.prmId != null) || (this.prmId != null && !this.prmId.equals(other.prmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Programacao[ prmId=" + prmId + " ]";
    }
    
}
