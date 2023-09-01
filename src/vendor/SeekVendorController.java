/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vendor;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import login.LogInPageController;
import logistics.AssetToBuy;
import logistics.PurchaseRequest;
import schedule.ScheduleApplication;
import user.AuthorityUser;
import user.LogisticsOfficer;
import user.NonAuthorityUser;
import static user.VisitormanagementOfficer.getAppNameForID;
import static user.VisitormanagementOfficer.getUserForID;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class SeekVendorController implements Initializable {

    @FXML
    private ComboBox<String> purchaseReqComboBox;
    @FXML
    private ComboBox<String> itemComboBox;
    @FXML
    private TextArea selectedVendorsTextArea;
    @FXML
    private ComboBox<String> itemTypeComboBox;
    @FXML
    private ComboBox<String> availableVendorComboBox;
    @FXML
    private TextArea pdfViewTextArea;
    
    ObservableList<String> temp = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
@Override
public void initialize(URL url, ResourceBundle rb) {
    ObservableList<PurchaseRequest> temp1 = LogisticsOfficer.viewPurchaseReq();
    
    for (PurchaseRequest p : temp1) {
        purchaseReqComboBox.getItems().addAll(p.getItems().toString());
    }

    purchaseReqComboBox.setOnAction(event -> {
        String selectedPurchaseRequest = purchaseReqComboBox.getValue();
        
        for (PurchaseRequest p : temp1) {
            if (p.getItems().toString().equals(selectedPurchaseRequest)) {
                ObservableList<AssetToBuy> temp2 = LogisticsOfficer.viewAssetsToBuy(p);
                
                itemComboBox.getItems().clear();
                
                for (AssetToBuy assetToBuy : temp2) {
                    itemComboBox.getItems().add(assetToBuy.getAssetName());
                }
                break; 
            }
        }
    });

    itemComboBox.setOnAction(event -> {
        String selectedAssetName = itemComboBox.getValue();
        
        for (PurchaseRequest p : temp1) {
            ObservableList<AssetToBuy> temp2 = LogisticsOfficer.viewAssetsToBuy(p);
            
            for (AssetToBuy assetToBuy : temp2) {
                if (assetToBuy.getAssetName().equals(selectedAssetName)) {
                    itemTypeComboBox.getItems().clear();
                    itemTypeComboBox.getItems().addAll(assetToBuy.getType());
                    break;
                }
            }
        }
    });
    
    itemTypeComboBox.setOnAction(event -> {
        AssetToBuy assetToBuy1 = null;
        String selectedAssetName = itemComboBox.getValue();
        ObservableList<Vendor> temp3 = LogisticsOfficer.viewVendor();
            
            for (PurchaseRequest p : temp1) {
                ObservableList<AssetToBuy> temp2 = LogisticsOfficer.viewAssetsToBuy(p);
                    for (AssetToBuy assetToBuy : temp2) {
                        if (assetToBuy.getAssetName().equals(selectedAssetName)) {
                            assetToBuy1 = assetToBuy;
                            break;
                        }
                    }
            }
        for(Vendor vendor: temp3){
                        System.out.println("selectedAssettype"+assetToBuy1.getType());
                        System.out.println("vendor.getType()"+vendor.getType());
            if(vendor.getType().equals(assetToBuy1.getType())){
                availableVendorComboBox.getItems().clear();
                availableVendorComboBox.getItems().addAll(vendor.getName());
            }
        }
        
    });
    
        
    
    
    
    }
    @FXML
    private void onAddVendorsButtonClicked(ActionEvent event) {
        
                String memorandum = "----------------------------------------------------------------\n"
                + "Bangladesh Prison\n\n" +
                "Date: " + LocalDate.now().toString() + "\n" +
                "To: " + availableVendorComboBox.getValue() + "\n" +
                "From: " + getLoggedInUser() + "\n" +
                "Subject: Request for Vendor Information\n\n" +
                "Dear "+ availableVendorComboBox.getValue() +",\n\n" +
                "I hope this message finds you well. I am writing to request information about your products and services as we are interested in establishing a business partnership with your esteemed company.\n\n" +
                "We are currently in need of "+ itemComboBox.getValue() +" to support our operations. We have heard excellent reviews about your offerings and believe that they align well with our requirements.\n\n" +
                "Could you please provide us with the following information:\n" +
                "- Details of the [Item/Service] you offer\n" +
                "- Pricing information\n" +
                "- Delivery timelines\n" +
                "- Any other relevant details\n\n" +
                "We are looking for high-quality products/services and a reliable partner who can meet our organization's needs effectively. Your prompt response and cooperation in providing the requested information will be greatly appreciated.\n\n" +
                "Thank you for considering our request. Please feel free to reach out to me if you have any questions or require further information.\n\n" +
                "We look forward to the possibility of working together.\n\n" +
                "Sincerely,\n\n" +
                getLoggedInUser() + "\n\n"
                        +"----------------------------------------------------------------";
                
        temp.add(memorandum);

        String text = "Vendor " + availableVendorComboBox.getValue() + " selected for "+ itemComboBox.getValue();
        selectedVendorsTextArea.appendText(text + "\n");
    }

    @FXML
    private void onGeneratePdfButtonClicked(ActionEvent event) {
        for(String text: temp){
            makePDFFromText(text);
        }
                                 
    } 

    

    @FXML
    private void gobackButtonOnClick(ActionEvent event)  throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/logistics/LogisticsdashBoard.fxml"));
        Scene scene = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene);
        stg2.show();
    }
    
    
   private String getLoggedInUser(){
        Object loggedInUser = LogInPageController.getLoggedInUser();

            if (loggedInUser instanceof AuthorityUser) {
                AuthorityUser authorityUser = (AuthorityUser) loggedInUser;
                String userName = authorityUser.getName(); 
                System.out.println("Logged-in user's name: " + userName);
                return userName;
            } else if (loggedInUser instanceof NonAuthorityUser) {
                NonAuthorityUser nonAuthorityUser = (NonAuthorityUser) loggedInUser;
                String userName = nonAuthorityUser.getName(); 
                System.out.println("Logged-in user's name: " + userName);
                return userName;
            } else {
                System.out.println("No user logged in.");
                }
                return null;
        }

    @FXML
    private void onGenerateMemoButtonClicked(ActionEvent event) {
        
        for(String text : temp){
        pdfViewTextArea.appendText(text);
    }
}
    
    private void makePDFFromText(String text){
        try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
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
                
                String paraText1 = text;
                
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Ask for Memo");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    

                               
//                doc.add(pageTitle);
//                doc.add(lineSpace);
                doc.add(para1);
//                doc.add(lineSpace);
//                doc.add(lineSpace);
                
                //----------------------------------------------------
                

                
                //----------------------------------------------------
                //adding an image
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Do you want to add an Image?");
                Optional<ButtonType> result = a.showAndWait();
                if(result.get() == ButtonType.OK){ 
                    File imageFile = fc.showOpenDialog(null);
                    String imagePath = imageFile.getAbsolutePath();
                    ImageData data = ImageDataFactory.create(imagePath);
                    Image image = new Image(data);  
                    image.setAutoScale(true);
                    
                    doc.add(image);
                    doc.add(lineSpace);
                    a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("The image is added successfully.");
                    a.showAndWait();
                }
                //----------------------------------------------------
                
                
                doc.close();
                
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