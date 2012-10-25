package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "operacao")
@SequenceGenerator(name="OperacaoGen" , allocationSize=1)
public class Operacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ope_id")
    @GeneratedValue(generator="OperacaoGen", strategy= GenerationType.SEQUENCE)
    private Integer opeId;
    
    @Column(name = "ope_descricao")
    private String opeDescricao;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Recurso recurso; 

    @ManyToMany(cascade=CascadeType.REFRESH)
    @JoinTable(name="USUARIO_GRUPO_OPERACAO",
            joinColumns=@JoinColumn(name="OPE_ID"),
            inverseJoinColumns=@JoinColumn(name="USG_ID")
    )
    private List<UsuarioGrupo> usuarioGrupos = new ArrayList<UsuarioGrupo>();
    
    public Operacao() {
    }

    public Operacao(Integer opeId) {
        this.opeId = opeId;
    }

    public Integer getOpeId() {
        return opeId;
    }

    public void setOpeId(Integer opeId) {
        this.opeId = opeId;
    }

    public String getOpeDescricao() {
        return opeDescricao;
    }

    public void setOpeDescricao(String opeDescricao) {
        this.opeDescricao = opeDescricao;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public List<UsuarioGrupo> getUsuarioGrupos() {
        return usuarioGrupos;
    }

    public void setUsuarioGrupos(List<UsuarioGrupo> usuarioGrupos) {
        this.usuarioGrupos = usuarioGrupos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opeId != null ? opeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacao)) {
            return false;
        }
        Operacao other = (Operacao) object;
        if ((this.opeId == null && other.opeId != null) || (this.opeId != null && !this.opeId.equals(other.opeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Operacao[ opeId=" + opeId + " ]";
    }
    
    
}
