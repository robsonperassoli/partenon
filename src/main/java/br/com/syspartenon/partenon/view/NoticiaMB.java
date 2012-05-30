package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.SiteBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.NoticiaBC;
import br.com.syspartenon.partenon.domain.Site;
import br.com.syspartenon.partenon.domain.Noticia;
import br.com.syspartenon.partenon.util.TwitterUtil;
import java.util.List;
import javax.inject.Inject;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@ViewController
public class NoticiaMB {
    @Inject
    private SiteBC siteBC;
    
    @Inject
    private NoticiaBC noticiaBC;
    
    private Site site;
    
    private Noticia noticia;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    private Boolean shareOnTwitter = false;
    
    public List<Noticia> getList(){
        if(site == null)
            site = getSite();
        return noticiaBC.findAll(site);
    }

    public Site getSite() {
        if(this.site == null) {
            this.site = new Site();
            if(this.id.getValue() != null) 
                this.site = siteBC.load(this.id.getValue());
        }
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Noticia getNoticia() {
        if(noticia == null){
            noticia = new Noticia();
            noticia.setSite(site);
        }
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
    
    public Boolean getShareOnTwitter() {
        return shareOnTwitter;
    }

    public void setShareOnTwitter(Boolean shareOnTwitter) {
        this.shareOnTwitter = shareOnTwitter;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(noticia.getNtcId() != null) 
                noticiaBC.update(noticia);
            else
                noticiaBC.insert(noticia);
            
            if (shareOnTwitter == true) {
                try {
                    Twitter twitter = TwitterUtil.getTwitter(TwitterUtil.convert(getSite()));
                    twitter.updateStatus("Notícia Postada: '" + noticia.getNtcTitulo() + "'. Acesse o site e confira.");
                } catch (TwitterException ex) {
                    messageContext.add("Erro ao Enviar para Twitter.", SeverityType.WARN);
                }
                shareOnTwitter = false;
            }
            
            messageContext.add("Noticia salva com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Noticia: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(Noticia noticia){
        try {
            noticiaBC.delete(noticia.getNtcId());
            messageContext.add("Noticia removida.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Noticia: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void novaNoticia(){
        this.noticia = new Noticia();
        noticia.setSite(getSite());
    }
}
