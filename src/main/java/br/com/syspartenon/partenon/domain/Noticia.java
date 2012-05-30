package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "noticia")
@SequenceGenerator(name="NoticiaGen" , allocationSize=1)
public class Noticia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ntc_id")
    @GeneratedValue(generator="NoticiaGen", strategy=GenerationType.SEQUENCE)
    private Integer ntcId;
    
    @Column(name = "ntc_titulo")
    private String ntcTitulo;
    
    @Column(name = "ntc_data")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ntcData = new Date();
    
    @Lob
    @Column(name = "ntc_conteudo")
    private String ntcConteudo;
    
    @JoinColumn(name = "sit_id", referencedColumnName = "sit_id")
    @ManyToOne(optional = false)
    private Site site;

    public Noticia() {
    }

    public Noticia(Integer ntcId) {
        this.ntcId = ntcId;
    }

    public Integer getNtcId() {
        return ntcId;
    }

    public void setNtcId(Integer ntcId) {
        this.ntcId = ntcId;
    }

    public String getNtcTitulo() {
        return ntcTitulo;
    }

    public void setNtcTitulo(String ntcTitulo) {
        this.ntcTitulo = ntcTitulo;
    }

    public String getNtcConteudo() {
        return ntcConteudo;
    }

    public void setNtcConteudo(String ntcConteudo) {
        this.ntcConteudo = ntcConteudo;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Date getNtcData() {
        return ntcData;
    }

    public void setNtcData(Date ntcData) {
        this.ntcData = ntcData;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ntcId != null ? ntcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.ntcId == null && other.ntcId != null) || (this.ntcId != null && !this.ntcId.equals(other.ntcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Noticia[ ntcId=" + ntcId + " ]";
    }
    
}
