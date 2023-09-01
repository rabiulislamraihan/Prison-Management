package mainpkg.ITOfficers;

import user.AuthorityUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mainpkg.FileToObList;

public class EditAuthorityUserController implements Initializable {

    @FXML
    private TextField editIdTextField;
    @FXML
    private TextField editNameTextField;
    @FXML
    private TextField editPasswordTextField;
    @FXML
    private TextField editContactNoTextField;
    @FXML
    private TextField editEmailTextField;
    @FXML
    private ComboBox<String> editUserTypeComboBox;
    @FXML
    private DatePicker editDOBDatePicker;
    @FXML
    private DatePicker editDOJDatePicker;

    private AuthorityUser user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        editUserTypeComboBox.getItems().addAll("Director General",
                "Trainer ",
                "Visitor Management Officer",
                "Logistics officer",
                "IT Officer ",
                "Medical Workers",
                "JAILOR ",
                "Security Incharge",
                "Finance and Accounting",
                "Trade");
        // TODO
    }

    @FXML
    private void goToHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ITDashboard.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }

    private void openUserEditScene(AuthorityUser user) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditAuthorityUser.fxml"));
            Parent root = fxmlLoader.load();

            EditAuthorityUserController editUserController = fxmlLoader.getController();
            editUserController.initData(user); // Pass the selected user to the edit controller

            Stage editStage = new Stage();
            editStage.initModality(Modality.APPLICATION_MODAL);
            editStage.initStyle(StageStyle.UNDECORATED);
            editStage.setScene(new Scene(root));
            editStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    // This method is called from NotificationPanelController to pass the selected user
    public void initData(AuthorityUser user) {
        this.user = user;

        editIdTextField.setText(Integer.toString(user.getId()));
        editNameTextField.setText(user.getName());
        editEmailTextField.setText(user.getEmail());
        editDOBDatePicker.setValue(user.getDob());
        editDOJDatePicker.setValue(user.getDoj());
        editPasswordTextField.setText(user.getPassword());
        editContactNoTextField.setText(user.getContactNo());
        editEmailTextField.setText(user.getEmail());
        editUserTypeComboBox.setValue(user.getUserType());
    }

@FXML
private void editedUserButtonOnClick(ActionEvent event) {
    // Update the AuthorityUser object with the edited values
    user.setName(editNameTextField.getText());
    user.setEmail(editEmailTextField.getText());
    user.setDob(editDOBDatePicker.getValue());
    user.setDoj(editDOJDatePicker.getValue());
    user.setPassword(editPasswordTextField.getText());
    user.setContactNo(editContactNoTextField.getText());
    user.setUserType(editUserTypeComboBox.getValue());

    ObservableList<AuthorityUser> userList = FileToObList.readObjectsFromFile("AuthorityUserList.bin");

    for (int i = 0; i < userList.size(); i++) {
        AuthorityUser existingUser = userList.get(i);
        if (existingUser.getId() == user.getId()) {
            userList.set(i, user);
            FileToObList.writeObjectsToFile(userList, "AuthorityUserList.bin"); // Update the list in the file
            showAlert("AuthorityUser Details Changed successfully!");
            break; 
        }
    }
}
    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
    