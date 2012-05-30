package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.EventoBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.MovimentacaoBC;
import br.com.syspartenon.partenon.domain.Evento;
import br.com.syspartenon.partenon.domain.Movimentacao;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class MovimentacaoMB {
    @Inject
    private EventoBC eventoBC;
    
    @Inject
    private MovimentacaoBC movimentacaoBC;
    
    private Evento evento;
    
    private Movimentacao movimentacao;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Movimentacao> getList(){
        if(evento == null)
            evento = getEvento();
        return movimentacaoBC.findAll(evento);
    }

    public Evento getEvento() {
        if(this.evento == null) {
            this.evento = new Evento();
            if(this.id.getValue() != null) 
                this.evento = eventoBC.load(this.id.getValue());
        }
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Movimentacao getMovimentacao() {
        if(movimentacao == null){
            movimentacao = new Movimentacao();
            movimentacao.setEvento(evento);
        }
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(movimentacao.getMvmId() != null) 
                movimentacaoBC.update(movimentacao);
            else
                movimentacaoBC.insert(movimentacao);
            messageContext.add("Movimentação salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Movimentação: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(Movimentacao movimentacao){
        try {
            movimentacaoBC.delete(movimentacao.getMvmId());
            messageContext.add("Movimentação removida.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Movimentação: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void novaMovimentacao(){
        movimentacao = new Movimentacao();
        movimentacao.setEvento(getEvento());
    }
    
    public double totalTipo(Character tipo) {
        double soma = 0.0;
        for (Movimentacao mov : movimentacaoBC.findAll(getEvento())) {
            if (mov.getMvmTipo().equals(tipo)) {
                soma += mov.getMvmValor().doubleValue();
            }
        }
        return soma;
    }

    public double getTotal() {
        double total = totalTipo('E') - totalTipo('S');
        return total;
    }

}
