package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.EntradaAgenda;
import br.com.syspartenon.partenon.domain.Evento;
import br.com.syspartenon.partenon.persistence.EntradaAgendaDAO;
import java.util.List;

@BusinessController
public class EntradaAgendaBC extends DelegateCrud<EntradaAgenda, Integer, EntradaAgendaDAO> {
    public List<EntradaAgenda> findAll(Evento evento) {
        return getDelegate().findAll(evento);
    }    
    public List<EntradaAgenda> findLast(Evento evento, Integer limit) {
        return getDelegate().findLast(evento, limit);
    }
}
