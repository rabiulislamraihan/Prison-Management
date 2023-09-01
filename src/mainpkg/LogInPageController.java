/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class LogInPageController implements Initializable {

    @FXML
    private TextField idTextFieldfxid;
    @FXML
    private TextField passwordTextFieldfxid;
    @FXML
    private ComboBox<String> userTypeComboBoxfxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBoxfxid.getItems().addAll("Director General",
                                                    "Trainer",
                                                    "Visitor Management Officer",
                                                    "Logistics officer",
                                                    "IT Officer",
                                                    "Medical Workers",
                                                    "JAILOR",
                                                    "Security Incharge",
                                                    "Finance and Accounting",
                                                    "Non Authority User");
    }    
    
    
    
    @FXML
    private void logInButtonOnClick(ActionEvent event) throws IOException {
        
        
        
        if(userTypeComboBoxfxid.getValue().equals("Visitor Management Officer")){
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("VisitorManagementDashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();         
        stg2.setScene(scene2);
        stg2.show();
        }else if(userTypeComboBoxfxid.getValue().equals("Non Authority User")){
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ApplicationForm.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();         
        stg2.setScene(scene2);
        stg2.show();
        }else if(userTypeComboBoxfxid.getValue().equals("JAILOR")){
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("JailorScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();         
        stg2.setScene(scene2);
        stg2.show();
        }else if(userTypeComboBoxfxid.getValue().equals("IT Officer")){
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/mainpkg/ITOfficers/ITDashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();         
        stg2.setScene(scene2);
        stg2.show();
        }else if(userTypeComboBoxfxid.getValue().equals("Trainer")){
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/mainpkg/trainerOfficer/TrainerCommonDashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();         
        stg2.setScene(scene2);
        stg2.show();
        }else if(userTypeComboBoxfxid.getValue().equals("Medical Workers")){
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/mainpkg/MedicalOfficer/MedicalOfficerDashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();         
        stg2.setScene(scene2);
        stg2.show();
        }
//        Parent parent = FXMLLoader.load(getClass().getResource("VisitorManagementDashboard.fxml"));
//        Scene scene  = new Scene(parent);
//        Stage newWindow = new Stage();
//        
//        
//        newWindow.setTitle("Visitor Management Dashboard");
//        newWindow.setScene(scene);
//        newWindow.show();
    }

   @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }
}
