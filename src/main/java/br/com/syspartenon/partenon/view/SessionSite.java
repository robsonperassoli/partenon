package br.com.syspartenon.partenon.view;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class SessionSite implements Serializable {
    private boolean votouEnquete = false;

    public boolean isVotouEnquete() {
        return votouEnquete;
    }

    public void setVotouEnquete(boolean votouEnquete) {
        this.votouEnquete = votouEnquete;
    }

}
