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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import user.AuthorityUser;

/**
 * FXML Controller class
 *
 * @author crypticx
 */
public class TicketDetailController implements Initializable {

    @FXML
    private TextField ticketIdTextField;
    private TextField editPasswordTextField;
    @FXML
    private TextField ticketDateTextField;
    @FXML
    private TextField ticketUserTextField;
    @FXML
    private TextArea textDetailsTextArea;
    private Ticket selectedTicket;
    @FXML
    private TextField ticketStatusTextField;
    @FXML
    private TextArea messageTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void initData(Ticket selectedTicket) {
        this.selectedTicket = selectedTicket;
        
       LocalDate localDate = selectedTicket.getTicketOpenDate();
        String dateString = localDate.toString();
        
        ticketIdTextField.setText(Integer.toString(selectedTicket.getTicketID()));
        ticketDateTextField.setText(dateString);
        
        ticketUserTextField.setText(selectedTicket.getTicketSender());
        ticketStatusTextField.setText(selectedTicket.getTicketStatus());
        textDetailsTextArea.setText(selectedTicket.getTicketDetails());
    }

    @FXML
    private void goToHomeButtonOnClick(ActionEvent event) throws IOException {
                Parent scene2Parent = FXMLLoader.load(getClass().getResource("/mainpkg/ITOfficers/ITDashboard.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }

    @FXML
    private void makeResolvedButtonOnClick(ActionEvent event) throws IOException {
        selectedTicket.setTicketMessage(messageTextArea.getText());
        ITOfficer.pendingToResolved(selectedTicket);
        System.out.println(selectedTicket);
        
        
    }
    
}
