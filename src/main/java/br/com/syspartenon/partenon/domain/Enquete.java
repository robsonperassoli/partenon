package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="ENQUETE")
@SequenceGenerator(name="EnqueteGen",allocationSize=1)
public class Enquete implements Serializable {
    
    @Id
    @Column(name="ENQ_ID")
    @GeneratedValue(generator="EnqueteGen", strategy= GenerationType.SEQUENCE)
    private Long enqId;
    
    
    @Column(name="ENQ_DESCRICAO")
    private String enqDescricao;
    
    @Column(name="ENQ_EXPIRACAO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date enqExpiracao = new Date();
    
    @Column(name="ENQ_INICIO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date enqInicio = new Date();
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "EVT_ID")
    private Evento evento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enquete")
    private List<EnqueteAlternativa> alternativas = new ArrayList<EnqueteAlternativa>() ;

    public List<EnqueteAlternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<EnqueteAlternativa> alternativas) {
        this.alternativas = alternativas;
    }
            
    public String getEnqDescricao() {
        return enqDescricao;
    }

    public void setEnqDescricao(String enqDescricao) {
        this.enqDescricao = enqDescricao;
    }

    public Long getEnqId() {
        return enqId;
    }

    public void setEnqId(Long enqId) {
        this.enqId = enqId;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Date getEnqExpiracao() {
        return enqExpiracao;
    }

    public void setEnqExpiracao(Date enqExpiracao) {
        this.enqExpiracao = enqExpiracao;
    }

    public Date getEnqInicio() {
        return enqInicio;
    }

    public void setEnqInicio(Date enqInicio) {
        this.enqInicio = enqInicio;
    }

    
}
