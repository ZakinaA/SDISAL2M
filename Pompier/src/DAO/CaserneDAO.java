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
import modele.Grade;

/**
 *
 * @author ts1sio
 */
public class CaserneDAO {
    
    Connection connection = null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    


public static ArrayList<Caserne> getLesCasernes(Connection connection){
ArrayList<Caserne> lesCasernes = new ArrayList<Caserne>();
try
{
requete = connection.prepareStatement("SELECT * FROM caserne");
// execute la requete vide  
rs=requete.executeQuery();

while(rs.next()){

Caserne uneCaserne = new Caserne();
uneCaserne.setNom(rs.getString("cas_nom"));
uneCaserne.setId(rs.getInt("caserne_id"));
uneCaserne.setRue(rs.getString("rue"));
uneCaserne.setCodePostale(rs.getString("copos"));
uneCaserne.setVille(rs.getString("ville"));
lesCasernes.add(uneCaserne);

}
}
 catch (SQLException e){
                e.printStackTrace();
            }
            return lesCasernes;
}

}
