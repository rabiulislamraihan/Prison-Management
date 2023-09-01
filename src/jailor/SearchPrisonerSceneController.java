/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package jailor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.dg.Cell;


public class SearchPrisonerSceneController implements Initializable {
    
    
    private Prisoner prisoner = null;
    @FXML
    private TextField NIDTextField;
    @FXML
    private Label optionallabel;
    @FXML
    private Label optionalOutputLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private TextField genderTextField;
    @FXML
    private TextField prisoncellTextField;
    @FXML
    private TextField statusTextField;
    @FXML
    private TextField prisonerIDTextField;
    @FXML
    private Button editButton;
    private boolean editable = false;
    @FXML
    private ComboBox<String> prisonecellComboBox;
    @FXML
    private ComboBox<String> StatusCombox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SearchByPrisonerIDOnClick(MouseEvent event) {
        prisoner = Jailor.getPrisonerByPrisonerID(Integer.parseInt(prisonerIDTextField.getText()));
        if(prisoner == null) {
            Jailor.showAlert("Prisoner Not Found !");
            return;
        }
        optionallabel.setText("NID: ");
        optionalOutputLabel.setText(prisoner.getNid());
        nameTextField.setText(prisoner.getName());
        dobDatePicker.setValue(prisoner.getDateOfBirth());
        genderTextField.setText(prisoner.getGender());
        prisoncellTextField.setText(prisoner.getPrisonCellBlock());
        statusTextField.setText(prisoner.getStatus());
        setAllDisable();
    }


    @FXML
    private void ViewCaseDetailsOnClick(MouseEvent event) throws IOException {
        if(prisoner == null) {
            Jailor.showAlert("Prisoner Not Found !");
            return;
        }
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewCaseDetailsScene.fxml"));
        Parent root = loader.load();
        ViewCaseDetailsSceneController ctrl = loader.getController();
        ctrl.data(prisoner);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SearchByNIDOnClick(MouseEvent event) {
        prisoner = Jailor.getPrisonerByNID(Integer.parseInt(NIDTextField.getText()));
        if(prisoner == null) {
            Jailor.showAlert("Prisoner Not Found !");
            return;
        }
        optionallabel.setText("Prisoner ID: ");
        optionalOutputLabel.setText(Integer.toString(prisoner.getPrisoner_id()));
        nameTextField.setText(prisoner.getName());
        dobDatePicker.setValue(prisoner.getDateOfBirth());
        genderTextField.setText(prisoner.getGender());
        prisoncellTextField.setText(prisoner.getPrisonCellBlock());
        statusTextField.setText(prisoner.getStatus());
        setAllDisable();
    }


    @FXML
    private void EditOrSaveButtonOnClick(MouseEvent event) {
        if(editable == false) {
            editable  = true;
            setAllEditable();
            editButton.setText("Save");
        }
        else {
            Jailor.update(prisoner, StatusCombox.getValue(), prisonecellComboBox.getValue());
            setAllDisable();
            editable = false;
            editButton.setText("Edit");
        }
    }
    private void setAllDisable() {
        nameTextField.setEditable(false);
        dobDatePicker.setEditable(false);
        genderTextField.setEditable(false);
        prisoncellTextField.setEditable(false);
        statusTextField.setEditable(false);
        prisonecellComboBox.setDisable(true);
        StatusCombox.setDisable(true);
    }
    private void setAllEditable() {
        prisoncellTextField.setEditable(true);
        statusTextField.setEditable(true);
        prisonecellComboBox.setDisable(false);
        StatusCombox.setDisable(false);
        StatusCombox.getItems().clear();
        StatusCombox.getItems().addAll(
            "Active", 
            "Inactive");
        
        prisonecellComboBox.getItems().clear();
        
        ObjectInputStream ois = null;
        try {
             Cell c;
             ois = new ObjectInputStream(new FileInputStream("Cell.bin"));

            while(true){
                c = (Cell) ois.readObject();
                prisonecellComboBox.getItems().add(Integer.toString(c.getCellNo()));
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
