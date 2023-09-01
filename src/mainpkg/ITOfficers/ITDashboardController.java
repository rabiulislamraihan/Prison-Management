package mainpkg.ITOfficers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ITDashboardController implements Initializable {

    @FXML
    private BorderPane itOfficerDashBoardBorderPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void updateContentToEditAuthority() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("EditAuthority.fxml"));
        itOfficerDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void notificationButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("NotificationPanel.fxml"));
        itOfficerDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void goToHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/homepage/HomePage.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }

    @FXML
    private void showNotificationButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ShowNotification.fxml"));
        itOfficerDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void manageUserPanelButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ManageUser.fxml"));
        itOfficerDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void helpDeskButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("HelpDesk.fxml"));
        itOfficerDashBoardBorderPane.setCenter(parent);
    }

    @FXML
    private void sendRequestToDGButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SendRequestToDG.fxml"));
        itOfficerDashBoardBorderPane.setCenter(parent);
    }

    
}
