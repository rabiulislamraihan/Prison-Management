/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.dg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class DGCommonDashboardController implements Initializable {

    @FXML
    private AnchorPane dgAncorPane;
    @FXML
    private BorderPane dgBorderPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

@FXML
private void addCellButtonOnClick(ActionEvent event) throws IOException {
    Stage stage = new Stage(); 
    Parent root = FXMLLoader.load(getClass().getResource("AddCell.fxml"));
    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();        
}

        
   

    @FXML
    private void makeRequestButtonOnClick(ActionEvent event) throws IOException {
        
    Stage stage = new Stage(); 
    Parent root = FXMLLoader.load(getClass().getResource("SendRequestToDG.fxml"));
    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();   
        
    }

    @FXML
    private void showRequestButtonOnClick(ActionEvent event) throws IOException {
        
        
        
    Stage stage = new Stage(); 
    Parent root = FXMLLoader.load(getClass().getResource("ShowRequest.fxml"));
    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();   
    }

    @FXML
    private void staticsButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("RequestPieChart.fxml"));
         dgBorderPane.setCenter(parent);
    }
    
}
