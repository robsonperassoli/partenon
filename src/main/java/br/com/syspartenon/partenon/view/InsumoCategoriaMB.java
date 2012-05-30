package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.InsumoCategoriaBC;
import br.com.syspartenon.partenon.domain.InsumoCategoria;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class InsumoCategoriaMB {

    @Inject
    private InsumoCategoriaBC business;
    private InsumoCategoria bean;
    @Inject
    private Parameter<Integer> id;
    @Inject
    private MessageContext messageContext;

    private List<InsumoCategoria> getList() {
        return business.findAll();
    }

    public InsumoCategoria getBean() {
        if (this.bean == null) {
            this.bean = new InsumoCategoria();
            if (this.id.getValue() != null) {
                this.bean = business.load(this.id.getValue());
            }
        }
        return bean;
    }

    public void setBean(InsumoCategoria bean) {
        this.bean = bean;
    }

    @Transactional
    public String salvar() {
        try {
            if (bean.getIctId() != null) {
                business.update(bean);
            } else {
                business.insert(bean);
            }
            messageContext.add("InsumoCategoria salvo com sucesso.", SeverityType.INFO);
            return "/insumo_categoria_listar.jsf?faces-redirect=true";
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Categoria de Insumo: " + e.getMessage(), SeverityType.ERROR);
            return "/insumo_categoria_listar.jsf?faces-redirect=true";
        }
    }

    @Transactional
    public String excluir() {
        try {
            business.delete(bean.getIctId());
            messageContext.add("Categoria de Insumo removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Categoria de Insumo: " + e.getMessage(), SeverityType.ERROR);
        }
        return "/insumo_categoria_listar.jsf?faces-redirect=true";
    }

    public String handleSelect(SelectEvent e) {
        return "/insumo_categoria_adicionar.jsf?faces-redirect=true&id=" + ((InsumoCategoria) e.getObject()).getIctId();
    }
}
