package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.FormaPagamentoBC;
import br.com.syspartenon.partenon.domain.FormaPagamento;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ViewController
public class FormaPagamentoMB {
    
    @Inject
    private FormaPagamentoBC formaPagamentoBC;
    
    private FormaPagamento forma;
    
    @Inject
    private MessageContext messageContext;
    
    @PostConstruct
    public void init(){
        forma = new FormaPagamento();
    }

    public FormaPagamento getForma() {
        return forma;
    }

    public void setForma(FormaPagamento forma) {
        this.forma = forma;
    }
    
    public List<FormaPagamento> getList(){
        return formaPagamentoBC.findAll();
    }
    
    @Transactional
    public String salvar(){
        try {
            formaPagamentoBC.insert(forma);
            messageContext.add("Inserido com sucesso", SeverityType.INFO);
            return "forma_pagamento_listar.jsf";
        } catch (Exception e) {
            messageContext.add(e.getMessage(), SeverityType.ERROR);
        }
        return "forma_pagamento_form.jsf";
    }
    
}
