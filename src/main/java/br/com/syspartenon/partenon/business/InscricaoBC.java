package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Inscricao;
import br.com.syspartenon.partenon.persistence.InscricaoDAO;

@BusinessController
public class InscricaoBC extends DelegateCrud<Inscricao, Integer, InscricaoDAO> {
    
}
