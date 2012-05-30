package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.InsumoBC;
import br.com.syspartenon.partenon.domain.Insumo;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class InsumoMB {
    @Inject
    private InsumoBC business;
    
    private Insumo bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    private List<Insumo> getList(){
        return business.findAll();
    }
    
    public Insumo getBean() {
        if(this.bean == null) {
            this.bean = new Insumo();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Insumo bean) {
        this.bean = bean;
    }
    
    @Transactional
    public String salvar(){
        try {
            if(bean.getInsId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Insumo salvo com sucesso.", SeverityType.INFO);
            return "/insumo_listar.jsf?faces-redirect=true";
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Insumo: " + e.getMessage(), SeverityType.ERROR);
            return "/insumo_listar.jsf?faces-redirect=true";
        }
    }
    
    @Transactional
    public String excluir(){
        try {
            business.delete(bean.getInsId());
            messageContext.add("Insumo removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Insumo: " + e.getMessage(), SeverityType.ERROR);
        }
        return "/insumo_listar.jsf?faces-redirect=true";
    }
    
    public String handleSelect(SelectEvent e){
        return "/insumo_adicionar.jsf?faces-redirect=true&id=" + ((Insumo) e.getObject()).getInsId();
    }
    
}
