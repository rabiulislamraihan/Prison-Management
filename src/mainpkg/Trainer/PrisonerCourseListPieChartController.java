package mainpkg.Trainer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

public class PrisonerCourseListPieChartController implements Initializable {

    @FXML
    private PieChart prisonerCourseListPieChartFxid;
    @FXML
    private Label statusLabelfxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<PieChart.Data> newChartData = Trainer.prisonerCountPieChart();

            prisonerCourseListPieChartFxid.setData(newChartData);

            for (PieChart.Data data : prisonerCourseListPieChartFxid.getData()) {
                data.getNode().setOnMouseClicked(event -> {
                    statusLabelfxid.setText(String.valueOf(data.getPieValue()));
                });
            }
        } catch (IOException ex) {
            Logger.getLogger(PrisonerCourseListPieChartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrisonerCourseListPieChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
