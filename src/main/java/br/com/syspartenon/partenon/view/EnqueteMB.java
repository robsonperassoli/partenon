package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.EnqueteAlternativaBC;
import br.com.syspartenon.partenon.business.EnqueteBC;
import br.com.syspartenon.partenon.business.EventoBC;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Parameter;
import br.com.syspartenon.partenon.domain.Enquete;
import br.com.syspartenon.partenon.domain.EnqueteAlternativa;
import br.com.syspartenon.partenon.domain.Evento;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class EnqueteMB {

    @Inject
    private EventoBC eventoBC;
    
    @Inject
    private EnqueteBC enqueteBC;
    
    @Inject
    private EnqueteAlternativaBC enqueteAlternativaBC;
    
    private Evento evento;
    private Enquete enquete;
    private EnqueteAlternativa novaAlternativa;
    
    @Inject
    private Parameter<Integer> id;
    
    @Inject
    private MessageContext messageContext;

    public List<Enquete> getList() {
        if (evento == null) {
            evento = getEvento();
        }
        return enqueteBC.findAll(getEvento());
    }
    
    public List<EnqueteAlternativa> getAlternativas() {
        return enqueteAlternativaBC.findAll(getEnquete());
    }

    public Evento getEvento() {
        if (this.evento == null) {
            this.evento = new Evento();
            if (this.id.getValue() != null) {
                this.evento = eventoBC.load(this.id.getValue());
            }
        }
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Enquete getEnquete() {
        if(enquete == null) 
            novaEnquete();
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }

    public EnqueteAlternativa getNovaAlternativa() {
        if(novaAlternativa == null) {
            novaAlternativa = new EnqueteAlternativa();
            novaAlternativa.setEnquete(enquete);
        }
        return novaAlternativa;
    }

    public void setNovaAlternativa(EnqueteAlternativa novaAlternativa) {
        this.novaAlternativa = novaAlternativa;
    }

    @Transactional
    public void salvar() {
        try {
            enqueteBC.salvar(enquete);
            enquete = null;
            messageContext.add("Enquete salva com sucesso.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao salvar Enquete: " + e.getMessage(), SeverityType.ERROR);
        }
    }

    @Transactional
    public void excluir() {
        try {
            enqueteBC.delete(enquete.getEnqId());
            messageContext.add("Enquete removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover Enquete: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void salvarAlternativa() {
        try {
            if(novaAlternativa.getEalId() == null) 
                enqueteAlternativaBC.insert(novaAlternativa);
            else
                enqueteAlternativaBC.update(novaAlternativa);
            novaAlternativa = null;
            messageContext.add("Alternativa Adicionada.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao adicionar alternativa: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluirAlternativa() {
        try {
            enqueteAlternativaBC.delete(novaAlternativa);
            novaAlternativa = null;
            messageContext.add("Alternativa Removida.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro ao remover alternativa: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void addAlternativas(){
        novaAlternativa = new EnqueteAlternativa();
        novaAlternativa.setEnquete(getEnquete());
    }
    
    public void novaEnquete(){
        enquete = new Enquete();
        enquete.setEvento(getEvento());
        
        Date inicioNovaEnquete = enqueteBC.proximaDataInicioEnquete(getEvento());
        enquete.setEnqInicio(inicioNovaEnquete);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inicioNovaEnquete);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        enquete.setEnqExpiracao(calendar.getTime());
    }
    
}
