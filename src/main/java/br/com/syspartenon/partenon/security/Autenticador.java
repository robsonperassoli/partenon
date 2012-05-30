package br.com.syspartenon.partenon.security;

import br.com.syspartenon.partenon.business.UsuarioBC;
import br.com.syspartenon.partenon.domain.Usuario;
import br.com.syspartenon.partenon.view.LoginMB;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Alternative
public class Autenticador implements Authenticator {
    
    @Inject
    private LoginMB loginMB;
    
    @Inject
    private UsuarioBC usuarioBC;
    
    @Inject
    private SessionAttributes sessionAttributes;
    
    public boolean authenticate() {
        Usuario retorno = usuarioBC.login(loginMB.getUsuario().getUsuLogin(), loginMB.getUsuario().getUsuSenha());
        if(retorno == null)
            return false;
        
        sessionAttributes.setUsuario(retorno);
        return true;
    }

    public void unAuthenticate() {
        sessionAttributes = null;
    }

    public User getUser() {
        if(sessionAttributes.getUsuario() == null)
            return null;
        else{
            return new User() {

                public String getId() {
                    return "" + sessionAttributes.getUsuario().getUsuLogin();
                }

                public Object getAttribute(Object o) {
                    return null;
                }

                public void setAttribute(Object o, Object o1) {

                }
            };
        }
    }
    
}
