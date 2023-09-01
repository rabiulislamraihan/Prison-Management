/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.ITOfficers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

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

    private int notificationID = 1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        notificationIDColumn.setCellValueFactory(new PropertyValueFactory<>("notificationID"));
        notificationDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("notificationDetails"));
        notificationDateColumn.setCellValueFactory(new PropertyValueFactory<>("notificationDate"));
        notificationUserColumn.setCellValueFactory(new PropertyValueFactory<>("notificationUserType"));
        
        tableView.setItems(ITOfficer.showNotification());
    }
    }    
    

