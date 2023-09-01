/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package securityincharge;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;


public class GeneratePfdOnTaskCompletionController implements Initializable {

    @FXML
    private TableView<AssignedTasks> tableView;
    @FXML
    private TableColumn<AssignedTasks, String> taskIDColumn;
    @FXML
    private TableColumn<AssignedTasks, String> TaskNameColumn;
    @FXML
    private TableColumn<AssignedTasks, String> ShiftColumn;
    @FXML
    private TableColumn<AssignedTasks, String> DateColumn;
    @FXML
    private TableColumn<AssignedTasks, String> StartTimeColumn;
    @FXML
    private TableColumn<AssignedTasks, String> EndColumn;
    @FXML
    private TableColumn<AssignedTasks, String> GuarrdIDColumn;
    @FXML
    private TableColumn<AssignedTasks, String> StatusColumn;
    
    ArrayList <AssignedTasks> list;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        taskIDColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(Integer.toString(cellData.getValue().getTasks().getTaskId()));});
        TaskNameColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getTaskname());});
        ShiftColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getShift().getShift());});
        DateColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getShift().getDate().toString());});
        StartTimeColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getShift().getStartTime());});
        EndColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getShift().getEndTime());});
        GuarrdIDColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(Integer.toString(cellData.getValue().getAuthorityUser().getId()));});
        StatusColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getTasks().getTaskStatus());});
        tableView.getItems().clear();
        list = SecurityInCharge.getAssignedTasksList();
        ObservableList <AssignedTasks> oList = FXCollections.observableArrayList();
        for (int i = 0; i <list.size(); i ++) {
                oList.add(list.get(i));
        }
        tableView.getItems().addAll(oList);
        
// TODO
    }    

    @FXML
    private void GeneratePDFOnClick(MouseEvent event) {
        
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));

            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                String filePath = file.getAbsolutePath();

                PdfWriter pdfWriter = new PdfWriter(filePath);
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                Document document = new Document(pdfDocument);
                
                
                for (int i = 0; i < list.size(); i ++) {
                    String text = list.get(i).toString();
                    Paragraph paragraph = new Paragraph(text);
                    document.add(paragraph);
                }
                document.close();
            }
        } catch (Exception e) {

        }
    }
    
}
