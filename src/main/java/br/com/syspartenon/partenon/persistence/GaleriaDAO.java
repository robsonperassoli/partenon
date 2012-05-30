package br.com.syspartenon.partenon.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Galeria;
import br.com.syspartenon.partenon.domain.Site;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class GaleriaDAO extends JPACrud<Galeria, Integer> {
    public List<Galeria> findAll(Site site) {
        String jpql = "select g from Galeria g where g.site.sitId = :sitId order by g.galData desc";
        Query query = createQuery(jpql);
        query.setParameter("sitId", site.getSitId());
        return query.getResultList();
    }
}
