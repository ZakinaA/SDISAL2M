/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class Caserne {
    private int id;
    private String nom;
    private String rue;
    private String codePostale;
    private String ville;
    private ArrayList<Pompier>lesPompiers;
    private ArrayList<Engin>lesEngins;

    public Caserne(){

}
    public Caserne(int id, String nom, String rue, String codePostale, String ville) {
        
        this.id = id;
        this.nom = nom;
        this.rue = rue;
        this.codePostale = codePostale;
        this.ville = ville;
       
    }    
	public int getId() {
        return id;
    }

        
    public String getNom() {
        return nom;
    }
    public String getRue() {
        return rue;
    }

    public String getCodePostale() {
        return codePostale;
    }
    public String getVille() {
        return ville;
    }
    public ArrayList<Pompier> getLesPompiers() {
        return lesPompiers;
    }
    public ArrayList<Engin> getLesEngins() {
        return lesEngins;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public void setLesPompiers(ArrayList<Pompier> lesPompiers) {
        this.lesPompiers = lesPompiers;
    }

     public void addUnPompier (Pompier pUnPompier){
         if(lesPompiers == null){
             lesPompiers = new ArrayList<Pompier>(); 
         }
         lesPompiers.add(pUnPompier);
          
     }
    public void setLesEngins(ArrayList<Engin> lesEngins) {
        this.lesEngins = lesEngins;
    }

     public void addUnEngin (Engin pUnEngin){
         if(lesEngins == null){
             lesEngins = new ArrayList<Engin>(); 
         }
         lesEngins.add(pUnEngin);
          
     }
}