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
public class Profession {
    
    private int id ;
    private String libelle ;
    private String ville;
    private ProVonl leProVonl;
    

public Profession (){
	}

    public Profession(int id, String libelle, String ville) {
        this.id = id;
        this.libelle = libelle;
        this.ville = ville;
    }
    public Profession(ProVonl leProVonl) {
        this.leProVonl = leProVonl;
    }
    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getVille() {
        return ville;
    }
     public ProVonl getLeProVonl() {
        return leProVonl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    public void setLeProVonl(ProVonl leProVonl) {
        this.leProVonl = leProVonl;
    }

}