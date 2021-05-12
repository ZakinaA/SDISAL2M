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
public class Engin {
    
private int id ;
private String numOrdre;
private String type;
private Caserne laCaserne;
private InterEng leInterEng;
private FonEng leFonEng;
    

public Engin(){
	}

    public Engin(int id, String numOrdre, String type) {
        this.id = id;
        this.numOrdre = numOrdre;
        this.type = type;
    }
    public Engin(Caserne laCaserne) {
        this.laCaserne = laCaserne;
    }
    public Engin(FonEng leFonEng) {
        this.leFonEng = leFonEng;
    }
    public Engin(InterEng leInterEng) {
        this.leInterEng = leInterEng;
    }

    public int getId() {
        return id;
    }

    public String getNumOrdre() {
        return numOrdre;
    }

    public String getType() {
        return type;
    }
     public Caserne getLaCaserne() {
        return laCaserne;
    }
    public InterEng getLeInterEng() {
        return leInterEng;
    }
    public FonEng getLeFonEng() {
        return leFonEng;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumOrdre(String numOrdre) {
        this.numOrdre = numOrdre;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setLaCaserne(Caserne laCaserne) {
        this.laCaserne = laCaserne;
    }
    public void setLeInterEng(InterEng leInterEng) {
        this.leInterEng = leInterEng;
    }
    public void setLeFonEng(FonEng leFonEng) {
        this.leFonEng = leFonEng;
    }
}

