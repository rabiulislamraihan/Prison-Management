/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package inventory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import user.LogisticsOfficer;

public class AddItemsInInventoryController implements Initializable {

    @FXML
    private TextField itemNameTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private DatePicker datePicker;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your components
    }

    @FXML
    private void addItemButtonOnClick(ActionEvent event) {
        Boolean alreadyThere = false;

        for (InventoryItem inventoryItem : LogisticsOfficer.viewInventory()) {
            if (inventoryItem.getItemName().equals(itemNameTextField.getText())) {
                inventoryItem.setQuantity(inventoryItem.getQuantity() + Integer.parseInt(quantityTextField.getText()));
                alreadyThere = true;
                break;
            }
        }

        if (!alreadyThere) {
            InventoryItem inventoryItem1 = new InventoryItem(
                    LogisticsOfficer.viewInventory().size() + 1,
                    itemNameTextField.getText(),
                    descriptionTextField.getText(),
                    Integer.parseInt(quantityTextField.getText()),
                    datePicker.getValue()
            );
            LogisticsOfficer.addToInventory(inventoryItem1);
        }
    }
}
