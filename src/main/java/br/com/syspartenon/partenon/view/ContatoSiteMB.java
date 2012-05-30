package br.com.syspartenon.partenon.view;

import br.com.syspartenon.partenon.business.ConfiguracaoBC;
import br.com.syspartenon.partenon.domain.Configuracao;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@ViewController
public class ContatoSiteMB {
    private String nome;
    private String email;
    private String assunto;
    private String mensagem;

    @Inject
    private ConfiguracaoBC configuracaoBC;

    @Inject
    private SiteMB siteMB;
    
    @Inject
    private MessageContext messageContext;
    
    private Configuracao configuracao;
    
    @PostConstruct
    public void inicializar() {
        configuracao = configuracaoBC.load(1);
    }
    
    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void enviarEmail(){
        try {
            SimpleEmail mailer = new SimpleEmail();
            mailer.setHostName(configuracao.getConSmtpServer());
            mailer.addTo(siteMB.getBean().getSitEmailContato());
            mailer.setFrom(email, nome);
            mailer.setSubject(assunto);
            mailer.setMsg(mensagem);
            mailer.setAuthentication(configuracao.getConSmtpUser(), configuracao.getConSmtpPassword());
            
            //configuracao gmailç
            mailer.setSmtpPort(465);  
            mailer.setSSL(true);  
            mailer.setTLS(true);  

            mailer.send();
            
            messageContext.add("Contato realizado com sucesso.", SeverityType.INFO);
        } catch (EmailException ex) {
            messageContext.add("Erro ao Enviar E-mail", SeverityType.ERROR);
            Logger.getLogger(ContatoSiteMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
