package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Estado;
import br.com.syspartenon.partenon.persistence.EstadoDAO;
import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class EstadoBC extends DelegateCrud<Estado, Integer, EstadoDAO> {
    @Startup
    @Transactional
    public void cargaInicialEstados(){
        if(getDelegate().findAll().isEmpty()){
            Estado e;
            e = new Estado();
            e.setEstUf("RS");
            e.setEstNome("Rio Grande do Sul");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("SC");
            e.setEstNome("Santa Catarina");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("PR");
            e.setEstNome("Paraná");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("SP");
            e.setEstNome("São Paulo");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("MS");
            e.setEstNome("Mato Grosso do Sul");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("MG");
            e.setEstNome("Minas Gerais");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("GO");
            e.setEstNome("Goias");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("MT");
            e.setEstNome("Mato Grosso");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("RO");
            e.setEstNome("Rondônia");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("AC");
            e.setEstNome("Acre");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("AM");
            e.setEstNome("Amazonas");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("AP");
            e.setEstNome("Amapa");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("PA");
            e.setEstNome("Pará");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("TO");
            e.setEstNome("Tocantins");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("DF");
            e.setEstNome("Distrito Federal");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("AL");
            e.setEstNome("Alagoas");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("BA");
            e.setEstNome("Bahia");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("CE");
            e.setEstNome("Ceará");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("MA");
            e.setEstNome("Maranhão");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("PB");
            e.setEstNome("Paraíba");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("PE");
            e.setEstNome("Pernambuco");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("PI");
            e.setEstNome("Piauí");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("RN");
            e.setEstNome("Rio Grande do Norte");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("SE");
            e.setEstNome("Sergipe");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("ES");
            e.setEstNome("Espirito Santo");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("RJ");
            e.setEstNome("Rio de Janeiro");
            getDelegate().insert(e);
            
            e = new Estado();
            e.setEstUf("RR");
            e.setEstNome("Roraima");
            getDelegate().insert(e);
        }
    }
}
