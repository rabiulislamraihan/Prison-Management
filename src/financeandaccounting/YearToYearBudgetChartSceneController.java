/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package financeandaccounting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class YearToYearBudgetChartSceneController implements Initializable {

    private TextField startYearTextField;
    private TextField endYearTextField;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private ComboBox<Integer> startYearComboBox;
    @FXML
    private ComboBox<Integer> endYearComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 2023; i < 2030; i ++) {
            startYearComboBox.getItems().add(i);
            endYearComboBox.getItems().add(i);
        }
        // TODO
    }    

    @FXML
    private void LoadButtonOnClick(MouseEvent event) {
        
        
        ObjectInputStream ois = null;
        Map<Integer, Integer> yearCount = new HashMap<>();
        try {
             Budget c;
             ois = new ObjectInputStream(new FileInputStream("BudgetAllocation.bin"));
             while(true){
                c = (Budget) ois.readObject();
                yearCount.put(c.getYear(), yearCount.getOrDefault(c.getYear(), 0) + getBudget(c));
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
        int startYear = Integer.parseInt(startYearTextField.getText());
        int endYear = Integer.parseInt(endYearTextField.getText());
        barChart.getData().clear();
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        for (int i = startYear; i<= endYear; i ++) {
            series.getData().add(new XYChart.Data<String,Number>(Integer.toString(i),yearCount.getOrDefault(i, 0)));
        }
        barChart.getData().add(series);
        
    }
    
    private int getBudget(Budget p) {
        return p.getClothes() + p.getFood() + p.getFurniture() + p.getHealthCare() + p.getTools();
    }
    
}
