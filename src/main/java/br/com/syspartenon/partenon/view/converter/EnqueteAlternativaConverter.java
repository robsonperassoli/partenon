package br.com.syspartenon.partenon.view.converter;

import br.com.syspartenon.partenon.business.EnqueteAlternativaBC;
import br.com.syspartenon.partenon.domain.EnqueteAlternativa;
import br.gov.frameworkdemoiselle.util.Beans;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="enqueteAlternativaConverter", forClass=EnqueteAlternativa.class)
public class EnqueteAlternativaConverter implements Converter {

    private EnqueteAlternativaBC enqueteAlternativaBC = Beans.getReference(EnqueteAlternativaBC.class);
    
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = new Long(string);
        return enqueteAlternativaBC.load(id);
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        EnqueteAlternativa alternativa = (EnqueteAlternativa) o;
        return alternativa.getEalId().toString();
    }
    
}
