/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java jnvffsjdto edit this template
 */
package financeandaccounting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import msc.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class BudgetAllocationSceneController implements Initializable {

    @FXML
    private TextField FoodTextField;
    @FXML
    private TextField HealthCareTextField;
    @FXML
    private TextField ToolsTextField;
    @FXML
    private TextField FurnitureTextField;
    @FXML
    private TextField ClothesTextField;
    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private TableView<Budget> tableView;
    @FXML
    private TableColumn<Budget, Integer> yearColumn;
    @FXML
    private TableColumn<Budget, String> monthColumn;
    @FXML
    private TableColumn<Budget, Integer> healthCare;
    @FXML
    private TableColumn<Budget, Integer> ToolsColumn;
    @FXML
    private TableColumn<Budget, Integer> FurnitureColumn;
    @FXML
    private TableColumn<Budget, Integer> ClothesColumn;
    @FXML
    private TableColumn<Budget, Integer> totalBudgetColumn;
    @FXML
    private ComboBox<Integer> yearComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        yearColumn.setCellValueFactory(new PropertyValueFactory<Budget,Integer>("Year"));
        monthColumn.setCellValueFactory(new PropertyValueFactory<Budget,String>("Month"));
        healthCare.setCellValueFactory(new PropertyValueFactory<Budget,Integer>("HealthCare"));
        ToolsColumn.setCellValueFactory(new PropertyValueFactory<Budget,Integer>("Tools"));
        FurnitureColumn.setCellValueFactory(new PropertyValueFactory<Budget,Integer>("Furniture"));
        ClothesColumn.setCellValueFactory(new PropertyValueFactory<Budget,Integer>("Clothes"));
        totalBudgetColumn.setCellValueFactory(new PropertyValueFactory<Budget,Integer>("TotalBudget"));

        monthComboBox.getItems().addAll(
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
                "Deecember");
        for (int i = 2023; i < 2030; i ++) {
            yearComboBox.getItems().add(i);
        }
    }    

    @FXML
    private void AllocateBudgetOnClick(MouseEvent event) {
        int food = Integer.parseInt(FoodTextField.getText());
        int healthCare = Integer.parseInt(HealthCareTextField.getText());
        int tools = Integer.parseInt(ToolsTextField.getText());
        int furniture = Integer.parseInt(FurnitureTextField.getText());
        int clothes = Integer.parseInt(ClothesTextField.getText());
        int total = food + healthCare + tools + furniture + clothes;
        
        String month = monthComboBox.getValue();
        int year = yearComboBox.getValue();
        
        Budget b = new Budget(month, year, food, healthCare, tools, furniture, clothes, total);
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("BudgetAllocation.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(b);

        } catch (IOException ex) {
            Logger.getLogger(Budget.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Budget.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("Budget Has Been Allocated !");
        a.showAndWait();
    }

    @FXML
    private void ShowResultOnClick(MouseEvent event) {
        tableView.getItems().clear();
        
        ObjectInputStream ois = null;
        try {
             Budget c;
             ois = new ObjectInputStream(new FileInputStream("BudgetAllocation.bin"));
             
            while(true){
                c = (Budget) ois.readObject();
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

    }
    
}
