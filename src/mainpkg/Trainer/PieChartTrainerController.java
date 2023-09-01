/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Trainer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PieChartTrainerController implements Initializable {

    @FXML
    private PieChart trainerCoursePieChart;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<PieChart.Data> tempPieChart = Trainer.pieChart();
    trainerCoursePieChart.setData(tempPieChart);
    
    
    }    
    
}
