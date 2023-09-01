/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package homepage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class HomePageController implements Initializable {

    @FXML
    private Label homePageLabelfxid;
    @FXML
     BorderPane homepageBorderPanefxid;
    private Node initialCenterContent;
    private static HomePageController instance;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
 
  
    
    public Node getInitialCenterContent() {
        return initialCenterContent;
    }    

    public HomePageController(Node initialCenterContent) {
        this.initialCenterContent = initialCenterContent;
    }
    
    
    public static HomePageController getInstance() {
        return instance;
    }

    public HomePageController() {
        instance = this;
    }
    
    
    @FXML
    private void signUpButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/nonauthorityuser/NonAuthoritySignUp.fxml"));
        homepageBorderPanefxid.setCenter(parent);
//        homePageLabelfxid.setText("Sign Up Page");
    }

    @FXML
    private void logInButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/login/LogInPage.fxml"));
        homepageBorderPanefxid.setCenter(parent);
//        homePageLabelfxid.setText("Log In Page");
    }

    @FXML
    private void superUserButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/itofficer/AddAuthorityUserScene.fxml"));
        homepageBorderPanefxid.setCenter(parent);
    }
    
}
