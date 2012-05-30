package br.com.syspartenon.partenon.business;

import br.com.syspartenon.partenon.domain.Evento;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Local;
import br.com.syspartenon.partenon.persistence.LocalDAO;
import java.util.List;

@BusinessController
public class LocalBC extends DelegateCrud<Local, Integer, LocalDAO> {

    public List<Local> findAll(Evento evento) {
        return getDelegate().findAll(evento);
    }
    
}
