/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package prisonguard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import user.AuthorityUser;


public class PrisonGuardHomePageSceneController implements Initializable {
    
    private AuthorityUser au;
    public void data(AuthorityUser au) {
        this.au = au;
    }

    @FXML
    private BorderPane BorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EntryButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("EmployeeEntryScene.fxml"));
        BorderPane.setCenter(parent);
    }


    @FXML
    private void SendNotificationButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/notifications/NotificationPanel.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void CreateIncidentReportOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CreateIncidentReportScene.fxml"));
        BorderPane.setCenter(parent);
        
    }

    @FXML
    private void ViewAllReportOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ShowIncidentReportsScene.fxml"));
        BorderPane.setCenter(parent);
        
        
    }


    @FXML
    private void ShowVisitorApprovalList(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/applications/CustomClassForApplicationToSendToDGScene.fxml"));
        BorderPane.setCenter(parent);
    }

    @FXML
    private void ViewAssignedTasksOnClick(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeeAssignedTaskScene.fxml"));
        Parent root = loader.load();
        SeeAssignedTaskSceneController ctrl = loader.getController();
        ctrl.data(au);
        BorderPane.setCenter(root);
    }

    
}
