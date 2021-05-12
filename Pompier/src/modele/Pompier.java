/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import modele.Compte;

/**
 *
 * @author ts1sio
 */
public class Pompier {
    private String matricule;
    private String nom;
    private String prenom;
    private String dtNaissance;
    private int numeroBip;
    private String sexe;
    private String telephone;
    private Caserne laCaserne;
    private Grade leGrade;
    private ArrayList<Compte>lesComptes;
    private ArrayList<Intervention>lesInterventions;
    private ArrayList<Fonction> lesFonctions;
    
    public Pompier(){
	}

    public Pompier(String matricule, String nom, String prenom, String dtNaissance, int numeroBip, String sexe, String telephone) {
        
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dtNaissance = dtNaissance;
        this.numeroBip = numeroBip;
        this.sexe = sexe;
        this.telephone = telephone;
    }
    public Pompier(Caserne laCaserne) {
        this.laCaserne = laCaserne;
    }
    
  
    public Pompier(Grade leGrade) {
        this.leGrade = leGrade;
    }      
    
    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public String getDtNaissance() {
        return dtNaissance;
    }
    public int getNumeroBip() {
        return numeroBip;
    }

    public String getSexe() {
        return sexe;
    }
    public String getTelephone() {
        return telephone;
    }

    public ArrayList<Compte> getLesComptes() {
        return lesComptes;
    }
    public ArrayList<Intervention> getLesInterventions() {
        return lesInterventions;
    }
    public ArrayList<Fonction> getLesFonctions(){
        return lesFonctions;
    }
    public Caserne getLaCaserne() {
        return laCaserne;
    }
    public Grade getLeGrade() {
        return leGrade;
    }
   
  
    
    
 
    
    
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDtNaissance(String dtNaissance) {
        this.dtNaissance = dtNaissance;
    }
    public void setNumeroBip(int numeroBip) {
        this.numeroBip = numeroBip;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setLaCaserne(Caserne laCaserne) {
        this.laCaserne = laCaserne;
    }
    public void setLeGrade(Grade leGrade) {
        this.leGrade = leGrade;
    }
 
    
    public void setLesFonctions(ArrayList<Fonction> lesFonctions){
        this.lesFonctions = lesFonctions;
    }
    public void setLesComptes(ArrayList<Compte> lesComptes) {
        this.lesComptes = lesComptes;
    }

     public void addUnCompte (Compte pUnCompte){
         if(lesComptes == null){
             lesComptes = new ArrayList<Compte>(); 
         }
         lesComptes.add(pUnCompte);
          
     }
     public void addUneFonction (Fonction pUneFonction){
         if(lesFonctions == null){
             lesFonctions = new ArrayList<Fonction>();
         }
         lesFonctions.add(pUneFonction);
     }
     public void setLesIntervention(ArrayList<Intervention> lesInterventions) {
        this.lesInterventions = lesInterventions;
    }

     public void addUneIntervention (Intervention pUneIntervention){
         if(lesInterventions == null){
             lesInterventions = new ArrayList<Intervention>(); 
         }
         lesInterventions.add(pUneIntervention);
          
     }
}