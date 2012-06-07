package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.ConfiguracaoBC;
import br.com.syspartenon.partenon.domain.Configuracao;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class ConfiguracaoMB {
    @Inject
    private ConfiguracaoBC business;
    
    private Configuracao bean;
    
    @Inject
    private MessageContext messageContext;
    
    public List<Configuracao> getList(){
        return business.findAll();
    }
    
    public Configuracao getBean() {
        if(this.bean == null)
            this.bean = business.load(1);
        return bean;
    }

    public void setBean(Configuracao bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getConId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Configuracao salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Configuracao: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getConId());
            messageContext.add("Configuracao removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Configuracao: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
