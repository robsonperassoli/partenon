package br.com.syspartenon.partenon.persistence;

import br.com.syspartenon.partenon.domain.Enquete;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.EnqueteAlternativa;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class EnqueteAlternativaDAO extends JPACrud<EnqueteAlternativa, Long> {

    public List<EnqueteAlternativa> findAll(Enquete enquete) {
        Query qry = createQuery("select ea from EnqueteAlternativa ea where ea.enquete.enqId = :enqId");
        qry.setParameter("enqId", enquete.getEnqId());
        return qry.getResultList();
    }
    
}
