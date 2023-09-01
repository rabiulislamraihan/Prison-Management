/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package applications;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import user.VisitormanagementOfficer;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class ApprovedApplicationsByJailorSceneController implements Initializable {

    @FXML
    private TableView<Application> tableView;
    @FXML
    private TableColumn<Application, String> applicationIDColumn;
    @FXML
    private TableColumn<Application, String> applicantNameColumn;
    @FXML
    private TableColumn<Application, LocalDate> applicationDateColumn;
    @FXML
    private TableColumn<Application, String> applicationColumn;
    @FXML
    private TableColumn<Application, Boolean> isApprovedColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        applicationIDColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplicationID()));
        applicantNameColumn.setCellValueFactory(cellData -> {
            Integer applicantID = cellData.getValue().getNonAuthorityUserid();
            String applicantName = VisitormanagementOfficer.getAppNameForID(applicantID); 
            return new SimpleStringProperty(applicantName);
        });
        applicationDateColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getApplicationDate()));
        applicationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplication()));
        isApprovedColumn.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isIsApproved()));
        

        ObservableList<Application> applications = VisitormanagementOfficer.viewApprovedApplication();
        tableView.setItems(applications);
    }
}
    

