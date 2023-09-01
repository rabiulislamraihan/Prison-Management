package mainpkg.ITOfficers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class NotificationPanelController implements Initializable {

    @FXML
    private TableView<Notification> tableView;
    @FXML
    private ComboBox<String> notificationUserComboBox;
    @FXML
    private TableColumn<Notification, Integer> notificationIDColumn;
    @FXML
    private TableColumn<Notification, String> notificationDetailsColumn;
    @FXML
    private TableColumn<Notification, LocalDate> notificationDateColumn;
    @FXML
    private TableColumn<Notification, String> notificationUserColumn;
    @FXML
    private TextArea notificationTextArea;

    private int notificationID = 1;

    // Initialize the controller class.
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Initialize the ComboBox with user types
        notificationUserComboBox.getItems().addAll(
                "Director General",
                "Visitor Management Officer",
                "Logistics Officer",
                "IT Officer",
                "Medical Workers",
                "JAILOR",
                "Security Incharge",
                "Finance and Accounting",
                "Trade",
                "All User"
        );

        notificationIDColumn.setCellValueFactory(new PropertyValueFactory<Notification, Integer>("notificationID"));
        notificationDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("notificationDetails"));
        notificationDateColumn.setCellValueFactory(new PropertyValueFactory<>("notificationDate"));
        notificationUserColumn.setCellValueFactory(new PropertyValueFactory<>("notificationUserType"));

        tableView.setItems(ITOfficer.showNotification()); ///tableView 
    }
    
//    Need to add deletebutton 

    @FXML
    private void sendNotificationButtonOnClick(ActionEvent event) {
        String selectedUserType = notificationUserComboBox.getValue();
        LocalDate currentDate = LocalDate.now();

        boolean notificationResult = ITOfficer.sendNotification(
                notificationID,
                notificationTextArea.getText(),
                currentDate,
                selectedUserType
        );

        if (notificationResult) {
            // Update the ObservableList with the new notification
            Notification newNotification = new Notification(notificationID,
                    notificationTextArea.getText(),
                    currentDate,
                    selectedUserType);
            tableView.getItems().add(newNotification); // Add the new notification to the table
            notificationID++; // Increment the notification ID for the next notification

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notification Result");
            alert.setHeaderText(null);
            alert.setContentText("Notification has been added successfully.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Notification Result");
            alert.setHeaderText("Error");
            alert.setContentText("Failed to add notification.");
            alert.showAndWait();
        }
    }

}


