package br.com.syspartenon.partenon.persistence;

import br.com.syspartenon.partenon.domain.Evento;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Imovel;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class ImovelDAO extends JPACrud<Imovel, Integer> {
    
    public List<Imovel> findAll(Evento evento) {
        String jpql = "select l from Imovel l where l.evento.evtId = :evtId";
        Query query = createQuery(jpql);
        query.setParameter("evtId", evento.getEvtId());
        return query.getResultList();
    }    
}
