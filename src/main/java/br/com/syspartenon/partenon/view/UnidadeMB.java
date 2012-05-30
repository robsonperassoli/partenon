package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.UnidadeBC;
import br.com.syspartenon.partenon.domain.Unidade;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class UnidadeMB {

    @Inject
    private UnidadeBC business;
    private Unidade bean;
    @Inject
    private Parameter<Integer> id;
    @Inject
    private MessageContext messageContext;

    private List<Unidade> getList() {
        return business.findAll();
    }

    public Unidade getBean() {
        if (this.bean == null) {
            this.bean = new Unidade();
            if (this.id.getValue() != null) {
                this.bean = business.load(this.id.getValue());
            }
        }
        return bean;
    }

    public void setBean(Unidade bean) {
        this.bean = bean;
    }

    @Transactional
    public String salvar() {
        try {
            if (bean.getUndId() != null) {
                business.update(bean);
            } else {
                business.insert(bean);
            }
            messageContext.add("Unidade salvo com sucesso.", SeverityType.INFO);
            return "/unidade_listar.jsf?faces-redirect=true";
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Unidade: " + e.getMessage(), SeverityType.ERROR);
            return "/unidade_listar.jsf?faces-redirect=true";
        }
    }

    @Transactional
    public String excluir() {
        try {
            business.delete(bean.getUndId());
            messageContext.add("Unidade removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Unidade: " + e.getMessage(), SeverityType.ERROR);
        }
        return "/unidade_listar.jsf?faces-redirect=true";
    }

    public String handleSelect(SelectEvent e) {
        return "/unidade_adicionar.jsf?faces-redirect=true&id=" + ((Unidade) e.getObject()).getUndId();
    }
}
