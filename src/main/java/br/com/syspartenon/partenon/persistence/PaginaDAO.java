package br.com.syspartenon.partenon.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Pagina;
import br.com.syspartenon.partenon.domain.Site;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class PaginaDAO extends JPACrud<Pagina, Integer> {
    public List<Pagina> findAll(Site site) {
        String jpql = "select p from Pagina p where p.site.sitId = :sitId";
        Query query = createQuery(jpql);
        query.setParameter("sitId", site.getSitId());
        return query.getResultList();
    }
    
}
