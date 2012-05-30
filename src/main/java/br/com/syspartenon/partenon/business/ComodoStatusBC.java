package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.ComodoStatus;
import br.com.syspartenon.partenon.domain.Entidade;
import br.com.syspartenon.partenon.persistence.ComodoStatusDAO;
import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import javax.inject.Inject;

@BusinessController
public class ComodoStatusBC extends DelegateCrud<ComodoStatus, Integer, ComodoStatusDAO> {
 
    @Inject
    private EntidadeBC entidadeBC;
    
    
    @Startup
    @Transactional
    public void cargaInicial(){
        if(findAll().isEmpty()) {
            Entidade entidade = entidadeBC.load(1);
            
            ComodoStatus sts;
            
            sts = new ComodoStatus();
            sts.setCmsDescricao("Disponível");
            sts.setEntidade(entidade);
            insert(sts);
            
            sts = new ComodoStatus();
            sts.setCmsDescricao("Reservado");
            sts.setEntidade(entidade);
            insert(sts);
            
            sts = new ComodoStatus();
            sts.setCmsDescricao("Negociação");
            sts.setEntidade(entidade);
            insert(sts);
        }
    }
}
