package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "usuario_grupo")
@SequenceGenerator(name="UsuarioGrupoGen" , allocationSize=1)
public class UsuarioGrupo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "usg_id")
    @GeneratedValue(generator="UsuarioGrupoGen")
    private Integer usgId;
    
    @Column(name = "usg_nome")
    private String usgNome;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioGrupo")
    private List<Usuario> usuarioList;
    
    @ManyToMany(mappedBy="usuarioGrupos")
    private List<Operacao> listOperacoes = new ArrayList<Operacao>();

    public UsuarioGrupo() {
    }

    public UsuarioGrupo(Integer usgId) {
        this.usgId = usgId;
    }

    public Integer getUsgId() {
        return usgId;
    }

    public void setUsgId(Integer usgId) {
        this.usgId = usgId;
    }

    public String getUsgNome() {
        return usgNome;
    }

    public void setUsgNome(String usgNome) {
        this.usgNome = usgNome;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Operacao> getListOperacoes() {
        return listOperacoes;
    }

    public void setListOperacoes(List<Operacao> listOperacoes) {
        this.listOperacoes = listOperacoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usgId != null ? usgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioGrupo)) {
            return false;
        }
        UsuarioGrupo other = (UsuarioGrupo) object;
        if ((this.usgId == null && other.usgId != null) || (this.usgId != null && !this.usgId.equals(other.usgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.UsuarioGrupo[ usgId=" + usgId + " ]";
    }
    
}
