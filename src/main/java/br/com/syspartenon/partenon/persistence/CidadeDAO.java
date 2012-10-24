package br.com.syspartenon.partenon.persistence;

import br.com.syspartenon.partenon.domain.Cidade;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class CidadeDAO extends JPACrud<Cidade, Integer> {

    public List<Cidade> filtrarPorNome(String nome) {
        Query qry = createQuery("select this from Cidade this where upper(this.cddNome) like upper(:nome)");
        qry.setParameter("nome", "%" + nome);
        return qry.getResultList();
    }
    
}
