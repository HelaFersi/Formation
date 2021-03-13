package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entities.Cours;
import Entities.Formation;
import Entities.Inscription;
import IServices.MyListener;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import xcode.controllers.ACCUEILController;
import xcode.controllers.AffichageController;
import xcode.controllers.AfficherForClickController;
import xcode.controllers.AfficherForController;

/**
 * FXML Controller class
 *
 * @author HELA
 */
public class InscrController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label prixo;
    @FXML
    private Label descO;
    @FXML
    private Button ADD;
    @FXML
    private ScrollPane scrollO;
    @FXML
    private GridPane grid;
    @FXML
    private Button inscrit;
    @FXML
    private ImageView img;
    @FXML
    private ComboBox<String> tri;

    /**
     * Initializes the controller class.
     */
    
     private  Formation f;
     private Image image;
   private MyListener myListener;
    private List<Formation> listf =new ArrayList<>();
    FormationServices ff = new FormationServices();
    @FXML
    private MenuItem prixT;
    @FXML
    private MenuItem triTitre;
    @FXML
    private TextField cher;
  //  private ObservableList<Formation> data ;
    String nameCat = "" ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        inscrit.setOnAction(event -> {
//            
//            try {
//                Inscription i = new Inscription(1, 4);
//                InscriptionsServices in =new InscriptionsServices();
//                in.ajouter(i);
//                
//                Alert alert = new Alert(AlertType.CONFIRMATION);
//                alert.setTitle("Information Dialog");
//                alert.setHeaderText(null);
//                alert.setContentText("vous êtes le bienvenu !");
//                alert.show();
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(InscrController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        // TODO
         ObservableList<String> cat = FXCollections.observableArrayList( "prix","date");
        tri.setItems(cat);  
        listf.addAll(ff.readAll(1));
           if (listf.size() > 0) {
               System.out.println(listf.get(0));
               
                setChosenO(listf.get(0));
                
                myListener = new MyListener() {
                    
                    @Override
                    public void onClickListener(MouseEvent event ,Formation formation) {
                         setChosenO(formation);
//                        try {
//                            AfficherForController.setF(f);
//                            Parent page1 = FXMLLoader.load(getClass().getResource("/View/AfficherFor.fxml"));
//                            Scene scene = new Scene(page1);
//                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                            stage.setScene(scene); 
//                            stage.show();
//                        } catch (IOException ex) {
//                            Logger.getLogger(InscrController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
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
                for (int i = 0; i < listf.size(); i++) {

                   FXMLLoader fxmlLoader = new FXMLLoader();
                   fxmlLoader.setLocation(getClass().getResource("/View/AfficherForClick.fxml"));
                   AnchorPane anchorPane = fxmlLoader.load();

                    AfficherForClickController itemController = fxmlLoader.getController();
                    
                itemController.setData(listf.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));
                }
                
                
                
                } catch (IOException ex) {
                   Logger.getLogger(ACCUEILController.class.getName()).log(Level.SEVERE, null, ex);
               } 
    }
    
        private void setChosenO(Formation ff) {
      
        prixo.setText((ff.getPrix())+"DT");
        descO.setText(ff.getDescription());
                File newFile2 = new File("C:\\xampp\\htdocs\\PI\\IMG\\" + ff.getImage());

        //image = new Image(getClass().getResourceAsStream(o.getImg()));
        img.setImage(new Image(newFile2.toURI().toString()));
        f=ff;
    }

  
     @FXML
    private void ajoutttt(ActionEvent event) {
      try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/View/AjouerFormation.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(InscrController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void afficherFor(ActionEvent event) {
         try { AfficherForController.setF(f);
                Parent page1 = FXMLLoader.load(getClass().getResource("/View/AfficherFor.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ACCUEILController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void triTitre(ActionEvent event) {
      
    }

    @FXML
    private void chercher(ActionEvent event) throws SQLException  {
        
        
        if(cher.getText()!=f.getTitre())
               // equals(""))
        {
            System.out.println("pas de resultat");
            try {
                            AfficherForController.setF(f);
                            Parent page1 = FXMLLoader.load(getClass().getResource("/View/chercherNull.fxml"));
                            Scene scene = new Scene(page1);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene); 
                            stage.show();
                        } catch (IOException ex) {
                           Logger.getLogger(InscrController.class.getName()).log(Level.SEVERE, null, ex);
                   
                };
                
        
        }
    else{
        
        ArrayList<Formation> listf = (ArrayList<Formation>) ff.rechercherFor(cher.getText()); 
            //  data.clear();
             // data = FXCollections.observableArrayList(liste);           
          if (listf.size() > 0) {
               System.out.println(listf.get(0));
               
                setChosenO(listf.get(0));
                
                myListener = new MyListener() {
                    
                    @Override
                    public void onClickListener(MouseEvent event ,Formation formation) {
                       try {
                            AfficherForController.setF(f);
                            Parent page1 = FXMLLoader.load(getClass().getResource("/View/AfficherFor.fxml"));
                            Scene scene = new Scene(page1);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene); 
                            stage.show();
                        } catch (IOException ex) {
                           Logger.getLogger(InscrController.class.getName()).log(Level.SEVERE, null, ex);
                   
                };
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
                for (int i = 0; i < listf.size(); i++) {

                   FXMLLoader fxmlLoader = new FXMLLoader();
                   fxmlLoader.setLocation(getClass().getResource("/View/AfficherForClick.fxml"));
                   AnchorPane anchorPane = fxmlLoader.load();

                    AfficherForClickController itemController = fxmlLoader.getController();
                    
                itemController.setData(listf.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));
                }
                
                 
                } catch (IOException ex) {
                  Logger.getLogger(InscrController.class.getName()).log(Level.SEVERE, null, ex);
               } 
           
//              File newFile2 = new File("C:\\xampp\\htdocs\\PI\\IMG\\" + a.getImage());
//        imgV.setImage(new Image(newFile2.toURI().toString()));
//         adesco.setText(a.getDescription());
//        aprixo.setText(String.valueOf(a.getPrix()));
//         adomaino.setText(a.getDomaine());
//         lang.setText(a.getLangue());
//          niv.setText(a.getNiveau());
//          lieu.setText(a.getLieu());
//          duree.setText(a.getDuree());
//          date.setText(a.getDate());
    }}
     @FXML
    private void choisirDomaine(ActionEvent event) {
     String s = tri.getSelectionModel().getSelectedItem();
        nameCat = s ;
    }
    
     @FXML
    void TriparPrix(ActionEvent event) throws SQLException {
         System.out.println("tri par prix");
    
        listf= ff.tri_prix();
           if (listf.size() > 0) {
               System.out.println(listf.get(0));
               
                setChosenO(listf.get(0));
                
                myListener = new MyListener() {
                    
                    @Override
                    public void onClickListener(MouseEvent event ,Formation formation) {
                       try {
                            AfficherForController.setF(f);
                            Parent page1 = FXMLLoader.load(getClass().getResource("/View/AfficherFor.fxml"));
                            Scene scene = new Scene(page1);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene); 
                            stage.show();
                        } catch (IOException ex) {
                           Logger.getLogger(InscrController.class.getName()).log(Level.SEVERE, null, ex);
                   
                };
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
                for (int i = 0; i < listf.size(); i++) {

                   FXMLLoader fxmlLoader = new FXMLLoader();
                   fxmlLoader.setLocation(getClass().getResource("/View/AfficherForClick.fxml"));
                   AnchorPane anchorPane = fxmlLoader.load();

                    AfficherForClickController itemController = fxmlLoader.getController();
                    
                itemController.setData(listf.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));
                }
                
                 
                } catch (IOException ex) {
                  Logger.getLogger(InscrController.class.getName()).log(Level.SEVERE, null, ex);
               }
    
//        }
//    else { System.out.println("");
//        }
    
    }
}