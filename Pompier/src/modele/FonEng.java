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
public class FonEng {
    private double nombreIntervenant;
    private ArrayList<Fonction>lesFonctions;
    private ArrayList<Engin>lesEngins;
    public FonEng(){
    
    }
    public ArrayList<Fonction> getLesFonctions() {
        return lesFonctions;
    }
    public ArrayList<Engin> getLesEngins() {
        return lesEngins;
    }
    public FonEng(double nombreIntervenant) {
        this.nombreIntervenant = nombreIntervenant;
        
    }
    public double getNombreIntervenant() {
        return nombreIntervenant;
    }
    

    public void setNombreIntervenant(double nombreIntervenant) {
        this.nombreIntervenant = nombreIntervenant;
    }
    public void setLesFonctions(ArrayList<Fonction> lesFonctions) {
        this.lesFonctions = lesFonctions;
    }

     public void addUneFonction (Fonction pUneFonction){
         if(lesFonctions == null){
             lesFonctions = new ArrayList<Fonction>(); 
         }
         lesFonctions.add(pUneFonction);
          
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
