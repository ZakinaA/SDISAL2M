/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modele.Compte;
import modele.Pompier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ts1sio
 */
public class CompteDAO {
    
Connection connection=null;
static PreparedStatement requete=null;
static ResultSet rs=null;
    
       
public static Compte getCompte(Connection connection, String login, String mdp) throws SQLException{
    try
    {
    requete=connection.prepareStatement("SELECT * FROM POMPIER , COMPTE" + " WHERE pomp_matricule = comp_id" + " AND login= ? and mdp= ?");
    requete.setString(1, login);
    requete.setString(2, mdp);
     
     rs=requete.executeQuery();
     
     Compte unCompte = new Compte();
     
      if (rs.next()){
        unCompte.setLogin(rs.getString("login"));
        unCompte.setMdp(rs.getString("mdp"));
        unCompte.setResponsable(rs.getInt("responsable"));
        
        
        Pompier unPompier = new Pompier();
        unPompier.setMatricule(rs.getString("pomp_matricule"));
        unPompier.setNom(rs.getString("nom"));
        unPompier.setPrenom(rs.getString("prenom"));
        
        
        unCompte.setLePompier(unPompier);
        ConnexionBdd.fermerConnexion(rs);
        ConnexionBdd.fermerConnexion(requete);
        return unCompte;
     
         }
    else{
        return null;
    }
}
catch (SQLException e)
{
    e.printStackTrace();
    return null;
}





















}
}
