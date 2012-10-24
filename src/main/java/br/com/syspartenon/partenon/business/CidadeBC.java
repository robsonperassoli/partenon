package br.com.syspartenon.partenon.business;

import br.com.syspartenon.partenon.domain.Cidade;
import br.com.syspartenon.partenon.persistence.CidadeDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import java.util.List;

@BusinessController
public class CidadeBC extends DelegateCrud<Cidade, Integer, CidadeDAO> {

    public List<Cidade> filtrarPorNome(String nome) {
        return getDelegate().filtrarPorNome(nome);
    }
    
}
