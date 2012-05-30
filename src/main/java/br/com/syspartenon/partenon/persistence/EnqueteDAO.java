package br.com.syspartenon.partenon.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.syspartenon.partenon.domain.Enquete;
import br.com.syspartenon.partenon.domain.Evento;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;


@PersistenceController
public class EnqueteDAO extends JPACrud<Enquete, Long> {
    
    public List<Enquete> findAll(Evento evento){
        Query qry = createQuery("select e from Enquete e where e.evento.evtId = :evento");
        qry.setParameter("evento", (Integer) evento.getEvtId());
        return qry.getResultList();
    }
    
    /**
     * Retorna a data de término da última enquete que ainda está em vigor
     * @param evento
     * @return 
     */
    public Date dataTerminoUltimaEnquete(Evento evento){
        String jpql = "select max(e.enqExpiracao) from Enquete e where e.evento = :evento";
        Query qry = createQuery(jpql);
        qry.setParameter("evento", evento);
        
        List<Date> dataTermino = qry.getResultList();
        if(!dataTermino.isEmpty())
            return dataTermino.get(0);
        return null;
    }

    public boolean existeEnqueteAtiva(Evento evento) {
        Date hoje = new Date();
        
        Query qry = createQuery("select count(e) from Enquete e where :hoje between e.enqInicio and e.enqExpiracao");
        qry.setParameter("hoje", hoje);
        
        Long count = (Long) qry.getSingleResult();
        return count > 0;
    }

    public Enquete enqueteAtiva(Evento evento) {
        Date hoje = new Date();

        Query qry = createQuery("select e from Enquete e where :hoje between e.enqInicio and e.enqExpiracao");
        qry.setParameter("hoje", hoje);
        
        List<Enquete> resultList = qry.getResultList();
        if(resultList.isEmpty())
            return null;
        
        return resultList.get(0);
    }
    
}


