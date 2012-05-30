package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.EventoBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.ImovelBC;
import br.com.syspartenon.partenon.domain.Endereco;
import br.com.syspartenon.partenon.domain.Evento;
import br.com.syspartenon.partenon.domain.Imovel;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ViewController
public class ImovelMB {
    @Inject
    private EventoBC eventoBC;
    
    @Inject
    private ImovelBC imovelBC;
    
    private Evento evento;
    
    private Imovel imovel;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Imovel> getList(){
        if(evento == null)
            evento = getEvento();
        return imovelBC.findAll(evento);
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

    public Imovel getImovel() {
        if(imovel == null){
            imovel = new Imovel();
            imovel.setEndereco(new Endereco());
            imovel.setEvento(getEvento());
        }
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(imovel.getImvId() != null) 
                imovelBC.update(imovel);
            else
                imovelBC.insert(imovel);
            imovel = null;
            messageContext.add("Imóvel salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Imóvel: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(Imovel imovel){
        try {
            imovelBC.delete(imovel.getImvId());
            messageContext.add("Imóvel removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Imóvel: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void adicionarComodos(Imovel imovel) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "evento_imoveis_comodos.jsf?faces-redirect=true&id=" + imovel.getImvId());
    }
}

