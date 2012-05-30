package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Cidade;
import br.com.syspartenon.partenon.persistence.CidadeDAO;

@BusinessController
public class CidadeBC extends DelegateCrud<Cidade, Integer, CidadeDAO> {
    
}
