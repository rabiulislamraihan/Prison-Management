
package securityincharge;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import user.AuthorityUser;

public class AssignTaskController implements Initializable {

    @FXML
    private ComboBox<Integer> taskIDComboBox;
    @FXML
    private ComboBox<Integer> GaurdComboBox;
    private ArrayList <AuthorityUser> list;
    private ArrayList<Tasks> tlist;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = SecurityInCharge.getPrisoneGuardList();
        tlist =  SecurityInCharge.getTasksList();
        for (int i = 0; i < list.size(); i ++) {
            GaurdComboBox.getItems().add(list.get(i).getId());
        }
        for (int i = 0; i < tlist.size(); i ++) {
            if(tlist.get(i).getTaskStatus().equals("Pending")) {
                taskIDComboBox.getItems().add(tlist.get(i).getTaskId());
            }
        }
    }    

    @FXML
    private void assignTaskOnAction(ActionEvent event) {

        int taskID = taskIDComboBox.getValue();
        int Gaurd = GaurdComboBox.getValue();
        Tasks t = null;
        AuthorityUser g = null;
        
        
        
        
        for (int i = 0; i < list.size(); i ++) {
            if(list.get(i).getId() == Gaurd){
                g = list.get(i);
                break;
            }
        }
        for (int i = 0; i < tlist.size(); i ++) {
            if(tlist.get(i).getTaskId() == taskID){
                t = tlist.get(i);
                break;
            }
        }
        
        AssignedTasks at = new AssignedTasks(t, g);
        SecurityInCharge.addAssignedTask(at);
        SecurityInCharge.showAlert("Tasks Successfully Assigned");
    }
    
}
