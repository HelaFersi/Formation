/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Cours;
import Entities.Formation;
import Entities.Inscription;
import Services.CoursServices;
import Services.FormationServices;
import Services.InscriptionsServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import xcode.controllers.ACCUEILController;

/**
 * FXML Controller class
 *
 * @author HELA
 */
public class AfficherCoursController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private Label desc;
    @FXML
    private ImageView file;
    @FXML
    private Label titre;
    @FXML
    private Label duree;
    @FXML
    private Label niveau;
    

    /**
     * Initializes the controller class.
     */
      private static Formation a ;
      
     //  FormationServices fs = FormationServices.getInstance();
     public static void setF (Formation f ){
        a=f;
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            CoursServices cs = new CoursServices();
            List <Cours> cours = new   ArrayList();
            cours.addAll(cs.readAll(a));
            System.out.println("hhh");
            
            // TODO
            File newFile2 = new File("C:\\xampp\\htdocs\\PI\\IMG\\" + cours.get(0).getFile());
            file.setImage(new Image(newFile2.toURI().toString()));
            desc.setText(cours.get(0).getDescription());
            titre.setText(cours.get(0).getTitre());
            duree.setText(cours.get(0).getDuree());  
            niveau.setText(cours.get(0).getNiveau());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
     
    @FXML
    private void backFor(ActionEvent event) {
          try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/View/AfficherFor.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherCoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

//    @FXML
//    private void AjouerFormationController(ActionEvent event) {
//          
//          try {
//                Inscription i = new Inscription();
//                InscriptionsServices in =new InscriptionsServices();
//                in.ajouter(i);
//               
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setTitle("Inscription Dialog");
//                alert.setHeaderText(null);
//                alert.setContentText("Welcome to the course !");
//                alert.show();
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(AfficherCoursController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
     
    }
    
