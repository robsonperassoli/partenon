package br.com.syspartenon.partenon.business;

import br.com.syspartenon.partenon.domain.FormaPagamento;
import br.com.syspartenon.partenon.persistence.FormaPagamentoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class FormaPagamentoBC extends DelegateCrud<FormaPagamento, Integer, FormaPagamentoDAO> {
    
}
