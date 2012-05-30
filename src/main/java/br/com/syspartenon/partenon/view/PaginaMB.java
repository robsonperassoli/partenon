package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.SiteBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.PaginaBC;
import br.com.syspartenon.partenon.domain.Site;
import br.com.syspartenon.partenon.domain.Pagina;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class PaginaMB {
    @Inject
    private SiteBC siteBC;
    
    @Inject
    private PaginaBC paginaBC;
    
    private Site site;
    
    private Pagina pagina;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Pagina> getList(){
        if(site == null)
            site = getSite();
        return paginaBC.findAll(site);
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

    public Pagina getPagina() {
        if(pagina == null){
            pagina = new Pagina();
            pagina.setSite(site);
        }
        return pagina;
    }

    public void setPagina(Pagina pagina) {
        this.pagina = pagina;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(pagina.getPgnId() != null) 
                paginaBC.update(pagina);
            else
                paginaBC.insert(pagina);
            messageContext.add("Pagina salva com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Pagina: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(Pagina pagina){
        try {
            paginaBC.delete(pagina.getPgnId());
            messageContext.add("Pagina removida.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Pagina: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void novaPagina(){
        this.pagina = new Pagina();
        pagina.setSite(getSite());
    }
}
