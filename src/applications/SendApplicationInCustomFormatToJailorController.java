/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package applications;

import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import applications.CustomClassToSendApplicationToJailorForApproval;
import user.VisitormanagementOfficer;
/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class SendApplicationInCustomFormatToJailorController implements Initializable {

    @FXML
    private TableView<CustomClassToSendApplicationToJailorForApproval> tableView;
    @FXML
    private TableColumn<CustomClassToSendApplicationToJailorForApproval, String> applicationIDColumn;
    @FXML
    private TableColumn<CustomClassToSendApplicationToJailorForApproval, LocalDate> applicationDateColumn;
    @FXML
    private TableColumn<CustomClassToSendApplicationToJailorForApproval, String> applicationColumn;
    @FXML
    private TableColumn<CustomClassToSendApplicationToJailorForApproval, Boolean> isApprovedColumn;
    @FXML
    private TableColumn<CustomClassToSendApplicationToJailorForApproval, CustomClassToSendApplicationToJailorForApproval> sendToJailorColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       applicationIDColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplicationID()));
       applicationDateColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getApplicationDate()));
       applicationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplication()));
       isApprovedColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().isIsApproved()));
       
       
        ObservableList<CustomClassToSendApplicationToJailorForApproval> tempList1 = FXCollections.observableArrayList(); 
        
        sendToJailorColumn.setCellValueFactory(cellValue -> new ReadOnlyObjectWrapper<>(cellValue.getValue()));
        sendToJailorColumn.setCellFactory(cellValue -> new SendApplicationInCustomFormatToJailorController.SendToJailorButtonCell());
        
        
        tempList1 = populateCustomTableForJailorApproval();
        tableView.setItems(tempList1);
        
        
    }  

private ObservableList<CustomClassToSendApplicationToJailorForApproval> populateCustomTableForJailorApproval() {
    ObservableList<Application> applicationsList = VisitormanagementOfficer.viewApplication();
    
    ObservableList<Application> approvedApplicationList = VisitormanagementOfficer.viewApprovedApplication();
    
    ObservableList<CustomClassToSendApplicationToJailorForApproval> tempList = FXCollections.observableArrayList();

    for (Application application : applicationsList) {
        boolean isApplicationApproved = isApplicationAlreadyApproved(application, approvedApplicationList);
//        for (Application approvedApplication : approvedApplicationList) {
//            if (application.getApplicationID().equals(approvedApplication.getApplicationID())) {
//                isApplicationApproved = true;
//                break;
//            }
//        }
        if (!isApplicationApproved){
        CustomClassToSendApplicationToJailorForApproval customClassToSendApplicationToJailorForApproval;
        customClassToSendApplicationToJailorForApproval = new CustomClassToSendApplicationToJailorForApproval(
            application.getApplicationID(),
            application.getApplicationDate(),
            application.getApplication(),
            application.isIsApproved());
        tempList.add(customClassToSendApplicationToJailorForApproval);
        }

    }
    return tempList;
}

private boolean isApplicationAlreadyApproved(Application application, ObservableList<Application> approvedByJailorList) {
    for (Application approvedApplication : approvedByJailorList) {
        if (application.getApplicationID().equals(approvedApplication.getApplicationID())) {
            return true;
        }
    }
    return false;
}
    
    private class SendToJailorButtonCell extends TableCell<CustomClassToSendApplicationToJailorForApproval, CustomClassToSendApplicationToJailorForApproval> {
        final Button SendToJailorButtonCell = new Button("Send To Jailor");

        SendToJailorButtonCell() {
            SendToJailorButtonCell.setOnAction((ActionEvent event) -> {
                CustomClassToSendApplicationToJailorForApproval customClassToSendApplicationToJailorForApproval = (CustomClassToSendApplicationToJailorForApproval) getTableRow().getItem();
                if (customClassToSendApplicationToJailorForApproval != null) {
                    
                    String applicationId = customClassToSendApplicationToJailorForApproval.getApplicationID();
                    ObservableList<Application> applicationsList = VisitormanagementOfficer.viewApplication();
                    for(Application application: applicationsList){
                        if(application.getApplicationID().equals(applicationId)){
                            VisitormanagementOfficer.sendToJailorApprovalWaiting(application);
                        }
                            
                    }

                    
                    SendToJailorButtonCell.setText("sent");
                    SendToJailorButtonCell.setDisable(true);
                   
//                    tableView.refresh();
                }
            });
        }

        // Display button if the row is not empty
        @Override
        protected void updateItem(CustomClassToSendApplicationToJailorForApproval customClassToSendApplicationToJailorForApproval, boolean empty) {
            super.updateItem(customClassToSendApplicationToJailorForApproval, empty);
            if (!empty) {
                setGraphic(SendToJailorButtonCell);
            } else {
                setGraphic(null);
            }
        }
    }    
    
}
