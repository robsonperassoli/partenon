package br.com.syspartenon.partenon.persistence;

import br.com.syspartenon.partenon.domain.Comodo;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Imagem;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class ImagemDAO extends JPACrud<Imagem, Integer> {
    public List<Imagem> findAll(Comodo comodo) {
        String jpql = "select i from Imagem i where i.comodo.cmdId = :cmdId";
        Query query = createQuery(jpql);
        query.setParameter("cmdId", comodo.getCmdId());
        return query.getResultList();
    }
}
