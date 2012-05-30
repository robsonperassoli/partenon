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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "local")
@SequenceGenerator(name="LocalGen" , allocationSize=1)
public class Local implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "lcl_id")
    @GeneratedValue(generator="LocalGen", strategy=GenerationType.SEQUENCE)
    private Integer lclId;
    
    @Column(name = "lcl_descricao")
    private String lclDescricao;
    
    @Lob
    @Column(name = "lcl_img")
    private byte[] lclImg;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
    private List<InsumoLocacao> insumoLocacaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
    private List<LocalProgramacao> localProgramacaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lclPai")
    private List<Local> localList;
    
    @JoinColumn(name = "lcl_pai", referencedColumnName = "lcl_id", nullable=true)
    @ManyToOne(optional=true)
    private Local lclPai;
    
    @ManyToOne
    @JoinColumn(name="evt_id")
    private Evento evento;
    
    @OneToOne(optional=false, cascade={CascadeType.ALL})
    @JoinColumn(name="end_id", unique=true, nullable=false, updatable=false, insertable=true, referencedColumnName = "end_id")
    private Endereco endereco = new Endereco() ;
    
    public Local() {
    }

    public Local(Integer lclId) {
        this.lclId = lclId;
    }

    public Integer getLclId() {
        return lclId;
    }

    public void setLclId(Integer lclId) {
        this.lclId = lclId;
    }

    public String getLclDescricao() {
        return lclDescricao;
    }

    public void setLclDescricao(String lclDescricao) {
        this.lclDescricao = lclDescricao;
    }

    public byte[] getLclImg() {
        return lclImg;
    }

    public void setLclImg(byte[] lclImg) {
        this.lclImg = lclImg;
    }

    @XmlTransient
    public List<InsumoLocacao> getInsumoLocacaoList() {
        return insumoLocacaoList;
    }

    public void setInsumoLocacaoList(List<InsumoLocacao> insumoLocacaoList) {
        this.insumoLocacaoList = insumoLocacaoList;
    }

    @XmlTransient
    public List<LocalProgramacao> getLocalProgramacaoList() {
        return localProgramacaoList;
    }

    public void setLocalProgramacaoList(List<LocalProgramacao> localProgramacaoList) {
        this.localProgramacaoList = localProgramacaoList;
    }

    @XmlTransient
    public List<Local> getLocalList() {
        return localList;
    }

    public void setLocalList(List<Local> localList) {
        this.localList = localList;
    }

    public Local getLclPai() {
        return lclPai;
    }

    public void setLclPai(Local lclPai) {
        this.lclPai = lclPai;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lclId != null ? lclId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.lclId == null && other.lclId != null) || (this.lclId != null && !this.lclId.equals(other.lclId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Local[ lclId=" + lclId + " ]";
    }
    
}
