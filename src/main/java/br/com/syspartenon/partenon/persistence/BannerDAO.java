package br.com.syspartenon.partenon.persistence;

import br.com.syspartenon.partenon.domain.Banner;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Site;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class BannerDAO extends JPACrud<Banner, Integer> {
    public List<Banner> findAll(Site site) {
        String jpql = "select b from Banner b where b.site.sitId = :sitId";
        Query query = createQuery(jpql);
        query.setParameter("sitId", site.getSitId());
        return query.getResultList();
    }        
}
