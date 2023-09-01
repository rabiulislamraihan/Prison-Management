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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class YearToYearBudgetChartSceneController implements Initializable {

    @FXML
    private TextField startYearTextField;
    @FXML
    private TextField endYearTextField;
    @FXML
    private BarChart<String, Number> barChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
/*
ObjectInputStream ois = null;
        Map<String, Integer> packageCounts = new HashMap<>();
        try {
             Subscriptions c;
             ois = new ObjectInputStream(new FileInputStream("Subscriptions.bin"));
             
            while(true){
                c = (Subscriptions) ois.readObject();
                packageCounts.put(c.getPackageID(), packageCounts.getOrDefault(c.getPackageID(), 0) + 1);
                
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
        
        for (Map.Entry<String, Integer> entry : packageCounts.entrySet()) {
            list.add( new PieChart.Data(entry.getKey(), entry.getValue()) );
            PieChart.setData(list);
        }

public class UI3Controller implements Initializable {

    @FXML private BarChart<String, Number> barChart;
    @FXML private NumberAxis yAxis;
    @FXML private CategoryAxis xAxis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("Farid",25));
        series.getData().add(new XYChart.Data<String,Number>("Shahed",150));
        series.getData().add(new XYChart.Data<String,Number>("Faria",160));
        series.getData().add(new XYChart.Data<String,Number>("Raihan",200));
        series.setName("Monthly Pay");
        barChart.getData().add(series);
    }    
    
}

*/
