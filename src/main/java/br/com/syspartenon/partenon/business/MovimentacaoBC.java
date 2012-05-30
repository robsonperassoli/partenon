package br.com.syspartenon.partenon.business;

import br.com.syspartenon.partenon.domain.Evento;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Movimentacao;
import br.com.syspartenon.partenon.persistence.MovimentacaoDAO;
import java.util.List;

@BusinessController
public class MovimentacaoBC extends DelegateCrud<Movimentacao, Integer, MovimentacaoDAO> {
    public List<Movimentacao> findAll(Evento evento) {
        return getDelegate().findAll(evento);
    }    
}
