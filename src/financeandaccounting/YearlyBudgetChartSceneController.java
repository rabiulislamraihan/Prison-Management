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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class YearlyBudgetChartSceneController implements Initializable {

    @FXML
    private TextField yearTextField;
    @FXML
    private LineChart<String, Number> lineChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadButtonClick(MouseEvent event) {
        lineChart.getData().clear();
        int year = Integer.parseInt(yearTextField.getText());
        XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        series1.getData().add(new XYChart.Data<String,Number>("Jan", totalBudget("January", year)));
        series1.getData().add(new XYChart.Data<String,Number>("Feb", totalBudget("February", year)));
        series1.getData().add(new XYChart.Data<String,Number>("Mar", totalBudget("March", year)));
        series1.getData().add(new XYChart.Data<String,Number>("Apr", totalBudget("April", year)));
        series1.getData().add(new XYChart.Data<String,Number>("May", totalBudget("May", year)));
        series1.getData().add(new XYChart.Data<String,Number>("Jun", totalBudget("June", year)));
        series1.getData().add(new XYChart.Data<String,Number>("Jul", totalBudget("July", year)));
        series1.getData().add(new XYChart.Data<String,Number>("Aug", totalBudget("August", year)));
        series1.getData().add(new XYChart.Data<String,Number>("Sep", totalBudget("September", year)));
        series1.getData().add(new XYChart.Data<String,Number>("Oct", totalBudget("October", year)));
        series1.getData().add(new XYChart.Data<String,Number>("Nov", totalBudget("November", year)));
        series1.getData().add(new XYChart.Data<String,Number>("Dec", totalBudget("December", year)));

        series1.setName(Integer.toString(year));
        lineChart.getData().addAll(series1);
    }
    
    
    private int totalBudget(String month, int Yr) {
        ObjectInputStream ois = null;
        Budget oc = null;
        try {
             Budget c;
             ois = new ObjectInputStream(new FileInputStream("BudgetAllocation.bin"));
             
            while(true){
                c = (Budget) ois.readObject();
                if(c.getMonth().equals(month) && c.getYear() == Yr) {
                    oc = c;
                    break;
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
        if (oc == null) return 0;
        return oc.getClothes() + oc.getFood() + oc.getFurniture() + oc.getHealthCare() + oc.getTools();
    }
    
}


/*


public class UI2Controller implements Initializable {

    @FXML private Label lineChartLabel;
    @FXML private Button loadLineChartButton;
    @FXML private LineChart<String, Number> lineChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadLineChartButtonOnClick(ActionEvent event) {
        lineChart.getData().clear();
        XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        series1.getData().add(new XYChart.Data<String,Number>("Jan",200));
        series1.getData().add(new XYChart.Data<String,Number>("Feb",500));
        series1.getData().add(new XYChart.Data<String,Number>("Mar",300));
        series1.getData().add(new XYChart.Data<String,Number>("Apr",600));
        series1.setName("Pay-1");
        
        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        series2.getData().add(new XYChart.Data<String,Number>("Jan",400));
        series2.getData().add(new XYChart.Data<String,Number>("Feb",100));
        series2.getData().add(new XYChart.Data<String,Number>("Mar",800));
        series2.getData().add(new XYChart.Data<String,Number>("Apr",500));
        series2.setName("Pay-2");
        
        XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        series3.getData().add(new XYChart.Data<String,Number>("Jan",500));
        series3.getData().add(new XYChart.Data<String,Number>("Feb",900));
        series3.getData().add(new XYChart.Data<String,Number>("Mar",450));
        series3.getData().add(new XYChart.Data<String,Number>("Apr",650));
        series3.setName("Pay-3");
        
        lineChart.getData().addAll(series1,series2,series3);
        
        for(XYChart.Data<String,Number> data: series1.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
        for(XYChart.Data<String,Number> data: series2.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    //Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    //lineChartLabel.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );            
        }
        for(XYChart.Data<String,Number> data: series3.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
    }
    
}

*/
