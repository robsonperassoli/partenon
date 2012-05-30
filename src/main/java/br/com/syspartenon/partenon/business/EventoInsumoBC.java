package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.EventoInsumo;
import br.com.syspartenon.partenon.persistence.EventoInsumoDAO;

@BusinessController
public class EventoInsumoBC extends DelegateCrud<EventoInsumo, Integer, EventoInsumoDAO> {
    
}
