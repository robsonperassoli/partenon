package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Operacao;
import br.com.syspartenon.partenon.persistence.OperacaoDAO;

@BusinessController
public class OperacaoBC extends DelegateCrud<Operacao, Integer, OperacaoDAO> {
    
}
