package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "imagem")
@SequenceGenerator(name="ImagemGen" , allocationSize=1)
public class Imagem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "img_id")
    @GeneratedValue(generator="ImagemGen",strategy= GenerationType.SEQUENCE)
    private Integer imgId;
    
    @Column(name = "img_nome")
    private String imgNome;
    
    @JoinColumn(name = "cmd_id", referencedColumnName = "cmd_id")
    @ManyToOne(optional = false)
    private Comodo comodo;
    
    public Imagem() {
    }

    public Imagem(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgNome() {
        return imgNome;
    }

    public void setImgNome(String imgNome) {
        this.imgNome = imgNome;
    }
    
    public Comodo getComodo() {
        return comodo;
    }

    public void setComodo(Comodo comodo) {
        this.comodo = comodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imgId != null ? imgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagem)) {
            return false;
        }
        Imagem other = (Imagem) object;
        if ((this.imgId == null && other.imgId != null) || (this.imgId != null && !this.imgId.equals(other.imgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Imagem[ imgId=" + imgId + " ]";
    }
    
}
