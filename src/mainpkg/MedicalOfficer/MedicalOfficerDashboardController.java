/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.MedicalOfficer;

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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author crypticx
 */
public class MedicalOfficerDashboardController implements Initializable {

    @FXML
    private BorderPane medicalOfficerDashBoardBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void patientRecordButtonOnClick(ActionEvent event) throws IOException {
                Parent parent = FXMLLoader.load(getClass().getResource("PatientRecord.fxml"));
        medicalOfficerDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void goToHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("MedicalOfficerDashboard.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }

    @FXML
    private void showNotificationButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/mainpkg/ShowNotification.fxml"));
        medicalOfficerDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void helpDeskButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("HelpDeskToITOfficer.fxml"));
        medicalOfficerDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void requestToDGButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SendRequestToDG.fxml"));
        medicalOfficerDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void chekcupButtonOnclick(ActionEvent event) throws IOException {
       Parent parent = FXMLLoader.load(getClass().getResource("PatientCheckUpList.fxml"));
        medicalOfficerDashBoardBorderPane.setCenter(parent);
    }
    
}
