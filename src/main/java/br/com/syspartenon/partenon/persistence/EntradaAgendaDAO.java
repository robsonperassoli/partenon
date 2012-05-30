package br.com.syspartenon.partenon.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.EntradaAgenda;
import br.com.syspartenon.partenon.domain.Evento;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class EntradaAgendaDAO extends JPACrud<EntradaAgenda, Integer> {
    public List<EntradaAgenda> findAll(Evento evento) {
        String jpql = "select e from EntradaAgenda e where e.evento.evtId = :evtId";
        Query query = createQuery(jpql);
        query.setParameter("evtId", evento.getEvtId());
        return query.getResultList();
    }    
    
    public List<EntradaAgenda> findLast(Evento evento, Integer limit) {
        String jpql = "select e from EntradaAgenda e where e.evento.evtId = :evtId and :hoje < e.eagDataFim";
        Query query = createQuery(jpql);
        query.setParameter("evtId", evento.getEvtId());
        query.setParameter("hoje", new Date());
        
        if(limit == null)
            query.setMaxResults(limit);
        
        return query.getResultList();
    }    
}
