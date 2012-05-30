package br.com.syspartenon.partenon.business;

import br.com.syspartenon.partenon.domain.Entidade;
import br.com.syspartenon.partenon.domain.Operacao;
import br.com.syspartenon.partenon.domain.Recurso;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Usuario;
import br.com.syspartenon.partenon.domain.UsuarioGrupo;
import br.com.syspartenon.partenon.persistence.UsuarioDAO;
import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import javax.inject.Inject;

@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, Integer, UsuarioDAO> {
 
    @Inject
    private RecursoBC recursoBC;
    
    @Inject
    private OperacaoBC operacaoBC;
    
    @Startup
    @Transactional
    public void criarUsuarioPadrao(){
        if(getDelegate().findAll().isEmpty()){
            UsuarioGrupoBC usuarioGrupoBC = new UsuarioGrupoBC();
            UsuarioGrupo grupo = new UsuarioGrupo();
            grupo.setUsgNome("Partenon");
            
            EntidadeBC entidadeBC = new EntidadeBC();
            Entidade entidadePartenon = new Entidade();
            entidadePartenon.setEntNome("Partenon");
            entidadePartenon.setEntEmail("partenon@partenon.com.br");
            
            
            Usuario usuarioPadrao =  new Usuario();
            usuarioPadrao.setEntidade(entidadePartenon);
            usuarioPadrao.setUsuLogin("partenon");
            usuarioPadrao.setUsuSenha("123");
            usuarioPadrao.setUsuarioGrupo(grupo);
            
            entidadePartenon.setUsuario(usuarioPadrao);
            
            //grupo.setListOperacoes(operacaoBC.findAll());
            
            usuarioGrupoBC.insert(grupo);
            entidadeBC.insert(entidadePartenon);
            getDelegate().insert(usuarioPadrao);
            
            
            // permissões do usuário padrão
            Recurso recurso = new Recurso();
            recurso.setRecDescricao("menu");

            Operacao opEvento = new Operacao();
            opEvento.setOpeDescricao("evento");
            opEvento.setRecurso(recurso);
            opEvento.getUsuarioGrupos().add(grupo);
            recurso.getListOperacoes().add(opEvento);

            Operacao opCidade = new Operacao();
            opCidade.setOpeDescricao("cidade");
            opCidade.setRecurso(recurso);
            opCidade.getUsuarioGrupos().add(grupo);
            recurso.getListOperacoes().add(opCidade);

            Operacao opEntidade = new Operacao();
            opEntidade.setOpeDescricao("entidade");
            opEntidade.setRecurso(recurso);
            opEntidade.getUsuarioGrupos().add(grupo);
            recurso.getListOperacoes().add(opEntidade);

            Operacao opUnidade = new Operacao();
            opUnidade.setOpeDescricao("unidade");
            opUnidade.setRecurso(recurso);
            opUnidade.getUsuarioGrupos().add(grupo);
            recurso.getListOperacoes().add(opUnidade);

            Operacao opInsCategoria = new Operacao();
            opInsCategoria.setOpeDescricao("insumoCategoria");
            opInsCategoria.setRecurso(recurso);
            opInsCategoria.getUsuarioGrupos().add(grupo);
            recurso.getListOperacoes().add(opInsCategoria);

            Operacao opInsMovimentacao = new Operacao();
            opInsMovimentacao.setOpeDescricao("insumoMovimentacao");
            opInsMovimentacao.setRecurso(recurso);
            opInsMovimentacao.getUsuarioGrupos().add(grupo);
            recurso.getListOperacoes().add(opInsMovimentacao);

            Operacao opUsuario = new Operacao();
            opUsuario.setOpeDescricao("usuario");
            opUsuario.setRecurso(recurso);
            opUsuario.getUsuarioGrupos().add(grupo);
            recurso.getListOperacoes().add(opUsuario);

            Operacao opGrupoUsuario = new Operacao();
            opGrupoUsuario.setOpeDescricao("grupoUsuario");
            opGrupoUsuario.setRecurso(recurso);
            opGrupoUsuario.getUsuarioGrupos().add(grupo);
            recurso.getListOperacoes().add(opGrupoUsuario);

            Operacao opRecurso = new Operacao();
            opRecurso.setOpeDescricao("recurso");
            opRecurso.setRecurso(recurso);
            opRecurso.getUsuarioGrupos().add(grupo);
            recurso.getListOperacoes().add(opRecurso);

            Operacao opConfig = new Operacao();
            opConfig.setOpeDescricao("configuracao");
            opConfig.setRecurso(recurso);
            opConfig.getUsuarioGrupos().add(grupo);
            recurso.getListOperacoes().add(opConfig);
            recursoBC.insert(recurso);
        }
    }
    
    public Usuario login(String login, String senha){
        return getDelegate().login(login, senha);
    }
}
