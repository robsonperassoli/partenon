package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.PacoteBC;
import br.com.syspartenon.partenon.domain.Pacote;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class PacoteMB {
    @Inject
    private PacoteBC business;
    
    private Pacote bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    private List<Pacote> getList(){
        return business.findAll();
    }
    
    public Pacote getBean() {
        if(this.bean == null) {
            this.bean = new Pacote();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Pacote bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getPctId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Pacote salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Pacote: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getPctId());
            messageContext.add("Pacote removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Pacote: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
