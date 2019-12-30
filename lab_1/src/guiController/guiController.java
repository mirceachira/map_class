package guiController;

import controller.Controller;
import domain.Activity;
import domain.Relation;
import domain.Room;
import java.awt.Color;
import java.lang.reflect.Array;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.GridPane;

public class guiController extends Controller {

    // Rooms
    @FXML private Button buttonAddRoom;
    @FXML private TextField roomNameTextField;

    @FXML private Button buttonUpdateRoom;
    @FXML private TextField updateRoomNameField;

    @FXML private Button buttonDeleteRoom;

    @FXML private TableColumn<Room, String> roomNameColumn;
    @FXML private TableView roomTableView;

    // Activities
    @FXML private Button buttonAddActivity;
    @FXML private TextField activityNameTextField;

    @FXML private Button buttonUpdateActivity;
    @FXML private TextField updateActivityNameField;

    @FXML private Button buttonDeleteActivity;

    @FXML private TableColumn<Activity, String> activityNameColumn;
    @FXML private TableView activityTableView;

    // Room activity relation
    @FXML private Button buttonAddRelation;

    @FXML private TextField teacherNameRel;
    @FXML private TextField roomNameRel;
    @FXML private TextField activityNameRel;
    @FXML private TextField formationNameRel;

    @FXML private TableColumn<Relation, String> activityNameRelColumn;
    @FXML private TableColumn<Relation, String> teacherNameRelColumn;
    @FXML private TableColumn<Relation, String> roomNameRelColumn;
    @FXML private TableColumn<Relation, String> formationNameRelColumn;
    @FXML private TableView timetableRelationTableView;

    @FXML private GridPane timetableGrid;

    @FXML
    public void initialize() {
        // TODO: add initial stuff in this class' parent
        roomNameColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("name"));
        this.refreshRoomsTable();

        activityNameColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
        this.refreshActivityTable();

        // activity - room - teacher - formation !!!
        activityNameRelColumn.setCellValueFactory(new PropertyValueFactory<Relation, String>("keyA"));
        roomNameRelColumn.setCellValueFactory(new PropertyValueFactory<Relation, String>("keyB"));
        teacherNameRelColumn.setCellValueFactory(new PropertyValueFactory<Relation, String>("keyC"));
        formationNameRelColumn.setCellValueFactory(new PropertyValueFactory<Relation, String>("keyD"));

        String formationName = this.getAllFormations().get(0).name;
        this.formationNameRel.setText(formationName);
        this.refreshTimetableRelationTable(formationName);

        ArrayList<Relation> rr = this.getAllTimetableRelations();
        for (Relation r : rr) {
            System.out.println(r);
        }
        System.out.printf("len: %d", rr.size());
    }

    // Room
    void refreshRoomsTable() {
        ArrayList<Room> rooms = this.getAllRooms();
        ObservableList<Room> obsRooms = FXCollections.observableArrayList(rooms);
        this.roomTableView.setItems(obsRooms);
    }

    @FXML
    void buttonAddRoomHandler(Event event) {
        String name = this.roomNameTextField.getText();
        this.addRoom(name);
        this.refreshRoomsTable();
    }

    @FXML
    void buttonUpdateRoomHandler(Event event) {
        String selectedName = this.roomTableView.getSelectionModel().getSelectedItem().toString();
        int indexInTable = -1;
        ArrayList<Room> rooms = this.getAllRooms();
        for (int i=0; i<rooms.size(); i++) {
            if (rooms.get(i).getName().equals(selectedName)) {
                indexInTable = i;
                break;
            }
        }

        String name = this.updateRoomNameField.getText();
        this.updateRoomByIndex(indexInTable, name);
        this.refreshRoomsTable();
    }

    @FXML
    void buttonDeleteRoomHandler(Event event) {
        String selectedName = this.roomTableView.getSelectionModel().getSelectedItem().toString();
        int indexInTable = -1;
        ArrayList<Room> rooms = this.getAllRooms();
        for (int i=0; i<rooms.size(); i++) {
            if (rooms.get(i).getName().equals(selectedName)) {
                indexInTable = i;
                break;
            }
        }

        this.deleteRoom(indexInTable);
        this.refreshRoomsTable();
    }

    // Activity
    void refreshActivityTable() {
        this.activityTableView.setItems(FXCollections.observableArrayList(this.getAllActivities()));
    }

    @FXML
    void buttonAddActivityHandler(Event event) {
        String name = this.activityNameTextField.getText();
        this.addActivity(name);
        this.refreshActivityTable();
    }

    @FXML
    void buttonUpdateActivityHandler(Event event) {
        String selectedName = this.activityTableView.getSelectionModel().getSelectedItem().toString();
        int indexInTable = -1;
        ArrayList<Activity> activities = this.getAllActivities();
        for (int i=0; i<activities.size(); i++) {
            if (activities.get(i).getName().equals(selectedName)) {
                indexInTable = i;
                break;
            }
        }

        String name = this.updateActivityNameField.getText();
        this.updateActivityByIndex(indexInTable, name);
        this.refreshActivityTable();
    }

    @FXML
    void buttonDeleteActivityHandler(Event event) {
        String selectedName = this.activityTableView.getSelectionModel().getSelectedItem().toString();
        int indexInTable = -1;
        ArrayList<Activity> activities = this.getAllActivities();
        for (int i=0; i<activities.size(); i++) {
            if (activities.get(i).getName().equals(selectedName)) {
                indexInTable = i;
                break;
            }
        }

        this.deleteActivity(indexInTable); // todo: fix delete not working with file repository, switch to database? switch all to database?
        this.refreshActivityTable();
    }

    // Room activity relation
    @FXML
    void buttonAddRelationHandler(Event event) {
        String roomName = this.roomNameRel.getText();
        String activityName = this.activityNameRel.getText();

        Map<String, String> map = new HashMap<String, String>();
        map.put("Monday", "a");
        map.put("Tuesday", "b");
        map.put("Wednesday", "c");
        map.put("Thursday", "d");
        map.put("Friday", "e");
//        day = map.get(day);
        // TODO: fix this, dont set at first then set according to drag
        // TODO: set when dragging, delete option somehow, drag back and forth?
        // TODO: tabs for teachers and formations
        String day = "Monay";
        String hour = "18:00";

        this.addRoomToActivityRelation(activityName, roomName, day + " " + hour);
    }

    void refreshTimetableRelationTable(String formationName) {
        ArrayList<Relation> allTimetableRelations = this.getAllTimetableRelations();
        ArrayList<Relation> relevantTimetableRelations = new ArrayList<Relation>();

        for (int i=0; i<allTimetableRelations.size(); i++) {
            if (allTimetableRelations.get(i).getKeyD().equals(formationName)) {
                relevantTimetableRelations.add(allTimetableRelations.get(i));
            }
        }

        this.timetableRelationTableView.setItems(FXCollections.observableArrayList(relevantTimetableRelations));
    }

    @FXML
    void formationChangeHandler(Event event) {
        this.refreshTimetableRelationTable(this.formationNameRel.getText());
    }

    @FXML
    void handleSourceDragging(DragEvent event) {
        System.out.println("I started moving!");
    }

    @FXML
    void handleTargetDragging(DragEvent event) {
        System.out.println("lol it works!");

        Dragboard db = event.getDragboard();
        Node node = event.getPickResult().getIntersectedNode();
        if(node != this.timetableGrid) {
            Integer cIndex = this.timetableGrid.getColumnIndex(node);
            Integer rIndex = this.timetableGrid.getRowIndex(node);
            System.out.printf("\n%d %d\n", cIndex, rIndex);
        }
        else {
            System.out.println("nothing called");
        }
        System.out.println("finish");
    }
}
