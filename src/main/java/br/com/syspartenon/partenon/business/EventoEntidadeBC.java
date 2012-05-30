package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.EventoEntidade;
import br.com.syspartenon.partenon.persistence.EventoEntidadeDAO;

@BusinessController
public class EventoEntidadeBC extends DelegateCrud<EventoEntidade, Integer, EventoEntidadeDAO> {
    
}
