package br.com.syspartenon.partenon.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Insumo;

@PersistenceController
public class InsumoDAO extends JPACrud<Insumo, Integer> {
    
}
