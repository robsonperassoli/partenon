package br.com.syspartenon.partenon.persistence;

import br.com.syspartenon.partenon.domain.Evento;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Local;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class LocalDAO extends JPACrud<Local, Integer> {

    public List<Local> findAll(Evento evento) {
        String jpql = "select l from Local l where l.evento.evtId = :evtId";
        Query query = createQuery(jpql);
        query.setParameter("evtId", evento.getEvtId());
        return query.getResultList();
    }
}
