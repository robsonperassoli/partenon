package br.com.syspartenon.partenon.business;

import br.com.syspartenon.partenon.domain.EnqueteAlternativa;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Enquete;
import br.com.syspartenon.partenon.domain.Evento;
import br.com.syspartenon.partenon.persistence.EnqueteDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

@BusinessController
public class EnqueteBC extends DelegateCrud<Enquete, Long, EnqueteDAO> {

    @Inject
    private EnqueteAlternativaBC enqueteAlternativaBC;
    
    public void salvar(Enquete enquete) throws Exception{
        Date dataMinimaEnquete = proximaDataInicioEnquete(enquete.getEvento());
        
        if(enquete.getEnqExpiracao().before(dataMinimaEnquete) || enquete.getEnqInicio().equals(dataMinimaEnquete))
            throw new Exception("Houve choque de datas entre as enquetes, já existe uma enquete para este pedíodo");
        
        if (enquete.getEnqId() != null)
            update(enquete);
        else
            insert(enquete);
        
    }
    
    public List<Enquete> findAll(Evento evento) {
        return getDelegate().findAll(evento);
    }
    
    public Date proximaDataInicioEnquete(Evento evento){
        Date terminoUltimaEnquete = getDelegate().dataTerminoUltimaEnquete(evento);
        
        Date hoje = new Date();
        // caso não tiver enquetes cadastradas
        if(terminoUltimaEnquete == null || terminoUltimaEnquete.before(hoje))
            return hoje;
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(terminoUltimaEnquete);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        
        return calendar.getTime();
    }

    public boolean existeEnqueteAtiva(Evento evento) {
        return getDelegate().existeEnqueteAtiva(evento);
    }

    public Enquete enqueteAtiva(Evento evento) {
        return getDelegate().enqueteAtiva(evento);
    }

    public void votar(EnqueteAlternativa alternativaSelecionada) {
        alternativaSelecionada.incrementaRespostas();
        enqueteAlternativaBC.update(alternativaSelecionada);            
    }
    
}
