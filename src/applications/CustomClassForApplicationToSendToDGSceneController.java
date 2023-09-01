/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package applications;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import applications.CustomClassForApplicationToSendToDG;
import user.NonAuthorityUser;
import user.VisitormanagementOfficer;
/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class CustomClassForApplicationToSendToDGSceneController implements Initializable {

    @FXML
    private TableView<CustomClassForApplicationToSendToDG> tableView;
    @FXML
    private TableColumn<CustomClassForApplicationToSendToDG, String> applicantNameColumn;
    @FXML
    private TableColumn<CustomClassForApplicationToSendToDG, String> applicationBodyColumn;
    @FXML
    private TableColumn<CustomClassForApplicationToSendToDG, String> applicantIdColumn;
    @FXML
    private TableColumn<CustomClassForApplicationToSendToDG, String> applicationIdColumn;
    @FXML
    private TableColumn<CustomClassForApplicationToSendToDG, Boolean> isApprovedCol;

    @Override
public void initialize(URL url, ResourceBundle rb) {
    applicantNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplicantName()));
    applicantIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplicantid()));
    applicationIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplicationId()));
    applicationBodyColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplicationBody()));
    isApprovedCol.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isIsapproved()));

ObservableList<Application> applications = VisitormanagementOfficer.viewApplication();
ObservableList<Application> approvedApplications = VisitormanagementOfficer.viewApprovedApplication();
ObservableList<NonAuthorityUser> users = VisitormanagementOfficer.ShowApprovedNonAuthorityUser();

ObservableList<CustomClassForApplicationToSendToDG> customClassForApplicationToSendToDGList = FXCollections.observableArrayList();

for (Application application : applications) {
    boolean isApproved = false;
    String applicationId = application.getApplicationID();
    String applicationText = application.getApplication();

    for (Application approvedApp : approvedApplications) {
        if (application.getApplicationID().equals(approvedApp.getApplicationID())) {
            isApproved = true;
            applicationId = approvedApp.getApplicationID();
            applicationText = approvedApp.getApplication();
            break;
        }
    }

    for (NonAuthorityUser nonAuthorityUser : users) {
        if (nonAuthorityUser.getId().equals(application.getNonAuthorityUserid())) {
            CustomClassForApplicationToSendToDG data = new CustomClassForApplicationToSendToDG(
                nonAuthorityUser.getName(),
                Integer.toString(application.getNonAuthorityUserid()),
                applicationId,
                applicationText,
                isApproved
            );
            customClassForApplicationToSendToDGList.add(data);
        }
    }
}

tableView.getItems().addAll(customClassForApplicationToSendToDGList);
System.out.println(customClassForApplicationToSendToDGList.toString());

}


//    public Integer indexFinder(ObservableList<Application> applications, String targetNID) {
//        for (int i = 0; i < applications.size(); i++) {
//            Application application = applications.get(i);
//            if (application.getApplicant().getNid().equals(targetNID)) {
//                return i; // Found the application with the target NID
//            }
//        }
//        return null;
//    }
}