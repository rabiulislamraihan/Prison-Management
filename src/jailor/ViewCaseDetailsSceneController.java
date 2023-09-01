/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package jailor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ViewCaseDetailsSceneController implements Initializable {

    @FXML
    private TableView<CaseDetail> tableView;
    @FXML
    private TableColumn<CaseDetail, Integer> caseIDColumn;
    @FXML
    private TableColumn<CaseDetail, String> crimeColumn;
    @FXML
    private TableColumn<CaseDetail, LocalDate> tssColumn;
    @FXML
    private TableColumn<CaseDetail, String> sentenceColumn;
    @FXML
    private TableColumn<CaseDetail, Integer> ActColumn;
    @FXML
    private TableColumn<CaseDetail, LocalDate> tseColumn;
    
    private Prisoner prisoner;


    
    public void data(Prisoner p) {
        this.prisoner = p;
        ObservableList <CaseDetail> list = FXCollections.observableArrayList();
        for (int i = 0; i < p.getCaseList().size(); i ++) {
            list.add(p.getCaseList().get(i));
        }
        tableView.getItems().addAll(list);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        caseIDColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,Integer>("caseNo"));
        crimeColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,String>("crime"));
        tssColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,LocalDate>("timeServeStart"));
        tssColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,LocalDate>("timeServeEnds"));
        sentenceColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,String>("sentenceDuration"));
        ActColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,Integer>("actNo"));
        
    }    
    
}
