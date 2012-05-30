package br.com.syspartenon.partenon.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.EventoBC;
import br.com.syspartenon.partenon.business.ProgramacaoBC;
import br.com.syspartenon.partenon.domain.Cidade;
import br.com.syspartenon.partenon.domain.Endereco;
import br.com.syspartenon.partenon.domain.Evento;
import br.com.syspartenon.partenon.domain.Local;
import br.com.syspartenon.partenon.domain.LocalProgramacao;
import br.com.syspartenon.partenon.domain.Movimentacao;
import br.com.syspartenon.partenon.domain.Noticia;
import br.com.syspartenon.partenon.domain.Pacote;
import br.com.syspartenon.partenon.domain.Pagina;
import br.com.syspartenon.partenon.domain.Programa;
import br.com.syspartenon.partenon.domain.Programacao;
import br.com.syspartenon.partenon.domain.Site;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class EventoMB {
    
    @Inject
    private ProgramacaoBC programacaoBC;
    
    private Evento bean;
    private Local novoLocal;
    private Local novoLocalProgramacao;
    private Programacao novaProgramacao;
    private Programa novoPrograma;
    private Pacote novoPacote;
    private Pagina novaPagina;
    private Noticia novaNoticia;
    private Movimentacao novaMovimentacao;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    @Inject
    private EventoBC business;
    
    public List<Evento> getList(){
        return business.findAll();
    }
    
    public Evento getBean() {
        if(this.bean == null) {
            this.bean = new Evento();
            this.bean.setLocal(new Local());
            this.bean.getLocal().setEndereco(new Endereco());
            this.bean.getLocal().getEndereco().setCidade(new Cidade());
            this.bean.setSite(new Site());
            this.bean.getSite().setEvento(bean);
            if(this.id.getValue() != null) 
                this.bean = business.load(this.id.getValue());
        }
        return bean;
    }

    public void setBean(Evento bean) {
        this.bean = bean;
    }

    public Local getNovoLocal() {
        if(novoLocal == null){
            novoLocal = new Local();
            novoLocal.setEndereco(new Endereco());
            novoLocal.getEndereco().setLocal(novoLocal);
        }
        return novoLocal;
    }

    public void setNovoLocal(Local novoLocal) {
        this.novoLocal = novoLocal;
    }

    public Programacao getNovaProgramacao() {
        if(novaProgramacao == null)
            novaProgramacao = new Programacao();
        return novaProgramacao;
    }

    public void setNovaProgramacao(Programacao novaProgramacao) {
        this.novaProgramacao = novaProgramacao;
    }
    
    public Movimentacao getNovaMovimentacao() {
        if(novaMovimentacao == null)
            novaMovimentacao = new Movimentacao();
        return novaMovimentacao;
    }

    public void setNovaMovimentacao(Movimentacao novaMovimentacao) {
        this.novaMovimentacao = novaMovimentacao;
    }

    public Programa getNovoPrograma() {
        if(novoPrograma == null)
            novoPrograma = new Programa();
        return novoPrograma;
    }

    public void setNovoPrograma(Programa novoPrograma) {
        this.novoPrograma = novoPrograma;
    }

    public Local getNovoLocalProgramacao() {
        if(novoLocalProgramacao == null)
            novoLocalProgramacao = new Local();
        return novoLocalProgramacao;
    }

    public void setNovoLocalProgramacao(Local novoLocalProgramacao) {
        this.novoLocalProgramacao = novoLocalProgramacao;
    }

    public Pacote getNovoPacote() {
        if(novoPacote == null)
            novoPacote = new Pacote();
        return novoPacote;
    }

    public void setNovoPacote(Pacote novoPacote) {
        this.novoPacote = novoPacote;
    }
    
    public Pagina getNovaPagina() {
        if(novaPagina == null)
            novaPagina = new Pagina();
        return novaPagina;
    }
    
    public void setNovaPagina(Pagina novaPagina) {
        this.novaPagina = novaPagina;
    }

    public Noticia getNovaNoticia() {
        if(this.novaNoticia == null)
            this.novaNoticia = new Noticia();
        return this.novaNoticia;
    }

    public void setNovaNoticia(Noticia novaNoticia) {
        this.novaNoticia = novaNoticia;
    }

    
        
    @Transactional
    public void salvar(){
        try {
            if(bean.getEvtId() != null) 
                business.update(bean);
            else
                business.insert(bean);
            messageContext.add("Evento salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Evento: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(Evento evento){
        try {
            business.delete(evento.getEvtId());
            messageContext.add("Evento removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Evento: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public String handleSelect(SelectEvent e){
        return "/evento_dados_gerais.jsf?faces-redirect=true&id=" + ((Evento) e.getObject()).getEvtId();
    }
    
    @Transactional
    public void salvarLocal(){
        novoLocal.setEvento(bean);
        this.bean.getLocalList().add(novoLocal);
        this.business.update(bean);
        novoLocal = null;
    }
    
    @Transactional
    public void adicionarProgramacao(){
        List<LocalProgramacao> listLocalProgramacao = novaProgramacao.getLocalProgramacaoList();
        novaProgramacao.setLocalProgramacaoList(null);
        programacaoBC.insert(novaProgramacao);
        
        for(LocalProgramacao localProgramacao : listLocalProgramacao){
            localProgramacao.getLocalProgramacaoPK().setLclId(localProgramacao.getLocal().getLclId());
            localProgramacao.getLocalProgramacaoPK().setPrmId(localProgramacao.getProgramacao().getPrmId());
        }
        novaProgramacao.setEvento(bean);
        this.bean.getProgramacaoList().add(novaProgramacao);
        this.business.update(bean);
        novaProgramacao = null;
    }
    
    public void adicionarProgramaParaProgramacao(){
        novoPrograma.setProgramacao(novaProgramacao);
        novaProgramacao.getProgramaList().add(novoPrograma);
        novoPrograma = null;
    }
    
    public void adicionarLocalParaProgramacao(){
        LocalProgramacao localProgramacao = new LocalProgramacao();
        localProgramacao.setLocal(novoLocalProgramacao);
        localProgramacao.setProgramacao(novaProgramacao);
        novaProgramacao.getLocalProgramacaoList().add(localProgramacao);
        novoLocalProgramacao = null;
    }
    
    public void adicionarProgramacaoParaPacote(){
        novaProgramacao.getPacoteList().add(novoPacote);
        novoPacote.getProgramacaoList().add(novaProgramacao);
    }
    
    public void adicionarPacote(){
        novoPacote.setEvento(bean);
        bean.getPacoteList().add(novoPacote);
        business.update(bean);
        novoPacote = null;
        novaProgramacao = null;
    }
    
    @Transactional
    public void removerLocal(Local local){
        try{
            bean.getLocalList().remove(local);
            this.business.update(bean);
            messageContext.add("Local Removido do evento.", SeverityType.INFO);
        }catch(Exception e){
            messageContext.add("Erro ao Remover Local: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void removerProgramacao(Programacao programacao){
        try{
            bean.getProgramacaoList().remove(programacao);
            this.business.update(bean);
            messageContext.add("Programação Removida do evento.", SeverityType.INFO);
        }catch(Exception e){
            messageContext.add("Erro ao Remover Programação: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void removerPacote(Pacote pacote){
        try{
            bean.getPacoteList().remove(pacote);
            this.business.update(bean);
            messageContext.add("Pacote Removido do evento.", SeverityType.INFO);
        }catch(Exception e){
            messageContext.add("Erro ao Remover Pacote: " + e.getMessage(), SeverityType.ERROR);
        }
    }

    @Transactional
    public void salvarPagina() {
        novaPagina.setSite(bean.getSite());
        if(bean.getSite().getPaginaList().contains(novaPagina))
            bean.getSite().getPaginaList().remove(novaPagina);
        bean.getSite().getPaginaList().add(novaPagina);
        this.business.update(bean);
        novaPagina = null;
    }   
    
}
