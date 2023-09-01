package jailor;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class ViewReleasePlanSceneController implements Initializable {
    @FXML
    private TextArea showTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList <ReleasePlan> list = Jailor.getReleasePlan();
        for (int i = 0; i < list.size(); i ++) {
            showTextArea.appendText(
            "Prisoner ID: " + list.get(i).getP().getPrisoner_id() +
            ", Prisoner Name: " + list.get(i).getP().getName() + 
            ", Proposed Released Date: " + list.get(i).getProposedReleasedate().toString() + 
            "\nDescription: \n" + list.get(i).getDescription() + "\n");
        }
    }    
}
