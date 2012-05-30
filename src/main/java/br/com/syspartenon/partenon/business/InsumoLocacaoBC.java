package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.InsumoLocacao;
import br.com.syspartenon.partenon.persistence.InsumoLocacaoDAO;

@BusinessController
public class InsumoLocacaoBC extends DelegateCrud<InsumoLocacao, Integer, InsumoLocacaoDAO> {
    
}
