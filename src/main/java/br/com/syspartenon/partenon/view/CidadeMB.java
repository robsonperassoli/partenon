package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.CidadeBC;
import br.com.syspartenon.partenon.domain.Cidade;
import br.com.syspartenon.partenon.util.JsfUtil;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class CidadeMB {
    @Inject
    private CidadeBC business;
    
    private Cidade bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Cidade> getList(){
        return business.findAll();
    }
    
    public Cidade getBean() {
        if(this.bean == null) {
            this.bean = new Cidade();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Cidade bean) {
        this.bean = bean;
    }
    
    @Transactional
    public String salvar(){
        try {
            if(bean.getCddId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Cidade salvo com sucesso.", SeverityType.INFO);
            return "/cidade_listar.jsf?faces-redirect=true";
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Cidade: " + e.getMessage(), SeverityType.ERROR);
            return "/cidade_adicionar.jsf?faces-redirect=true";
        }
    }
    
    @Transactional
    public String excluir(){
        try {
            business.delete(bean.getCddId());
            messageContext.add("Cidade removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Cidade: " + e.getMessage(), SeverityType.ERROR);
        }
        return "/cidade_listar.jsf?faces-redirect=true";
    }
    
    public void handleSelect(SelectEvent e){
        try {
            //new NavigationHandlerImpl().handleNavigation(FacesContext.getCurrentInstance(), null, null);
            JsfUtil.redirect("cidade_adicionar.jsf?faces-redirect=true&id=" + ((Cidade) e.getObject()).getCddId());
        } catch (Exception ex) {
            messageContext.add(ex.getMessage(), SeverityType.FATAL);
        }
    }
    
    public List<Cidade> filtrarPorNome(String nome){
        return business.filtrarPorNome(nome);
    }
    
}
