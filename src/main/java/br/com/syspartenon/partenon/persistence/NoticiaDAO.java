package br.com.syspartenon.partenon.persistence;

import br.com.syspartenon.partenon.domain.Evento;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Noticia;
import br.com.syspartenon.partenon.domain.Site;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class NoticiaDAO extends JPACrud<Noticia, Integer> {
    
    public List<Noticia> findAll(Site site) {
        String jpql = "select n from Noticia n where n.site.sitId = :sitId";
        Query query = createQuery(jpql);
        query.setParameter("sitId", site.getSitId());
        return query.getResultList();
    }
    
    public List<Noticia> findLast(Evento evento, Integer limit) {
        String jpql = "select n from Noticia n where n.site.sitId = :sitId order by n.ntcData desc";
        Query query = createQuery(jpql);
        query.setParameter("sitId", evento.getSite().getSitId());
        
        if (limit == null) {
            query.setMaxResults(limit);
        }

        return query.getResultList();
    }    
    
    public List<Noticia> findPage(Evento evento, Integer pagina, Integer limit) {
        String jpql = "select n from Noticia n where n.site.sitId = :sitId order by n.ntcData desc";
        Query query = createQuery(jpql);
        query.setParameter("sitId", evento.getSite().getSitId());
        
        query.setFirstResult((pagina-1) * limit);
        query.setMaxResults(limit);
        
        return query.getResultList();
    }    
    
    public Long count(Evento evento) {
        String jpql = "select count(n) from Noticia n where n.site.sitId = :sitId";
        Query query = createQuery(jpql);
        query.setParameter("sitId", evento.getSite().getSitId());
        
        return (Long) query.getSingleResult();
    }    
}
