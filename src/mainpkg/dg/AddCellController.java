/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.dg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddCellController implements Initializable {

    @FXML
    private TextField enterCellNoTextAreaFxid;
    @FXML
    private TextField blockNoTextAreaFxid;
    @FXML
    private TextField wingNoTextAreaFxid;
    @FXML
    private TextField cellCapacityTextAreaFxid;
    @FXML
    private TextField cellTypeTextAreaFxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void addCellToPrisonButtonOnClick(ActionEvent event) {

         Cell cell;
        cell = new Cell(
                Integer.parseInt(enterCellNoTextAreaFxid.getText()),
                blockNoTextAreaFxid.getText(),

                Integer.parseInt(wingNoTextAreaFxid.getText()),
                Integer.parseInt(cellCapacityTextAreaFxid.getText()),
                cellTypeTextAreaFxid.getText()
        );
        System.out.print(cell.toString());
        
        DG.addCell(cell);
        
    }
    
}
