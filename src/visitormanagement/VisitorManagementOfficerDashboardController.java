/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package visitormanagement;

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
 * @author calsifer
 */
public class VisitorManagementOfficerDashboardController implements Initializable {

    @FXML
    private BorderPane visitorManagementDashBoardBorderPane;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/homepage/HomePage.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }

    @FXML
    private void verifySignUpOnButtonclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/visitormanagement/SignUpApproveSceneForVisitorManagementOfficer.fxml"));
        visitorManagementDashBoardBorderPane.setCenter(parent);

    }

    @FXML
    private void viewVarifiedUsersButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/visitormanagement/ViewVarifiedNonAuthorityUsers.fxml"));
        visitorManagementDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void applicationsButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/applications/ApplicationDashBoard.fxml"));
        visitorManagementDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void scheduleAppointmentButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/schedule/MakeAppointmentScene.fxml"));
        visitorManagementDashBoardBorderPane.setCenter(parent);
        
    }

    @FXML
    private void permissionCardbuttonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/nonauthorityuser/PermissionCardPdfgenerator.fxml"));
        visitorManagementDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void reportButtonOnclick(ActionEvent event) {
    }

    @FXML
    private void viewReportReqbuttonOnclick(ActionEvent event) {
    }

    @FXML
    private void viewNotificationButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/notifications/ShowNotification.fxml"));
        visitorManagementDashBoardBorderPane.setCenter(parent);
    }
    
}
