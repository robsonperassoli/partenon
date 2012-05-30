package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.ImagemBC;
import br.com.syspartenon.partenon.domain.Imagem;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class ImagemMB {
    @Inject
    private ImagemBC business;
    
    private Imagem bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    private List<Imagem> getList(){
        return business.findAll();
    }
    
    public Imagem getBean() {
        if(this.bean == null) {
            this.bean = new Imagem();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Imagem bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getImgId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Imagem salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Imagem: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getImgId());
            messageContext.add("Imagem removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Imagem: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
