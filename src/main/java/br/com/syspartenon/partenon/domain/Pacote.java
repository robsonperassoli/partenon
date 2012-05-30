package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "pacote")
@SequenceGenerator(name="PacoteGen" , allocationSize=1)
public class Pacote implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "pct_id")
    @GeneratedValue(generator="PacoteGen", strategy=GenerationType.SEQUENCE)
    private Integer pctId;
    
    @Column(name = "pct_nome")
    private String pctNome;
    
    @ManyToMany
    @JoinTable(name="PACOTE_INSCRICAO",
            joinColumns=@JoinColumn(name="PCT_ID"),
            inverseJoinColumns=@JoinColumn(name="INC_ID")
    )
    private List<Inscricao> inscricoes;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="PACOTE_PROGRAMACAO",
             joinColumns=
                  @JoinColumn(name="PCT_ID"),
             inverseJoinColumns=
                  @JoinColumn(name="PRM_ID")
    )
    private List<Programacao> programacaoList = new ArrayList<Programacao>();

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="evt_id")
    private Evento evento;
    
    public Pacote() {
    }

    public Pacote(Integer pctId) {
        this.pctId = pctId;
    }

    public Integer getPctId() {
        return pctId;
    }

    public void setPctId(Integer pctId) {
        this.pctId = pctId;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getPctNome() {
        return pctNome;
    }

    public void setPctNome(String pctNome) {
        this.pctNome = pctNome;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    @XmlTransient
    public List<Programacao> getProgramacaoList() {
        return programacaoList;
    }

    public void setProgramacaoList(List<Programacao> programacaoList) {
        this.programacaoList = programacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pctId != null ? pctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacote)) {
            return false;
        }
        Pacote other = (Pacote) object;
        if ((this.pctId == null && other.pctId != null) || (this.pctId != null && !this.pctId.equals(other.pctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Pacote[ pctId=" + pctId + " ]";
    }
    
}
