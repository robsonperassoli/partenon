package br.com.syspartenon.partenon.security;

import br.com.syspartenon.partenon.domain.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SessionAttributes implements Serializable {
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
