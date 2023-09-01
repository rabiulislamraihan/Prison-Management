
package securityincharge;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ShiftScheduleController implements Initializable {

    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private ComboBox<String> shiftNameComboBox;
    @FXML
    private TextField startTimeTextField;
    @FXML
    private TextField endTimeTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shiftNameComboBox.getItems().addAll(
                "Morning",
                "Day",
                "Night");
    }    

    @FXML
    private void NextButtonOnClick(MouseEvent event) throws IOException {
        LocalDate date = dateDatePicker.getValue();
        String shiftName = shiftNameComboBox.getValue();
        String startTime = startTimeTextField.getText();
        String endTime = endTimeTextField.getText();
        Shift s = new Shift(date,shiftName, startTime,endTime);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTask.fxml"));
        Parent root = loader.load();
        AddTaskController ctrl = loader.getController();
        ctrl.data(s);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
