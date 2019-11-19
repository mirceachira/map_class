package guiController;

import controller.Controller;
import domain.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class guiController extends Controller {

    // Rooms
    @FXML private Button buttonGetAllRooms;

    @FXML private Button buttonAddRoom;
    @FXML private TextField roomNameTextField;

    @FXML private Button buttonUpdateRoom;
    @FXML private TextField updateRoomIndexField;
    @FXML private TextField updateRoomNameField;

    @FXML private Button buttonDeleteRoom;
    @FXML private TextField roomDeleteIndexTextField;

    @FXML private TableColumn<Room, String> roomNameColumn;
    @FXML private TableView roomTableView;

    // Activities
    @FXML private Button buttonGetAllActivities;

    @FXML private Button buttonAddActivity;
    @FXML private TextField activityNameTextField;

    @FXML private Button buttonUpdateActivity;
    @FXML private TextField updateActivityIndexField;
    @FXML private TextField updateActivityNameField;

    @FXML private Button buttonDeleteActivity;
    @FXML private TextField activityDeleteIndexTextField;

    // Room activity relation
    @FXML private Button buttonAddRelation;

    @FXML private TextField relRoomNameTextField;
    @FXML private TextField relActivityNameTextField;
    @FXML private TextField relDayTextField;
    @FXML private TextField relHourTextField;

    @FXML
    public void initialize() {
        // TODO: add initial stuff in this class' parent
        ArrayList<Room> rooms = this.getAllRooms();
        ObservableList<Room> obsRooms = FXCollections.observableArrayList(rooms);
        roomNameColumn.setCellValueFactory(new PropertyValueFactory<>(roomNameColumn.getText()));
        this.roomTableView.setItems(obsRooms);
    }

    // Room
    @FXML
    void buttonGetAllRoomsHandler(Event event) {
        ArrayList<Room> rooms = this.getAllRooms();
        ObservableList<Room> obsRooms = FXCollections.observableArrayList(rooms);
        this.roomTableView.setItems(obsRooms);
    }

    @FXML
    void buttonAddRoomHandler(Event event) {
        String name = this.roomNameTextField.getText();
        this.addRoom(name);
    }

    @FXML
    void buttonUpdateRoomHandler(Event event) {
        int index = Integer.parseInt(this.updateRoomIndexField.getText());
        String name = this.updateRoomNameField.getText();
        this.updateRoomByIndex(index, name);
    }

    @FXML
    void buttonDeleteRoomHandler(Event event) {
        int index = Integer.parseInt(this.roomDeleteIndexTextField.getText());
        this.deleteRoom(index);
    }

    // Activity
    @FXML
    void buttonGetAllActivitiesHandler(Event event) {
        System.out.println("Implement me!");
    }

    @FXML
    void buttonAddActivityHandler(Event event) {
        String name = this.activityNameTextField.getText();
        this.addActivity(name);
    }

    @FXML
    void buttonUpdateActivityHandler(Event event) {
        int index = Integer.parseInt(this.updateActivityIndexField.getText());
        String name = this.updateActivityNameField.getText();
        this.updateActivityByIndex(index, name);
    }

    @FXML
    void buttonDeleteActivityHandler(Event event) {
        int index = Integer.parseInt(this.activityDeleteIndexTextField.getText());
        this.deleteActivity(index);
    }

    // Room activity relation
    @FXML
    void buttonAddRelationHandler(Event event) {
        String roomName = this.relRoomNameTextField.getText();
        String activityName = this.relActivityNameTextField.getText();
        String day = this.relDayTextField.getText();

        Map<String, String> map = new HashMap<String, String>();
        map.put("Monday", "a");
        map.put("Tuesday", "b");
        map.put("Wednesday", "c");
        map.put("Thursday", "d");
        map.put("Friday", "e");
        day = map.get(day);

        String hour = this.relHourTextField.getText();

        this.addRoomToActivityRelation(activityName, roomName, day + " " + hour);
    }


}
