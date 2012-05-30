package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.ControleEntrada;
import br.com.syspartenon.partenon.persistence.ControleEntradaDAO;

@BusinessController
public class ControleEntradaBC extends DelegateCrud<ControleEntrada, Integer, ControleEntradaDAO> {
    
}
