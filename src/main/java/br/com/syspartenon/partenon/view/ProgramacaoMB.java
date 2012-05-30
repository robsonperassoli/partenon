package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.ProgramacaoBC;
import br.com.syspartenon.partenon.domain.Programacao;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class ProgramacaoMB {
    @Inject
    private ProgramacaoBC business;
    
    private Programacao bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Programacao> getList(){
        return business.findAll();
    }
    
    public Programacao getBean() {
        if(this.bean == null) {
            this.bean = new Programacao();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Programacao bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getPrmId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Programacao salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Programacao: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getPrmId());
            messageContext.add("Programacao removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Programacao: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
