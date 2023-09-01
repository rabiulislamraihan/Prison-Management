package mainpkg.MedicalOfficer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import login.LogInPageController;
import mainpkg.ITOfficers.Ticket;
import user.AuthorityUser;

public class HelpDeskToITOfficerController implements Initializable {

    @FXML
    private TextField helpDeskTitleTextField;
    @FXML
    private TextArea gelpDeskDescriptionTextArea;

    private AuthorityUser loggedInAuthorityUser;

    @FXML
    private TableView<Ticket> tableView1;
    @FXML
    private TableColumn<Ticket, Integer> closeTicketIDColumn1;
    @FXML
    private TableColumn<Ticket, String> closeTicketTittleColumn;
    @FXML
    private TableColumn<Ticket, LocalDate> sentTicketDateColumn;
    @FXML
    private TableColumn<Ticket, LocalDate> resolvedTicketDateColumn;
    @FXML
    private TableColumn<Ticket, String> descriptionTicketUserColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Object userObject = LogInPageController.getLoggedInUser();

        if (userObject instanceof AuthorityUser) {
            loggedInAuthorityUser = (AuthorityUser) userObject;
        } else {
            // Handle the case where the user object is not an AuthorityUser
        }

        ObservableList<Ticket> resolvedList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ResolvedTicketList.bin"))) {
            while (true) {
                try {
                    Ticket temp = (Ticket) ois.readObject();
                    System.out.println(" Ticket Sender: "+temp.getTicketSender());
                    System.out.println(" Ticket Logggef: "+loggedInAuthorityUser.getUserType());
                    if (temp.getTicketSender().equals(loggedInAuthorityUser.getUserType())) {
                        // Change According to UserType
                        resolvedList.add(temp);
                    }
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeTicketIDColumn1.setCellValueFactory(new PropertyValueFactory<>("ticketID"));
        closeTicketTittleColumn.setCellValueFactory(new PropertyValueFactory<>("ticketTitle"));
        resolvedTicketDateColumn.setCellValueFactory(new PropertyValueFactory<>("ticketClosedDate"));
        sentTicketDateColumn.setCellValueFactory(new PropertyValueFactory<>("ticketOpenDate"));
        descriptionTicketUserColumn.setCellValueFactory(new PropertyValueFactory<>("ticketDescription"));

        tableView1.setItems(resolvedList);
    }

    @FXML
    private void helpDeskSendButtonOnClick(ActionEvent event) {
        if (loggedInAuthorityUser != null) {
            String title = helpDeskTitleTextField.getText();
            String description = gelpDeskDescriptionTextArea.getText();
            String userSender =  loggedInAuthorityUser.getUserType();
            loggedInAuthorityUser.requestHelpDesk(title, description, userSender);
        } else {
            // Handle the case where loggedInAuthorityUser is null
        }
    }
}
