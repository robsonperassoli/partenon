package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Site;
import br.com.syspartenon.partenon.persistence.SiteDAO;

@BusinessController
public class SiteBC extends DelegateCrud<Site, Integer, SiteDAO> {

    public Site load(String slug) {
        return getDelegate().load(slug);
    }
    
}
