/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package applications;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class ApplicationDashBoardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewAllApplicationsButtonOnClick(ActionEvent event) throws IOException {
//        New window
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/applications/CustomClassForApplicationToSendToDGScene.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = new Stage();
        stg2.setScene(scene);
        stg2.show();
    }

    @FXML
    private void sendToJailorButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/applications/SendApplicationInCustomFormatToJailor.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = new Stage();
        stg2.setScene(scene);
        stg2.show();
    }

    @FXML
    private void applicationsApprovedByJailorButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/applications/ApprovedApplicationsByJailorScene.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = new Stage();
        stg2.setScene(scene);
        stg2.show();
    }
    
}
