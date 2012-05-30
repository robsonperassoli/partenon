package br.com.syspartenon.partenon.security;

import br.com.syspartenon.partenon.domain.Operacao;
import br.gov.frameworkdemoiselle.security.Authorizer;
import java.util.List;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Alternative
public class Autorizador implements Authorizer {

    @Inject 
    private SessionAttributes sessionAttributes;
    
    public boolean hasRole(String string) {
        return false;
    }

    public boolean hasPermission(String resource, String operation) {
        if(sessionAttributes.getUsuario() == null)
            return false;
        List<Operacao> operacoesPermitidas =  sessionAttributes.getUsuario().getUsuarioGrupo().getListOperacoes();
        for(Operacao operacao : operacoesPermitidas) {
            if (operacao.getRecurso().getRecDescricao().equals(resource) && operacao.getOpeDescricao().equals(operation))
                return true;
        }
        return false;
    }
    
}
