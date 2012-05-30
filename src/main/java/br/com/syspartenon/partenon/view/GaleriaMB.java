package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.EventoBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.GaleriaBC;
import br.com.syspartenon.partenon.domain.Evento;
import br.com.syspartenon.partenon.domain.Galeria;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ViewController
public class GaleriaMB {
    @Inject
    private EventoBC eventoBC;
    
    @Inject
    private GaleriaBC galeriaBC;
    
    private Evento evento;
    
    private Galeria galeria;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Galeria> getList(){
        if(evento == null)
            evento = getEvento();
        return galeriaBC.findAll(evento.getSite());
    }

    public Evento getEvento() {
        if(this.evento == null) {
            this.evento = new Evento();
            if(this.id.getValue() != null) 
                this.evento = eventoBC.load(this.id.getValue());
        }
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Galeria getGaleria() {
        if(galeria == null){
            galeria = new Galeria();
            galeria.setSite(getEvento().getSite());
        }
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(galeria.getGalId() != null) 
                galeriaBC.update(galeria);
            else
                galeriaBC.insert(galeria);
            galeria = null;
            messageContext.add("Galeria salva com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Galeria: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(Galeria galeria){
        try {
            galeriaBC.delete(galeria.getGalId());
            messageContext.add("Galeria removida.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Galeria: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void adicionarFotos(Galeria galeria) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "evento_site_fotos.jsf?faces-redirect=true&id=" + galeria.getGalId());
    }
}

