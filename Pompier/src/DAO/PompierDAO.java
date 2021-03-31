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
import modele.Compte;
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
            requete=connection.prepareStatement("SELECT * FROM pompier, compte WHERE COM_POMPIER = POMP_MATRICULE AND LOGIN=? AND MDP=? ");
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
}
