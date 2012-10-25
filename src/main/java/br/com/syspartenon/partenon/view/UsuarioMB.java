package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.UsuarioBC;
import br.com.syspartenon.partenon.domain.Usuario;
import br.com.syspartenon.partenon.util.JsfUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class UsuarioMB {
    @Inject
    private UsuarioBC business;
    
    private Usuario bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Usuario> getList(){
        return business.findAll();
    }
    
    public Usuario getBean() {
        if(this.bean == null) {
            this.bean = new Usuario();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Usuario bean) {
        this.bean = bean;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getUsuId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Usuario salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Usuario: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getUsuId());
            messageContext.add("Usuario removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Usuario: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void handleSelect(SelectEvent e){
        try {
            JsfUtil.redirect("usuario_adicionar.jsf?faces-redirect=true&id=" + ((Usuario) e.getObject()).getUsuId());
        } catch (Exception ex) {
            messageContext.add(ex.getMessage(), SeverityType.FATAL);
        }
    }
    
}
