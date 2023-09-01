/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package securityincharge;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import prisonguard.SendTaskDescriptionToSInchargeController;

public class TasksCompletionConfirmationSceneController implements Initializable {

    @FXML
    private TableView<AssignedTasks> tableView;
    @FXML
    private TableColumn<AssignedTasks, String> taskIDColumn;
    @FXML
    private TableColumn<AssignedTasks, String> TaskNameColumn;
    @FXML
    private TableColumn<AssignedTasks, String> ShiftColumn;
    @FXML
    private TableColumn<AssignedTasks, String> DateColumn;
    @FXML
    private TableColumn<AssignedTasks, String> StartTimeColumn;
    @FXML
    private TableColumn<AssignedTasks, String> EndColumn;
    @FXML
    private TableColumn<AssignedTasks, String> GuarrdIDColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        taskIDColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(Integer.toString(cellData.getValue().getTasks().getTaskId()));});
        TaskNameColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getTaskname());});
        ShiftColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getShift().getShift());});
        DateColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getShift().getDate().toString());});
        StartTimeColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getShift().getStartTime());});
        EndColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getShift().getEndTime());});
        GuarrdIDColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(Integer.toString(cellData.getValue().getAuthorityUser().getId()));});
        populatetable();
    }    

    @FXML
    private void SeeCompletionDescriptionOnClick(MouseEvent event) throws IOException {
        AssignedTasks at = tableView.getSelectionModel().getSelectedItem();
        
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeeCompletionTaskdescription.fxml"));
        Parent root = loader.load();
        SeeCompletionTaskdescriptionController ctrl = loader.getController();
        ctrl.data(at);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void MarkAsDoneOnClick(MouseEvent event) {
        AssignedTasks at = tableView.getSelectionModel().getSelectedItem();
        at.getTasks().setTaskStatus("Complete");
        SecurityInCharge.sendUpdates(at);
        populatetable();
    }
    private void populatetable() {
        tableView.getItems().clear();
        ArrayList <AssignedTasks> list = SecurityInCharge.getAssignedTasksList();
        ObservableList <AssignedTasks> oList = FXCollections.observableArrayList();
        for (int i = 0; i <list.size(); i ++) {
            if(!list.get(i).getTaskCompletionDescription().equals("") &&
                    list.get(i).getTasks().getTaskStatus().equals("Pending")) {
                oList.add(list.get(i));
            }
        }
        tableView.getItems().addAll(oList);
    }
}
