package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Evento;
import br.com.syspartenon.partenon.persistence.EventoDAO;

@BusinessController
public class EventoBC extends DelegateCrud<Evento, Integer, EventoDAO> {
    
}
