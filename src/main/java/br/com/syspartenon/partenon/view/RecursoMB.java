package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.RecursoBC;
import br.com.syspartenon.partenon.domain.Operacao;
import br.com.syspartenon.partenon.domain.Recurso;
import br.com.syspartenon.partenon.util.JsfUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class RecursoMB {
    @Inject
    private RecursoBC business;
    
    private Recurso bean;

    private Operacao operacao;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Recurso> getList(){
        return business.findAll();
    }
    
    public Recurso getBean() {
        if(this.bean == null) {
            this.bean = new Recurso();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Recurso bean) {
        this.bean = bean;
    }

    public Operacao getOperacao() {
        if(operacao == null)
            operacao = new Operacao();
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }
    
    
    
    @Transactional
    public void salvar(){
        try {
            if(bean.getRecId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Recurso salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Recurso: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getRecId());
            messageContext.add("Recurso removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Recurso: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void adicionarOperacao(){
        try {
            if(operacao.getOpeDescricao().equals(""))
                throw new Exception("A Operação não pode estar em branco.");
            
            operacao.setRecurso(bean);
            bean.getListOperacoes().add(operacao);
            operacao = new Operacao();
        } catch (Exception e) {
            messageContext.add(e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void handleSelect(SelectEvent e){
        try {
            JsfUtil.redirect("recurso_adicionar.jsf?faces-redirect=true&id=" + ((Recurso) e.getObject()).getRecId());
        } catch (Exception ex) {
            messageContext.add(ex.getMessage(), SeverityType.FATAL);
        }
    }
    
}
