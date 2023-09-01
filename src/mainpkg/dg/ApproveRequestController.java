package mainpkg.dg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class ApproveRequestController implements Initializable {

    @FXML
    private TableView<Request> approveRequestTableViewFxid;
    @FXML
    private TableColumn<Request, Integer> requestIdTableColomnFxid;
    @FXML
    private TableColumn<Request, String> requestTypeTableColomnFxid;
    @FXML
    private TableColumn<Request, String> requestSenderTableColomnFxid;
    @FXML
    private TableColumn<Request, LocalDate> requestTimeTableColomnFxid;
    @FXML
    private TableColumn<Request, String> requestDescribtionTableColomnFxid;
    @FXML
    private TableColumn<Request, Boolean> statusTableColomnFxid;
    @FXML
    private TextArea commentTextAreaFxid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        requestIdTableColomnFxid.setCellValueFactory(new PropertyValueFactory<>("requestID"));
        requestTypeTableColomnFxid.setCellValueFactory(new PropertyValueFactory<>("requestType"));
        requestSenderTableColomnFxid.setCellValueFactory(new PropertyValueFactory<>("requestSender"));
        requestTimeTableColomnFxid.setCellValueFactory(new PropertyValueFactory<>("requestTime"));
        requestDescribtionTableColomnFxid.setCellValueFactory(new PropertyValueFactory<>("requestDescription"));
        statusTableColomnFxid.setCellValueFactory(new PropertyValueFactory<>("status"));
        
         approveRequestTableViewFxid.setItems(DG.showRequests());
        
        
    }

    @FXML
    private void approveButtonOnAction(ActionEvent event) {

    }

    @FXML
    private void declineButtonOnAction(ActionEvent event) {
        // Code for the decline button action
    }

    @FXML
    private void loadRequestButtonOnClick(ActionEvent event) {
      
    }

    }

