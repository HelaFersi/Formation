/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Inscription;
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
public class InscriptionsServices {

    //Connection cnx;
    Statement ste;
    private static FormationServices instance;
Connection cnx = DB.getInstance().getConnection();
    public InscriptionsServices() throws SQLException {
        
      //  ste = cnx.createStatement();
    }

//    public static FormationServices getInstance() {
//        if (instance == null) {
//            instance = new FormationServices();
//        }
//        return instance;
//    }

    public void ajouter(Inscription p) {
        try {
            PreparedStatement pre = cnx.prepareStatement("INSERT INTO `inscription` ( `user_id`, `formation_id`, `date`) VALUES ( ?, ?, ?);");
            pre.setInt(1, p.u1.getUser_id());
            pre.setInt(2, p.f.getFormation_id());
            pre.setDate(3, p.getDate());
            pre.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(InscriptionsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
