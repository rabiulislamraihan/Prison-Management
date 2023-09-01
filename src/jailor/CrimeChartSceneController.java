/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package jailor;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;


public class CrimeChartSceneController implements Initializable {

    @FXML
    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoadCrimeChartButtonOnClick(MouseEvent event) {
        Map<String, Integer> crimeCounts = new HashMap<>();
        ObservableList <Prisoner> prisonerList = Jailor.ViewPrisonerlist();
        for (int i = 0; i < prisonerList.size(); i ++) {
            ArrayList<CaseDetail> caseList = prisonerList.get(i).getCaseList();
            for (int j = 0; j < caseList.size(); j ++) {
                crimeCounts.put(caseList.get(j).getCrime(), crimeCounts.getOrDefault(caseList.get(j).getCrime(), 0) + 1);
                
            }
        }
        ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : crimeCounts.entrySet()) {
            list.add( new PieChart.Data(entry.getKey(), entry.getValue()) );
            pieChart.setData(list);
        }
    }
    
}
