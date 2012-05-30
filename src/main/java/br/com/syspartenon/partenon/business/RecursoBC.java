package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Recurso;
import br.com.syspartenon.partenon.persistence.RecursoDAO;

@BusinessController
public class RecursoBC extends DelegateCrud<Recurso, Integer, RecursoDAO> {
}
