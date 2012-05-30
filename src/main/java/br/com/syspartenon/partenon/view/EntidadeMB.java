package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.EntidadeBC;
import br.com.syspartenon.partenon.domain.Endereco;
import br.com.syspartenon.partenon.domain.Entidade;
import br.com.syspartenon.partenon.domain.EntidadeCategoria;
import br.com.syspartenon.partenon.domain.Usuario;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class EntidadeMB {

    @Inject
    private EntidadeBC business;
    private Entidade bean;
    private EntidadeCategoria novaEntidadeCategoria;
    @Inject
    private Parameter<Integer> id;
    @Inject
    private MessageContext messageContext;

    public List<Entidade> getList() {
        return business.findAll();
    }

    public Entidade getBean() {
        if (this.bean == null) {
            this.bean = new Entidade();
            this.bean.setEndereco(new Endereco());
            this.bean.setUsuario(new Usuario());
            if (this.id.getValue() != null) {
                this.bean = business.load(this.id.getValue());
            }
        }
        return bean;
    }

    public void setBean(Entidade bean) {
        this.bean = bean;
    }

    public EntidadeCategoria getNovaEntidadeCategoria() {
        if (novaEntidadeCategoria == null) {
            novaEntidadeCategoria = new EntidadeCategoria();
        }
        return novaEntidadeCategoria;
    }

    public void setNovaEntidadeCategoria(EntidadeCategoria novaEntidadeCategoria) {
        this.novaEntidadeCategoria = novaEntidadeCategoria;
    }

    @Transactional
    public void salvar() {
        try {
            if (bean.getEntId() != null) {
                business.update(bean);
            } else {
                List l = bean.getEntidadeCategoriaList();
                bean.setEntidadeCategoriaList(null);
                business.insert(bean);
                if(l.size() > 0){
                    bean.setEntidadeCategoriaList(l);
                    business.update(bean);
                }
                
            }
            messageContext.add("Entidade salva com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Entidade: " + e.getMessage(), SeverityType.ERROR);
        }
    }

    @Transactional
    public void excluir(Entidade ent) {
        try {
            business.delete(ent.getEntId());
            messageContext.add("Entidade removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Entidade: " + e.getMessage(), SeverityType.ERROR);
        }
    }

    public String handleSelect(SelectEvent e) {
        return "/entidade_dados_gerais.jsf?faces-redirect=true&id=" + ((Entidade) e.getObject()).getEntId();
    }

    public void adicionaCategoria() {
        try {
            this.bean.getEntidadeCategoriaList().add(novaEntidadeCategoria);
            novaEntidadeCategoria = null;
        } catch (Exception e) {
            messageContext.add("Erro ao relacionar Categoria.", SeverityType.ERROR);
        }
    }
}
