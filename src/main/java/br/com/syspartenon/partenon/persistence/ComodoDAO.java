package br.com.syspartenon.partenon.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Comodo;
import br.com.syspartenon.partenon.domain.Imovel;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class ComodoDAO extends JPACrud<Comodo, Integer> {
    public List<Comodo> findAll(Imovel imovel) {
        String jpql = "select l from Comodo l where l.imovel.imvId = :imvId";
        Query query = createQuery(jpql);
        query.setParameter("imvId", imovel.getImvId());
        return query.getResultList();
    }    
}
