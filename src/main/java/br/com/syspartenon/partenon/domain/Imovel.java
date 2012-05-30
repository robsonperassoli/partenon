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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "imovel")
@SequenceGenerator(name="ImovelGen" , allocationSize=1)
public class Imovel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "imv_id")
    @GeneratedValue(generator = "ImovelGen", strategy = GenerationType.SEQUENCE)
    private Integer imvId;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ent_id", nullable = false, updatable = false, insertable = true, referencedColumnName = "ent_id")
    private Entidade entidade;
    
    @OneToOne(optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "end_id", unique = true, nullable = false, updatable = false, insertable = true, referencedColumnName = "end_id")
    private Endereco endereco;
    
    @JoinColumn(name = "evt_id", referencedColumnName = "evt_id")
    @ManyToOne(optional = false)
    private Evento evento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imovel")
    private List<Comodo> comodoList = new ArrayList<Comodo>();

    public Imovel() {
    }

    public Imovel(Integer imvId) {
        this.imvId = imvId;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public Integer getImvId() {
        return imvId;
    }

    public void setImvId(Integer imvId) {
        this.imvId = imvId;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @XmlTransient
    public List<Comodo> getComodoList() {
        return comodoList;
    }

    public void setComodoList(List<Comodo> comodoList) {
        this.comodoList = comodoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imvId != null ? imvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imovel)) {
            return false;
        }
        Imovel other = (Imovel) object;
        if ((this.imvId == null && other.imvId != null) || (this.imvId != null && !this.imvId.equals(other.imvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Imovel[ imvId=" + imvId + " ]";
    }
}
