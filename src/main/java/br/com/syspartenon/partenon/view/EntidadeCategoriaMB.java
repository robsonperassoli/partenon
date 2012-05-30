package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.EntidadeCategoriaBC;
import br.com.syspartenon.partenon.domain.EntidadeCategoria;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class EntidadeCategoriaMB {
    @Inject
    private EntidadeCategoriaBC business;
    
    private EntidadeCategoria bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<EntidadeCategoria> getList(){
        return business.findAll();
    }
    
    public EntidadeCategoria getBean() {
        if(this.bean == null) {
            this.bean = new EntidadeCategoria();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(EntidadeCategoria bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getEncId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("EntidadeCategoria salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar EntidadeCategoria: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getEncId());
            messageContext.add("EntidadeCategoria removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover EntidadeCategoria: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
