package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class openingPageController implements Initializable {

    @FXML private Text firstLongTermGoalText;
    @FXML private Label firstLongTermGoalStartDate;
    @FXML private Label firstLongTermGoalEndDate;

    @FXML private Text secondLongTermGoalText;
    @FXML private Label secondLongTermGoalStartDate;
    @FXML private Label secondLongTermGoalEndDate;

    @FXML private Text thirdLongTermGoalText;
    @FXML private Label thirdLongTermGoalStartDate;
    @FXML private Label thirdLongTermGoalEndDate;

    @FXML private Text firstShortTermGoalText;
    @FXML private Label firstShortTermGoalStartDate;
    @FXML private Label firstShortTermGoalEndDate;

    @FXML private Text secondShortTermGoalText;
    @FXML private Label secondShortTermGoalStartDate;
    @FXML private Label secondShortTermGoalEndDate;

    @FXML private Text thirdShortTermGoalText;
    @FXML private Label thirdShortTermGoalStartDate;
    @FXML private Label thirdShortTermGoalEndDate;

    @FXML private ListView<String> selectedDayTaskList;
    @FXML private ListView<String> thisMonthTaskList;

    @FXML
    private void handleRemoveSelectedDayTasks(ActionEvent event) {
        selectedDayTaskList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List<String> selectedObjects = selectedDayTaskList.getSelectionModel().getSelectedItems();
        selectedDayTaskList.getItems().removeAll(selectedObjects);

        // if you remove the day tasks, they can be assumed to be no longer useful
        for (String s: selectedObjects) {
            s = null;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
