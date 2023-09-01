package jailor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddProgramSceneController implements Initializable {

    @FXML
    private TextField programidTextField;
    @FXML
    private TextField programnameTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddProgramButtonOnClick(MouseEvent event) {
        
        int programID = Integer.parseInt(programidTextField.getText());
        String programName = programnameTextField.getText();
        Program p = new Program(programName, programID);
        Jailor.addProgram(p);
    }
    
}
