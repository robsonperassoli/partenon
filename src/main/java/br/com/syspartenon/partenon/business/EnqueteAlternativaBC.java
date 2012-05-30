package br.com.syspartenon.partenon.business;

import br.com.syspartenon.partenon.domain.Enquete;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.EnqueteAlternativa;
import br.com.syspartenon.partenon.persistence.EnqueteAlternativaDAO;
import java.util.List;

@BusinessController
public class EnqueteAlternativaBC extends DelegateCrud<EnqueteAlternativa, Long, EnqueteAlternativaDAO> {

    public void delete(EnqueteAlternativa alternativa) throws Exception {
        if (alternativa.getEalRespostas() > 0)
            throw new Exception("Alternativa já possui respostas, impossível remover.");

        super.delete(alternativa.getEalId());
    }
    
    public List<EnqueteAlternativa> findAll(Enquete enquete) {
        return getDelegate().findAll(enquete);
    }
    
}
