package notifications;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import login.LogInPageController;
import mainpkg.ITOfficers.Notification;
import user.AuthorityUser;
import user.NonAuthorityUser;
import user.VisitormanagementOfficer;
import user.User;

public class ShowNotificationController implements Initializable {

    @FXML
    private TableView<Notification> tableView;
    @FXML
    private TableColumn<Notification, Integer> notificationIDColumn;
    @FXML
    private TableColumn<Notification, String> notificationDetailsColumn;
    @FXML
    private TableColumn<Notification, LocalDate> notificationDateColumn;
    @FXML
    private TableColumn<Notification, String> notificationUserColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        notificationIDColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getNotificationID()));
        notificationDetailsColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getNotificationDetails()));
        notificationDateColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getNotificationDate()));
        notificationUserColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getNotificationUserType()));


        Object userObject = LogInPageController.getLoggedInUser();

        if (userObject instanceof AuthorityUser) {
            AuthorityUser loggedInAuthorityUser = (AuthorityUser) userObject;
            tableView.setItems(User.showNotification(loggedInAuthorityUser));
        } else if (userObject instanceof NonAuthorityUser) {
//            NonAuthorityUser loggedInNonAuthorityUser = (NonAuthorityUser) userObject;
//            tableView.setItems(User.showNotification(loggedInNonAuthorityUser));
        } else {
            System.out.println("No user logged in.");
        }
    }
}

