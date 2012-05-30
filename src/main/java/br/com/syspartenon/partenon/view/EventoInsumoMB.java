package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.EventoInsumoBC;
import br.com.syspartenon.partenon.domain.EventoInsumo;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class EventoInsumoMB {
    @Inject
    private EventoInsumoBC business;
    
    private EventoInsumo bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    private List<EventoInsumo> getList(){
        return business.findAll();
    }
    
    public EventoInsumo getBean() {
        if(this.bean == null) {
            this.bean = new EventoInsumo();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(EventoInsumo bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getEviId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("EventoInsumo salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar EventoInsumo: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getEviId());
            messageContext.add("EventoInsumo removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover EventoInsumo: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
