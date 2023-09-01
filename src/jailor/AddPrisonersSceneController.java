package jailor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainpkg.dg.Cell;

/**
 * FXML Controller class
 *
 * @author raiha
 */

public class AddPrisonersSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField nidTextField;
    @FXML
    private TextField prisonerIdTextField;
    @FXML
    private ComboBox<String> statusComboBox;
    @FXML
    private DatePicker dateOfBirthDatePicker;
    @FXML
    private ComboBox<String> prisonerCellBlockComboBox;
    @FXML
    private ComboBox<String> genderComboBox;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        genderComboBox.getItems().addAll(
                "Male",
                "Female",
                "Others");
        
        statusComboBox.getItems().addAll(
            "Active", 
            "Inactive");
        
        
        ObjectInputStream ois = null;
        try {
             Cell c;
             ois = new ObjectInputStream(new FileInputStream("Cell.bin"));

            while(true){
                c = (Cell) ois.readObject();
                prisonerCellBlockComboBox.getItems().add(Integer.toString(c.getCellNo()));
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
    }    

    @FXML
    private void AddPrisonerButtonOnClick(MouseEvent event) throws IOException {
        String name = nameTextField.getText();
        String NID = nidTextField.getText();
        String prisonerIdstr = prisonerIdTextField.getText();
        if(prisonerIdstr.length() != 6) {
            Jailor.showAlert("Prison ID must be 6 digit");
            return;
        }
        int prisonerId = Integer.parseInt(prisonerIdstr);
        String status = statusComboBox.getValue();
        LocalDate dob = dateOfBirthDatePicker.getValue();
        String prisonerCellBlock = prisonerCellBlockComboBox.getValue();
        String gender = genderComboBox.getValue();
        Prisoner p = new Prisoner(name, NID, dob, prisonerId, gender, prisonerCellBlock, status);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCaseDetailsScene.fxml"));
        Parent root = loader.load();
        AddCaseDetailsSceneController ctrl = loader.getController();
        ctrl.data(p);
          
          
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void prisonIdOnClick(MouseEvent event) {
        int prisonerId = Integer.parseInt(prisonerIdTextField.getText());
        Prisoner tmp = Jailor.getPrisonerByPrisonerID(prisonerId);
        if(tmp!= null) {
            Jailor.showAlert("Prisoner ID Already exists!");
            return;
        }
    }
}
