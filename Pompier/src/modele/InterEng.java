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
public class InterEng {
    private ArrayList<Engin>lesEngins;
    private ArrayList<Intervention>lesInterventions;
    
    
    public InterEng(){
         
    }
    
    public ArrayList<Engin> getLesEngins() {
        return lesEngins;
    }
    public ArrayList<Intervention> getLesInterventions() {
        return lesInterventions;
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
      public void setLesInterventions(ArrayList<Intervention> lesInterventions) {
        this.lesInterventions = lesInterventions;
    }

     public void addUneIntervention (Intervention pUneIntervention){
         if(lesInterventions == null){
             lesInterventions = new ArrayList<Intervention>(); 
         }
         lesInterventions.add(pUneIntervention);
          
     }
}
