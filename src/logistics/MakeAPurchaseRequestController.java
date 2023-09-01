/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logistics;

import applications.Application;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import login.LogInPageController;
import user.AuthorityUser;
import user.LogisticsOfficer;
import user.User;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class MakeAPurchaseRequestController implements Initializable {

    @FXML
    private TextField assetNameTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private ComboBox<String> priorityComboBox;
    @FXML
    private TableView<AssetToBuy> viewAddedItem;
    @FXML
    private TableColumn<AssetToBuy, String> nameCol;
    @FXML
    private TableColumn<AssetToBuy, Integer> quantityCol;
    @FXML
    private TableColumn<AssetToBuy, String> priorityCol;
    @FXML
    private TableColumn<AssetToBuy, String> needCol;
    @FXML
    private DatePicker reqDatePicker;
    @FXML
    private TextField needTextField1;
    
    
    
    ObservableList<AssetToBuy> tempList = FXCollections.observableArrayList();

        
        
        
    @FXML
    private TableColumn<AssetToBuy, String> statusCol;
    @FXML
    private TextField typeTextField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        priorityComboBox.getItems().addAll("Urgent","Medium","Less");
        
        
        nameCol.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getAssetName()));
        quantityCol.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getQuantity()));
        priorityCol.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getPriority()));
        needCol.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getNeed()));
        statusCol.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getStatus()));
        
        
        
  
    }
    
    
    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        
        Object userObject = LogInPageController.getLoggedInUser();
            if (userObject instanceof AuthorityUser) {
            AuthorityUser auth = (AuthorityUser) userObject;
            
            
            
            System.out.println(auth.getName());
     
            PurchaseRequest purchaseRequest = new PurchaseRequest(
                                        LogisticsOfficer.viewPurchaseReq().size()+1,
                                        reqDatePicker.getValue(),
                                        auth.getName(), 
                                        tempList);
            
   
     
     LogisticsOfficer.makePurchaseReq(purchaseRequest);
//     clearFields();
            }  
             

    }

    @FXML
    private void addAssetButtonOnClick(ActionEvent event) {
        
                AssetToBuy assetToBuy = new AssetToBuy(
                                    assetNameTextField.getText(),
                                    Integer.parseInt(quantityTextField.getText()),
                                    priorityComboBox.getValue(),
                                    needTextField1.getText(),
                                    "Not accepted",
                                    typeTextField.getText());
                tempList.add(assetToBuy);
                viewAddedItem.setItems(tempList);
//                clearFields();
                
    }
    
    private void clearFields() {
    assetNameTextField.clear();
    quantityTextField.clear();
    priorityComboBox.getSelectionModel().clearSelection();
    needTextField1.clear();
    reqDatePicker.setValue(null);
    tempList.clear();
    viewAddedItem.setItems(tempList);
}
  
    

}
