package mainpkg.Trainer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TrainingProgramController implements Initializable {

    @FXML
    private TextField enterCourseIdTextFieldFxid;
    @FXML
    private TextField enterCourseNameTextFieldFxid;
    @FXML
    private ComboBox<String> courseTypeComboBoxFxid;
    @FXML
    private ComboBox<String> courseDurationComboBoxFxid;
    @FXML
    private TextField courseCapacityTextFieldFxid;
    @FXML
    private TextArea courseDescribtionTextAreaFxid;
    @FXML
    private ComboBox<String> courseTimeComboBoxFxid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        courseTypeComboBoxFxid.getItems().addAll(
                "Educational", "NonEducational"
        );
        courseDurationComboBoxFxid.getItems().addAll(
                "One Month",
                "Two Month"
        );
        courseTimeComboBoxFxid.getItems().addAll(
        "ST-11:00AM-01:00PM",
        "ST-02:00PM-04:00PM"
        );
        
    }

    @FXML
    private void addCoursesButtonOnClick(ActionEvent event) {
        TrainingProgramCourses trainingProgramCourses;
        trainingProgramCourses = new TrainingProgramCourses(
                Integer.parseInt(enterCourseIdTextFieldFxid.getText()),
                enterCourseNameTextFieldFxid.getText(),
                courseTypeComboBoxFxid.getValue(),
                courseDurationComboBoxFxid.getValue(),
                Integer.parseInt(courseCapacityTextFieldFxid.getText()),
                courseTimeComboBoxFxid.getValue(),
                courseDescribtionTextAreaFxid.getText()
        );
        System.out.print(trainingProgramCourses.toString());

//        if (Trainer.validateData(trainingProgramCourses)) {
            Trainer.addNewTrainingCourse(trainingProgramCourses);
//        }
    }
}
