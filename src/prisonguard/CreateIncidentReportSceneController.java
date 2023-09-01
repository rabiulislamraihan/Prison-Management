/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package prisonguard;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;


public class CreateIncidentReportSceneController implements Initializable {

    @FXML
    private DatePicker incidentDateDatePicker;
    @FXML
    private TextArea ReportTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CreateIncidentReportOnClick(MouseEvent event) {
        
        LocalDate incidentDate = incidentDateDatePicker.getValue();
        String report = ReportTextArea.getText();
        IncidentReport i = new IncidentReport(report, incidentDate);
        PrisonGuard.addIncidentReport(i);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("Report has been successfully created !");
        a.showAndWait();
    }
    
}
