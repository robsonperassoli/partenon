package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "insumo")
@SequenceGenerator(name="InsumoGen" , allocationSize=1)
public class Insumo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ins_id")
    @GeneratedValue(generator="InsumoGen", strategy= GenerationType.SEQUENCE)
    private Integer insId;
    
    @Column(name = "ins_descricao")
    private String insDescricao;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ins_quantidade")
    private BigDecimal insQuantidade;
    
    @Column(name = "ins_valor")
    private BigDecimal insValor;
    
    @Column(name = "ins_negociavel")
    private Boolean insNegociavel;
    
    @Lob
    @Column(name = "ins_img")
    private byte[] insImg;
    
    @Column(name = "ins_movel")
    private Boolean insMovel;
    
    @JoinColumn(name = "und_id", referencedColumnName = "und_id")
    @ManyToOne(optional = false)
    private Unidade unidade;
    
    @JoinColumn(name = "ict_id", referencedColumnName = "ict_id")
    @ManyToOne(optional = false)
    private InsumoCategoria insumoCategoria;
    
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne(optional = false)
    private Entidade entidade;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumo")
    private List<EventoInsumo> eventoInsumoList;

    public Insumo() {
    }

    public Insumo(Integer insId) {
        this.insId = insId;
    }

    public Integer getInsId() {
        return insId;
    }

    public void setInsId(Integer insId) {
        this.insId = insId;
    }

    public String getInsDescricao() {
        return insDescricao;
    }

    public void setInsDescricao(String insDescricao) {
        this.insDescricao = insDescricao;
    }

    public BigDecimal getInsQuantidade() {
        return insQuantidade;
    }

    public void setInsQuantidade(BigDecimal insQuantidade) {
        this.insQuantidade = insQuantidade;
    }

    public BigDecimal getInsValor() {
        return insValor;
    }

    public void setInsValor(BigDecimal insValor) {
        this.insValor = insValor;
    }

    public Boolean getInsNegociavel() {
        return insNegociavel;
    }

    public void setInsNegociavel(Boolean insNegociavel) {
        this.insNegociavel = insNegociavel;
    }

    public byte[] getInsImg() {
        return insImg;
    }

    public void setInsImg(byte[] insImg) {
        this.insImg = insImg;
    }

    public Boolean getInsMovel() {
        return insMovel;
    }

    public void setInsMovel(Boolean insMovel) {
        this.insMovel = insMovel;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public InsumoCategoria getInsumoCategoria() {
        return insumoCategoria;
    }

    public void setInsumoCategoria(InsumoCategoria insumoCategoria) {
        this.insumoCategoria = insumoCategoria;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    @XmlTransient
    public List<EventoInsumo> getEventoInsumoList() {
        return eventoInsumoList;
    }

    public void setEventoInsumoList(List<EventoInsumo> eventoInsumoList) {
        this.eventoInsumoList = eventoInsumoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insId != null ? insId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.insId == null && other.insId != null) || (this.insId != null && !this.insId.equals(other.insId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Insumo[ insId=" + insId + " ]";
    }
    
}
