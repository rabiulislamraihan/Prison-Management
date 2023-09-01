
package prisonguard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import securityincharge.AssignedTasks;


public class SendTaskDescriptionToSInchargeController implements Initializable {

    @FXML
    private TextArea descriptionTextArea;
    
    private AssignedTasks at;
    public void data(AssignedTasks at) {
        this.at = at;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendDescriptionOnClick(MouseEvent event) {
        String description = descriptionTextArea.getText();
        at.setTaskCompletionDescription(description);
        PrisonGuard.sendUpdates(at);
    }
    
}
