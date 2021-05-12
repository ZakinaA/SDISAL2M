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
import modele.Grade;

/**
 *
 * @author ts1sio
 */
public class GradeDAO {
    
    Connection connection = null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    


public static ArrayList<Grade> getLesGrades(Connection connection){
ArrayList<Grade> lesGrades = new ArrayList<Grade>();
try
{
requete = connection.prepareStatement("SELECT * FROM grade");
// execute la requete vide  
rs=requete.executeQuery();

while(rs.next()){

Grade unGrade = new Grade();
unGrade.setLibelle(rs.getString("libelle"));
unGrade.setId(rs.getInt("grad_id"));
lesGrades.add(unGrade);

}
}
 catch (SQLException e){
                e.printStackTrace();
            }
            return lesGrades;
}

}
