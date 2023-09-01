package mainpkg.Trainer;

import jailor.Prisoner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;

public class AddPrisonerToCourseController implements Initializable {
    private ArrayList<Prisoner> prisonerData;
    private ArrayList<Prisoner> selectedPrisoners;

    @FXML
    private ComboBox<Prisoner> prisonerListComboBoxFxid;
    @FXML
    private ComboBox<String> courseListComboBoxFxid;
    @FXML
    private TextArea prisonerListTextArea;

    ArrayList<TrainingProgramCourses> trainingCourse;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Prisoner> prisonerData =Trainer.showPrisoner();
        selectedPrisoners = new ArrayList<>();
        
        
  
//        prisonerData.add(new Prisoner("Anika", 192322233, LocalDate.of(2022, 8, 2), 1, "Male", "Cell-02", "Jail 5 years"));
//        prisonerData.add(new Prisoner("Sakib", 192322233, LocalDate.of(2022, 8, 2), 1, "Male", "Cell-02", "Jail 5 years"));
//        prisonerData.add(new Prisoner("Rashim", 192322233, LocalDate.of(2022, 8, 2), 1, "Male", "Cell-02", "Jail 5 years"));
//        prisonerData.add(new Prisoner("Tasdir", 192322233, LocalDate.of(2022, 8, 2), 1, "Male", "Cell-02", "Jail 5 years"));
//        prisonerData.add(new Prisoner("Shahal", 192322233, LocalDate.of(2022, 8, 2), 1, "Male", "Cell-02", "Jail 5 years"));

        
       for (Prisoner tempPrisoner : prisonerData) {
            prisonerListComboBoxFxid.getItems().add(tempPrisoner);
        }
        prisonerListComboBoxFxid.getItems().addAll(prisonerData);

        trainingCourse = Trainer.showCourse();

        for (TrainingProgramCourses trainingProgramCourse : trainingCourse) {
            courseListComboBoxFxid.getItems().addAll(trainingProgramCourse.getCourseName());
        }
    }

    @FXML
    private void addPrisonerComboBoxOnClick(ActionEvent event) {
        Prisoner selectedPrisoner = prisonerListComboBoxFxid.getValue();
        if (selectedPrisoner != null) {
            prisonerListTextArea.appendText("ID: " + selectedPrisoner.getPrisoner_id() + " - Name: " + selectedPrisoner.getName() + "\n");
            selectedPrisoners.add(selectedPrisoner);
        }
    }

    @FXML
    private void addPrisonerToCourseButtonOnClick(ActionEvent event) {
        String courseName = courseListComboBoxFxid.getValue();

        boolean addPrisonerCourseResult = Trainer.addPrisonerToCourse(courseName, selectedPrisoners);
        if (addPrisonerCourseResult) {
            showAlert("Prisoners added to course successfully.");
        } else {
            showAlert("Failed to add prisoners to course.");
        }
    }

    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
