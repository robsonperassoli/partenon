package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Galeria;
import br.com.syspartenon.partenon.domain.Site;
import br.com.syspartenon.partenon.persistence.GaleriaDAO;
import java.util.List;

@BusinessController
public class GaleriaBC extends DelegateCrud<Galeria, Integer, GaleriaDAO> {
    public List<Galeria> findAll(Site site) {
        return getDelegate().findAll(site);
    }    
}
