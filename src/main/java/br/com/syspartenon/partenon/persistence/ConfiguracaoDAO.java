package br.com.syspartenon.partenon.persistence;

import br.com.syspartenon.partenon.domain.Configuracao;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class ConfiguracaoDAO extends JPACrud<Configuracao, Integer> {
    
}
