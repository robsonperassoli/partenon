package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.EntradaAgendaBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.EventoBC;
import br.com.syspartenon.partenon.domain.EntradaAgenda;
import br.com.syspartenon.partenon.domain.Evento;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;

@ViewController
public class EntradaAgendaMB {
    @Inject
    private EntradaAgendaBC entradaAgendaBC;
    
    @Inject
    private EventoBC eventoBC;
    
    private EntradaAgenda entradaAgenda;
    
    private Evento evento;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<EntradaAgenda> getList(){
        if(evento == null)
            evento = getEvento();
        return entradaAgendaBC.findAll(evento);
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

    public EntradaAgenda getEntradaAgenda() {
        if(entradaAgenda == null){
            entradaAgenda = new EntradaAgenda();
            entradaAgenda.setEvento(getEvento());
        }
        return entradaAgenda;
    }

    public void setEntradaAgenda(EntradaAgenda entradaAgenda) {
        this.entradaAgenda = entradaAgenda;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(entradaAgenda.getEagId() != null) 
                entradaAgendaBC.update(entradaAgenda);
            else
                entradaAgendaBC.insert(entradaAgenda);
            entradaAgenda = null;
            messageContext.add("Entrada salva com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Entrada: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(EntradaAgenda entradaAgenda){
        try {
            entradaAgendaBC.delete(entradaAgenda.getEagId());
            messageContext.add("Entrada removida.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Entrada: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void visualizarEvento() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "evento_agenda.jsf?faces-redirect=true&id=" + evento.getEvtId());
    }
    
}

