/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package financeandaccounting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class MonthlyBudgetChartSceneController implements Initializable {

    @FXML
    private ComboBox<String> selectMonthComboBox;
    @FXML
    private TextField yearTextField;
    @FXML
    private PieChart PieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        // TODO
    }    

    @FXML
    private void LoadPieChartButtonOnClick(MouseEvent event) {
        String month = selectMonthComboBox.getValue();
        int year = Integer.parseInt(yearTextField.getText());
        
        
        ObservableList <PieChart.Data> list = FXCollections.observableArrayList();
        
        
        ObjectInputStream ois = null;
        try {
             Budget c;
             ois = new ObjectInputStream(new FileInputStream("BudgetAllocation.bin"));
             
            while(true){
                c = (Budget) ois.readObject();
                if(c.getMonth().equals(month) && c.getYear() == year) {
                    list.add(new PieChart.Data("Food", c.getFood()));
                    list.add(new PieChart.Data("Clothes", c.getClothes()));
                    list.add(new PieChart.Data("Furniture", c.getFurniture()));
                    list.add(new PieChart.Data("HealthCare", c.getHealthCare()));
                    list.add(new PieChart.Data("Tools", c.getTools()));
                    PieChart.setData(list);
                    return;
                }
                
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
