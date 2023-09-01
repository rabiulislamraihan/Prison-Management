/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nonauthorityuser;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import schedule.ScheduleApplication;
import user.NonAuthorityUser;
import user.VisitormanagementOfficer;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class PermissionCardPdfgeneratorController implements Initializable {

    @FXML
    private TableView<ScheduleApplication> tableView;
    @FXML
    private TableColumn<ScheduleApplication, String> dateColumn;
    @FXML
    private TableColumn<ScheduleApplication, String> startTimeColumn;
    @FXML
    private TableColumn<ScheduleApplication, String> endTimeColumn;
    @FXML
    private TableColumn<ScheduleApplication, String> activityColumn;
    @FXML
    private TableColumn<ScheduleApplication, String> nonAuthorityUserColumn;
    @FXML
    private TableColumn<ScheduleApplication, String> applicationColumn;
    @FXML
    private TableColumn<ScheduleApplication, ScheduleApplication> generatePDF;
    @FXML
    private TableColumn<ScheduleApplication, ScheduleApplication> sendEmailCol;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<ScheduleApplication> schedules = VisitormanagementOfficer.viewSchedules();
        System.out.println(schedules.toString());
        

        // Configure the cell value factories
        dateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        startTimeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartTime()));
        endTimeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndTime()));
        activityColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getActivity()));
        
        nonAuthorityUserColumn.setCellValueFactory(cellData -> {
        Integer applicantID = cellData.getValue().getApplication().getNonAuthorityUserid();
        String applicantName = VisitormanagementOfficer.getAppNameForID(applicantID); // Replace this with the actual method to get applicant name
        return new SimpleStringProperty(applicantName);
    });
        
        applicationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplication().getApplication()));


        generatePDF.setCellValueFactory(cellValue -> new ReadOnlyObjectWrapper<>(cellValue.getValue()));
        generatePDF.setCellFactory(cellValue -> new generatePDF());
        
        sendEmailCol.setCellValueFactory(cellValue -> new ReadOnlyObjectWrapper<>(cellValue.getValue()));
        sendEmailCol.setCellFactory(cellValue -> new SendEmailCell());

        
        tableView.setItems(schedules);
    } 
    
     private class generatePDF extends TableCell<ScheduleApplication, ScheduleApplication> {
    final Button sendToJailorButton = new Button("Generate PDF and send by E-mail");

    generatePDF() {
        sendToJailorButton.setOnAction(event -> {
            ScheduleApplication schedule = (ScheduleApplication) getTableRow().getItem();
            if (schedule != null) {
                    NonAuthorityUser nonAuthorityUser = getNameFromSchedule(schedule);
                    
                    showAlert("PDF generated");
                    System.out.println(schedule);
                    
                    VisitormanagementOfficer.generatePDFForApplication(schedule, nonAuthorityUser.getName()+"_"+nonAuthorityUser.getNid());
                    
                    sendToJailorButton.setText("Done");
                    sendToJailorButton.setDisable(true);
            }
        });
    }

    @Override
    protected void updateItem(ScheduleApplication schedule, boolean empty) {
        super.updateItem(schedule, empty);
        if (!empty) {
            setGraphic(sendToJailorButton);
        } else {
            setGraphic(null);
        }
    }
}
     
     
    private class SendEmailCell extends TableCell<ScheduleApplication, ScheduleApplication> {
        final Button sendEmailButton = new Button("Send Email");

        SendEmailCell() {
            sendEmailButton.setOnAction(event -> {
                ScheduleApplication schedule = (ScheduleApplication) getTableRow().getItem();
                if (schedule != null) {
                    sendEmail(schedule);
                    sendEmailButton.setText("Email Sent");
                    sendEmailButton.setDisable(true);
                }
            });
        }

        @Override
        protected void updateItem(ScheduleApplication schedule, boolean empty) {
            super.updateItem(schedule, empty);
            if (!empty) {
                setGraphic(sendEmailButton);
            } else {
                setGraphic(null);
            }
        }

        private void sendEmail(ScheduleApplication schedule) {
            NonAuthorityUser nonAuthorityUser = getNameFromSchedule(schedule);

            String from = "yourEmail@gmail.com"; 
            String to = nonAuthorityUser.getEmail().toString(); 
            String subject = "Permission Card";
            String attachment = nonAuthorityUser.getName()+"_"+nonAuthorityUser.getNid()+".pdf";
            String attachmentPath = "/home/calsifer/NetBeansProjects/JailMangement_Final_Shahal (copy 1)/"+nonAuthorityUser.getName()+"_"+nonAuthorityUser.getNid(); 


//            VisitormanagementOfficer.sendEmail(to, subject, subject, attachmentPath);
            VisitormanagementOfficer.sendEmailV2(to, subject, attachment, attachmentPath, attachment);
        }
    }
    
        private NonAuthorityUser getNameFromSchedule(ScheduleApplication schedule){
            Integer i = schedule.getApplication().getNonAuthorityUserid();
            ObservableList<NonAuthorityUser> tempList = VisitormanagementOfficer.ShowApprovedNonAuthorityUser();
            
            for(NonAuthorityUser nonAuthorityUser: tempList){
                if(nonAuthorityUser.getId().equals(i)){
                    return nonAuthorityUser;
                }
            }
            return null;
        }
    
        private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
