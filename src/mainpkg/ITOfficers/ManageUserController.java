package mainpkg.ITOfficers;

import user.AuthorityUser;
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
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * author crypticx
 */
public class ManageUserController implements Initializable {


    private AuthorityUser user;
    private TableView<AuthorityUser> tableView; // Reference to the TableView
    @FXML
    private TableView<AuthorityUser> manageUserTableView;
    @FXML
    private TableColumn<AuthorityUser, Integer> userIDColumn;
    @FXML
    private TableColumn<AuthorityUser, String> userNameColumn;
    @FXML
    private TableColumn<AuthorityUser, String> userTypeColumn;

    // Setter for the TableView reference
    public void setTableView(TableView<AuthorityUser> tableView) {
        this.tableView = tableView;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  userIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        userTypeColumn.setCellValueFactory(new PropertyValueFactory<>("userType"));

        manageUserTableView.setItems(ITOfficer.showUsers());
        // TODO
    }



    @FXML
    private void addNewUserButtonOnClick(ActionEvent event) {
         try {
        Parent addUserParent = FXMLLoader.load(getClass().getResource("/itofficer/AddAuthorityUserScene.fxml"));
        Scene addUserScene = new Scene(addUserParent);

        // Get the correct Stage for switching scenes
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        currentStage.setScene(addUserScene);
        currentStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void editUserButtonOnClick(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditAuthorityUser.fxml"));
        Parent personViewParent = loader.load();

        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene personViewScene = new Scene(personViewParent);
        
        //access the controller
        EditAuthorityUserController controller = loader.getController();
        //controller = new PersonViewSceneController();
        controller.initData(manageUserTableView.getSelectionModel().getSelectedItem());
                
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
       
    }

    @FXML
    private void deleteUserButtonOnClick(ActionEvent event) {
        AuthorityUser removeUser = manageUserTableView.getSelectionModel().getSelectedItem();
        ITOfficer.deleteUser(removeUser);
        manageUserTableView.setItems(ITOfficer.showUsers());
        
        
        
    }

    @FXML
    private void generatePdfButtonOnClick(ActionEvent event) {
                AuthorityUser selectedUser = manageUserTableView.getSelectionModel().getSelectedItem();
        System.out.println(selectedUser);
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
                
                String paraText1 
                        = "Name: "+ selectedUser.getName() 
                        + "\nEmail:" + selectedUser.getEmail()
                        + "\nDesignation" + selectedUser.getUserType()
                        + "\nContact No "+ selectedUser.getContactNo()
                        + "\nDate Of Birth "+ selectedUser.dob
                        + "\nDate Of Joining "+ selectedUser.doj;
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("USER DETAILS OF " + selectedUser.getName());
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
