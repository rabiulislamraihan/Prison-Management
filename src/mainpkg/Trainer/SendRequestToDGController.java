package mainpkg.Trainer;

import mainpkg.ITOfficers.*;
import mainpkg.Trainer.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import login.LogInPageController;
import mainpkg.dg.Request;
import user.AuthorityUser;
import msc.AppendableObjectOutputStream;

/**
 * FXML Controller class
 * 
 * This controller is responsible for sending requests to the Director General.
 *
 * @author crypticx
 */
public class SendRequestToDGController implements Initializable {

    @FXML
    private TextField reqeustIdFxid;
    @FXML
    private TextField requestDescriptionFxid;
    @FXML
    private ComboBox<String> requestTypeComboBox;
    
    private AuthorityUser loggedInAuthorityUser;
    
    @FXML
    private TableView<Request> requestHistoryTable;
    @FXML
    private TableColumn<Request, Integer> requestIDCol;
    @FXML
    private TableColumn<Request, String> requestTypeCol;
    @FXML
    private TableColumn<Request, LocalDate> requestDateCol;
    @FXML
    private TableColumn<Request, String> requestDescriptionCol;
    @FXML
    private TableColumn<Request, String> requestResponseCol;
    @FXML
    private TableColumn<Request, String> requestStatusCol;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        requestTypeComboBox.getItems().addAll(
            "Leave Of Absent",
            "Emergency Support",
            "Application",
            "Complaint",
            "Budget & Finance",
            "Approval",
            "Advice"
        );
        

        
        
        
        
        
        Object userObject = LogInPageController.getLoggedInUser();
        
        if (userObject instanceof AuthorityUser) {
            loggedInAuthorityUser = (AuthorityUser) userObject;
        } 
    }    
    
    private static int ticketCounter = 1;

    @FXML
    private void sendRequestToDGButtonOnClick(ActionEvent event) {
        Request newRequest = new Request(ticketCounter,
                requestTypeComboBox.getValue(),
                loggedInAuthorityUser.getUserType(),
                LocalDate.now(),
                requestDescriptionFxid.getText(),
                false,
                null
        );
        
        ticketCounter++;
        
        loggedInAuthorityUser.sendRequest(newRequest);
        reqeustIdFxid.setText(Integer.toString(ticketCounter));
    }

    @FXML
    private void loadTableButtonOnClick(ActionEvent event) {
        reqeustIdFxid.setText(Integer.toString(ticketCounter));
        requestIDCol.setCellValueFactory(new PropertyValueFactory<>("requestID"));
        requestTypeCol.setCellValueFactory(new PropertyValueFactory<>("requestType"));
        requestDateCol.setCellValueFactory(new PropertyValueFactory<>("requestTime"));
        requestDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("requestDescription"));
        requestResponseCol.setCellValueFactory(new PropertyValueFactory<>("requestResponse"));
        requestStatusCol.setCellValueFactory(new PropertyValueFactory<>("requestStatus"));
        requestHistoryTable.setItems(loggedInAuthorityUser.showRequestHistory());
    }
}
