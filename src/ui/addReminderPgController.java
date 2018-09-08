package ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class addReminderPgController implements Initializable {


    private static final int REQUIRED_DATELEN = 8;
    private static final int ALTERNATE_DATELEN = 7;
    private static final int MAX_DESCRIPTIONLEN = 50;
    @FXML private ListView<String> listOfStrings;
    @FXML private Button addAllButton;
    @FXML private Button removeSelectedButton;
    @FXML private Button resetListButton;
    @FXML private TextField startDateField;
    @FXML private TextField completionDateField;
    @FXML private TextField startTimeField;
    @FXML private TextField endTimeField;
    @FXML private TextArea descriptionField;
    @FXML private Button addToListButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void clickAddToList(ActionEvent event) {
        String reminderInfo = parseReminder();
        if (!listOfStrings.getItems().contains(reminderInfo)) {
            listOfStrings.getItems().add(reminderInfo);
        }
    }

    private String parseReminder() {
        String reminderString = "";

        ArrayList<String> stringsToAdd = new ArrayList<String>();
        String reminderStartDate = startDateField.getText();
        String reminderEndDate = completionDateField.getText();
        String reminderStartTime = startTimeField.getText();
        String reminderEndTime = endTimeField.getText();
        String reminderDescription = descriptionField.getText();

        // clean up this shit!
        if (reminderStartDate.length() == REQUIRED_DATELEN) {
            stringsToAdd.add(reminderStartDate);
        }

        if (reminderEndDate.length() == REQUIRED_DATELEN) {
            stringsToAdd.add(reminderEndDate);
        }

        if (reminderStartTime.length() == REQUIRED_DATELEN ||
                reminderStartTime.length() == ALTERNATE_DATELEN) {
            stringsToAdd.add(reminderStartTime);
        }
        if (reminderStartTime.length() == REQUIRED_DATELEN ||
                reminderStartTime.length() == ALTERNATE_DATELEN) {
            stringsToAdd.add(reminderEndTime);
        }

        if (reminderDescription.length() <= MAX_DESCRIPTIONLEN) {
            stringsToAdd.add(reminderDescription);
        }

        for (String part : stringsToAdd) {
            reminderString = reminderString + " " + part;
        }

        return reminderString;
    }

    @FXML
    private void clickResetList(ActionEvent event) {
        listOfStrings.getItems().clear();
    }
}
