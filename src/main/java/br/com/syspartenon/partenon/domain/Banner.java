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
@Table(name = "banner")
@SequenceGenerator(name="BannerGen", allocationSize=1)
public class Banner implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ban_id")
    @GeneratedValue(generator="BannerGen",strategy= GenerationType.SEQUENCE)
    private Integer banId;
    
    @Column(name = "ban_nome")
    private String banNome;
    
    @Column(name = "ban_descricao")
    private String banDescricao;
    
    @JoinColumn(name = "sit_id", referencedColumnName = "sit_id")
    @ManyToOne(optional = false)
    private Site site;
    
    public Banner() {
    }

    public String getBanDescricao() {
        return banDescricao;
    }

    public void setBanDescricao(String banDescricao) {
        this.banDescricao = banDescricao;
    }

    public Integer getBanId() {
        return banId;
    }

    public void setBanId(Integer banId) {
        this.banId = banId;
    }

    public String getBanNome() {
        return banNome;
    }

    public void setBanNome(String banNome) {
        this.banNome = banNome;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banId != null ? banId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banner)) {
            return false;
        }
        Banner other = (Banner) object;
        if ((this.banId == null && other.banId != null) || (this.banId != null && !this.banId.equals(other.banId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Banner[ banId=" + banId + " ]";
    }
    
}
