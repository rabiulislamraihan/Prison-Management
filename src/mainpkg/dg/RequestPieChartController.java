package mainpkg.dg;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RequestPieChartController implements Initializable {

    @FXML
    private PieChart requestPieChartFxid;
    @FXML
    private Label statusLabelFxid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<PieChart.Data> newChartData = DG.requestPieChart();

            requestPieChartFxid.setData(newChartData);

            for (PieChart.Data data : requestPieChartFxid.getData()) {
                data.getNode().setOnMouseClicked(event -> {
                    statusLabelFxid.setText(String.valueOf(data.getPieValue()));
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            statusLabelFxid.setText("Error loading pie chart data");
        }
    }
}
