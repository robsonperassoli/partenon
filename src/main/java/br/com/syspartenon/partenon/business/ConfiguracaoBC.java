package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Configuracao;
import br.com.syspartenon.partenon.persistence.ConfiguracaoDAO;
import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class ConfiguracaoBC extends DelegateCrud<Configuracao, Integer, ConfiguracaoDAO> {

    @Startup
    @Transactional
    public void carregaConfiguracao(){
        if(findAll().isEmpty()) {
            Configuracao conf = new Configuracao();
            conf.setConId(1);
            insert(conf);
        }
    }
    
}
