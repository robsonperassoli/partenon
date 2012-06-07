package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.ComodoBC;
import br.com.syspartenon.partenon.business.ImagemBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.business.ImovelBC;
import br.com.syspartenon.partenon.domain.Comodo;
import br.com.syspartenon.partenon.domain.Imagem;
import br.com.syspartenon.partenon.domain.Imovel;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;

@ViewController
public class ComodoMB {
    @Inject
    private ComodoBC comodoBC;
    
    @Inject
    private ImovelBC imovelBC;
    
    @Inject
    private ImagemBC imagemBC;
    
    private Comodo comodo;
    
    private Imovel imovel;
    
    @Inject
    private Parameter<Integer> imvId;


    @Inject
    private MessageContext messageContext;
    
    public List<Comodo> getList(){
        if(imovel == null)
            imovel = getImovel();
        return comodoBC.findAll(imovel);
    }

    public Imovel getImovel() {
        if(this.imovel == null) {
            this.imovel = new Imovel();
            if(this.imvId.getValue() != null) 
                this.imovel = imovelBC.load(this.imvId.getValue());
        }
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Comodo getComodo() {
        if(comodo == null){
            comodo = new Comodo();
            comodo.setImovel(getImovel());
        }
        return comodo;
    }

    public void setComodo(Comodo comodo) {
        this.comodo = comodo;
    }
    
    @Transactional
    public void salvar(){
        try {
            if(comodo.getCmdId() != null) 
                comodoBC.update(comodo);
            else
                comodoBC.insert(comodo);
            comodo = null;
            messageContext.add("Cômodo salvo com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Cômodo: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(Comodo comodo){
        try {
            comodoBC.delete(comodo.getCmdId());
            messageContext.add("Cômodo removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Cômodo: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluirImagem(Imagem imagem){
        try {
            imagemBC.delete(imagem.getImgId());
            messageContext.add("Imagem removida.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Imagem: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void visualizarImovel() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "evento_imoveis.jsf?faces-redirect=true&id=" + imovel.getEvento().getEvtId());
    }
    
    public void handleUpload(FileUploadEvent event) {
        imagemBC.insert(comodo, event.getFile().getContents(), event.getFile().getFileName());
    }
    
    public List<Imagem> getImageList(){
        return imagemBC.findAll(getComodo());
    }
}