package br.com.syspartenon.partenon.view.converter;

import br.com.syspartenon.partenon.business.CidadeBC;
import br.com.syspartenon.partenon.domain.Cidade;
import br.gov.frameworkdemoiselle.util.Beans;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="cidadeConverter")
public class CidadeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        CidadeBC bc = Beans.getReference(CidadeBC.class);
        return bc.load(new Integer(id));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null)
            return "";
        return ((Cidade) o).getCddId().toString();
    }
    
}
