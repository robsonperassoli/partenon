package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "recurso")
@SequenceGenerator(name="RecursoGen" , allocationSize=1)
public class Recurso implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "rec_id")
    @GeneratedValue(generator="RecursoGen", strategy=GenerationType.SEQUENCE)
    private Integer recId;
    
    @Column(name = "rec_descricao")
    private String recDescricao;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="recurso", cascade= CascadeType.ALL)
    private List<Operacao> listOperacoes = new ArrayList<Operacao>();
    
    public Recurso() {
    }

    public Recurso(Integer recId) {
        this.recId = recId;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getRecDescricao() {
        return recDescricao;
    }

    public void setRecDescricao(String recDescricao) {
        this.recDescricao = recDescricao;
    }

    public List<Operacao> getListOperacoes() {
        return listOperacoes;
    }

    public void setListOperacoes(List<Operacao> listOperacoes) {
        this.listOperacoes = listOperacoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recId != null ? recId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.recId == null && other.recId != null) || (this.recId != null && !this.recId.equals(other.recId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Recurso[ recId=" + recId + " ]";
    }
    
}
