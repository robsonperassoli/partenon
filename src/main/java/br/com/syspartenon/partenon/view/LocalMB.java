package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.EventoBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.LocalBC;
import br.com.syspartenon.partenon.domain.Evento;
import br.com.syspartenon.partenon.domain.Local;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class LocalMB {
    @Inject
    private EventoBC eventoBC;
    
    @Inject
    private LocalBC localBC;
    
    private Evento evento;
    
    private Local local;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Local> getList(){
        if(evento == null)
            evento = getEvento();
        return localBC.findAll(evento);
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

    public Local getLocal() {
        if(local == null){
            local = new Local();
            local.setEvento(evento);
        }
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(local.getLclId() != null) 
                localBC.update(local);
            else
                localBC.insert(local);
            messageContext.add("Local salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Local: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            localBC.delete(local.getLclId());
            messageContext.add("Local removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Local: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void novoLocal(){
        local = new Local();
        local.setEvento(getEvento());
    }
}
