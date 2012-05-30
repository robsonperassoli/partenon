package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.domain.Usuario;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import javax.inject.Inject;

@ViewController
public class LoginMB {
    private Usuario usuario;

    @Inject
    private MessageContext messageContext;
    
    @Inject
    private SecurityContext securityContext;
    
    public Usuario getUsuario() {
        if(usuario == null)
            usuario = new Usuario();
        return usuario;
    }
    
    public String login(){
        try {
           securityContext.login();
           if(!securityContext.isLoggedIn())
               throw new Exception("Não foi possível acessar o sistema.");
           return "/index.jsf";
        } catch (Exception e) {
            messageContext.add(e.getMessage(), SeverityType.ERROR);
            return "/login.jsf";
        }
    }
    
}
