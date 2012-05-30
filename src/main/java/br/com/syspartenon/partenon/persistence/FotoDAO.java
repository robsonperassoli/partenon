package br.com.syspartenon.partenon.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Foto;
import br.com.syspartenon.partenon.domain.Galeria;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class FotoDAO extends JPACrud<Foto, Integer> {
    public List<Foto> findAll(Galeria galeria) {
        String jpql = "select f from Foto f where f.galeria.galId = :galId";
        Query query = createQuery(jpql);
        query.setParameter("galId", galeria.getGalId());
        return query.getResultList();
    }        
}
