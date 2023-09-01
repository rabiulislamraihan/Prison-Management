/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.MedicalOfficer;

import jailor.Prisoner;
import java.io.IOException;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mainpkg.ITOfficers.EditAuthorityUserController;
import user.AuthorityUser;

/**
 * FXML Controller class
 *
 * @author crypticx
 */
public class PresciptionPageController implements Initializable {

    private Prisoner patient;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextArea prescribeDetailsTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void openUserEditScene(AuthorityUser user) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Prescription.fxml"));
            Parent root = fxmlLoader.load();

            EditAuthorityUserController editUserController = fxmlLoader.getController();
            editUserController.initData(user); // Pass the selected user to the edit controller

            Stage editStage = new Stage();
            editStage.initModality(Modality.APPLICATION_MODAL);
            editStage.initStyle(StageStyle.UNDECORATED);
            editStage.setScene(new Scene(root));
            editStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    // This method is called from NotificationPanelController to pass the selected user
    public void initData(Prisoner patient) {
        this.patient = patient;


       idTextField.setText(Integer.toString(patient.getPrisoner_id()));
        nameTextField.setText(patient.getName());
        ageTextField.setText(Integer.toString(patient.getDateOfBirth().getYear()));
//        editDOBDatePicker.setValue(user.getDob());
//        editDOJDatePicker.setValue(user.getDoj());
//        editPasswordTextField.setText(user.getPassword());
//        editContactNoTextField.setText(user.getContactNo());
//        editEmailTextField.setText(user.getEmail());
//        editUserTypeComboBox.setValue(user.getUserType());
    }

    @FXML
    private void addPrescriptionButtonOnClick(ActionEvent event) {
        String prescriptionDetails = prescribeDetailsTextArea.getText();
        Integer prisonerID = patient.getPrisoner_id();
        LocalDate prescribeTime = LocalDate.now();
        
        Prescription newPrescription = new Prescription(prisonerID, prescriptionDetails, prescribeTime);
        Medicalofficer.addPresciption(newPrescription);
        
        
    }

    @FXML
    private void goToHomeButtonOnClick(ActionEvent event) throws IOException {
                Parent scene2Parent = FXMLLoader.load(getClass().getResource("MedicalOfficerDashboard.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }

    
}
