package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.OperacaoBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.UsuarioGrupoBC;
import br.com.syspartenon.partenon.domain.Operacao;
import br.com.syspartenon.partenon.domain.UsuarioGrupo;
import br.com.syspartenon.partenon.util.JsfUtil;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class UsuarioGrupoMB {
    @Inject
    private UsuarioGrupoBC business;
    
    @Inject
    private OperacaoBC operacaoBC;
    
    private UsuarioGrupo bean;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<UsuarioGrupo> getList(){
        return business.findAll();
    }
    
    public UsuarioGrupo getBean() {
        if(this.bean == null) {
            this.bean = new UsuarioGrupo();
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(UsuarioGrupo bean) {
        this.bean = bean;
    }

    @Transactional
    public void salvar(){
        try {
            if(bean.getUsgId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("UsuarioGrupo salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar UsuarioGrupo: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            business.delete(bean.getUsgId());
            messageContext.add("UsuarioGrupo removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover UsuarioGrupo: " + e.getMessage(), SeverityType.ERROR);
        }
    }
 
    public void adicionaOperacao(SelectEvent e){
        Operacao operacaoParaAdicionar = (Operacao) e.getObject();
        boolean existe = false;
        for(Operacao operacao : bean.getListOperacoes()) {
            if(operacaoParaAdicionar.getOpeId().equals(operacao.getOpeId())) {
                existe = true;
                break;
            }
        }
        
        if(!existe) {
            operacaoParaAdicionar.getUsuarioGrupos().add(bean);
//            operacaoBC.update(operacaoParaAdicionar);
            bean.getListOperacoes().add(operacaoParaAdicionar);
            business.update(bean);
        } else
            messageContext.add("Operação já foi adicionada ao Grupo.", SeverityType.WARN);
    }
    
    public void handleSelect(SelectEvent e){
        try {
            JsfUtil.redirect("usuario_grupo_adicionar.jsf?faces-redirect=true&id=" + ((UsuarioGrupo) e.getObject()).getUsgId());
        } catch (Exception ex) {
            messageContext.add(ex.getMessage(), SeverityType.FATAL);
        }
    }
    
}
