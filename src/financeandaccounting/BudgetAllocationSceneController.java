/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package financeandaccounting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import msc.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class BudgetAllocationSceneController implements Initializable {

    @FXML
    private TextField BudgetTextField;
    @FXML
    private TextField FoodTextField;
    @FXML
    private TextField HealthCareTextField;
    @FXML
    private TextField ToolsTextField;
    @FXML
    private TextField FurnitureTextField;
    @FXML
    private TextField ClothesTextField;
    @FXML
    private TextArea showResultTextArea;
    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private TextField yearTextField;
    private int currentBudget = 1000000;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObjectInputStream ois = null;
        Budget oc = null;
        try {
             Budget c;
             ois = new ObjectInputStream(new FileInputStream("BudgetAllocation.bin"));
             
            while(true){
                c = (Budget) ois.readObject();
                currentBudget = c.getBudgetRemaining();
                
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
        BudgetTextField.setText(Integer.toString(currentBudget));
        monthComboBox.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "Deecember");
        // TODO
    }    

    @FXML
    private void AllocateBudgetOnClick(MouseEvent event) {
        int budget = Integer.parseInt(BudgetTextField.getText());
//        int food = Integer.parseInt(FoodTextField.getText());


        int food = 0;
        String foodbudget = FoodTextField.getText();
        if(!foodbudget.equals("")) {
            food = Integer.parseInt(foodbudget);
            
        }
        
        int healthCare = Integer.parseInt(HealthCareTextField.getText());
        int tools = Integer.parseInt(ToolsTextField.getText());
        int furniture = Integer.parseInt(FurnitureTextField.getText());
        int clothes = Integer.parseInt(ClothesTextField.getText());
        String month = monthComboBox.getValue();
        int year = Integer.parseInt(yearTextField.getText());
        currentBudget = budget - food - healthCare - tools - furniture - clothes;
        
        Budget b = new Budget(month, year, food, healthCare, tools, furniture, clothes, currentBudget);
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("BudgetAllocation.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(b);

        } catch (IOException ex) {
            Logger.getLogger(Budget.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Budget.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("Budget Has Been Allocated !");
        a.showAndWait();
        BudgetTextField.setText(Integer.toString(currentBudget));
        
    }

    @FXML
    private void ShowResultOnClick(MouseEvent event) {
        
        ObjectInputStream ois = null;
        showResultTextArea.setText("");
        try {
             Budget c;
             ois = new ObjectInputStream(new FileInputStream("BudgetAllocation.bin"));
             
            while(true){
                c = (Budget) ois.readObject();
                showResultTextArea.appendText(
                                "Month: " + c.getMonth() + ", " + 
                                "Year: " + c.getYear() + ", " + 
                                "Food: " + c.getFood() + ", " + 
                                "HealthCare: " + c.getHealthCare() + ", " + 
                                "Tools: " + c.getTools() + ", " + 
                                "Furniture: " + c.getFurniture() +  ", " + 
                                "Clothes: "  + c.getClothes() + ", " + 
                                "BudgetRemaining: " + c.getBudgetRemaining() + "\n");
               
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
