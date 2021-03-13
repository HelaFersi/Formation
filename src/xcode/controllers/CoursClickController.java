/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xcode.controllers;

import Entities.Cours;
import Entities.Formation;
import IServices.MyListener;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HELA
 */
public class CoursClickController implements Initializable {

   
private Cours c;
private MyListener myListener;
    @FXML
    private Label titre;
    @FXML
    private Label desc;
    @FXML
    private ImageView img;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click(MouseEvent event) {
        myListener.onClickListener(event,c);
    }
    
     public void setData(Cours f, MyListener myListener) {
        this.c  = c;
        this.myListener = myListener;
        titre.setText(f.getTitre());
        desc.setText((f.getDescription())+"DT");
      File newFile = new File("C:\\xampp\\htdocs\\PI\\IMG\\" + f.getFile());

        img.setImage(new Image(newFile.toURI().toString()));
       
    }

}    
