package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.UsuarioGrupo;
import br.com.syspartenon.partenon.persistence.UsuarioGrupoDAO;

@BusinessController
public class UsuarioGrupoBC extends DelegateCrud<UsuarioGrupo, Integer, UsuarioGrupoDAO> {
    
}
