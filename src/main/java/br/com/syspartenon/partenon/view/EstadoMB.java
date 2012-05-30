package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.EstadoBC;
import br.com.syspartenon.partenon.domain.Estado;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class EstadoMB {
    @Inject
    private EstadoBC business;
    
    private Estado bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    private List<Estado> getList(){
        return business.findAll();
    }
    
    public Estado getBean() {
        if(this.bean == null) {
            this.bean = new Estado();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Estado bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getEstId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Estado salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Estado: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getEstId());
            messageContext.add("Estado removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Estado: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
