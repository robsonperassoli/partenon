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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "comodo")
@SequenceGenerator(name="ComodoGen" , allocationSize=1)
public class Comodo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "cmd_id")
    @GeneratedValue(generator = "ComodoGen", strategy = GenerationType.SEQUENCE)
    private Integer cmdId;
    
    @Column(name = "cmd_descricao")
    private String cmdDescricao;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cmd_dimensao")
    private BigDecimal cmdDimensao;
    
    @JoinColumn(name = "imv_id", referencedColumnName = "imv_id")
    @ManyToOne(optional = false)
    private Imovel imovel;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comodo")
    private List<Imagem> imagemList;

    @JoinColumn(name = "cms_id", referencedColumnName = "cms_id")
    @ManyToOne(optional = false)
    private ComodoStatus comodoStatus;
    
    public Comodo() {
    }

    public Comodo(Integer cmdId) {
        this.cmdId = cmdId;
    }

    public Integer getCmdId() {
        return cmdId;
    }

    public void setCmdId(Integer cmdId) {
        this.cmdId = cmdId;
    }

    public BigDecimal getCmdDimensao() {
        return cmdDimensao;
    }

    public void setCmdDimensao(BigDecimal cmdDimensao) {
        this.cmdDimensao = cmdDimensao;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    @XmlTransient
    public List<Imagem> getImagemList() {
        return imagemList;
    }

    public void setImagemList(List<Imagem> imagemList) {
        this.imagemList = imagemList;
    }

    public ComodoStatus getComodoStatus() {
        return comodoStatus;
    }

    public void setComodoStatus(ComodoStatus comodoStatus) {
        this.comodoStatus = comodoStatus;
    }

    public String getCmdDescricao() {
        return cmdDescricao;
    }

    public void setCmdDescricao(String cmdDescricao) {
        this.cmdDescricao = cmdDescricao;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmdId != null ? cmdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comodo)) {
            return false;
        }
        Comodo other = (Comodo) object;
        if ((this.cmdId == null && other.cmdId != null) || (this.cmdId != null && !this.cmdId.equals(other.cmdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Comodo[ cmdId=" + cmdId + " ]";
    }
    
}
