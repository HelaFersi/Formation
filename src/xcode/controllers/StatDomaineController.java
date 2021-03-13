/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xcode.controllers;

import Services.FormationServices;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HELA
 */
public class StatDomaineController implements Initializable {

    @FXML
    private BarChart<String, Integer> idstatart;
    @FXML
    private Button btnstatartt;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            FormationServices f=new FormationServices();
        XYChart.Series<String, Integer> series = f.bestDomain();
        idstatart.setData(FXCollections.observableArrayList(series));
    }    

    @FXML
    private void RetourConsulart(MouseEvent event) {
    }
    
}
