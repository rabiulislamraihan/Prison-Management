/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Trainer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TrainerCommonDashboardController implements Initializable {

    @FXML
    private BorderPane trainerCommonDashBorderpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void trainingProgramSceneMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("TrainingProgram.fxml"));
        trainerCommonDashBorderpane.setCenter(parent);
    }

    @FXML
    private void addPrisonerToCourseMenuItemOnClick(ActionEvent event) throws IOException {
                Parent parent = FXMLLoader.load(getClass().getResource("addPrisonerToCourse.fxml"));
                trainerCommonDashBorderpane.setCenter(parent);
                
        
    }

    @FXML
    private void prisonerCourseCountPieChartOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PrisonerCourseListPieChart.fxml"));
        trainerCommonDashBorderpane.setCenter(parent);
        
    }

    @FXML
    private void sendRrequestToDGMenuItemOnClick(ActionEvent event) throws IOException {
         Parent parent = FXMLLoader.load(getClass().getResource("SendRequestToDG.fxml"));
        trainerCommonDashBorderpane.setCenter(parent);     
        
        
    }

    private void requestToDGButtonOnClick(ActionEvent event) throws IOException {
         Parent parent = FXMLLoader.load(getClass().getResource("SendRequestToDG.fxml"));
        trainerCommonDashBorderpane.setCenter(parent);
    }

    private void attendanceButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Attandance.fxml"));
        trainerCommonDashBorderpane.setCenter(parent);
        
    }

    @FXML
    private void helpDeskMenu(ActionEvent event) throws IOException {
       Parent parent = FXMLLoader.load(getClass().getResource("HelpDeskToITOfficer.fxml"));
        trainerCommonDashBorderpane.setCenter(parent);
    }

    @FXML
    private void helpDeskmenuItemOnClick(ActionEvent event) throws IOException {
               Parent parent = FXMLLoader.load(getClass().getResource("HelpDeskToITOfficer.fxml"));
        trainerCommonDashBorderpane.setCenter(parent);
    }
    
}
