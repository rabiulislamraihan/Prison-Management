/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package jailor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class JailorDashboard_1Controller implements Initializable {

    @FXML
    private BorderPane jailorDashboard;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void addInmateRecordOnClick(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPrisonersScene.fxml"));
        Parent root = loader.load();
        jailorDashboard.setCenter(root);
    }


    @FXML
    private void ViewPrisonerOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewPrisonerListScene.fxml"));
        Parent root = loader.load();
        jailorDashboard.setCenter(root);
    }

    @FXML
    private void SearchPrisonerOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchPrisonerScene.fxml"));
        Parent root = loader.load();
        jailorDashboard.setCenter(root);
    }

    @FXML
    private void addProgramButtonOnclick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProgramScene.fxml"));
        Parent root = loader.load();
        jailorDashboard.setCenter(root);
    }

    @FXML
    private void addRehabilitationOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RehabilitationProgramScene.fxml"));
        Parent root = loader.load();
        jailorDashboard.setCenter(root);
    }

    @FXML
    private void ReleasePlanOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReleasePlanScene.fxml"));
        Parent root = loader.load();
        jailorDashboard.setCenter(root);
        
    }

    @FXML
    private void ViewReleasePlanOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewReleasePlanScene.fxml"));
        Parent root = loader.load();
        jailorDashboard.setCenter(root);
    }

    @FXML
    private void showCrimePieChartOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CrimeChartScene.fxml"));
        Parent root = loader.load();
        jailorDashboard.setCenter(root);
    }

    @FXML
    private void viewTaskUpdatesOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/securityincharge/GeneratePfdOnTaskCompletion.fxml"));
        Parent root = loader.load();
        jailorDashboard.setCenter(root);
    }

    @FXML
    private void approveApplicationButtonOnclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/jailor/ApplicationApproveSceneForJailor.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
