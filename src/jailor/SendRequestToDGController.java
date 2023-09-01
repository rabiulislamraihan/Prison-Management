package jailor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class SendRequestToDGController implements Initializable {

    @FXML
    private TextField reqeustIdFxid;
    @FXML
    private TextField requestTypeFxid;
    @FXML
    private TextField requestSenderFxid;
    @FXML
    private DatePicker requestTimeDatePickerFxid;

    @FXML
    private TextField requestDescriptionFxid;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void sendRequestToDGButtonOnClick(ActionEvent event) {
        
        Request request;
        request = new Request(
                Integer.parseInt(reqeustIdFxid.getText()),
                requestTypeFxid.getText(),
                requestSenderFxid.getText(),
                requestTimeDatePickerFxid.getValue(),
                requestDescriptionFxid.getText());
        
        
        System.out.print(request.toString());
    }
}

        
        
        
        
        
