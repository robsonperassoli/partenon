package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.EventoInsumoCategoriaBC;
import br.com.syspartenon.partenon.domain.EventoInsumoCategoria;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class EventoInsumoCategoriaMB {
    @Inject
    private EventoInsumoCategoriaBC business;
    
    private EventoInsumoCategoria bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    private List<EventoInsumoCategoria> getList(){
        return business.findAll();
    }
    
    public EventoInsumoCategoria getBean() {
        if(this.bean == null) {
            this.bean = new EventoInsumoCategoria();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(EventoInsumoCategoria bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getEicId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("EventoInsumoCategoria salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar EventoInsumoCategoria: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getEicId());
            messageContext.add("EventoInsumoCategoria removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover EventoInsumoCategoria: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
