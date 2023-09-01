/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vendor;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import logistics.AssetToBuy;
import user.LogisticsOfficer;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class AddVendorController implements Initializable {

    @FXML
    private Label headingLabel;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField cpTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField typeTextField;
    @FXML
    private Button saveButton;
    @FXML
    private RadioButton tgText;
    @FXML
    private RadioButton tgComboBox;
    @FXML
    private ComboBox<String> typeComboBox;
    
        String s;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup toggleGroup = new ToggleGroup();
        tgText.setToggleGroup(toggleGroup);
        tgComboBox.setToggleGroup(toggleGroup);
        
        ObservableList<List<AssetToBuy>> temp = LogisticsOfficer.viewAllAssetToBuy();
        for(List<AssetToBuy> tempList:temp){
            for(AssetToBuy assetToBuy: tempList){
                typeComboBox.getItems().add(assetToBuy.getType());
            }
    }    }

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
    
        if(tgText.isSelected()){
            s = typeTextField.getText();  
        }else{
            s =  typeComboBox.getValue();   
        }
        
        Vendor vendor = new Vendor(LogisticsOfficer.viewVendor().size(),
                                 nameTextField.getText(),
                                 cpTextField.getText(),
                                 emailTextField.getText(),
                                 phoneTextField.getText(),
                                 s
                                 
        );
        
        LogisticsOfficer.addVendor(vendor);
        
        headingLabel.setText("New " + vendor.getType() + " vendor Added");
        nameTextField.clear();
        cpTextField.clear();
        emailTextField.clear();
        phoneTextField.clear();
        typeTextField.clear();
        saveButton.setText("Add another");
        
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/logistics/LogisticsdashBoard.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
        
    }
    
}
