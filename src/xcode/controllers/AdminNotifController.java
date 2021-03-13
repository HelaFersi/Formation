/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xcode.controllers;

import Entities.Cours;
import Entities.Formation;
import IServices.MyListener;
import Services.FormationServices;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HELA
 */
public class AdminNotifController implements Initializable {

    @FXML
    private Button gest;
    @FXML
    private Button mdp;
    @FXML
    private Button role;
    @FXML
    private Button form;
    @FXML
    private Button event;
    @FXML
    private Button favoris;
    @FXML
    private ScrollPane scrollO;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     */
     private MyListener myListener;
    private List<Formation> listforADMIN =new ArrayList<>();
    private FormationServices fs = new FormationServices();
    @FXML
    private Button event1;
    @FXML
    private Button stat;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listforADMIN.addAll(fs.afficherForAdmin());
        if (listforADMIN.size() > 0) {
               System.out.println(listforADMIN.get(0));
               myListener = new MyListener() {
                   @Override
                   public void onClickListener(MouseEvent event, Formation f) {
                          try {
                            ValidationAdmiController.setF(f);
                            Parent page1 = FXMLLoader.load(getClass().getResource("/View/ValidationAdmin.fxml"));
                            Scene scene = new Scene(page1);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene); 
                            stage.show();
                        } 
                          catch (IOException ex) {
                            Logger.getLogger(AdminNotifController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   } 

                   @Override
                   public void onClickListener(MouseEvent event, Cours cours) {
                       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   }
               
               };
    
    
                       }
        int column = 0;
            int row = 1;
            try {
                for (int i = 0; i < listforADMIN.size(); i++) {

                   FXMLLoader fxmlLoader = new FXMLLoader();
                   fxmlLoader.setLocation(getClass().getResource("/View/Adminclick.fxml"));
                   AnchorPane anchorPane = fxmlLoader.load();
                   AdminclickController itemController = fxmlLoader.getController();
                itemController.setData(listforADMIN.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));
                }
              
                } catch (IOException ex) {
                   Logger.getLogger(AdminNotifController.class.getName()).log(Level.SEVERE, null, ex);
               }
        
    }

    @FXML
    private void statistics(ActionEvent event) {
          try {
                            //ValidationAdmiController.setF(f);
                            Parent page1 = FXMLLoader.load(getClass().getResource("/View/StatDomaine.fxml"));
                            Scene scene = new Scene(page1);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene); 
                            stage.show();
                        } 
                          catch (IOException ex) {
                            Logger.getLogger(AdminNotifController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }
}