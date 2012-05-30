package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name="UsuarioGen" , allocationSize=1)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "usu_id")
    @GeneratedValue(generator="UsuarioGen", strategy=GenerationType.SEQUENCE)
    private Integer usuId;
    
    @Column(name = "usu_login")
    private String usuLogin;
    
    @Column(name = "usu_senha")
    private String usuSenha;
    
    @JoinColumn(name = "usg_id", referencedColumnName = "usg_id")
    @ManyToOne(optional = false)
    private UsuarioGrupo usuarioGrupo;
    
    @OneToOne(cascade= CascadeType.ALL, mappedBy="usuario")
    private Entidade entidade;
    
    public Usuario() {
    }

    public Usuario(Integer usuId) {
        this.usuId = usuId;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public UsuarioGrupo getUsuarioGrupo() {
        return usuarioGrupo;
    }

    public void setUsuarioGrupo(UsuarioGrupo usuarioGrupo) {
        this.usuarioGrupo = usuarioGrupo;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Usuario[ usuId=" + usuId + " ]";
    }
    
}
