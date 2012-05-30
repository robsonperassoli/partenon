package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Comodo;
import br.com.syspartenon.partenon.domain.Imovel;
import br.com.syspartenon.partenon.persistence.ComodoDAO;
import java.util.List;

@BusinessController
public class ComodoBC extends DelegateCrud<Comodo, Integer, ComodoDAO> {
    public List<Comodo> findAll(Imovel imovel) {
        return getDelegate().findAll(imovel);
    }    
}
