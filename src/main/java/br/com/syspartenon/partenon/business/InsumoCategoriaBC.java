package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.InsumoCategoria;
import br.com.syspartenon.partenon.persistence.InsumoCategoriaDAO;

@BusinessController
public class InsumoCategoriaBC extends DelegateCrud<InsumoCategoria, Integer, InsumoCategoriaDAO> {
    
}
