package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Unidade;
import br.com.syspartenon.partenon.persistence.UnidadeDAO;

@BusinessController
public class UnidadeBC extends DelegateCrud<Unidade, Integer, UnidadeDAO> {
    
}
