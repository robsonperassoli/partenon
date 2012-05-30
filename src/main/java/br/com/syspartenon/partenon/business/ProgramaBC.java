package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Programa;
import br.com.syspartenon.partenon.persistence.ProgramaDAO;

@BusinessController
public class ProgramaBC extends DelegateCrud<Programa, Integer, ProgramaDAO> {
    
}
