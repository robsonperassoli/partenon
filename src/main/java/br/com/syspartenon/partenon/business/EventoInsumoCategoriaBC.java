package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.EventoInsumoCategoria;
import br.com.syspartenon.partenon.persistence.EventoInsumoCategoriaDAO;

@BusinessController
public class EventoInsumoCategoriaBC extends DelegateCrud<EventoInsumoCategoria, Integer, EventoInsumoCategoriaDAO> {
    
}
