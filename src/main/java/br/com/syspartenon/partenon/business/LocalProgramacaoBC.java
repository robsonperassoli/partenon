package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.LocalProgramacao;
import br.com.syspartenon.partenon.persistence.LocalProgramacaoDAO;

@BusinessController
public class LocalProgramacaoBC extends DelegateCrud<LocalProgramacao, Integer, LocalProgramacaoDAO> {
    
}
