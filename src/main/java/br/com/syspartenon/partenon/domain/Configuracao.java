package br.com.syspartenon.partenon.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "configuracao")
@SequenceGenerator(name="ConfiguracaoGen" , allocationSize=1)
public class Configuracao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "con_id")
    @GeneratedValue(generator="ConfiguracaoGen",strategy= GenerationType.SEQUENCE)
    private Integer conId;
    
    @Column(name = "con_smtp_server")
    private String conSmtpServer;
    
    @Column(name = "con_smtp_user")
    private String conSmtpUser;
    
    @Column(name = "con_smtp_password")
    private String conSmtpPassword;
    
    public Configuracao() {
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConSmtpPassword() {
        return conSmtpPassword;
    }

    public void setConSmtpPassword(String conSmtpPassword) {
        this.conSmtpPassword = conSmtpPassword;
    }

    public String getConSmtpServer() {
        return conSmtpServer;
    }

    public void setConSmtpServer(String conSmtpServer) {
        this.conSmtpServer = conSmtpServer;
    }

    public String getConSmtpUser() {
        return conSmtpUser;
    }

    public void setConSmtpUser(String conSmtpUser) {
        this.conSmtpUser = conSmtpUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracao)) {
            return false;
        }
        Configuracao other = (Configuracao) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Configuracao[ conId=" + conId + " ]";
    }
    
}
