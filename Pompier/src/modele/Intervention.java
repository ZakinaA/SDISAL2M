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
public class Intervention {
    private int id;
    private String lieu;
    private String dtIntervention;
    private String duree;
    private String heureAppel;
    private String heureArrivee;
    private TypeInter leTypeInter;
    private InterEng leInterEng;
    private ArrayList<Pompier>lesPompiers;
    
    public Intervention(){

    }
    
    public Intervention (int id, String lieu, String dtIntervention, String duree, String heureAppel, String heureArrivee) {
        
        this.id = id;
        this.lieu = lieu;
        this.dtIntervention = dtIntervention;
        this.duree = duree;
        this.heureAppel = heureAppel;
        this.heureArrivee = heureArrivee;
      
    }    
    
    public int getId() {
        return id;
    }
    public Intervention(TypeInter leTypeInter) {
        this.leTypeInter = leTypeInter;
    }
    public Intervention(InterEng leInterEng) {
        this.leInterEng = leInterEng;
    }
    

    public String getLieu() {
        return lieu;
    }
    public String getDtIntervention() {
        return dtIntervention;
    }

    public String getDuree() {
        return duree;
    }
    public String getHeureAppel() {
        return heureAppel;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }
    public TypeInter getLeTypeInter() {
        return leTypeInter;
    }
  
     public InterEng getLeInterEng() {
        return leInterEng;
    }
    public ArrayList<Pompier> getLesPompiers() {
        return lesPompiers;
    }
    
    public void setId (int id) {
        this.id = id;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    public void setDtIntervention(String dtIntervention) {
        this.dtIntervention = dtIntervention;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }
    public void setHeureAppel(String heureAppel) {
        this.heureAppel = heureAppel;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }
    public void setLeTypeInter(TypeInter leTypeInter) {
        this.leTypeInter = leTypeInter;
    }
     public void setLeInterEng(InterEng leInterEng) {
        this.leInterEng = leInterEng;
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
