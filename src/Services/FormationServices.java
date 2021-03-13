/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Cours;
import IServices.IServices;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import Utils.DB;
import Entities.Formation;
import Entities.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.XYChart;
/**
 *
 * @author HELA
 */
public class FormationServices implements IServices{
    
    Connection cnx;
    Statement ste;
    PreparedStatement pste;
private static FormationServices instance;
     
    
    public FormationServices()  {
        try {
            cnx = DB.getInstance().getConnection();
            ste= cnx.createStatement();
            // pSte =cnx.prepareStatement(sql)
        } catch (SQLException ex) {
            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static FormationServices getInstance() {
        if(instance==null) 
            instance=new FormationServices();
        return instance;
    }

    @Override
    public void ajouter(Formation f)  {
//         ZoneId defaultZoneId = ZoneId.systemDefault();
//          (java.sql.Date) Date.from(f.getDate().atStartOfDay(defaultZoneId).toInstant())
        try {
            pste =cnx.prepareStatement("insert into formation (user_id ,domaine,date,durée, lieu,prix,niveau,langue,nbr_inscrits,notation,description,image,titre) "
                    //  + "values((select user_id=? from user)a,?,?,?,?,?,?,?,?,?,(select cours_id=? from cours) b,?);");
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?);");
            pste.setInt(1,25);
           // f.u1.getUser_id()
            pste.setString(2,f.getDomaine());
            pste.setString(3,f.getDate() );
            pste.setString (4,f.getDuree());
            pste.setString (5, f.getLieu());
            pste.setFloat(6, f.getPrix());
            pste.setString (7,f.getNiveau());
            pste.setString (8, f.getLangue());
            pste.setInt (9, f.getNbr_inscrits());
            pste.setInt(10, f.getNotation());
            
           // pste.setInt(11, f.getCours_id());
            
            pste.setString(11, f.getDescription());
            pste.setString(12, f.getImage());
            pste.setString(13, f.getTitre());
            pste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
//     public void ajouter12(Formation f) {
//         String req = "insert into formation (user_id ,domaine,date,durée, lieu,prix,niveau,langue,nbr_inscrits,notation,cours_id,description)"
//                 + "  Values ('"+ f.getDomaine() +"' , '"+ f.getLieu() +"');";
//        try {                                                      
//            ste.executeUpdate(req);
//        } catch (SQLException ex) {
//            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     }
//     public void ajouter1(Formation f) {
//         String req = "insert into `formation` ( `domaine`, `lieu`)  Values ('"+ f.getDomaine() +"' , '"+ f.getLieu() +"');";
//        try {                                                      
//            ste.executeUpdate(req);
//        } catch (SQLException ex) {
//            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     }

    @Override
    public void delete(Formation f) throws SQLException {
    String req = "delete from formation where " + "formation_id=?" ;
    Formation p=readById(f.getFormation_id());
    
     if(f!=null)
               {
          pste=cnx.prepareStatement(req);
          pste.setInt(1, f.getFormation_id());
          pste.executeUpdate();}
    }

    @Override
    public void update(Formation f ) throws SQLException {
        String req = "update  formation set domaine=?, date = ?, duree=?, lieu=?,"
              + "prix = ?  , langue=?, niveau=?, description=?, image=?; " ; 
          pste=cnx.prepareStatement(req);
           pste.setInt(1,f.getUser_id());
           pste.setString(2,f.getDomaine());
            pste.setString(3,f.getDate() );
            pste.setString (4,f.getDuree());
            pste.setString (5, f.getLieu());
            pste.setFloat(6, f.getPrix());
            pste.setString (7,f.getNiveau());
            pste.setString (8, f.getLangue());
            //maybe i should remove this
          //  pste.setInt (, f.getNbr_inscrits());
            //pste.setInt(10, f.getNotation());
            pste.setInt(9, f.getCours_id());
            pste.setString(10, f.getDescription());
            pste.setString(11, f.getImage());
            pste.executeUpdate();
     
    }

    @Override
    public List readAll() throws SQLException {
        List <Formation> formations = new   ArrayList();
        String req = "select * from formation;";
//         String req = "select * from formation where domaine=?, date between '?' and '?', duree=?, lieu=?,"
//                 + "prix between '?' and '?' , langue=?, niveau=?; " ; 
//           
         ResultSet rs= ste.executeQuery(req);
         
             while(rs.next()){
                  Formation f1 = new Formation();
                   // f1.setFormation_id(rs.getInt("formation_id"));
                         
               // formations.add(new Formation(rs.getInt(1),rs.getString("image")));
               f1.setUser_id(rs.getInt("user_id"));
               f1.setDescription(rs.getString("description"));
               f1.setImage(rs.getString("image"));
               f1.setPrix(rs.getFloat("prix"));
               formations.add(f1);
//                 
//            formations.add(new Formation(rs.getInt("user_id"),rs.getString("domaine"),rs.getString("date"), rs.getString("durée"), rs.getString("lieu"), rs.getFloat("prix"), rs.getString("niveau"),
//                    rs.getString("langue"), 0, 0, 0, rs.getString("description"), rs.getString("image")) );
       // formations.add(new Formation(0, req, req, req, req, 0, req, req, 0, 0, 0, req, req) )
             }
   return formations;
    }
    
    
     public List readAll(int user_id) {
          String req =     "select * from formation where user_id= "+user_id;
          List <Formation> formations = new   ArrayList();
        try {
           
            ResultSet rs= ste.executeQuery(req);
            while(rs.next()){
                Formation f1 = new Formation();
                    f1.setUser_id(rs.getInt("user_id"));
                         
               // formations.add(new Formation(rs.getInt(1),rs.getString("image")));
               f1.setFormation_id(rs.getInt("formation_id"));
               f1.setDescription(rs.getString("description"));
               f1.setImage(rs.getString("image"));
               f1.setPrix(rs.getFloat("prix"));
                f1.setDuree(rs.getString("durée"));
                 f1.setNiveau(rs.getString("niveau"));
                  f1.setLangue(rs.getString("langue"));
               f1.setLieu(rs.getString("lieu"));
               f1.setDomaine(rs.getString("domaine"));
               f1.setDate(rs.getString("date"));
               formations.add(f1);
            }
                    } 
        catch (SQLException ex) {
            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formations;
    }
     
         public Formation readById(int id) throws SQLException {
           String req="select * from formation where formation_id ="+id;
          Formation f1 = new Formation();
          
       
             ResultSet rs=ste.executeQuery(req);
           while(rs.next()){
            
              f1.setFormation_id(rs.getInt("formation_id"));
                         
               // formations.add(new Formation(rs.getInt(1),rs.getString("image")));
               f1.setUser_id(rs.getInt("user_id"));
               f1.setDescription(rs.getString("description"));
               f1.setImage(rs.getString("image"));
               f1.setPrix(rs.getFloat("prix"));
               f1.setDuree(rs.getString("durée"));
               f1.setLieu(rs.getString("lieu"));
               f1.setDomaine(rs.getString("domaine"));
               f1.setDate(rs.getString("date"));;
               System.out.println(f1);
            }  
      
    return f1;
    }
     
      public List<Formation> afficherForAdmin() {
        String req="SELECT * FROM `formation`WHERE `isvalid`=0";
        List<Formation> listf =new ArrayList<>();
        
        try {
           Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                Formation f1 =new Formation();
             f1.setFormation_id(rs.getInt("formation_id"));
                         
               // formations.add(new Formation(rs.getInt(1),rs.getString("image")));
               f1.setUser_id(rs.getInt("user_id"));
               f1.setDescription(rs.getString("description"));
               f1.setImage(rs.getString("image"));
               f1.setPrix(rs.getFloat("prix"));
               f1.setDuree(rs.getString("durée"));
               f1.setLieu(rs.getString("lieu"));
               f1.setDomaine(rs.getString("domaine"));
               f1.setDate(rs.getString("date"));
                       
               listf.add(f1);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return listf;
    }
     
    public List order() throws SQLException {
        List <Formation> formations = new   ArrayList();
     String req="select sum(notation) as rating, domaine from formation order by rating ";
         ResultSet rs= ste.executeQuery(req);
             while(rs.next()){
        //    formations.add(new Formation(rs.getString("domaine"), rs.getInt("rating")));
        }
   return formations;
    }
    
    
    public  XYChart.Series<String, Integer>  bestDomain() {
         XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
          try {
             
              String req="select count(domaine) as somme_domaine, domaine from formation group by domaine ";
              
              Statement ste=cnx.createStatement();
              ResultSet res=ste.executeQuery(req);
               while (res.next()){
                series.getData().add(new XYChart.Data<>(res.getString("domaine"), res.getInt("somme_domaine")));
            }
               
             
          } catch (SQLException ex) {
              Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
          }
       return series;
    }
    
    public void valider(Formation f) throws SQLException{
        //Formation f1 =new Formation();
    String req= "update formation set isvalid=? where formation_id="+f.getFormation_id();
  pste=cnx.prepareStatement(req);
     pste.setInt(1,1);
//          
   pste.executeUpdate();}
       
//          ste.executeUpdate(req);
    
          
          
public List <Formation> tri_prix() throws SQLException{
List <Formation> listP = new ArrayList<>();
String req = "SELECT * FROM formation order by prix asc";
 Statement ps = cnx.createStatement();
            ResultSet rs;
            rs = ps.executeQuery(req);
 while(rs.next())
            {
                int user_id= rs.getInt("user_id");
                
               String desc =rs.getString("description");
               String img =rs.getString("image");
             float prix= rs.getFloat("prix");
              String dur= rs.getString("durée");
              String lieu= rs.getString("lieu");
              String dom= rs.getString("domaine");
              String date= rs.getString("date");  
              String niv =rs.getString("niveau");
              String lang = rs.getString("langue");
              String titre = rs.getString("titre");
              Formation f = new Formation(user_id, dom, date, dur, lieu, prix, niv, lang, 0, 0, desc,img, titre);
           // Formation f = new Formation(user_id, dom, date, dur, lieu, prix, niv, lang, user_id, user_id, desc, img, titre)
                    
              listP.add(f)  ;          }
 return listP;
}  
  
    public List<Formation> rechercherFor(String titre) throws SQLException {
         ArrayList<Formation> listef = new ArrayList<Formation>();
        
            Statement ps = cnx.createStatement();
            ResultSet rs;
             rs = ps.executeQuery("select * from formation where titre like '%"+titre+"%'");
            while(rs.next())
            {
                int user_id= rs.getInt("user_id");
                
               String desc =rs.getString("description");
               String img =rs.getString("image");
             float prix= rs.getFloat("prix");
              String dur= rs.getString("durée");
              String lieu= rs.getString("lieu");
              String dom= rs.getString("domaine");
              String date= rs.getString("date");  
              String niv =rs.getString("niveau");
              String lang = rs.getString("langue");
              Formation f = new Formation(user_id, dom, date, dur, lieu, prix, niv, lang, 0, 0, desc,img, titre);
           // Formation f = new Formation(user_id, dom, date, dur, lieu, prix, niv, lang, user_id, user_id, desc, img, titre)
                    
              listef.add(f)  ;          }
         
          // System.out.println("Erreur d'affichage "+f.getMessage());
          return listef;
    
    }
         
}
