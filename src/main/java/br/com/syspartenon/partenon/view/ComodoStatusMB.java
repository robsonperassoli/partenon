package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.ComodoStatusBC;
import br.com.syspartenon.partenon.domain.ComodoStatus;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class ComodoStatusMB {

    @Inject
    private ComodoStatusBC business;
    private ComodoStatus bean;
    @Inject
    private Parameter<Integer> id;
    @Inject
    private MessageContext messageContext;

    public List<ComodoStatus> getList() {
        return business.findAll();
    }

    public ComodoStatus getBean() {
        if (this.bean == null) {
            this.bean = new ComodoStatus();
            if (this.id.getValue() != null) {
                this.bean = business.load(this.id.getValue());
            }
        }
        return bean;
    }

    public void setBean(ComodoStatus bean) {
        this.bean = bean;
    }

    @Transactional
    public String salvar() {
        try {
            if (bean.getCmsId() != null) {
                business.update(bean);
            } else {
                business.insert(bean);
            }
            messageContext.add("ImovelStatus salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar ImovelStatus: " + e.getMessage(), SeverityType.ERROR);
        }
        return "/comodo_status_listar.jsf?faces-redirect=true";
    }

    @Transactional
    public String excluir() {
        try {
            business.delete(bean.getCmsId());
            messageContext.add("ImovelStatus removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover ImovelStatus: " + e.getMessage(), SeverityType.ERROR);
        }
        return "/comodo_status_listar.jsf?faces-redirect=true";
    }

    public String handleSelect(SelectEvent e) {
        return "/comodo_status_adicionar.jsf?faces-redirect=true&id=" + ((ComodoStatus) e.getObject()).getCmsId();
    }
}
