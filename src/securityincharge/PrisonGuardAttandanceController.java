package securityincharge;

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


public class PrisonGuardAttandanceController implements Initializable {

    @FXML
    private TextField EmployeeIDTextField;
    @FXML
    private TableView<PrisonGuardAttandance> tableView;
    @FXML
    private TableColumn<PrisonGuardAttandance, Integer> EmployeeIDColumn;
    @FXML
    private TableColumn<PrisonGuardAttandance, String > EmployeeNameColumn;
    @FXML
    private TableColumn<PrisonGuardAttandance, Date> EntryTimeColumn;
    @FXML
    private TableColumn<PrisonGuardAttandance, Date> ExitTimeColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EmployeeIDColumn.setCellValueFactory(new PropertyValueFactory<PrisonGuardAttandance,Integer>("EmployeeID"));
        EmployeeNameColumn.setCellValueFactory(new PropertyValueFactory<PrisonGuardAttandance,String>("EmployeeName"));
        EntryTimeColumn.setCellValueFactory(new PropertyValueFactory<PrisonGuardAttandance,Date>("entry"));
        ExitTimeColumn.setCellValueFactory(new PropertyValueFactory<PrisonGuardAttandance,Date>("exit"));
        setTableView();
    }    

    @FXML
    private void AddEntryButtonClick(MouseEvent event) {
        
        int employeeID = Integer.parseInt(EmployeeIDTextField.getText());
        
        
        if(!SecurityInCharge.PrisonGuardExistence(employeeID)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Such Prison Guard Does Not Exist");
            a.showAndWait();
            return;
        }
        
        if(SecurityInCharge.PrisonGuardentried(employeeID)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("PrisonGuard Has  Already entried!");
            a.showAndWait();
            return;
        }
        else{
            PrisonGuardAttandance ea = SecurityInCharge.AddAttandance(employeeID);
            ObservableList <PrisonGuardAttandance> list = FXCollections.observableArrayList();
            tableView.getItems().addAll(list);
            setTableView();
        }
    }

    @FXML
    private void AddExitButtonClick(MouseEvent event) {
        int employeeID = Integer.parseInt(EmployeeIDTextField.getText());
        
        
        if(!SecurityInCharge.PrisonGuardExistence(employeeID)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Such Prison Guard Does Not Exist");
            a.showAndWait();
        }
        
        
        if(!SecurityInCharge.PrisonGuardentried(employeeID)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("PrisonGuard Has Not Entried");
            a.showAndWait();
        }
        else {
            SecurityInCharge.UpdateExit(employeeID);
            setTableView();
        }
        
    }
    
    private void setTableView() {
        ObservableList <PrisonGuardAttandance> list = FXCollections.observableArrayList();
        
        ObjectInputStream ois = null;
        PrisonGuardAttandance oc = null;
        try {
             PrisonGuardAttandance c;
             ois = new ObjectInputStream(new FileInputStream("PrisonGuardAttandance.bin"));
             
            while(true){
                c = (PrisonGuardAttandance) ois.readObject();
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
}

