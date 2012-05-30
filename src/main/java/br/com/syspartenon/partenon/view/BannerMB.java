package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.BannerBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.SiteBC;
import br.com.syspartenon.partenon.domain.Banner;
import br.com.syspartenon.partenon.domain.Site;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;

@ViewController
public class BannerMB {
    @Inject
    private BannerBC bannerBC;
    
    @Inject
    private SiteBC siteBC;
    
    private Banner banner;
    
    private Site site;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Banner> getList(){
        if(site == null)
            site = getSite();
        return bannerBC.findAll(site);
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

    public Banner getBanner() {
        if(banner == null){
            banner = new Banner();
            banner.setSite(getSite());
        }
        return banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(banner.getBanId() != null) 
                bannerBC.update(banner);
            else
                bannerBC.insert(banner);
            banner = null;
            messageContext.add("Banner salva com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Banner: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(Banner banner){
        try {
            bannerBC.delete(banner.getBanId());
            messageContext.add("Banner removida.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Banner: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void visualizarSite() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "evento_site_banners.jsf?faces-redirect=true&id=" + site.getSitId());
    }
    
    public void handleUpload(FileUploadEvent event) {
        banner = new Banner();
        banner.setBanDescricao("");
        banner.setSite(site);
        bannerBC.insert(banner, event.getFile().getContents(), event.getFile().getFileName());
    }
    
}

