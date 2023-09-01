
package prisonguard;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class EmployeeEntrySceneController implements Initializable {

    @FXML
    private TextField EmployeeIDTextField;
    @FXML
    private TableView<EmployeeAttandance> tableView;
    @FXML
    private TableColumn<EmployeeAttandance, Integer> EmployeeIDColumn;
    @FXML
    private TableColumn<EmployeeAttandance, String > EmployeeNameColumn;
    @FXML
    private TableColumn<EmployeeAttandance, Date> EntryTimeColumn;
    @FXML
    private TableColumn<EmployeeAttandance, Date> ExitTimeColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EmployeeIDColumn.setCellValueFactory(new PropertyValueFactory<EmployeeAttandance,Integer>("EmployeeID"));
        EmployeeNameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeAttandance,String>("EmployeeName"));
        EntryTimeColumn.setCellValueFactory(new PropertyValueFactory<EmployeeAttandance,Date>("entry"));
        ExitTimeColumn.setCellValueFactory(new PropertyValueFactory<EmployeeAttandance,Date>("exit"));
        setTableView();
        // TODO
    }    

    @FXML
    private void AddEntryButtonClick(MouseEvent event) {
        
        int employeeID = Integer.parseInt(EmployeeIDTextField.getText());
        
        
        if(!PrisonGuard.EmployeeExistence(employeeID)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Employee Does Not Exist");
            a.showAndWait();
            return;
        }
        
        if(PrisonGuard.entried(employeeID)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Employee Already entried!");
            a.showAndWait();
            return;
        }
        else{
            EmployeeAttandance ea = PrisonGuard.AddAttandance(employeeID);
            ObservableList <EmployeeAttandance> list = FXCollections.observableArrayList();
            tableView.getItems().addAll(list);
            setTableView();
            
            
        }
    }

    @FXML
    private void AddExitButtonClick(MouseEvent event) {
        int employeeID = Integer.parseInt(EmployeeIDTextField.getText());
        
        
        if(!PrisonGuard.EmployeeExistence(employeeID)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Employee Does Not Exist");
            a.showAndWait();
        }
        
        
        if(!PrisonGuard.entried(employeeID)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Employee Has Not Entried");
            a.showAndWait();
        }
        else {
            PrisonGuard.UpdateExit(employeeID);
            setTableView();
        }
        
    }
    
    private void setTableView() {
        ObservableList <EmployeeAttandance> list = FXCollections.observableArrayList();
        
        ObjectInputStream ois = null;
        EmployeeAttandance oc = null;
        try {
             EmployeeAttandance c;
             ois = new ObjectInputStream(new FileInputStream("EmployeeAttandance.bin"));
             
            while(true){
                c = (EmployeeAttandance) ois.readObject();
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        tableView.setItems(list);
        
    }

    @FXML
    private void DownloadPDFButtonOnClick(MouseEvent event) {
        
        PrisonGuard.DownloadAttandance();
    }
    
}
