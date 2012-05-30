package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.MovimentacaoOrigem;
import br.com.syspartenon.partenon.persistence.MovimentacaoOrigemDAO;

@BusinessController
public class MovimentacaoOrigemBC extends DelegateCrud<MovimentacaoOrigem, Integer, MovimentacaoOrigemDAO> {
    
}
