/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.ITOfficers;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import user.AuthorityUser;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class AddAuthorityUserSceneController implements Initializable, Serializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField contactNoTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private TextField idTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private DatePicker dojDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Director General",
                                                    "Trainer ",
                                                    "Visitor Management Officer",
                                                    "Logistics officer",
                                                    "IT Officer ",
                                                    "Medical Workers",
                                                    "JAILOR ",
                                                    "Security Incharge",
                                                    "Finance and Accounting",
                                                    "Trade");
    }    

    @FXML
    private void addUserButtonOnClick(ActionEvent event) {
        System.out.println(Integer.parseInt(idTextField.getText()));
        AuthorityUser authorityUser = new AuthorityUser(
                            Integer.parseInt(idTextField.getText()),
                            nameTextField.getText(),
                            passwordTextField.getText(),
                            userTypeComboBox.getValue(),
                            dobDatePicker.getValue(),
                            dojDatePicker.getValue(),
                            contactNoTextField.getText(),
                            emailTextField.getText()
                
        );
        
        
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("AuthorityUserList.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(authorityUser);
                        showAlert("New " + authorityUser.getUserType() +" added successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add new" + authorityUser.getUserType());
            }
        }
        
    }
    
    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
//    public static boolean validateData(Faculty faculty) throws validateException{
//        if(!faculty.getName().matches("^[a-zA-Z]+$")){
//            showAlert("Enter a valid name");
////            throw new validateException("Enter a valid Name, Only charecters allowed");
//        }else{
//            return true;
//        }
//        return false;

    @FXML
    private void goToHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ITDashboard.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }


}
    
