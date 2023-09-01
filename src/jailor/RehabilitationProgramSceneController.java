package jailor;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RehabilitationProgramSceneController implements Initializable {

    @FXML
    private TextField prisonertextField;
    @FXML
    private ComboBox<Integer> programComboBox;
    private ArrayList <Program> list;
    @FXML
    private TextArea showTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        list = Jailor.ProgramList();
        for (int i = 0; i < list.size(); i  ++) {
            programComboBox.getItems().add(list.get(i).getProgramID());
        }
    }    

    @FXML
    private void addRehabilitationOnClick(MouseEvent event) {
        Prisoner p = Jailor.getPrisonerByPrisonerID(Integer.parseInt(prisonertextField.getText()));
        if(p == null) {
            Jailor.showAlert("Prisoner Not Found");
            return;
        }
        Program pr = null;
        for (int i = 0; i < list.size(); i ++) {
            if(programComboBox.getValue() == list.get(i).getProgramID()) {
                pr = list.get(i);
                break;
            }
        }
        Rehabilitation r = new Rehabilitation(pr, p);
        Jailor.AddRehabilitation(r);
        
        Jailor.showAlert("Successfully added");
        ArrayList<Rehabilitation> list = Jailor.getRehabilitationList();
        showTextArea.setText("");
        for (int i = 0; i < list.size(); i ++) {
            showTextArea.appendText(list.get(i).toString() + "\n");
        }
    }
}
