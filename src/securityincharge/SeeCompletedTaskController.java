/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package securityincharge;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class SeeCompletedTaskController implements Initializable {

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
        tableView.getItems().clear();
        ArrayList <AssignedTasks> list = SecurityInCharge.getAssignedTasksList();
        for (int i = 0; i <list.size(); i ++) {
            if(list.get(i).getTaskCompletionDescription()!=null &&
                    list.get(i).getTasks().getTaskStatus().equals("Complete")) {
                tableView.getItems().add(list.get(i));
            }
        }
        // TODO
    }    
    
}
