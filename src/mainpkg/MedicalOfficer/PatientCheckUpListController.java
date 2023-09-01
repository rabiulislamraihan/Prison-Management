/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.MedicalOfficer;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.ITOfficers.ITOfficer;

/**
 * FXML Controller class
 *
 * @author crypticx
 */
public class PatientCheckUpListController implements Initializable {

    @FXML
    private TableView<Prescription> checkUpTable;
    @FXML
    private TableColumn<Prescription, Integer> idPatientCol;
    @FXML
    private TableColumn<Prescription, String> namePatientCol;
    @FXML
    private TableColumn<Prescription, LocalDate> dateCol;
    @FXML
    private TableColumn<Prescription, String> desCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         idPatientCol.setCellValueFactory(new PropertyValueFactory<>("prisonerID"));
        namePatientCol.setCellValueFactory(new PropertyValueFactory<>("prisonerLatestPrescrition"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("prisonerLastConsult"));
        desCol.setCellValueFactory(new PropertyValueFactory<>("presciptionDetails"));
        

        checkUpTable.setItems(Medicalofficer.showAllPresciption());
        
        // TODO
    }    
    
}
