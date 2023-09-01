package mainpkg.Trainer;

import jailor.Prisoner;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class AttandanceController implements Initializable {

    @FXML
    private TableView<Prisoner> attandanceTableViewFxid;
    @FXML
    private TableColumn<Prisoner, String> prisonerNameTableColomnFxid;
    @FXML
    private Label statusLabelForAttandance;
    @FXML
    private ComboBox<CustomClassToShowCourseAndPrisoner> attendanceCourseListComboBox;

    private ObservableList<CustomClassToShowCourseAndPrisoner> coursePrisonerList;
    @FXML
    private TableColumn<?, ?> prisonerIdTableColomnFxid;
    @FXML
    private TableColumn<?, ?> presentTableColomnFxid;
    @FXML
    private TableColumn<?, ?> presentTableColomnFxid1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coursePrisonerList = Trainer.courseAndPrisonerList();

        for (CustomClassToShowCourseAndPrisoner temp : coursePrisonerList) { 
            attendanceCourseListComboBox.getItems().addAll(temp);
        }
    }

    @FXML
    private void attendanceCourseListOnClick(ActionEvent event) {
        CustomClassToShowCourseAndPrisoner selectedCourse = attendanceCourseListComboBox.getValue();
        for (CustomClassToShowCourseAndPrisoner course : coursePrisonerList) {
            if (course.getTrainingCourse().equals(selectedCourse)) {
                
                prisonerNameTableColomnFxid.setCellValueFactory(new PropertyValueFactory<>("name"));
                // Populate the TableView with prisoner data for the selected course
                attandanceTableViewFxid.setItems((ObservableList<Prisoner>) course.getPrisonersList());
                // Set the CellValueFactory for the columns to display prisoner information

            }
        }
    }
}
