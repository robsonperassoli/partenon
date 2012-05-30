package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.EnqueteBC;
import br.com.syspartenon.partenon.business.EntradaAgendaBC;
import br.com.syspartenon.partenon.business.GaleriaBC;
import br.com.syspartenon.partenon.business.ImovelBC;
import br.com.syspartenon.partenon.business.NoticiaBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.SiteBC;
import br.com.syspartenon.partenon.domain.Enquete;
import br.com.syspartenon.partenon.domain.EnqueteAlternativa;
import br.com.syspartenon.partenon.domain.EntradaAgenda;
import br.com.syspartenon.partenon.domain.Galeria;
import br.com.syspartenon.partenon.domain.Imovel;
import br.com.syspartenon.partenon.domain.Noticia;
import br.com.syspartenon.partenon.domain.Pagina;
import br.com.syspartenon.partenon.domain.Site;
import br.gov.frameworkdemoiselle.message.SeverityType;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class SiteMB {

    @Inject
    private SiteBC business;
    @Inject
    private ImovelBC imovelBC;
    @Inject
    private EntradaAgendaBC entradaAgendaBC;
    @Inject
    private NoticiaBC noticiaBC;
    @Inject
    private GaleriaBC galeriaBC;
    @Inject
    private EnqueteBC enqueteBC;
    private Site bean;
    @Inject
    private Parameter<String> slug;
    @Inject
    private Parameter<String> pagina;
    @Inject
    private MessageContext messageContext;
    @Inject
    private Parameter<Integer> imvId;
    @Inject
    private Parameter<Integer> galId;
    @Inject
    private Parameter<Integer> ntcId;
    @Inject
    private Parameter<Integer> page;
    @Inject
    private SessionSite sessionSite;
    private EnqueteAlternativa alternativaSelecionada;

    public Site getBean() {
        if (this.bean == null) {
            this.bean = new Site();
            if (this.slug.getValue() != null) {
                this.bean = business.load(this.slug.getValue());
            }
        }
        return bean;
    }

    public Pagina getPagina() {
        Pagina returnPage = null;
        for (Pagina p : bean.getPaginaList()) {
            if (p.getPgnTituloPagina().equals(this.pagina.getValue())) {
                returnPage = p;
                break;
            }
        }

        if (returnPage == null) {
            returnPage = new Pagina();
            returnPage.setPgnTituloMenu("Erro 404");
            returnPage.setPgnConteudo("A página que você está tentando acessar não existe.");
        }

        return returnPage;
    }

    public void setBean(Site bean) {
        this.bean = bean;
    }

    public Imovel getImovel() {
        return imovelBC.load(imvId.getValue());
    }

    public EnqueteAlternativa getAlternativaSelecionada() {
        return alternativaSelecionada;
    }

    public void setAlternativaSelecionada(EnqueteAlternativa alternativaSelecionada) {
        this.alternativaSelecionada = alternativaSelecionada;
    }

    public Noticia getNoticia() {
        return noticiaBC.load(ntcId.getValue());
    }

    public Galeria getGaleria() {
        return galeriaBC.load(galId.getValue());
    }

    public List<EntradaAgenda> getUltimosAgenda() {
        return entradaAgendaBC.findLast(getBean().getEvento(), 5);
    }

    public List<Noticia> getUltimasNoticias() {
        return noticiaBC.findLast(getBean().getEvento(), 5);
    }

    public List<Galeria> getGalerias() {
        return galeriaBC.findAll(getBean());
    }

    public List<Noticia> getPaginaNoticias() {
        return noticiaBC.findPage(getBean().getEvento(), page.getValue(), 10);
    }

    public boolean getMostrarPaginaAnterior() {
        return page.getValue() > 1;
    }

    public boolean getMostrarProximaPagina() {
        Long count = noticiaBC.count(getBean().getEvento());
        return (count / 10.0) > page.getValue();
    }

    public Integer getPage() {
        return page.getValue();
    }

    public boolean getExisteEnqueteAtiva() {
        return enqueteBC.existeEnqueteAtiva(getBean().getEvento());
    }

    public Enquete getEnqueteAtiva() {
        return enqueteBC.enqueteAtiva(getBean().getEvento());
    }

    public String votar() {
        try {
            if (alternativaSelecionada == null)
                throw new Exception("Selecione uma alternativa");
            
            enqueteBC.votar(alternativaSelecionada);
            sessionSite.setVotouEnquete(true);
            
            return "site_enquete_resultado.jsf";
        } catch (Exception e) {
            messageContext.add(e.getMessage(), SeverityType.INFO);
            return "site_inicial.jsf";
        }
    }
    
    public String getPartialEnquete(){
        if(sessionSite.isVotouEnquete())
            return "site_inicial_obrigado.xhtml";
        else
            return "site_inicial_enquete.xhtml";
    }
}
