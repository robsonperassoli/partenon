package br.com.syspartenon.partenon.business;

import br.com.syspartenon.partenon.domain.Evento;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Noticia;
import br.com.syspartenon.partenon.domain.Site;
import br.com.syspartenon.partenon.persistence.NoticiaDAO;
import java.util.List;

@BusinessController
public class NoticiaBC extends DelegateCrud<Noticia, Integer, NoticiaDAO> {
    
    public List<Noticia> findAll(Site site) {
        return getDelegate().findAll(site);
    }
    
    public List<Noticia> findLast(Evento evento, Integer limit) {
        return getDelegate().findLast(evento, limit);
    }
    
    public List<Noticia> findPage(Evento evento, Integer pagina, Integer limit) {
        return getDelegate().findPage(evento, pagina, limit);
    }
    
    public Long count(Evento evento) {
        return getDelegate().count(evento);
    }
    
}
