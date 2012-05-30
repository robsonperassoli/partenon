package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.EnderecoBC;
import br.com.syspartenon.partenon.domain.Endereco;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class EnderecoMB {
    @Inject
    private EnderecoBC business;
    
    private Endereco bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    private List<Endereco> getList(){
        return business.findAll();
    }
    
    public Endereco getBean() {
        if(this.bean == null) {
            this.bean = new Endereco();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Endereco bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getEndId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Endereco salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Endereco: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getEndId());
            messageContext.add("Endereco removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Endereco: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
