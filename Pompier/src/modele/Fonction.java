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
public class Fonction {
    private int id;
    private String libelle;
    private FonEng leFonEng;

public Fonction(){
    
}
public Fonction(int id, String libelle) {
        
        this.id = id;
        this.libelle = libelle;
    }

    public Fonction(FonEng leFonEng) {
        this.leFonEng = leFonEng;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }
    
    public FonEng getLeFonEng() {
        return leFonEng;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

     public void setLeFonEng(FonEng leFonEng) {
        this.leFonEng = leFonEng;
    }
}
