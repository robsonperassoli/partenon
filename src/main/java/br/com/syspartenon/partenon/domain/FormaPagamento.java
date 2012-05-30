package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FORMA_PAGAMENTO")
public class FormaPagamento implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="FRP_ID")
    private Integer id;
    
    @Column(name="FRP_DESCRICAO")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
     
    
}
