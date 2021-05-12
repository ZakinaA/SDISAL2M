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
public class ProVonl {
    private ArrayList<Volontaire>lesVonlontaires;
    private ArrayList<Profession>lesProfessions;
    
    
    public ProVonl(){
         
    }
    
    public ArrayList<Volontaire> getLesVonlontaires() {
        return lesVonlontaires;
    }
    public ArrayList<Profession> getLesProfessions() {
        return lesProfessions;
    }
     public void setLesVonlontaires(ArrayList<Volontaire> lesVonlontaires) {
        this.lesVonlontaires = lesVonlontaires;
    }

     public void addUnVonlontaire (Volontaire pUnVonlontaire){
         if(lesVonlontaires == null){
             lesVonlontaires = new ArrayList<Volontaire>(); 
         }
         lesVonlontaires.add(pUnVonlontaire);
          
     }
      public void setLesProfessions(ArrayList<Profession> lesProfessions) {
        this.lesProfessions = lesProfessions;
    }

     public void addUneProfession (Profession pUneProfession){
         if(lesProfessions == null){
             lesProfessions = new ArrayList<Profession>(); 
         }
         lesProfessions.add(pUneProfession);
          
     }
}
