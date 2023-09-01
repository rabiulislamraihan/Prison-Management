/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logistics;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import user.LogisticsOfficer;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class ViewRequestedAssetsStatusController implements Initializable {

    @FXML
    private TableView<AssetToBuy> viewAssetsTableView;
    @FXML
    private TableColumn<AssetToBuy, String> nameCol;
    @FXML
    private TableColumn<AssetToBuy, String> statusCol;
    
    private PurchaseRequest PR;
    
    private ObservableList<AssetToBuy> tempList1 = FXCollections.observableArrayList();

        public void data(PurchaseRequest tmp) {
        this.PR = tmp;
        }

        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void loadStatusButtonOnClick(ActionEvent event) {
        System.out.println("second scene " + PR);
        
        nameCol.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getAssetName()));
        statusCol.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getStatus()));
        
//        List<AssetToBuy> tmpList = LogisticsOfficer.viewAssetsToBuy(PR);
//        for(AssetToBuy assetToBuy : tmpList){
//            tempList1.add(assetToBuy);
//        }
        viewAssetsTableView.setItems(LogisticsOfficer.viewAssetsToBuy(PR));

    }
    

}
