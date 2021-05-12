/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Caserne;
import modele.Compte;
import modele.Fonction;
import modele.Grade;
import modele.Intervention;
import modele.Pompier;

/**
 *
 * @author ts1sio
 */
public class PompierDAO {
    Connection connection = null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
       public static Pompier getPompier(Connection connection, String login, String mdp){
            Pompier unPompier = new Pompier();
            try{
            requete=connection.prepareStatement("SELECT * FROM pompier, compte, grade, caserne  WHERE compte.COM_POMPIER = pompier.POMP_MATRICULE AND grade.GRAD_ID = pompier.POMP_GRADE AND caserne.CASERNE_ID = pompier.POMP_CASERNE AND compte.LOGIN=? AND compte.MDP=? ");
            requete.setString(1, login);
            requete.setString(2, mdp);
            
            rs = requete.executeQuery();
            if( rs.next()){
                unPompier.setMatricule(rs.getString("POMP_MATRICULE"));
                unPompier.setNom(rs.getString("NOM"));
                unPompier.setPrenom(rs.getString("PRENOM"));
                unPompier.setDtNaissance(rs.getString("DATENAISSANCE"));
                unPompier.setNumeroBip(rs.getInt("NUMEROBIP"));
                unPompier.setSexe(rs.getString("SEXE"));
                unPompier.setTelephone(rs.getString("TELEPHONE"));
                
                Grade g = new Grade();
                g.setLibelle(rs.getString("LIBELLE"));
                g.setId(rs.getInt("GRAD_ID"));
                
                Caserne c = new Caserne();
                c.setId(rs.getInt("CASERNE_ID"));
                c.setNom(rs.getString("CAS_NOM"));
                c.setRue(rs.getString("RUE"));
                c.setCodePostale(rs.getString("COPOS"));
                c.setVille(rs.getString("VILLE"));
                
                unPompier.setLeGrade(g);
                unPompier.setLaCaserne(c);
                String mat = unPompier.getMatricule();
                
                requete=connection.prepareStatement("SELECT * FROM fonction, pompier, pomfonc WHERE fonction.FONCT_CODE = pomfonc.POMFONC_CODE AND pompier.POMP_MATRICULE = pomfonc.POMFONC_MATRICULE AND pompier.POMP_MATRICULE =?");
  
                requete.setString(1, mat);
                   
                rs = requete.executeQuery();
                while(rs.next()){
                    Fonction uneFonction = new Fonction();
                    uneFonction.setId(rs.getInt("FONCT_CODE"));
                    uneFonction.setLibelle(rs.getString("FON_LIBELLE"));
                        
                    unPompier.addUneFonction(uneFonction);
                }
                               
                Compte leCompte = new Compte();
                leCompte.setLogin(rs.getString("LOGIN"));
                leCompte.setMdp(rs.getString("MDP"));
                unPompier.addUnCompte(leCompte);
                
            }
            
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return unPompier;
    }
         public static ArrayList<Intervention> getLesInterventions (Connection connection, String matricule ){
         ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
        try{
    requete=connection.prepareStatement("SELECT * FROM intervention,pompier,pominter  WHERE intervention.INTER_ID = pominter.INTER_ID AND pompier.POMP_MATRICULE=pominter.POMP_MATRICULE  AND pompier.POMP_MATRICULE=?");
    requete.setString(1, matricule);
     
     rs=requete.executeQuery();
     
     Intervention uneIntervention = new Intervention();
     
      while (rs.next()){
        uneIntervention.setId(rs.getInt("inter_id"));
        uneIntervention.setLieu(rs.getString("lieu"));
        uneIntervention.setDtIntervention(rs.getString("dtinter"));
        uneIntervention.setDuree(rs.getString("duree"));
        uneIntervention.setHeureAppel(rs.getString("heureappel"));
        uneIntervention.setHeureArrivee(rs.getString("heurearrivee"));
        lesInterventions.add(uneIntervention);
      }
        ConnexionBdd.fermerConnexion(rs);
        ConnexionBdd.fermerConnexion(requete);
     
         
}
catch (SQLException e){

    e.printStackTrace();
   }
    return lesInterventions;
}
 
public static Pompier getLesPompiers(Connection connection){
            Pompier unPompier = new Pompier();
            try{
            requete=connection.prepareStatement("SELECT * FROM pompier");
            
            
            rs = requete.executeQuery();
            while( rs.next()){
                unPompier.setMatricule(rs.getString("POMP_MATRICULE"));
                unPompier.setNom(rs.getString("NOM"));
                unPompier.setPrenom(rs.getString("PRENOM"));
                unPompier.setDtNaissance(rs.getString("DATENAISSANCE"));
                //unPompier.setNumeroBip(rs.getInt("NUMEROBIP"));
                unPompier.setSexe(rs.getString("SEXE"));
                unPompier.setTelephone(rs.getString("TELEPHONE"));
                
                Grade g = new Grade();
                g.setLibelle(rs.getString("LIBELLE"));
                g.setId(rs.getInt("GRAD_ID"));
                unPompier.setLeGrade(g);
                
                
                
            }
            
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return unPompier;
    }
   public static int addPompier (Connection connection,Pompier lePompier){
           int resultatUpdate =-1;
            try{
            requete = connection.prepareStatement ("INSERT INTO pompier (POMP_MATRICULE,POMP_CASERNE, POMP_GRADE,NOM,PRENOM,DATENAISSANCE,NUMEROBIP, SEXE,TELEPHONE) values (?,?,?,?,?,?,?,?,?)");
            requete.setString(1, lePompier.getMatricule());
            requete.setInt(2, lePompier.getLaCaserne().getId());
            requete.setInt(3, lePompier.getLeGrade().getId());
            requete.setString(4, lePompier.getNom());
            requete.setString(5, lePompier.getPrenom());
            requete.setString(6, lePompier.getDtNaissance());
            requete.setInt(7, lePompier.getNumeroBip());
            requete.setString(8, lePompier.getSexe());
            requete.setString(9, lePompier.getTelephone());
            
            resultatUpdate = requete.executeUpdate();
            
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
            
            
            
        
          
            }
            
         
            
            catch (SQLException e){
                e.printStackTrace();
            }
            
            
            
            
            return resultatUpdate;
       }
          
}
       
       

