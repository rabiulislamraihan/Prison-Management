/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package jailor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class ViewPrisonerListSceneController implements Initializable {

    @FXML
    private TableView<Prisoner> tableView;
    @FXML
    private TableColumn<Prisoner, Integer> prisonIDColumn;
    @FXML
    private TableColumn<Prisoner, String> nameColumn;
    @FXML
    private TableColumn<Prisoner, Integer> nidColumn;
    @FXML
    private TableColumn<Prisoner, LocalDate> dobColumn;
    @FXML
    private TableColumn<Prisoner, String> genderColumn;
    @FXML
    private TableColumn<Prisoner, String> prisoncellBlockColumn;
    @FXML
    private TableColumn<Prisoner, String> statusColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        prisonIDColumn.setCellValueFactory(new PropertyValueFactory<Prisoner,Integer>("prisoner_id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Prisoner,String>("name"));
        nidColumn.setCellValueFactory(new PropertyValueFactory<Prisoner,Integer>("nid"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<Prisoner,LocalDate>("dateOfBirth"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<Prisoner,String>("gender"));
        prisoncellBlockColumn.setCellValueFactory(new PropertyValueFactory<Prisoner,String>("prisonCellBlock"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Prisoner,String>("Status"));

        
        ObservableList <Prisoner> list = Jailor.ViewPrisonerlist();
        tableView.getItems().addAll(list);
        // TODO
    }    

    @FXML
    private void ViewcaseInfoOnClick(MouseEvent event) throws IOException {
        Prisoner p = tableView.getSelectionModel().getSelectedItem();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewCaseDetailsScene.fxml"));
        Parent root = loader.load();
        ViewCaseDetailsSceneController ctrl = loader.getController();
        ctrl.data(p);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
}
