/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.dg;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import user.AuthorityUser;




public class ShowRequestController implements Initializable {

    @FXML
    private TableView<Request> pendingRequestTableViewFxid;
    @FXML
    private TableColumn<Request, Integer> pendingRequestIdColomnFxid;
    @FXML
    private TableColumn<Request, String> pendingRequestTypeColomnFxid;
    @FXML
    private TableColumn<Request, String> pendingRequestSenderColomnFxid;
    @FXML
    private TableColumn<Request, String> pendingRequestDescriptionColomnFxid;
    @FXML
    private TableView<Request> requestHistoryTableViewFxid;
    @FXML
    private TableColumn<Request, Integer> requestHistoryIDColumnFxid;
    @FXML
    private TableColumn<Request, String> requestHistorySenderColumnFxid;
    @FXML
    private TableColumn<Request, Boolean> requestHistoryStatusColumnFxid;
    @FXML
    private TableColumn<Request, LocalDate> pendingRequestTimeColomnFxid;
    @FXML
    private TextArea messageContentTextArea;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        pendingRequestIdColomnFxid.setCellValueFactory(new PropertyValueFactory<>("requestID"));
        pendingRequestTypeColomnFxid.setCellValueFactory(new PropertyValueFactory<>("requestType"));
        pendingRequestSenderColomnFxid.setCellValueFactory(new PropertyValueFactory<>("requestSender"));
        pendingRequestDescriptionColomnFxid.setCellValueFactory(new PropertyValueFactory<>("requestDescription"));
        pendingRequestTimeColomnFxid.setCellValueFactory(new PropertyValueFactory<>("requestTime"));
        DG.showRequests();
        
        requestHistoryIDColumnFxid.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getRequestID()));
        requestHistorySenderColumnFxid.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getRequestSender()));
        requestHistoryStatusColumnFxid.setCellValueFactory(cellData -> 
            new SimpleObjectProperty<>(cellData.getValue().getRequestStatus()));
        
        
        pendingRequestTableViewFxid.setItems(DG.showRequests()); 
        
          pendingRequestTableViewFxid.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
          
        
        pendingRequestTableViewFxid.setRowFactory(tv -> {
            TableRow<Request> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 2) {
                    // Process rowData
                }
            });
            return row;
        });
   

        
        
    }    

    @FXML
    private void approveButtonOnClick(ActionEvent event) {
 ObservableList<Request> selectedRows = pendingRequestTableViewFxid.getSelectionModel().getSelectedItems();
        for (Request selectedRow : selectedRows) {
            selectedRow.setRequestStatus(Boolean.TRUE);
            selectedRow.setRequestResponse(messageContentTextArea.getText());
            DG.approvedRequest(selectedRow);
            requestHistoryTableViewFxid.setItems(selectedRows);
            
            
            


            
 }
    }

    @FXML
    private void declineButtonOnClick(ActionEvent event) {
      ObservableList<Request> selectedRows = pendingRequestTableViewFxid.getSelectionModel().getSelectedItems();
        for (Request selectedRow : selectedRows) {
            selectedRow.setRequestResponse(messageContentTextArea.getText());
            selectedRow.setRequestStatus(Boolean.FALSE);
            DG.declinedRequest(selectedRow);
            
            requestHistoryTableViewFxid.setItems(selectedRows);   
        }    
        
    }

    @FXML
    private void generatePDFButtonOnClick(ActionEvent event) {
                        Request selectedRequest = pendingRequestTableViewFxid.getSelectionModel().getSelectedItem();
        System.out.println(selectedRequest);
              try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            File f = fc.showSaveDialog(null);
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                //PdfWriter pw = new PdfWriter(new FileOutputStream("testPDF.pdf"));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
                //----------------------------------------------------
                //adding paragrapg to the pdf
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 
                        = "Request ID: "+ selectedRequest.getRequestID()
                        + "\nRequest Type : " + selectedRequest.getRequestType()
                        + "\nTime :  "+ selectedRequest.getRequestTime()
                        + "\nSender :" + selectedRequest.getRequestSender()
                        + "\nDescription "+ selectedRequest.getRequestDescription();
                        
                       
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Request ID  " + selectedRequest.getRequestID());
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    //OR titleText.setBold();

                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

                
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                
                
                //----------------------------------------------------
//                //adding an image
//                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
//                a.setContentText("Do you want to add an Image?");
//                Optional<ButtonType> result = a.showAndWait();
//                if(result.get() == ButtonType.OK){ 
//                    File imageFile = fc.showOpenDialog(null);
//                    String imagePath = imageFile.getAbsolutePath();
//                    ImageData data = ImageDataFactory.create(imagePath);
//                    Image image = new Image(data);  
//                    image.setAutoScale(true);
//                    
//                    doc.add(image);
//                    doc.add(lineSpace);
//                    a = new Alert(Alert.AlertType.INFORMATION);
//                    a.setContentText("The image is added successfully.");
//                    a.showAndWait();
//                }
                //----------------------------------------------------
                
                         
                doc.close();
                Alert a;
                a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The PDF is saved successfully.");
                a.showAndWait();    
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
            //System.out.println("Something went wrong...");
            //System.out.println(e);
        } 
    }


    @FXML
    private void pdfGenerateButtonOnClick(ActionEvent event) {
         Request selectedRequest = pendingRequestTableViewFxid.getSelectionModel().getSelectedItem();
        System.out.println(selectedRequest);
              try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            File f = fc.showSaveDialog(null);
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                //PdfWriter pw = new PdfWriter(new FileOutputStream("testPDF.pdf"));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
                //----------------------------------------------------
                //adding paragrapg to the pdf
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 
                        = "Request ID: "+ selectedRequest.getRequestID()
                        + "\nRequest Type : " + selectedRequest.getRequestType()
                        + "\nTime :  "+ selectedRequest.getRequestTime()
                        + "\nSender :" + selectedRequest.getRequestSender()
                        + "\nDescription "+ selectedRequest.getRequestDescription()
                        + "\nDescription "+ selectedRequest.getRequestResponse();
                        
                       
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Request ID  " + selectedRequest.getRequestID());
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    //OR titleText.setBold();

                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

                
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                
                
                //----------------------------------------------------
//                //adding an image
//                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
//                a.setContentText("Do you want to add an Image?");
//                Optional<ButtonType> result = a.showAndWait();
//                if(result.get() == ButtonType.OK){ 
//                    File imageFile = fc.showOpenDialog(null);
//                    String imagePath = imageFile.getAbsolutePath();
//                    ImageData data = ImageDataFactory.create(imagePath);
//                    Image image = new Image(data);  
//                    image.setAutoScale(true);
//                    
//                    doc.add(image);
//                    doc.add(lineSpace);
//                    a = new Alert(Alert.AlertType.INFORMATION);
//                    a.setContentText("The image is added successfully.");
//                    a.showAndWait();
//                }
                //----------------------------------------------------
                
                         
                doc.close();
                Alert a;
                a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The PDF is saved successfully.");
                a.showAndWait();    
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
            //System.out.println("Something went wrong...");
            //System.out.println(e);
        } 
    }
    
}
