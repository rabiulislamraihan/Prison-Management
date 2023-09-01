
package financeandaccounting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import user.AuthorityUser;


public class PaySalarySceneController implements Initializable {

    @FXML
    private TextField EmployeeIDTextField;
    @FXML
    private TextField BonusTextField;
    @FXML
    private TableView<Salary> tableView;
    @FXML
    private TableColumn<Salary, Integer> employeeIDColumn;
    @FXML
    private TableColumn<Salary, String> gradeColumn;
    @FXML
    private TableColumn<Salary, Integer> AmmountColumn;
    @FXML
    private ComboBox<String> selectUserComboBox;
    @FXML
    private ComboBox<String> selectMonthComboBox;
    String grade = null;
    int ammount = 0;
    String month = "";
    int bonus = 0;
     ArrayList <AuthorityUser> list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("employeeID"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("grade"));
        AmmountColumn.setCellValueFactory(new PropertyValueFactory<Salary,Integer>("ammount"));
        
        
        selectMonthComboBox.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
        
        selectUserComboBox.getItems().addAll("Director General",
                "Trainer",
                "Visitor Management Officer",
                "Logistics officer",
                "IT Officer",
                "Medical Workers",
                "JAILOR",
                "Prison Guard",
                "Security Incharge",
                "Finance and Accounting");
    }    

    @FXML
    private void PaySalaryToEmployeeButtonOnClick(MouseEvent event) {
        
        if(!FinanceAndAccountOfficer.EmployeeExistence(Integer.parseInt(EmployeeIDTextField.getText()))) {
            FinanceAndAccountOfficer.showAlert("Employee Not Foun");
            return;
        }
        getInfo();
        Salary s = new Salary (Integer.parseInt(EmployeeIDTextField.getText()), grade, ammount, selectMonthComboBox.getValue(), Integer.parseInt(BonusTextField.getText()));
        FinanceAndAccountOfficer.paySalary(s);
        FinanceAndAccountOfficer.showAlert("Salary has been paid");
        
    }
    public void getInfo() {
        String userType = selectUserComboBox.getValue();
            if(userType.equals("Director General")) {
                grade = "Grade 1";
                ammount = 75000;
            }
            if(userType.equals("JAILOR")) {
                grade = "Grade 10";
                ammount = 20500;
            }
            if(userType.equals("IT Officer")) {
                grade = "Grade 9";
                ammount = 23500;
            }
            if(userType.equals("Prison Guard")) {
                grade = "Grade 18";
                ammount = 8800;
            }
            if(userType.equals("Finance and Accounting")) {
                grade = "Grade 9";
                ammount = 23500;
            }
            if(userType.equals("Logistics officer")) {
                grade = "Grade 9";
                ammount = 23500;
            }
            if(userType.equals("Medical Workers")) {
                grade = "Grade 9";
                ammount = 23500;
            }
            if(userType.equals("Security Incharge")) {
                grade = "Grade 10";
                ammount = 16000;
            }
            if(userType.equals("Trainer")) {
                grade = "Grade 15";
                ammount = 9700;
            }
            if(userType.equals("Visitor Management Officer")) {
                grade = "Grade 13";
                ammount = 11000;
            }
    }

    @FXML
    private void loadEmployeeButtonClick(MouseEvent event) {
        getInfo();
        String userType = selectUserComboBox.getValue();
           list = FinanceAndAccountOfficer.getSelectedEmployee(userType);
           tableView.getItems().clear();
            for (int i = 0; i < list.size(); i ++) {
                Salary s = new Salary(list.get(i).getId(), grade, ammount, month, bonus);
                tableView.getItems().add(s);
        }
        
        
    }

    @FXML
    private void PaySalaryToAllEmployeeButtonOnClick(MouseEvent event) {
        for (int i = 0; i < list.size(); i ++) {
            Salary s =  new Salary(list.get(i).getId(), grade, ammount, selectMonthComboBox.getValue(), Integer.parseInt(BonusTextField.getText()));
            FinanceAndAccountOfficer.paySalary(s);
        }
        FinanceAndAccountOfficer.showAlert("Salary has been paid");
        
        
        
    }
}
