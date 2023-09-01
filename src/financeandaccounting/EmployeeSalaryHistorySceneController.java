package financeandaccounting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class EmployeeSalaryHistorySceneController implements Initializable {

    @FXML
    private TableView<Salary> tableView;
    @FXML
    private TableColumn<Salary, Integer> employeeIDColumn;
    @FXML
    private TableColumn<Salary, String> MonthColumn;
    @FXML
    private TableColumn<Salary, Integer> YearColumn;
    @FXML
    private TableColumn<Salary, Integer> BaseSalaryColumn;
    @FXML
    private TableColumn<Salary, Integer> BounsColumn;
    @FXML
    private TableColumn<Salary, Integer> TotalColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("EmployeeID"));
        MonthColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("Month"));
        YearColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("Year"));
        BaseSalaryColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("BaseSalary"));
        BounsColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("Bonus"));
        TotalColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("TotalPay"));
        
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Salary c;
             ois = new ObjectInputStream(new FileInputStream("Salary.bin"));
             
            while(true){
                c = (Salary) ois.readObject();
                tableView.getItems().add(c);
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

        // TODO
    }    
    
}
