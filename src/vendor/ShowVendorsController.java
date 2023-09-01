/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vendor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import user.LogisticsOfficer;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class ShowVendorsController implements Initializable {

    @FXML
    private TableView<Vendor> vendorTableView;
    @FXML
    private TableColumn<Vendor, Integer> vendorIdColumn;
    @FXML
    private TableColumn<Vendor, String> nameColumn;
    @FXML
    private TableColumn<Vendor, String> contactPersonColumn;
    @FXML
    private TableColumn<Vendor, String> emailColumn;
    @FXML
    private TableColumn<Vendor, String> phoneColumn;
    @FXML
    private TableColumn<Vendor, String> typeColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vendorIdColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getVendorId()));
        nameColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getName()));
        contactPersonColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getContactPerson()));
        emailColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getEmail()));
        phoneColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getPhone()));
        typeColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getType()));
        
        vendorTableView.setItems(LogisticsOfficer.viewVendor());
        
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
