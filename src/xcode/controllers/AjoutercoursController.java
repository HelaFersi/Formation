/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xcode.controllers;

import Entities.Cours;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import Services.CoursServices;
import java.sql.SQLException;
import java.util.Optional;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author HELA
 */
public class AjoutercoursController implements Initializable {

    @FXML
    private Button MESO;
    @FXML
    private TextField desc;
    @FXML
    private TextField titre;
    @FXML
    private TextField duree;
    @FXML
    private Button bimgo;
    @FXML
    private Button annulero;
    @FXML
    private TextField txtimg;
File file;
    @FXML
    private Button ajouterC;
    @FXML
    private ComboBox<String> niv;
    
    String nameCat = "" ;
    @FXML
    private Button back1;
    
   // CoursServices cs = CoursServices();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
                ObservableList<String> cat = FXCollections.observableArrayList("débutant", "intermédiaire","avancé");
        niv.setItems(cat);
    
 
         }    



    @FXML
    private void ajouterC(ActionEvent event) throws SQLException {
          Cours c = new Cours();
        if (titre.getText().isEmpty()
                || desc.getText().isEmpty()
                || duree.getText().isEmpty()
                || txtimg.getText().isEmpty()
                || nameCat ==""
                
                
               ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setHeaderText("Veuillez remplir tous les champs");
            alert.showAndWait();
        }
        else {
        c.setTitre(titre.getText());
        c.setDescription(desc.getText());
        c.setNiveau(nameCat);
        c.setFormation_id(4);// the problem is here 
      
        c.setFile(file.getName());
        CoursServices cs = new CoursServices();
        cs.ajouter1(c);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("confirmation");
        alert.setHeaderText("Cours ajouté");
        alert.setContentText("Vous pouvez ajouter encore des cours");
        
ButtonType ajouterC= new ButtonType("ajouter ");
ButtonType buttonTypeTwo = new ButtonType("Non ");
alert.getButtonTypes().setAll(ajouterC, buttonTypeTwo);
Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ajouterC){
    try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/View/Cours.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ACCUEILController.class.getName()).log(Level.SEVERE, null, ex);
            }
   
} 
else { Alert aa = new Alert(Alert.AlertType.INFORMATION);
        aa.setHeaderText("cours ajouté ☺ ");
            aa.setContentText("cours ajouté avec sucèes ☺ ");
            aa.showAndWait();
//
}
}
        
        
    }

    //@FXML
//    private void annuler(ActionEvent event) {
//        desc.setText("");
//        nomo.setText(""); 
//        prixo.setText("");
//    }
    
    
      @FXML
    private void chercherI(ActionEvent event) throws FileNotFoundException, IOException  {
 Stage primary = new Stage();
       File dest =new File("C:\\xampp\\htdocs\\PI\\IMG");
        
        FileChooser filechooser = new FileChooser();
        filechooser.setInitialDirectory(new File("C:\\"));
        filechooser.setTitle("insérer image");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"), new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        
        file = filechooser.showOpenDialog(primary);
        FileUtils.copyFileToDirectory(file, dest);
        
        File newFile2 = new File("C:\\xampp\\htdocs\\PI\\IMG\\" + file.getName());

        FileInputStream input2 = new FileInputStream(newFile2);
        Image image2 = new Image(input2);
        txtimg.setText(newFile2.getName());
     //   imgV.setImage(image2);
       System.out.println(txtimg.getText());
        if(file!=null)
        {
        txtimg.setVisible(true);
        txtimg.setText(file.getName());
//            try {             Files.copy(file.toPath(),new File(path+"\\"+file.getName()).toPath());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    else {
               System.out.println("Image introuvable");         
    }}

    @FXML
    private void selectcat(ActionEvent event) {
        String s = niv.getSelectionModel().getSelectedItem();
        nameCat = s ;
    }

    @FXML
    private void backClient(ActionEvent event) {
           try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/View/InscriptionForm.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ACCUEILController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void acceuilFormafteur(ActionEvent event) {
           try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/View/ACCUEIL.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ACCUEILController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}


