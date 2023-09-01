/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package schedule;

import applications.Application;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import user.VisitormanagementOfficer;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class MakeAppointmentSceneController implements Initializable {

 
    @FXML
    private TableView<Application> tableView;
    @FXML
    private TableColumn<Application, String> applicantNameColumn;
    @FXML
    private TableColumn<Application, String> applicationIDColumn;
    @FXML
    private TableColumn<Application, LocalDate> applicationDateColumn;
    @FXML
    private TableColumn<Application, String> applicationColumn;
    @FXML
    private TableColumn<Application, Boolean> isApprovedColumn;
    @FXML
    private TableColumn<Application, Application> appointmentCol;
    
    private Application selectedApplication;
    @FXML
    private TextField fromText;
    @FXML
    private TextField totext;
    @FXML
    private DatePicker dateText;
    @FXML
    private TextField reasontext;
    @FXML
    private TextField prisonertext;
     
//     private Application selectedApplication1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    applicantNameColumn.setCellValueFactory(cellData -> {
        Integer applicantID = cellData.getValue().getNonAuthorityUserid();
        String applicantName = VisitormanagementOfficer.getAppNameForID(applicantID); // Replace this with the actual method to get applicant name
        return new SimpleStringProperty(applicantName);
    });

    applicationIDColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplicationID()));
    applicationDateColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getApplicationDate()));
    applicationColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getApplication()));
    isApprovedColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().isIsApproved()));
    
    
    appointmentCol.setCellValueFactory(cellValue -> new ReadOnlyObjectWrapper<>(cellValue.getValue()));
    appointmentCol.setCellFactory(cellValue -> new MakeAppointmentSceneController.MakeAppointmentCell());
    
    ObservableList<Application> applications = VisitormanagementOfficer.viewApprovedApplication();
        tableView.setItems(applications);
    
    
    }

    @FXML
    private void appointButtonOnClick(ActionEvent event) {
        
                ScheduleApplication schedule = new ScheduleApplication(
                dateText.getValue(),
                fromText.getText(),
                totext.getText(),
                reasontext.getText(),
                selectedApplication,
                Integer.parseInt(prisonertext.getText()));
        
        VisitormanagementOfficer.makeAppointment(schedule);
    }

    
    private class MakeAppointmentCell extends TableCell<Application, Application> {
        final Button SendToJailorButtonCell = new Button("Make Appointment");

        MakeAppointmentCell() {
            SendToJailorButtonCell.setOnAction((ActionEvent event) -> {
                Application application = (Application) getTableRow().getItem();
                if (application != null) {
                    selectedApplication = application;

                    SendToJailorButtonCell.setText("go to appoint ");
                    SendToJailorButtonCell.setDisable(true);
                   
//                    tableView.refresh();
                }
            });
        }

        // Display button if the row is not empty
        @Override
        protected void updateItem(Application application, boolean empty) {
            super.updateItem(application, empty);
            if (!empty) {
                setGraphic(SendToJailorButtonCell);
            } else {
                setGraphic(null);
            }
        }
    }


    
}
