/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.MedicalOfficer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jailor.Prisoner;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainpkg.FileToObList;
import mainpkg.ITOfficers.EditAuthorityUserController;

/**
 * FXML Controller class
 *
 * @author crypticx
 */
public class PatientRecordController implements Initializable {

    @FXML
    private TableView<Prisoner> patientTable;
    @FXML
    private TableColumn<Prisoner, Integer> prisonerIDColumn;
    @FXML
    private TableColumn<Prisoner, String> patientNameCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Prisoner> prisonerData = FileToObList.readObjectsFromFile("Prisoner.bin");
                
                
                
                
        prisonerIDColumn.setCellValueFactory(new PropertyValueFactory<>("prisoner_id"));
        patientNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        patientTable.setItems(prisonerData);
        
    }    

    @FXML
    private void prescibeButtonOnClick(ActionEvent event) throws IOException {
                  FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PresciptionPage.fxml"));
        Parent prescripsonViewParent = loader.load();

        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene personViewScene = new Scene(prescripsonViewParent);
        
        //access the controller
        PresciptionPageController controller = loader.getController();
        //controller = new PersonViewSceneController();
        controller.initData(patientTable.getSelectionModel().getSelectedItem());
                
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }

    @FXML
    private void historyButtonOnClick(ActionEvent event) {
    }
    
}
