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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "site")
@SequenceGenerator(name="SiteGen" , allocationSize=1)
public class Site implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "sit_id")
    @GeneratedValue(generator="SiteGen", strategy=GenerationType.SEQUENCE)
    private Integer sitId;
    
    @Column(name = "sit_mostrar_inscricao")
    private Boolean sitMostrarInscricao;
    
    @Column(name = "sit_mostrar_imoveis")
    private Boolean sitMostrarImoveis;
    
    @Column(name = "sit_slug_url")
    private String sitSlugUrl;
    
    @Column(name = "sit_email_contato")
    private String sitEmailContato;
    
    @Column(name = "sit_fone_contato")
    private String sitFoneContato;
    
    @Column(name = "sit_twt_consumer_key")
    private String sitTwtConsumerKey;
    
    @Column(name = "sit_twt_consumer_secret")
    private String sitTwtConsumerSecret;
    
    @Column(name = "sit_twt_access_token")
    private String sitTwtAccessToken;
    
    @Column(name = "sit_twt_access_token_secret")
    private String sitTwtAccessTokenSecret;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "site")
    private List<Noticia> noticiaList = new ArrayList<Noticia>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "site")
    private List<Pagina> paginaList = new ArrayList<Pagina>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "site")
    private List<Banner> bannerList = new ArrayList<Banner>();
    
    @JoinColumn(name = "evt_id", referencedColumnName = "evt_id")
    @OneToOne(optional = false)
    private Evento evento;

    public Site() {
    }

    public Site(Integer sitId) {
        this.sitId = sitId;
    }

    public Integer getSitId() {
        return sitId;
    }

    public void setSitId(Integer sitId) {
        this.sitId = sitId;
    }

    public Boolean getSitMostrarInscricao() {
        return sitMostrarInscricao;
    }

    public void setSitMostrarInscricao(Boolean sitMostrarInscricao) {
        this.sitMostrarInscricao = sitMostrarInscricao;
    }

    public Boolean getSitMostrarImoveis() {
        return sitMostrarImoveis;
    }

    public void setSitMostrarImoveis(Boolean sitMostrarImoveis) {
        this.sitMostrarImoveis = sitMostrarImoveis;
    }

    @XmlTransient
    public List<Noticia> getNoticiaList() {
        return noticiaList;
    }

    public void setNoticiaList(List<Noticia> noticiaList) {
        this.noticiaList = noticiaList;
    }

    @XmlTransient
    public List<Pagina> getPaginaList() {
        return paginaList;
    }

    public void setPaginaList(List<Pagina> paginaList) {
        this.paginaList = paginaList;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getSitSlugUrl() {
        return sitSlugUrl;
    }

    public void setSitSlugUrl(String sitSlugUrl) {
        this.sitSlugUrl = sitSlugUrl;
    }

    public String getSitTwtAccessToken() {
        return sitTwtAccessToken;
    }

    public void setSitTwtAccessToken(String sitTwtAccessToken) {
        this.sitTwtAccessToken = sitTwtAccessToken;
    }

    public String getSitTwtAccessTokenSecret() {
        return sitTwtAccessTokenSecret;
    }

    public void setSitTwtAccessTokenSecret(String sitTwtAccessTokenSecret) {
        this.sitTwtAccessTokenSecret = sitTwtAccessTokenSecret;
    }

    public String getSitTwtConsumerKey() {
        return sitTwtConsumerKey;
    }

    public void setSitTwtConsumerKey(String sitTwtConsumerKey) {
        this.sitTwtConsumerKey = sitTwtConsumerKey;
    }

    public String getSitTwtConsumerSecret() {
        return sitTwtConsumerSecret;
    }

    public void setSitTwtConsumerSecret(String sitTwtConsumerSecret) {
        this.sitTwtConsumerSecret = sitTwtConsumerSecret;
    }

    public String getSitEmailContato() {
        return sitEmailContato;
    }

    public void setSitEmailContato(String sitEmailContato) {
        this.sitEmailContato = sitEmailContato;
    }

    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    public String getSitFoneContato() {
        return sitFoneContato;
    }

    public void setSitFoneContato(String sitFoneContato) {
        this.sitFoneContato = sitFoneContato;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sitId != null ? sitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.sitId == null && other.sitId != null) || (this.sitId != null && !this.sitId.equals(other.sitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Site[ sitId=" + sitId + " ]";
    }
    
}
