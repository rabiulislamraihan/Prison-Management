/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package itofficer;

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
public class ITDashboardController implements Initializable {

    @FXML
    private BorderPane itOfficerDashBoardBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void notificationButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/notifications/NotificationPanel.fxml"));
        itOfficerDashBoardBorderPane.setCenter(parent);

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
    private void showNotificationButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/notifications/ShowNotification.fxml"));
        itOfficerDashBoardBorderPane.setCenter(parent);
        
    }

    @FXML
    private void addAuthorityUserButtonOnClick(ActionEvent event) throws IOException {
                Parent parent = FXMLLoader.load(getClass().getResource("AddAuthorityUserScene.fxml"));
        itOfficerDashBoardBorderPane.setCenter(parent);
    }
    
}
