package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.EntidadeCategoria;
import br.com.syspartenon.partenon.persistence.EntidadeCategoriaDAO;
import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class EntidadeCategoriaBC extends DelegateCrud<EntidadeCategoria, Integer, EntidadeCategoriaDAO> {
    
    @Startup
    @Transactional
    public void inserirCategorisPadrao(){
        if(getDelegate().findAll().isEmpty()) {
            EntidadeCategoria ec;
            ec = new EntidadeCategoria();
            ec.setEncId(1);
            ec.setEncDescricao("Participante");
            getDelegate().insert(ec);
            
            ec = new EntidadeCategoria();
            ec.setEncId(2);
            ec.setEncDescricao("Cliente");
            getDelegate().insert(ec);
            
            ec = new EntidadeCategoria();
            ec.setEncId(3);
            ec.setEncDescricao("Fornecedor");
            getDelegate().insert(ec);
            
            ec = new EntidadeCategoria();
            ec.setEncId(4);
            ec.setEncDescricao("Cliente da Aplicação");
            getDelegate().insert(ec);
            
            ec = new EntidadeCategoria();
            ec.setEncId(5);
            ec.setEncDescricao("Dono de Imovel");
            getDelegate().insert(ec);
        }
    }
}
