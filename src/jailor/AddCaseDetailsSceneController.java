
package jailor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class AddCaseDetailsSceneController implements Initializable {

    @FXML
    private TextField caseNoTextField;
    @FXML
    private ComboBox<String> crimeComboBox;
    @FXML
    private DatePicker timeServeStartsDatePicker;
    @FXML
    private DatePicker timeServeEndsDatePicker;
    @FXML
    private TextField actNoTextField;
    @FXML
    private TextField sentenceDurationTextField;
    private Prisoner p;
    @FXML
    private TextField caseIDTextField;
    private int caseNumber = 1;
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
    @FXML
    private TextField prisonerIDTextField;



    
    public void data(Prisoner p) {
        this.p = p;
        prisonerIDTextField.setText(Integer.toString(p.getPrisoner_id()));

    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        caseNoTextField.setText(Integer.toString(caseNumber));
        crimeComboBox.getItems().addAll(
            "Murder",
            "Theft",
            "Illegal drug trade",
            "Rape",
            "Cybercrime",
            "Violence",
            "Terrorism",
            "Money laundering",
            "Kidnapping",
            "Human trafficking");

        caseIDColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,Integer>("caseNo"));
        crimeColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,String>("crime"));
        tssColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,LocalDate>("timeServeStart"));
        tssColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,LocalDate>("timeServeEnds"));
        sentenceColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,String>("sentenceDuration"));
        ActColumn.setCellValueFactory(new PropertyValueFactory<CaseDetail,Integer>("actNo"));
    }    

    @FXML
    private void FinishButtonOnClick(MouseEvent event) throws IOException {
        Jailor.addNewPrisoner(p);
        Jailor.showAlert("Prisoner added succesfully\n");
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("JailorDashboard_1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void AddCaseButtonOnClick(MouseEvent event) {
        int caseID = Integer.parseInt(caseIDTextField.getText());
        String crime = crimeComboBox.getValue();
        LocalDate tss = timeServeStartsDatePicker.getValue();
        LocalDate tse = timeServeEndsDatePicker.getValue();
        int actNo = Integer.parseInt(actNoTextField.getText());
        String sentenceDuration = sentenceDurationTextField.getText();
        CaseDetail c = new CaseDetail(crime, caseID, actNo, tss, tse, sentenceDuration);
        p.getCaseList().add(c);
        
        
        caseIDTextField.setText("");
        actNoTextField.setText("");
        sentenceDurationTextField.setText("");
        caseNumber++;
        caseNoTextField.setText(Integer.toString(caseNumber));
        tableView.getItems().add(c);
    }
    
}
