/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package securityincharge;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


public class SeeCompletionTaskdescriptionController implements Initializable {

    @FXML
    private TextArea showdescriptionOnClick;
    
    private AssignedTasks at;
    

    /**
     * Initializes the controller class.
     */
    
    public void data(AssignedTasks at) {
        this.at = at;
        showdescriptionOnClick.setText(at.getTaskCompletionDescription());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
