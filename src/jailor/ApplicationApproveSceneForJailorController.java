/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package jailor;

import applications.Application;
import applications.CustomApplicationClassForJailorApproval;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
import user.VisitormanagementOfficer;
import user.NonAuthorityUser;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class ApplicationApproveSceneForJailorController implements Initializable {

    @FXML
    private TableColumn<CustomApplicationClassForJailorApproval, String> applicantNameCol;
    @FXML
    private TableColumn<CustomApplicationClassForJailorApproval, String> nidCol;
    @FXML
    private TableColumn<CustomApplicationClassForJailorApproval, String> applicationIdCol;
    @FXML
    private TableColumn<CustomApplicationClassForJailorApproval, String> applicationBodyCol;
    @FXML
    private TableColumn<CustomApplicationClassForJailorApproval, String> applicantTypeCol;
    @FXML
    private TableColumn<CustomApplicationClassForJailorApproval, CustomApplicationClassForJailorApproval> approveCol;
    @FXML
    private TableView<CustomApplicationClassForJailorApproval> jailorTableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                applicantNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
                nidCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNid()));
                applicationIdCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
                applicationBodyCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBody()));
                applicantTypeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplicanttype()));
                approveCol.setCellValueFactory(cellValue -> new ReadOnlyObjectWrapper<>(cellValue.getValue()));
                approveCol.setCellFactory(cellValue -> new ApplicationApproveSceneForJailorController.ApproveButtonCell());
                ObservableList<CustomApplicationClassForJailorApproval> tempList1 = populateCustomTableForJailorApproval();
                jailorTableView.setItems(tempList1);
    }   
    
    
    
 private class ApproveButtonCell extends TableCell<CustomApplicationClassForJailorApproval, CustomApplicationClassForJailorApproval> {
        final Button approveButtonCell = new Button("Approve by Jailor");

        ApproveButtonCell() {
            approveButtonCell.setOnAction((ActionEvent event) -> {
                CustomApplicationClassForJailorApproval customApplicationClassForJailorApproval = (CustomApplicationClassForJailorApproval) getTableRow().getItem();
                if (customApplicationClassForJailorApproval != null) {
                    
                    String applicationId = customApplicationClassForJailorApproval.getId();
                    ObservableList<Application> applicationsList = VisitormanagementOfficer.viewApplication();
                    for(Application application: applicationsList){
                        if(application.getApplicationID().equals(applicationId)){
                            application.setIsApproved(true);
                            Jailor.jailorApproval(application);
                        }
                    }
                    approveButtonCell.setText("sent");
                    approveButtonCell.setDisable(true);
                }
            });
        }

        // Display button if the row is not empty
        @Override
        protected void updateItem(CustomApplicationClassForJailorApproval customApplicationClassForJailorApproval, boolean empty) {
            super.updateItem(customApplicationClassForJailorApproval, empty);
            if (!empty) {
                setGraphic(approveButtonCell);
            } else {
                setGraphic(null);
            }
        }
    }  


private ObservableList<CustomApplicationClassForJailorApproval> populateCustomTableForJailorApproval() {
    ObservableList<Application> applicationsList = Jailor.viewPendingApplication();
    ObservableList<Application> approvedApplications = VisitormanagementOfficer.viewApprovedApplication();

    ObservableList<CustomApplicationClassForJailorApproval> tempList = FXCollections.observableArrayList();

    for (Application application : applicationsList) {
        boolean isApproved = false;

        for (Application approvedApplication : approvedApplications) {
            if (approvedApplication.getApplicationID().equals(application.getApplicationID())) {
                isApproved = true;
                break;
            }
        }

        if (!isApproved) {
            
            ObservableList<NonAuthorityUser> tempList2 = VisitormanagementOfficer.ShowApprovedNonAuthorityUser();
            for(NonAuthorityUser nonAuthorityUser: tempList2){
                if(nonAuthorityUser.getId().equals(application.getNonAuthorityUserid())){
                    
                CustomApplicationClassForJailorApproval customApplicationClassForJailorApproval;
                customApplicationClassForJailorApproval = new CustomApplicationClassForJailorApproval(
                        
                nonAuthorityUser.getName(),
                nonAuthorityUser.getNid(),
                application.getApplicationID(),
                application.getApplication(),
                nonAuthorityUser.getUserType()
            );
            tempList.add(customApplicationClassForJailorApproval);
                }
            }
            

        }
    }

    return tempList;
}

}