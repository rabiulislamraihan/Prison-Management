/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logistics;

import applications.Application;
import applications.CustomApplicationClassForJailorApproval;
import jailor.ApplicationApproveSceneForJailorController;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import jailor.Jailor;
import user.LogisticsOfficer;
import user.VisitormanagementOfficer;


/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class ViewPurchaseReqStatusController implements Initializable {

    @FXML
    private TableView<PurchaseRequest> purchaseRequestTableView;
    @FXML
    private TableColumn<PurchaseRequest, Integer> requestIdColumn;
    @FXML
    private TableColumn<PurchaseRequest, LocalDate> requestDateColumn;
    @FXML
    private TableColumn<PurchaseRequest, String> requestedByColumn;
    @FXML
    private TableColumn<PurchaseRequest, List<AssetToBuy>> assetsCol;
    @FXML
    private TableColumn<PurchaseRequest, PurchaseRequest> statusCol;
    
    
    private PurchaseRequest PR;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        requestIdColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getRequestId()));
        requestDateColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getRequestDate()));
        requestedByColumn.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getRequestedBy()));
        assetsCol.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getItems()));
        
        statusCol.setCellValueFactory(cellValue -> new ReadOnlyObjectWrapper<>(cellValue.getValue()));
        statusCol.setCellFactory(cellValue -> new ViewPurchaseReqStatusController.trackStatusCol());
        
        System.out.println(LogisticsOfficer.viewPurchaseReq());
        
        purchaseRequestTableView.setItems(LogisticsOfficer.viewPurchaseReq());
    }    
    
    
    
    
    private class trackStatusCol extends TableCell<PurchaseRequest, PurchaseRequest> {
        final Button statusCol = new Button("see status");

trackStatusCol() {
    statusCol.setOnAction((ActionEvent event) -> {
    PurchaseRequest purchaseRequest = (PurchaseRequest) getTableRow().getItem();
    if (purchaseRequest != null) {
        try {
            System.out.println("Loading FXML...");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/logistics/ViewRequestedAssetsStatus.fxml"));
            Parent scene2Parent = loader.load();
            

            System.out.println("FXML Loaded.");

            ViewRequestedAssetsStatusController viewRequestedAssetsStatusController = loader.getController();
            viewRequestedAssetsStatusController.data(purchaseRequest);

            System.out.println("Controller data set.");

            Scene scene = new Scene(scene2Parent);
            Stage stg2 = new Stage();
            stg2.setScene(scene);
            stg2.show();

            System.out.println("New scene displayed.");

            statusCol.setText("View Again");
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
});

}

        @Override
        protected void updateItem(PurchaseRequest purchaseRequest, boolean empty) {
            super.updateItem(purchaseRequest, empty);
            if (!empty) {
                setGraphic(statusCol);
            } else {
                setGraphic(null);
            }
        }
    } 
    
    public PurchaseRequest getSelectedPurchaseRequest () {
        return PR;
    }
    
}
