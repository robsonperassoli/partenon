package br.com.syspartenon.partenon.util;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class JsfUtil {

    private JsfUtil() {}
    
    public static void redirect(String url) throws Exception{
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(url);
        } catch (IOException ex) {
            throw new Exception("Erro ao redirecional para a url solicitada.", ex);
        }
    }
    
}
