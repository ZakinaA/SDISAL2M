/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import DAO.ConnexionBdd;
import java.sql.Connection;

/**
 *
 * @author ts1sio
 */
public class test {
    public static void main(String[] args) {
        Connection con = ConnexionBdd.ouvrirConnexion();
        ConnexionBdd.fermerConnexion(con);
    }
    
    
}
