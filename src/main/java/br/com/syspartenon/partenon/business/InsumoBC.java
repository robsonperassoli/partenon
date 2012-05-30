package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Insumo;
import br.com.syspartenon.partenon.persistence.InsumoDAO;

@BusinessController
public class InsumoBC extends DelegateCrud<Insumo, Integer, InsumoDAO> {
    
}
