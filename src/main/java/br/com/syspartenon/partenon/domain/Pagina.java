package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pagina")
@SequenceGenerator(name="PaginaGen" , allocationSize=1)
public class Pagina implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "pgn_id")
    @GeneratedValue(generator="PaginaGen", strategy=GenerationType.SEQUENCE)
    private Integer pgnId;
    
    @Column(name = "pgn_titulo_menu")
    private String pgnTituloMenu;
    
    @Column(name = "pgn_titulo_pagina")
    private String pgnTituloPagina;
    
    @Lob
    @Column(name = "pgn_conteudo")
    private String pgnConteudo;
    
    @JoinColumn(name = "sit_id", referencedColumnName = "sit_id")
    @ManyToOne(optional = false)
    private Site site;

    public Pagina() {
    }

    public Pagina(Integer pgnId) {
        this.pgnId = pgnId;
    }

    public Integer getPgnId() {
        return pgnId;
    }

    public void setPgnId(Integer pgnId) {
        this.pgnId = pgnId;
    }

    public String getPgnTituloMenu() {
        return pgnTituloMenu;
    }

    public void setPgnTituloMenu(String pgnTituloMenu) {
        this.pgnTituloMenu = pgnTituloMenu;
    }

    public String getPgnTituloPagina() {
        return pgnTituloPagina;
    }

    public void setPgnTituloPagina(String pgnTituloPagina) {
        this.pgnTituloPagina = pgnTituloPagina;
    }

    public String getPgnConteudo() {
        return pgnConteudo;
    }

    public void setPgnConteudo(String pgnConteudo) {
        this.pgnConteudo = pgnConteudo;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgnId != null ? pgnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagina)) {
            return false;
        }
        Pagina other = (Pagina) object;
        if ((this.pgnId == null && other.pgnId != null) || (this.pgnId != null && !this.pgnId.equals(other.pgnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Pagina[ pgnId=" + pgnId + " ]";
    }
    
}
