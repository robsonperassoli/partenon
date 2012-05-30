package br.com.syspartenon.partenon.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Site;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class SiteDAO extends JPACrud<Site, Integer> {
    
    public Site load(String slug) {
        Query qry = createQuery("select s from Site s where s.sitSlugUrl = :slugUrl");
        qry.setParameter("slugUrl", slug);
        List<Site> list = qry.getResultList();

        if (list != null && list.size() > 0) {
            return (Site) list.get(0);
        }
        return null;
    }    
}
