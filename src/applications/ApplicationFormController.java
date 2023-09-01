/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package applications;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import user.NonAuthorityUser;
import user.VisitormanagementOfficer;
/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class ApplicationFormController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextArea applicationBodyTextArea;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private DatePicker datefxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll( "Visitor",
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
    private void handleCreateApplication(ActionEvent event) {
        String name = nameTextField.getText();
        String nid = idTextField.getText();
        String applicationBody = applicationBodyTextArea.getText();
        String userType = userTypeComboBox.getValue();
        LocalDate date = datePicker.getValue();
        
        
        if(checkValidity(name, nid) != null){
            NonAuthorityUser newApplicant = checkValidity(name, nid);
            
        int applicationId = VisitormanagementOfficer.viewApplication().size()+1;    
            
        Application application = new Application(Integer.toString(applicationId),newApplicant.getId() , date, applicationBody, false);
            ObservableList<Application> tempList = VisitormanagementOfficer.viewApplication();
        NonAuthorityUser.writeApplication(application, tempList.size());
    }
    }
    @FXML
    private void handleClearFields(ActionEvent event) {
        nameTextField.clear();
        idTextField.clear();
        applicationBodyTextArea.clear();
        userTypeComboBox.getSelectionModel().clearSelection();
        datePicker.setValue(null);
    }

    @FXML
    private void goToHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/homepage/HomePage.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
        
    }
 
    
    
    
    public static NonAuthorityUser checkValidity(String name, String nid){
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ApprovedNonAuthorityUser.bin"))){
            while(true){
                try{
                    NonAuthorityUser nonAuthorityUser = (NonAuthorityUser)ois.readObject();
                    if(nonAuthorityUser.getName().equals(name) && nonAuthorityUser.getNid().equals(nid)){
                        return nonAuthorityUser;
                    }
                }catch(EOFException e){
                    break;
                }catch(ClassNotFoundException e){
                   System.err.println("Class not Found");
                }
            }
        }catch(FileNotFoundException e){
                    System.err.println("File not Found");
        }catch(IOException e){
                    System.err.println("IO exception" + e.getMessage());
        }
        return null;
        
}
}