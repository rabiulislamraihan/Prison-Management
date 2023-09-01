/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package prisonguard;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;


public class ShowIncidentReportsSceneController implements Initializable {

    @FXML
    private ComboBox<String> selectReportComboBox;
    @FXML
    private TextArea showReportTextArea;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObjectInputStream ois = null;
        int i = 1;
        try {
             IncidentReport c;
             ois = new ObjectInputStream(new FileInputStream("IncidentReport.bin"));
             
            while(true){
                c = (IncidentReport) ois.readObject();
                selectReportComboBox.getItems().add(Integer.toString(i++));
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
        // TODO
    }    

    @FXML
    private void LoadButtonClick(MouseEvent event) {
        int incidentNumber = Integer.parseInt(selectReportComboBox.getValue());
        ObjectInputStream ois = null;
        int i = 1;
        try {
             IncidentReport c;
             ois = new ObjectInputStream(new FileInputStream("IncidentReport.bin"));
             
            while(true){
                c = (IncidentReport) ois.readObject();
                if(i == incidentNumber) {
                    showReportTextArea.setText("Incident Date: " + c.getIncidentDate() + "\n" + 
                            "Incident: " + "\n" + 
                            c.getReport());
                }
                selectReportComboBox.getItems().add(Integer.toString(i++));
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
