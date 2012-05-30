package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ENQUETE_ALTERNATIVA")
@SequenceGenerator(name="AlternativaGen",allocationSize=1)
public class EnqueteAlternativa implements Serializable {
    
    @Id
    @Column(name="EAL_ID")
    @GeneratedValue(generator="AlternativaGen", strategy= GenerationType.SEQUENCE)
    private Long ealId;
    
    @JoinColumn(name = "ENQ_ID", referencedColumnName = "ENQ_ID")
    @ManyToOne(optional = false)
    private Enquete enquete;
    
    @Column(name="EAL_DESCRICAO")
    private String ealDescricao;
    
    @Column(name="EAL_RESPOSTAS")
    private Long ealRespostas = 0l;

    public String getEalDescricao() {
        return ealDescricao;
    }

    public void setEalDescricao(String ealDescricao) {
        this.ealDescricao = ealDescricao;
    }

    public Long getEalId() {
        return ealId;
    }

    public Long getEalRespostas() {
        return ealRespostas;
    }

    public Enquete getEnquete() {
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }
    
    public void incrementaRespostas(){
        this.ealRespostas++;
    }
}
