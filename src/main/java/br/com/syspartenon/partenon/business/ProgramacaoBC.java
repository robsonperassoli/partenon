package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Programacao;
import br.com.syspartenon.partenon.persistence.ProgramacaoDAO;

@BusinessController
public class ProgramacaoBC extends DelegateCrud<Programacao, Integer, ProgramacaoDAO> {
    
}
