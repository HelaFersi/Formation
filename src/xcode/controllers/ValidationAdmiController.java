/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xcode.controllers;

import Entities.Formation;
import Services.FormationServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HELA
 */
public class ValidationAdmiController implements Initializable {

    @FXML
    private Button gest;
    @FXML
    private Button mdp;
    @FXML
    private Button role;
    @FXML
    private Button event;
    @FXML
    private Button favoris;
    @FXML
    private Button form;
    @FXML
    private Button event1;
    @FXML
    private Label adesco;
    @FXML
    private ImageView imgV;
    @FXML
    private Label lieu;
    @FXML
    private Label aprixo;
    @FXML
    private Button valider;
    @FXML
    private Label adomaino;
    @FXML
    private Label niv;
    @FXML
    private Label lang;
    @FXML
    private Label date;
    @FXML
    private Label duree;

    /**
     * Initializes the controller class.
     */
    
    private static Formation a ;
    private  Formation f;
     FormationServices fs = FormationServices.getInstance();
     public static void setF (Formation f ){
        a=f;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          File newFile2 = new File("C:\\xampp\\htdocs\\PI\\IMG\\" + a.getImage());
        imgV.setImage(new Image(newFile2.toURI().toString()));
         adesco.setText(a.getDescription());
        aprixo.setText(String.valueOf(a.getPrix()));
         adomaino.setText(a.getDomaine());
         lang.setText(a.getLangue());
          niv.setText(a.getNiveau());
          lieu.setText(a.getLieu());
          duree.setText(a.getDuree());
          date.setText(a.getDate());
                 }    

    @FXML
    private void validerO(ActionEvent event) throws SQLException {
           //ValidationAdmiController.setF(f);
          if(alert("Voulez vous vraiment valider cette formation?").get()==ButtonType.OK)
          {  fs.valider(a); try {
              Parent page1 = FXMLLoader.load(getClass().getResource("/View/AdminNotif.fxml"));
              Scene scene = new Scene(page1);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
              } catch (IOException ex) {
                  Logger.getLogger(ValidationAdmiController.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
            
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Dialog");
        alert.setHeaderText(null);
     alert.setContentText("formation validée");
    }
    private Optional<ButtonType> alert(String deux) {
        Alert alert = new Alert( Alert.AlertType.CONFIRMATION);
        alert.setTitle("validation");
        alert.setHeaderText("validation");      
        alert.setContentText(deux);
        return alert.showAndWait();
    }
    @FXML
    private void acceuilFor(ActionEvent event) {
        
          try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/View/AdminNotif.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AdminNotifController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
