/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Formation;
import Services.FormationServices;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import xcode.controllers.ACCUEILController;

/**
 * FXML Controller class
 *
 * @author HELA
 */
public class AjouerFormationController implements Initializable {

    @FXML
    private ComboBox<String> btn_domaine;
    @FXML
    private TextField btn_duree;
    @FXML
    private DatePicker btn_date;
    @FXML
    private TextField btn_lieu;
    @FXML
    private Button btn_valider;
    @FXML
    private TextField btn_lang;
    @FXML
    private TextField btn_prix;
    @FXML
    private TextField btn_desc;
    @FXML
    private TextField btn_niv;
     @FXML
    private TextField txtimg;
        
     @FXML
    private Button back;
     @FXML
         private ImageView imgV;

    String nameCat = "" ;
    File file ;
    @FXML
    private Button bimgo;
    @FXML
    private Button back1;
    @FXML
    private TextField btn_titre;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   ObservableList<String> cat = FXCollections.observableArrayList( "dance","theatre", "musique","littérature",	"peinture",	"audiovisuel",	"sculpture");
        btn_domaine.setItems(cat);     
}

    @FXML
    private void ajouter(ActionEvent event) {
         SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
      LocalDate d=  date.toLocalDate();
       // LocalDate date2= btn_date.getValue();
         if (btn_date.getValue()==null
               
                    ||  btn_titre.getText().isEmpty()
                || btn_duree.getText().isEmpty()
                || btn_lieu.getText().isEmpty()
                || btn_niv.getText().isEmpty()
                || btn_prix.getText().isEmpty()
                 ||   btn_lang.getText().isEmpty()
                 ||   btn_desc.getText().isEmpty()
                || nameCat ==""
                
               ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setHeaderText("merci de remplir tous les champs");
            alert.showAndWait();
           
        }
         
         
         else if (btn_date.getValue().isBefore(d)) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("date invalide");
            alert.showAndWait();        }
         
         
         
         else {
             //txtimg.file.getName()
             Formation f = new Formation();
             f.setDuree(btn_duree.getText());
             f.setTitre(btn_titre.getText());
           f.setLieu(btn_lieu.getText());
           f.setLangue(btn_lang.getText());
        f.setDescription(btn_desc.getText());
        f.setDomaine(nameCat);
        f.setPrix(Float.parseFloat( btn_prix.getText()));
       f.setDate(btn_date.getValue().toString());
        f.setImage(file.getName());
        f.setNiveau(btn_niv.getText());
      //  Formation f = new Formation(1,nameCat ,btn_date.getValue().toString() , btn_duree.getText(), btn_lieu.getText(),Float.parseFloat((btn_prix.getText())), btn_niv.getText(),btn_lang.getText() ,
              //  0, 0,1,  btn_desc.getText(), null);

        FormationServices fs = FormationServices.getInstance();
            fs.ajouter(f);
            
          
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("confirmation");
        alert.setHeaderText("Formation ajoutée");
        alert.setContentText("Vous pouvez céer un contenu à votre formation en ajoutant des cours");
        
ButtonType ajouterC= new ButtonType("Créez votre contenu");
ButtonType buttonTypeTwo = new ButtonType("Non,je veux juste annocer ma formation ");
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
   
} else {alert.setHeaderText("");
           alert.setContentText(" Formation en attente de confirmation de la part de l'admin ");

}
//switch (ff.back(event)){
//case back(event) 
//        }
        alert.show();
       
//        try {
//                Parent page1 = FXMLLoader.load(getClass().getResource("/View/Cours.fxml"));
//                Scene scene = new Scene(page1);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
//            } catch (IOException ex) {
//                Logger.getLogger(ACCUEILController.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }}

    @FXML
    private void choisirDomaine(ActionEvent event) {
     String s = btn_domaine.getSelectionModel().getSelectedItem();
        nameCat = s ;
    }

    @FXML
    private void back(ActionEvent event) {
        
        
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

    @FXML
    private void chercherI(ActionEvent event) throws IOException {
        
        Stage primary = new Stage();
       File dest =new File("C:\\xampp\\htdocs\\PI\\IMG");
        
        FileChooser filechooser = new FileChooser();
        filechooser.setInitialDirectory(new File("C:\\"));
        filechooser.setTitle("insérer image");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        file = filechooser.showOpenDialog(primary);
        FileUtils.copyFileToDirectory(file, dest);
        
        File newFile2 = new File("C:\\xampp\\htdocs\\PI\\IMG\\" + file.getName());

        FileInputStream input2 = new FileInputStream(newFile2);
        Image image2 = new Image(input2);
        txtimg.setText(newFile2.getName());
        imgV.setImage(image2);
        
        
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
    }
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
}
