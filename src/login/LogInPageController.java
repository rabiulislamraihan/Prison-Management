package login;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import prisonguard.PrisonGuardHomePageSceneController;
import user.AuthorityUser;
import user.NonAuthorityUser;
import user.User;



public class LogInPageController implements Initializable {

    @FXML
    private TextField idTextFieldfxid;
    @FXML
    private TextField passwordTextFieldfxid;
    @FXML
    private ComboBox<String> userTypeComboBoxfxid;
    
    private static AuthorityUser loggedInAuthoriyUser;
    private static NonAuthorityUser loggedNonAuthorityInUser;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBoxfxid.getItems().addAll("Director General",
                "Trainer",
                "Visitor Management Officer",
                "Logistics officer",
                "IT Officer",
                "Medical Workers",
                "JAILOR",
                "Security Incharge",
                "Finance and Accounting",
                "Prison Guard",
                "Non Authority User");
        
       
    }

    @FXML
    private void logInButtonOnClick(ActionEvent event) throws IOException {
        String selectedUserType = userTypeComboBoxfxid.getValue();
        String inputId = idTextFieldfxid.getText();
        String inputPassword = passwordTextFieldfxid.getText();

        ObservableList<AuthorityUser> authorityUsers = varifyLogIn();
        ObservableList<NonAuthorityUser> nonAuthorityUsers = varifyLogInNonAuth();

        if (selectedUserType == null || inputId.isEmpty() || inputPassword.isEmpty()) {
            showAlert("Invalid input", AlertType.ERROR);
            return;
            
        } else if (userTypeComboBoxfxid.getValue().equals("Non Authority User")) {
            boolean loggedIn = false;
            for (NonAuthorityUser nonauthorityUser : nonAuthorityUsers) {
                if (inputId.equals(nonauthorityUser.getNid()) && inputPassword.equals(nonauthorityUser.getPassword())) {
                    loggedIn = true;
                    loggedNonAuthorityInUser = nonauthorityUser;
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/applications/ApplicationForm.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();

                    break;
                }
            }
            if (!loggedIn) {
                showAlert("Incorrect credentials", AlertType.ERROR);
            }
        } else {
    boolean loggedIn = false;
    for (AuthorityUser authorityUser : authorityUsers) {
        if (authorityUser.getId() == Integer.parseInt(inputId) && inputPassword.equals(authorityUser.getPassword())) {
            String userType = authorityUser.getUserType();
            
            System.out.println(userType);
            System.out.println(selectedUserType);

            if (userType.equals(selectedUserType)) {
                loggedIn = true;
                        System.out.println("yes");
                
                loggedInAuthoriyUser = authorityUser;
                navigateToDashboard(userType, event);
                break;  
            }
        }
    }
    if (!loggedIn) {
        System.out.println("nope");
        showAlert("Incorrect credentials", AlertType.ERROR);
    }
}
}

    private void showAlert(String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static ObservableList<AuthorityUser> varifyLogIn() {
        ObservableList<AuthorityUser> tempList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AuthorityUserList.bin"))) {
            while (true) {
                try {
                    AuthorityUser authorityUser = (AuthorityUser) ois.readObject();
                    tempList.add(authorityUser);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("AuthorityUser Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ApprovedAuthorityUser.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }

    public static ObservableList<NonAuthorityUser> varifyLogInNonAuth() {
        ObservableList<NonAuthorityUser> tempList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ApprovedNonAuthorityUser.bin"))) {
            while (true) {
                try {
                    NonAuthorityUser nonAuthorityUser = (NonAuthorityUser) ois.readObject();
                    tempList.add(nonAuthorityUser);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("NonAuthorityUser Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ApprovedNonAuthorityUser.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
    
    private void navigateToDashboard(String userType, ActionEvent event) throws IOException {
        Parent scene2Parent = null;
        if (userType.equals("Visitor Management Officer")) {
            scene2Parent = FXMLLoader.load(getClass().getResource("/visitormanagement/VisitorManagementDashboard.fxml"));
        } else if (userType.equals("JAILOR")) {
            scene2Parent = FXMLLoader.load(getClass().getResource("/jailor/JailorDashboard_1.fxml"));
        }  else if (userType.equals("Security Incharge")) {
            scene2Parent = FXMLLoader.load(getClass().getResource("/securityincharge/SecurityInChargeDashBoard.fxml"));
        }else if (userType.equals("IT Officer")) {
            scene2Parent = FXMLLoader.load(getClass().getResource("/mainpkg/ITOfficers/ITDashboard.fxml"));
        } else if (userType.equals("Trainer")) {
            scene2Parent = FXMLLoader.load(getClass().getResource("/mainpkg/Trainer/TrainerCommonDashboard.fxml"));
        }else if (userType.equals("Logistics officer")) {
            scene2Parent = FXMLLoader.load(getClass().getResource("/logistics/LogisticsdashBoard.fxml"));
        } else if (userType.equals("Non Authority User")) {
            scene2Parent = FXMLLoader.load(getClass().getResource("/applications/ApplicationForm.fxml"));
        } else if (userType.equals("Director General")) {
            scene2Parent = FXMLLoader.load(getClass().getResource("/mainpkg/dg/DGCommonDashboard.fxml"));
        }else if (userType.equals("Finance and Accounting")) {
            scene2Parent = FXMLLoader.load(getClass().getResource("/financeandaccounting/FinanceAndAccountingHomePage.fxml"));
        }else if (userType.equals("Medical Workers")) {
            scene2Parent = FXMLLoader.load(getClass().getResource("/mainpkg/MedicalOfficer/MedicalOfficerDashboard.fxml"));
        } else if (userType.equals("Prison Guard")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/prisonguard/PrisonGuardHomePageScene.fxml"));
            scene2Parent = loader.load();
            PrisonGuardHomePageSceneController ctrl = loader.getController();
            ctrl.data(loggedInAuthoriyUser);
            System.out.print(loggedInAuthoriyUser.getId());
        }

        if (scene2Parent != null) {
            Scene scene2 = new Scene(scene2Parent);
            Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stg2.setScene(scene2);
            stg2.show();
        }
    }
    
    public static Object getLoggedInUser() {
        if (loggedInAuthoriyUser != null) {
            return loggedInAuthoriyUser;
        } else if (loggedNonAuthorityInUser != null) {
            return loggedNonAuthorityInUser;
        } else {
            return null;
        }
    }
    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/homepage/HomePage.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }
}
