package br.com.syspartenon.partenon.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Usuario;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Integer> {
    
    public Usuario login(String login, String senha){
        Query qry  = createQuery("select usuario from Usuario usuario where usuario.usuLogin = :login and usuario.usuSenha = :senha");
        qry.setParameter("login", login);
        qry.setParameter("senha", senha);
        List<Usuario> list = qry.getResultList();
        
        if(list != null && list.size() > 0)
            return (Usuario) list.get(0);
        
        return null;
    }    
}
