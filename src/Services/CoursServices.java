/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DB;
import Entities.Cours;
import Entities.Formation;

import IServices.IServicesCours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HELA
 */
public class CoursServices implements IServicesCours{
      Connection cnx;
    Statement ste;
    PreparedStatement pste;
 //   private static CoursServices instance;

    public CoursServices()  {
          try {
              cnx = DB.getInstance().getConnection();
              ste= cnx.createStatement();
              // pSte =cnx.prepareStatement(sql)
          } catch (SQLException ex) {
              Logger.getLogger(CoursServices.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
//    public static CoursServices getInstance() throws SQLException {
//        if(instance==null) 
//            instance=new CoursServices();
//        return instance;
//    }
     public void ajouter1(Cours c) {
          try {
              String req = "insert into `cours` ( `titre`, `niveau`,`description`,`durée`,`image`,`formation_id`)  Values ('"+ c.getTitre() +"' , '"+ c.getNiveau() +"','"+ c.getDescription() +"','"+ c.getDuree() +"','"+ c.getFile() +"','"+ c.getFormation_id()+"');";
              
              ste.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(CoursServices.class.getName()).log(Level.SEVERE, null, ex);
          }
        
     }

    @Override
    public void ajouter(Cours c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Cours c) throws SQLException {
      String req = "delete from formation where " + "formation_id=?";
    pste=cnx.prepareStatement(req);
    }

    @Override
    public void update(Cours c) throws SQLException {
        try {
            
            PreparedStatement pste = cnx.prepareStatement("update cours set titre=?, niveau=?, description=? , duree=? where id_cours=?");
            pste.setString(1,c.getTitre());
            pste.setString(2,c.getNiveau());
            pste.setString(3,c.getDescription());
            pste.setString(4,c.getDuree());
            pste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoursServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cours> readAll(Cours c) throws SQLException {
        List <Cours> cours =   new ArrayList<>();
             PreparedStatement pste = cnx.prepareStatement( "select * from cours where titre=? and  niveau=? and description=? and duree=? ");
             pste.setString(1,c.getTitre());
            pste.setString(2,c.getNiveau());
            pste.setString(3,c.getDescription());
            pste.setString(4,c.getDuree());
            pste.executeQuery();       
           ResultSet rs= pste.executeQuery();
                while(rs.next()){
            cours.add(new Cours(rs.getString("titre"), rs.getString("niveau"), rs.getString("description"),rs.getString("durée"),rs.getInt("formation_id")));
        //cours.add(c);
                }
           return cours;
    }
    
//    "select count(nbr_inscrit) from formation where formation_id=? "
    
//date between '?' and '?'

    @Override
    public List<Cours> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        public List<Cours> readAll(Formation f ) throws SQLException {
     String req =     "select * from cours where formation_id= "+f.getFormation_id();
          List <Cours> cours = new   ArrayList();
          
            ResultSet rs= ste.executeQuery(req);
            while(rs.next()){
                Cours c = new Cours();
                c.setFormation_id(rs.getInt("formation_id"));
                c.setTitre(rs.getString("titre"));
                c.setDescription(rs.getString("description"));
                c.setDuree(rs.getString("durée"));
                c.setNiveau(rs.getString("niveau"));
                c.setFile(rs.getString("image"));
                cours.add(c);
            }
    
return cours;
    
    
}
}
