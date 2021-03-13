/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xcode.controllers;

import Entities.Formation;
import Services.FormationServices;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

/**
 * FXML Controller class
 *
 * @author HELA
 */
public class ModifierController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private TextField btn_lieu;
    @FXML
    private TextField btn_duree;
    @FXML
    private DatePicker btn_date;
    @FXML
    private TextField btn_lang;
    @FXML
    private TextField btn_prix;
    @FXML
    private TextField btn_desc;
    @FXML
    private TextField btn_niv;
    @FXML
    private ComboBox<String> btn_domaine;
    @FXML
    private TextField txtimg;
    @FXML
    private Button bimgo;
    @FXML
    private Button btn_valider;
    @FXML
    private ImageView imgV;

    /**
     * Initializes the controller class.
     */
      private static Formation s ;
    
    //ControleSaisie controlem = new ControleSaisie();
    
    
    FormationServices fs = new FormationServices();
    String nameCat = "" ;
    File file ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         ObservableList<String> cat = FXCollections.observableArrayList( "dance","theatre", "musique","littérature",	"peinture",	"audiovisuel",	"sculpture");
        btn_domaine.setItems(cat);
    
       // final int initialValue = (int) s.getQuantite();
 
      
        
        try {
         File newFile2 = new File("C:\\xampp\\htdocs\\PI\\IMG\\" + s.getImage());
          imgV.setImage(new Image(newFile2.toURI().toString()));
          btn_lieu.setText(s.getLieu());
          btn_lang.setText(s.getLangue());
          btn_duree.setText(s.getDuree());
         // btn_date.setValue(s.getDate().todate); lezem nrod string date !!!
        
        btn_prix.setText(String.valueOf(s.getPrix()));
          btn_desc.setText(s.getDescription());
          btn_domaine.setValue(s.getDomaine());
        } catch (Exception e) {
        }
        
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
    private void choisirDomaine(ActionEvent event) {
       
        String s = btn_domaine.getSelectionModel().getSelectedItem();
        nameCat = s ;
         
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
    private void validerModif(ActionEvent event) throws FileNotFoundException, IOException, SQLException {
        
        //while(isvalid=0)
        if (btn_date.getValue()==null
              //  ||  date. ==0
                                                
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
        else {
             SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        date.toLocalDate();
             s.setDuree(btn_duree.getText());
           s.setLieu(btn_lieu.getText());
           s.setLangue(btn_lang.getText());
        s.setDescription(btn_desc.getText());
        s.setDomaine(nameCat);
        s.setPrix(Float.parseFloat( btn_prix.getText()));
       s.setDate(btn_date.getValue().toString());
    s.setImage(file.getName());
        s.setNiveau(btn_niv.getText());
        
        fs.update(s);
        
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
      //  alert.setHeaderText("Formation modifié ☺ ");
            alert.setContentText("Formation modifiée avec sucèes ☺ ");
            alert.showAndWait();
        }
      
       // LocalDate date2= btn_date.getValue();
     
    }
    
    public static void setFor (Formation f ){
        s=f;
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
