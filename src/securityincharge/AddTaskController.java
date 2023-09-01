
package securityincharge;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class AddTaskController implements Initializable {

    @FXML
    private TextField taskIdTextField;
    @FXML
    private TextField taskNameTextField;
    @FXML
    private ComboBox<String> taskStatusComboBox;
    @FXML
    private TextArea descriptionTextarea;
    
    private Shift s;
    
    public void data(Shift s) {
        this.s = s;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        taskStatusComboBox.getItems().addAll(
        "Pending",
                "Complete");
    }    

    @FXML
    private void addTaskOnClick(MouseEvent event) throws IOException {
        int taskId = Integer.parseInt(taskIdTextField.getText());
        String taskName = taskNameTextField.getText();
        String taskStatus = taskStatusComboBox.getValue();
        String description = descriptionTextarea.getText();
        Tasks t = new Tasks(taskId, taskName, taskStatus, description, s);
        SecurityInCharge.addTask(t);
        
        SecurityInCharge.showAlert("Tasks Successfully added");
        
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SecurityInChargeDashBoard.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
