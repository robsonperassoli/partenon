package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.ProgramaEntidade;
import br.com.syspartenon.partenon.persistence.ProgramaEntidadeDAO;

@BusinessController
public class ProgramaEntidadeBC extends DelegateCrud<ProgramaEntidade, Integer, ProgramaEntidadeDAO> {
    
}
