package br.com.syspartenon.partenon.business;

import br.com.syspartenon.partenon.domain.Evento;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Imovel;
import br.com.syspartenon.partenon.persistence.ImovelDAO;
import java.util.List;

@BusinessController
public class ImovelBC extends DelegateCrud<Imovel, Integer, ImovelDAO> {
    public List<Imovel> findAll(Evento evento) {
        return getDelegate().findAll(evento);
    }    
}
