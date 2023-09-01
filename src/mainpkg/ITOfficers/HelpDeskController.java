/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.ITOfficers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import user.AuthorityUser;

/**
 * FXML Controller class
 *
 * @author crypticx
 */
public class HelpDeskController implements Initializable {

    @FXML
    private TableView<Ticket> HelpDeskPendingtableView;
    @FXML
    private TableColumn<Ticket, Integer> pendingTicketIDColumn;
    @FXML
    private TableColumn<Ticket, String> pendingTicketTitleColumn;
    @FXML
    private TableColumn<Ticket, LocalDate> pendingTicketDateColumn;
    @FXML
    private TableColumn<Ticket, String> pendingUserColumn;
    @FXML
    private TableColumn<Ticket, String> pendingTicketStatusColumn;
    @FXML
    private TableView<Ticket> tableView1;
    @FXML
    private TableColumn<Ticket, Integer> closeTicketIDColumn1;
    @FXML
    private TableColumn<Ticket, String> closeTicketTittleColumn;
    @FXML
    private TableColumn<Ticket, LocalDate> closedResolvedTicketDateColumn;
    @FXML
    private TableColumn<Ticket, LocalDate> closedReceivedTicketDateColumn;
    @FXML
    private TableColumn<Ticket, String> closeTicketUserColumn;
    @FXML
    private TableColumn<Ticket, String> closeTicketStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pendingTicketIDColumn.setCellValueFactory(new PropertyValueFactory<>("ticketID"));
        pendingTicketTitleColumn.setCellValueFactory(new PropertyValueFactory<>("ticketTitle"));
        pendingTicketDateColumn.setCellValueFactory(new PropertyValueFactory<>("ticketOpenDate"));
        pendingUserColumn.setCellValueFactory(new PropertyValueFactory<>("ticketSender"));
        pendingTicketStatusColumn.setCellValueFactory(new PropertyValueFactory<>("ticketStatus"));
        
        closeTicketIDColumn1.setCellValueFactory(new PropertyValueFactory<>("ticketID"));
        closeTicketTittleColumn.setCellValueFactory(new PropertyValueFactory<>("ticketTitle"));
        closedResolvedTicketDateColumn.setCellValueFactory(new PropertyValueFactory<>("ticketClosedDate"));
        closedReceivedTicketDateColumn.setCellValueFactory(new PropertyValueFactory<>("ticketOpenDate"));
        closeTicketUserColumn.setCellValueFactory(new PropertyValueFactory<>("ticketSender"));
        closeTicketStatus.setCellValueFactory(new PropertyValueFactory<>("ticketStatus"));
        
        HelpDeskPendingtableView.setItems(ITOfficer.showTicket());
        tableView1.setItems(ITOfficer.showClosedTicket());
    }    


    @FXML
    private void makeResolvedButtonOnClick(ActionEvent event) throws IOException {

    }


    @FXML
    private void deleteTicketButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void generateTicketPDFButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void openPendingButtonOnClick(ActionEvent event) throws IOException {
        Ticket tempTicket = HelpDeskPendingtableView.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TicketDetail.fxml"));
        Parent ticketViewParent = loader.load();

        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene ticketViewScene = new Scene(ticketViewParent);
        
        //access the controller
        TicketDetailController controller = loader.getController();
        //controller = new PersonViewSceneController();
        controller.initData(HelpDeskPendingtableView.getSelectionModel().getSelectedItem());
                
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(ticketViewScene);
        window.show();
       
    }

    @FXML
    private void pendintTicketOpenButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void pendingPDFGenerateButtonOnClick(ActionEvent event) {
    }
    
}
