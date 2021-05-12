/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author ts1sio
 */
public class Compte {
    
private int id ;
private String login;
private String mdp;
private int responsable;
private Pompier lePompier;


// Construction des constructeurs 
public Compte(){
    
}

    public Compte(int id, String login, String mdp, int responsable) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.responsable = responsable;
    }

    public Compte(Pompier lePompier) {
        this.lePompier = lePompier;
    }
    
// Construction des getters

    public int getId() {
        return id;
    }


    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public int getResponsable() {
        return responsable;
    }

    public Pompier getLePompier() {
        return lePompier;
    }
    
    

// Construction des setters

    public void setId(int id) {
        this.id = id;
    }



    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public void setLePompier(Pompier lePompier) {
        this.lePompier = lePompier;
    }

    
    
}

