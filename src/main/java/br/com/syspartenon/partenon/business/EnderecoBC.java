package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Endereco;
import br.com.syspartenon.partenon.persistence.EnderecoDAO;
import br.gov.frameworkdemoiselle.template.Crud;

@BusinessController
public class EnderecoBC extends DelegateCrud<Endereco, Integer, EnderecoDAO> {
    
}
