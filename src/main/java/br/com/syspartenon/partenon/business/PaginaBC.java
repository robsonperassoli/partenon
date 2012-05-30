package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Pagina;
import br.com.syspartenon.partenon.domain.Site;
import br.com.syspartenon.partenon.persistence.PaginaDAO;
import java.util.List;

@BusinessController
public class PaginaBC extends DelegateCrud<Pagina, Integer, PaginaDAO> {
    public List<Pagina> findAll(Site site) {
        return getDelegate().findAll(site);
    }    
}
