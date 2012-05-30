package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Entidade;
import br.com.syspartenon.partenon.persistence.EntidadeDAO;

@BusinessController
public class EntidadeBC extends DelegateCrud<Entidade, Integer, EntidadeDAO> {
    
}
