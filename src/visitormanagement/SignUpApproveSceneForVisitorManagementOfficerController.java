/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package visitormanagement;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
import user.NonAuthorityUser;
import user.VisitormanagementOfficer;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class SignUpApproveSceneForVisitorManagementOfficerController implements Initializable {

  @FXML
    private TableView<NonAuthorityUser> tableView;
    @FXML
    private TableColumn<NonAuthorityUser, String> nameColumn;
    @FXML
    private TableColumn<NonAuthorityUser, LocalDate> dobColumn;
    @FXML
    private TableColumn<NonAuthorityUser, String> nidColumn;
    @FXML
    private TableColumn<NonAuthorityUser, String> fatherNameColumn;
    @FXML
    private TableColumn<NonAuthorityUser, String> motherNameColumn;
    @FXML
    private TableColumn<NonAuthorityUser, String> passwordColumn;
    @FXML
    private TableColumn<NonAuthorityUser, String> contactNoColumn;
    @FXML
    private TableColumn<NonAuthorityUser, String> addressColumn;
    @FXML
    private TableColumn<NonAuthorityUser, String> nationalityColumn;
    @FXML
    private TableColumn<NonAuthorityUser, String> userTypeColumn;
    @FXML
    private TableColumn<NonAuthorityUser, NonAuthorityUser> approveColumn;

    private ObservableList<NonAuthorityUser> approvedNonAuthorityUsers = FXCollections.observableArrayList();
    
    private ObservableList<NonAuthorityUser> tempList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
public void initialize(URL url, ResourceBundle rb) {
        // Initialize columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        nidColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        fatherNameColumn.setCellValueFactory(new PropertyValueFactory<>("fatherName"));
        motherNameColumn.setCellValueFactory(new PropertyValueFactory<>("motherName"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        contactNoColumn.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        userTypeColumn.setCellValueFactory(new PropertyValueFactory<>("userType"));

        // Add "Approve" button column
        approveColumn.setCellValueFactory(cellValue -> new ReadOnlyObjectWrapper<>(cellValue.getValue()));
        approveColumn.setCellFactory(cellValue -> new ApproveButtonCell());
        
        approvedNonAuthorityUsers = VisitormanagementOfficer.ShowApprovedNonAuthorityUser();
        
        if (approvedNonAuthorityUsers.isEmpty()) {
        tableView.setItems(VisitormanagementOfficer.viewSignUps());
        }else{

        for (NonAuthorityUser nonApprovedUser : VisitormanagementOfficer.viewSignUps()) {
            boolean foundInApprovedList = false;
    
                for (NonAuthorityUser approvedUser : approvedNonAuthorityUsers) {
                    if (nonApprovedUser.getNid().equals(approvedUser.getNid())) {
                        foundInApprovedList = true;
                        break;
                        }
                    }
    
                    if (!foundInApprovedList) {
                         tempList.add(nonApprovedUser);
                            System.out.println(tempList.size());
                }
            }

        tableView.setItems(tempList);
        System.out.println(tempList.toString());
        }
}
    private class ApproveButtonCell extends TableCell<NonAuthorityUser, NonAuthorityUser> {
        final Button approveButton = new Button("Approve");

        ApproveButtonCell() {
            approveButton.setOnAction((ActionEvent event) -> {
                NonAuthorityUser user = (NonAuthorityUser) getTableRow().getItem();
                if (user != null) {

                    VisitormanagementOfficer.approveSignUp(user);
                    
                    approveButton.setText("Approved");
                    approveButton.setDisable(true);
                    
                    approvedNonAuthorityUsers = VisitormanagementOfficer.ShowApprovedNonAuthorityUser();
                    System.out.println(approvedNonAuthorityUsers.toString());
        
                   
                    // Update your data source and refresh the table
//                    tableView.refresh();
                }
            });
        }


        @Override
        protected void updateItem(NonAuthorityUser user, boolean empty) {
            super.updateItem(user, empty);
            if (!empty) {
                setGraphic(approveButton);
            } else {
                setGraphic(null);
            }
        }
    }    
}
