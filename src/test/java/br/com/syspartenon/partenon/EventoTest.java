package br.com.syspartenon.partenon;

import java.util.Date;
import br.com.syspartenon.partenon.business.EventoBC;
import br.com.syspartenon.partenon.domain.Endereco;
import br.com.syspartenon.partenon.domain.Evento;
import br.com.syspartenon.partenon.domain.Local;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(DemoiselleRunner.class)
public class EventoTest {
    @Inject
    private EventoBC eventoBC;
    
    @Test 
    @Transactional
    public void testInsert(){
//        Evento evt = new Evento();
//        //evt.setEvtId(99999);
//        evt.setEvtNome("Evento Teste");
//        evt.setEvtDescricao("Descrição Evento Teste");
//        evt.setEvtInicio(new Date());
//        evt.setEvtFim(new Date());
//        evt.setLocal(new Local());
//        evt.getLocal().setLclDescricao("Local Teste");
//        evt.getLocal().setEndereco(new Endereco());
//        evt.getLocal().getEndereco().setEndRua("Rua XXX");
//        evt.getLocal().getEndereco().setEndBairro("XXX");
//        evt.getLocal().getEndereco().setEndCep("89900000");
//        eventoBC.insert(evt);
//        
//        Evento evtCarregado = eventoBC.load(99999); 
//        //se != null então foi inserido
//        assertNotNull(evtCarregado);
    }
}
