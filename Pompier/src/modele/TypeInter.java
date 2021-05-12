
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
public class TypeInter {
    private int id;
    private String libelle;
    private ArrayList<Intervention>lesInterventions;
    
    
    
    public TypeInter(){
    
    }
public TypeInter(int id, String libelle) {
        
        this.id = id;
        this.libelle = libelle;
    }    

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }
    public ArrayList<Intervention> getLesInterventions() {
        return lesInterventions;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void setLesIntervnetions(ArrayList<Intervention> lesInterventions) {
        this.lesInterventions = lesInterventions;
    }

     public void addUneIntervention (Intervention pUneIntervention){
         if(lesInterventions == null){
             lesInterventions = new ArrayList<Intervention>(); 
         }
         lesInterventions.add(pUneIntervention);
          
     }

}
