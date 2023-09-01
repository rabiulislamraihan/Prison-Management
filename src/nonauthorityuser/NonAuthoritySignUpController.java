/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nonauthorityuser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import user.NonAuthorityUser;
import user.VisitormanagementOfficer;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class NonAuthoritySignUpController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private TextField nidTextField;
    @FXML
    private TextField fatherNameTextField;
    @FXML
    private TextField motherNameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField contactNoTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField nationalityTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private TextField emailTextField1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Visitor",
            "Family Member",
            "Legal Counsel",
            "Social Worker",
            "Medical Professional",
            "Educational Instructor",
            "Volunteer",
            "Journalist",
            "Maintenance Personnel",
            "Contractor");
    }    

    @FXML
    private void signUpButtonOnClick(ActionEvent event) throws IOException {
            
        String name = nameTextField.getText();
        LocalDate dob = dobDatePicker.getValue();
        String nid = nidTextField.getText();
        String fatherName = fatherNameTextField.getText();
        String motherName = motherNameTextField.getText();
        String password = passwordField.getText();
        String contactNo = contactNoTextField.getText();
        String address = addressTextField.getText();
        String nationality = nationalityTextField.getText();
        String userType = userTypeComboBox.getValue();
        String email = emailTextField1.getText();
        
        Integer i = VisitormanagementOfficer.viewSignUps().size()+1;
        System.out.println(i);

        NonAuthorityUser nonAuthorityUser = new NonAuthorityUser(
            name,
         i,
            dob,
            nid,
            fatherName,
            motherName,
            password,
            contactNo,
            address,
            nationality,
            userType,
            email
        );
        
        
       VisitormanagementOfficer.addNonAauthorityUser(nonAuthorityUser);
       System.out.println(nonAuthorityUser);
       System.out.println(VisitormanagementOfficer.viewSignUps());
                        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/login/LogInPage.fxml"));
                        Scene scene = new Scene(scene2Parent);
                        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stg2.setScene(scene);
                        stg2.show();
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/homepage/HomePage.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }
private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}

    
    

