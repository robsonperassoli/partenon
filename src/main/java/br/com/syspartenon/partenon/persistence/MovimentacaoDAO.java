package br.com.syspartenon.partenon.persistence;

import br.com.syspartenon.partenon.domain.Evento;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Movimentacao;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class MovimentacaoDAO extends JPACrud<Movimentacao, Integer> {
    public List<Movimentacao> findAll(Evento evento) {
        String jpql = "select m from Movimentacao m where m.evento.evtId = :evtId";
        Query query = createQuery(jpql);
        query.setParameter("evtId", evento.getEvtId());
        return query.getResultList();
    }    
}
