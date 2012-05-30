package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.OperacaoBC;
import br.com.syspartenon.partenon.domain.Operacao;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class OperacaoMB {
    @Inject
    private OperacaoBC business;
    
    private Operacao bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Operacao> getList(){
        return business.findAll();
    }
    
    public Operacao getBean() {
        if(this.bean == null) {
            this.bean = new Operacao();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Operacao bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getOpeId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Operacao salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Operacao: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getOpeId());
            messageContext.add("Operacao removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Operacao: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public String handleSelect(SelectEvent e){
        return "/operacao_adicionar.jsf?faces-redirect=true&id=" + ((Operacao) e.getObject()).getOpeId();
    }
    
}
