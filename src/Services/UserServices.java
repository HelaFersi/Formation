/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Formation;
import Entities.Users;
import Utils.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HELA
 */
public class UserServices {
     Connection cnx;
    Statement ste;
    PreparedStatement pste;

    public UserServices() throws SQLException {
        cnx = DB.getInstance().getConnection();
        ste= cnx.createStatement();
       // pSte =cnx.prepareStatement(sql)
    }
    
     public void ajouter1(Users f) {
         String req = "insert into `user` ( `nom`, `prenom`,`username`,`password`,`role`,`adresse`,`num_tel`,`email`,`image`)  Values ('"+ f.getNom() +"' , '"+ f.getPrenom()+"','"+ f.getUsername()+"','"+ f.getPassword()+"','"+ f.getRole()+"','"+ f.getAdresse()+"','"+ f.getNum_tel()+"','"+ f.getEmail()+"','"+ f.getImage()+"');";
        try {                                                      
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
