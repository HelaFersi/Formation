  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import Entities.Cours;
import Entities.Formation;
import Entities.Inscription;
import Entities.Users;
import Services.CoursServices;
import Services.FormationServices;
import Services.InscriptionsServices;
import Services.UserServices;
import java.sql.Date;
import java.sql.SQLException;
 

/**
 *
 * @author HELA
 */
public class Main {
     public static void main(String[] args) throws SQLException {
        Formation design1 = new Formation( "digital", "manzah");
         Users u2 = new Users( "baliz", "aaa", null,0, null, null, 0, null, null);
         Cours c1 = new Cours("fr", "debutant", "lala","5j");
         Cours c2 = new Cours("danse orientale ", "debutant", "yallaaa","2j");
         CoursServices cs = new CoursServices();
         UserServices us = new UserServices();
         
         
       
         //Cours c3 = new Cours("adobe", "debutant", "oh yeah","6j");
       //Formation f1 = new Formation(u1.getUser_id(), "dance", new Date(1377249026), "2h", "online", 50.50f, "beginner", "eng", 0,0, c1.getCours_id(), "dance on fire",);
   
    //Formation f1 = new Formation(0, domaine, date, duree, lieu, 0, niveau, langue, 0, description)
      FormationServices s1 = new FormationServices();

   // s1.ajouter1(design1);
     
      //   cs.ajouter1(c2);
       // us.ajouter1(u2); u2.getUser_id()
         Formation f1 = new Formation(25, "digital_art","2021-06-29 'at' 04:04:04", "2h", "online", 50.50f, "beginner", "eng", 0,0, "video editing",null,"adobe for video editing");
         
  InscriptionsServices i1 = new InscriptionsServices();
  Inscription p = new Inscription(u2, f1);
s1.ajouter(f1);
         //System.out.println(f1);
 i1.ajouter(p);
         System.out.println(p);
                 
// Formation f1 = new Formation(0, domaine, date, duree, lieu, 0, niveau, langue, 0, 0, 0, description);
          
        
//          
  // Formation f2 =new Formation(6, "design", new Date(1377249026), "2j", "tunis", 150.1f, "intermediate", "fr", 100, 5, 2, "go");
//  Formation f3 =new Formation(6, "music", "2021-06-29 'at' 04:04:04", "2j", "tunis", 150.1f, "intermediate", "fr", 100, 4, 2, "go",null);
//    s1.ajouter(f2);
 // s1.ajouter(f3);
//          
       // System.out.println(cs.readAll(c1));
         //System.out.println(s1.best());
        // System.out.println(s1.rechercheFormation(1));
     }
}
