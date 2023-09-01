/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package visitormanagement;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class ViewVarifiedNonAuthorityUsersController implements Initializable {

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
    private TableColumn<NonAuthorityUser, Integer> idcol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));

        ObservableList<NonAuthorityUser> approvedNonAuthorityUsers = VisitormanagementOfficer.ShowApprovedNonAuthorityUser();
        tableView.setItems(approvedNonAuthorityUsers);
    }    
    
}
