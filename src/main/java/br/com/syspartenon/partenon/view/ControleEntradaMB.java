package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.ControleEntradaBC;
import br.com.syspartenon.partenon.domain.ControleEntrada;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class ControleEntradaMB {
    @Inject
    private ControleEntradaBC business;
    
    private ControleEntrada bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    private List<ControleEntrada> getList(){
        return business.findAll();
    }
    
    public ControleEntrada getBean() {
        if(this.bean == null) {
            this.bean = new ControleEntrada();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(ControleEntrada bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getCteId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("ControleEntrada salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar ControleEntrada: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getCteId());
            messageContext.add("ControleEntrada removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover ControleEntrada: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
