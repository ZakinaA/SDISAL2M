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
public class Grade {
   
    private int id;
    private String libelle;
    private ArrayList<Pompier>lesPompiers;
    
    
    public Grade(){
    
    }
public Grade(int id, String libelle) {
        
        this.id = id;
        this.libelle = libelle;
    }    

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }
    public ArrayList<Pompier> getLesPompiers() {
        return lesPompiers;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
}
