package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Pacote;
import br.com.syspartenon.partenon.persistence.PacoteDAO;

@BusinessController
public class PacoteBC extends DelegateCrud<Pacote, Integer, PacoteDAO> {
    
}
