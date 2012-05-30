package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.FotoBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.GaleriaBC;
import br.com.syspartenon.partenon.domain.Foto;
import br.com.syspartenon.partenon.domain.Galeria;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;

@ViewController
public class FotoMB {
    @Inject
    private FotoBC fotoBC;
    
    @Inject
    private GaleriaBC galeriaBC;
    
    private Foto foto;
    
    private Galeria galeria;
    
    @Inject
    private Parameter<Integer> id;

    @Inject
    private MessageContext messageContext;
    
    public List<Foto> getList(){
        if(galeria == null)
            galeria = getGaleria();
        return fotoBC.findAll(galeria);
    }

    public Galeria getGaleria() {
        if(this.galeria == null) {
            this.galeria = new Galeria();
            if(this.id.getValue() != null) 
                this.galeria = galeriaBC.load(this.id.getValue());
        }
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }

    public Foto getFoto() {
        if(foto == null){
            foto = new Foto();
            foto.setGaleria(getGaleria());
        }
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(foto.getFotId() != null) 
                fotoBC.update(foto);
            else
                fotoBC.insert(foto);
            foto = null;
            messageContext.add("Foto salva com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Foto: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(Foto foto){
        try {
            fotoBC.delete(foto.getFotId());
            messageContext.add("Foto removida.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Foto: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void visualizarGaleria() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "evento_site_galerias.jsf?faces-redirect=true&id=" + galeria.getSite().getEvento().getEvtId());
    }
    
    public void handleUpload(FileUploadEvent event) {
        foto = new Foto();
        foto.setFotDescricao("");
        foto.setGaleria(galeria);
        fotoBC.insert(foto, event.getFile().getContents(), event.getFile().getFileName());
    }
    
}

