package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cidade")
@SequenceGenerator(name="CidadeGen" , allocationSize=1)
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cdd_id")
    @GeneratedValue(generator="CidadeGen", strategy= GenerationType.SEQUENCE)
    private Integer cddId;
    
    @Column(name = "cdd_nome")
    private String cddNome;
    
    @JoinColumn(name = "est_id", referencedColumnName = "est_id", nullable=false)
    @ManyToOne(optional = false)
    private Estado estado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidade")
    private List<Endereco> enderecoList;

    public Cidade() {
    }

    public Cidade(Integer cddId) {
        this.cddId = cddId;
    }

    public Integer getCddId() {
        return cddId;
    }

    public void setCddId(Integer cddId) {
        this.cddId = cddId;
    }

    public String getCddNome() {
        return cddNome;
    }

    public void setCddNome(String cddNome) {
        this.cddNome = cddNome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cddId != null ? cddId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.cddId == null && other.cddId != null) || (this.cddId != null && !this.cddId.equals(other.cddId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Cidade[ cddId=" + cddId + " ]";
    }
    
}
