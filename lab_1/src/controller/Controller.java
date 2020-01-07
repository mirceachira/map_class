package controller;

import domain.*;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import repository.ActivityRepository;
import repository.DisciplineRepository;
import repository.FormationRepository;
import repository.RoomRepository;
import repository.TeacherRepository;
import repository.TimetableRelationRepository;


class BaseController {

  private TeacherRepository teacherRepo;
  private RoomRepository roomRepo;
  private ActivityRepository activityRepo;
  private DisciplineRepository disciplineRepo;
  private FormationRepository formationRepo;
  private TimetableRelationRepository timetableRelationRepo;

  BaseController() {
    this.teacherRepo = new TeacherRepository();
    this.roomRepo = new RoomRepository();
    this.activityRepo = new ActivityRepository();
    this.disciplineRepo = new DisciplineRepository();
    this.formationRepo = new FormationRepository();
    this.timetableRelationRepo = new TimetableRelationRepository();
  }

  public void addTeacher(String name) {
    Teacher newTeacher = new Teacher(name);
    this.teacherRepo.addEntry(newTeacher);
  }

  public void addTeacher(String name, String rank) {
    Teacher newTeacher = new Teacher(name, rank);
    this.teacherRepo.addEntry(newTeacher);
  }

  public void addActivity(String name) {
    Activity newActivity = new Activity(name);
    this.activityRepo.addEntry(newActivity);
  }

  public void addDiscipline(String name) {
    Discipline newDiscipline = new Discipline(name);
    this.disciplineRepo.addEntry(newDiscipline);
  }

  public void addRoom(String name) {
    Room newRoom = new Room(name);
    this.roomRepo.addEntry(newRoom);
  }

  public void addFormation(String name) {
    Formation newFormation = new Formation(name);
    this.formationRepo.addEntry(newFormation);
  }

  public void addTimetableRelation(String activityName, String roomName, String teacherName, String formationName, String dateString) throws Exception{
    Relation newRelation = new Relation(activityName, roomName, teacherName, formationName, dateString);
    this.timetableRelationRepo.addEntry(newRelation);
  }

  public ArrayList<Teacher> getAllTeachers() { return this.teacherRepo.getAllEntries(); }

  ArrayList<Activity> getAllActivities() {
    return this.activityRepo.getAllEntries();
  }

  public ArrayList<Discipline> getAllDisciplines() {
    return this.disciplineRepo.getAllEntries();
  }

  ArrayList<Room> getAllRooms() {
    return this.roomRepo.getAllEntries();
  }

  ArrayList<Formation> getAllFormations() {
    return this.formationRepo.getAllEntries();
  }

  ArrayList<Relation> getAllTimetableRelations() {
    return this.timetableRelationRepo.getAllEntries();
  }

  public Teacher getTeacherByIndex(int index) {
    return this.teacherRepo.getByIndex(index);
  }

  public Activity getActivityByIndex(int index) {
    return this.activityRepo.getByIndex(index);
  }

  public Discipline getDisciplineByIndex(int index) {
    return this.disciplineRepo.getByIndex(index);
  }

  public Room getRoomByIndex(int index) {
    return this.roomRepo.getByIndex(index);
  }

  public Formation getFormationByIndex(int index) {
    return this.formationRepo.getByIndex(index);
  }

  public Relation getTimetableRelationByIndex(int index) {
    return this.timetableRelationRepo.getByIndex(index);
  }

  public void updateTeacherByIndex(int index, String name) {
    Teacher currentTeacher = this.teacherRepo.getByIndex(index);
    currentTeacher.setName(name);
    this.teacherRepo.setAtIndex(currentTeacher, index);
  }

  void updateActivityByIndex(int index, String name) {
    Activity currentActivity = this.activityRepo.getByIndex(index);
    currentActivity.setName(name);
    this.activityRepo.setAtIndex(currentActivity, index);
  }

  public void updateDisciplineByIndex(int index, String name) {
    Discipline currentDiscipline = this.disciplineRepo.getByIndex(index);
    currentDiscipline.setName(name);
    this.disciplineRepo.setAtIndex(currentDiscipline, index);
  }

  void updateRoomByIndex(int index, String name) {
    Room currentRoom = this.roomRepo.getByIndex(index);
    currentRoom.setName(name);
    this.roomRepo.setAtIndex(currentRoom, index);
  }

  public void updateFormationByIndex(int index, String name) {
    Formation currentFormation = this.formationRepo.getByIndex(index);
    currentFormation.setName(name);
    this.formationRepo.setAtIndex(currentFormation, index);
  }

  public void deleteTeacher(int index) {
    this.teacherRepo.deleteIndex(index);
  }

  public void deleteDiscipline(int index) {
    this.activityRepo.deleteIndex(index);
  }

  void deleteActivity(int index) {
    this.disciplineRepo.deleteIndex(index);
  }

  void deleteRoom(int index) {
    this.roomRepo.deleteIndex(index);
  }

  public void deleteFormation(int index) {
    this.formationRepo.deleteIndex(index);
  }

  public void deleteRelation(int index) {
    this.timetableRelationRepo.deleteIndex(index);
  }
}

public class Controller extends BaseController implements Initializable {

  // Rooms
  @FXML
  private Button buttonAddRoom;
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

  // Teachers
  @FXML private Button buttonAddwTeacher;
  @FXML private TextField teacherNameTextField;

  @FXML private Button buttonUpdateTeacher;
  @FXML private TextField updateTeacherNameField;

  @FXML private Button buttonDeleteTeacher;

  @FXML private TableColumn<Teacher, String> teacherNameColumn;
  @FXML private TableView teacherTableView;

  // Formations
  @FXML private Button buttonAddFormation;
  @FXML private TextField formationNameTextField;

  @FXML private Button buttonUpdateFormation;
  @FXML private TextField updateFormationNameField;

  @FXML private Button buttonDeleteFormation;

  @FXML private TableColumn<Formation, String> formationNameColumn;
  @FXML private TableView formationTableView;

  // Timetable relations tab
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

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    roomNameColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("name"));
    this.refreshRoomsTable();

    activityNameColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
    this.refreshActivityTable();

    teacherNameColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
    this.refreshTeacherTable();

    formationNameColumn.setCellValueFactory(new PropertyValueFactory<Formation, String>("name"));
    this.refreshFormationTable();

    activityNameRelColumn.setCellValueFactory(new PropertyValueFactory<Relation, String>("activityName"));
    roomNameRelColumn.setCellValueFactory(new PropertyValueFactory<Relation, String>("roomName"));
    teacherNameRelColumn.setCellValueFactory(new PropertyValueFactory<Relation, String>("teacherName"));
    formationNameRelColumn.setCellValueFactory(new PropertyValueFactory<Relation, String>("formationName"));

    String formationName = this.getAllFormations().get(0).name;
    this.formationNameRel.setText(formationName);
    this.refreshTimetableRelationTable(formationName);
  }

  // Room
  private void refreshRoomsTable() {
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

  // Teachers
  private void refreshTeacherTable() {
    ArrayList<Teacher> teachers = this.getAllTeachers();
    ObservableList<Teacher> obsTeachers = FXCollections.observableArrayList(teachers);
    this.teacherTableView.setItems(obsTeachers);
  }

  @FXML
  void buttonAddTeacherHandler(Event event) {
    String name = this.teacherNameTextField.getText();
    this.addTeacher(name);
    this.refreshTeacherTable();
  }

  @FXML
  void buttonUpdateTeacherHandler(Event event) {
    String selectedName = this.teacherTableView.getSelectionModel().getSelectedItem().toString();
    int indexInTable = -1;
    ArrayList<Teacher> teachers = this.getAllTeachers();
    for (int i=0; i<teachers.size(); i++) {
      if (teachers.get(i).getName().equals(selectedName)) {
        indexInTable = i;
        break;
      }
    }

    String name = this.updateTeacherNameField.getText();
    this.updateTeacherByIndex(indexInTable, name);
    this.refreshTeacherTable();
  }

  @FXML
  void buttonDeleteTeacherHandler(Event event) {
    String selectedName = this.teacherTableView.getSelectionModel().getSelectedItem().toString();
    int indexInTable = -1;
    ArrayList<Teacher> teachers = this.getAllTeachers();
    for (int i=0; i<teachers.size(); i++) {
      if (teachers.get(i).getName().equals(selectedName)) {
        indexInTable = i;
        break;
      }
    }

    this.deleteTeacher(indexInTable);
    this.refreshTeacherTable();
  }

  // Formations
  private void refreshFormationTable() {
    ArrayList<Formation> formations = this.getAllFormations();
    ObservableList<Formation> obsFormations = FXCollections.observableArrayList(formations);
    this.formationTableView.setItems(obsFormations);
  }

  @FXML
  void buttonAddFormationHandler(Event event) {
    String name = this.formationNameTextField.getText();
    this.addFormation(name);
    this.refreshFormationTable();
  }

  @FXML
  void buttonUpdateFormationHandler(Event event) {
    String selectedName = this.formationTableView.getSelectionModel().getSelectedItem().toString();
    int indexInTable = -1;
    ArrayList<Formation> formations = this.getAllFormations();
    for (int i=0; i<formations.size(); i++) {
      if (formations.get(i).getName().equals(selectedName)) {
        indexInTable = i;
        break;
      }
    }

    String name = this.updateFormationNameField.getText();
    this.updateFormationByIndex(indexInTable, name);
    this.refreshFormationTable();
  }

  @FXML
  void buttonDeleteFormationHandler(Event event) {
    String selectedName = this.formationTableView.getSelectionModel().getSelectedItem().toString();
    int indexInTable = -1;
    ArrayList<Formation> formations = this.getAllFormations();
    for (int i=0; i<formations.size(); i++) {
      if (formations.get(i).getName().equals(selectedName)) {
        indexInTable = i;
        break;
      }
    }
    this.deleteFormation(indexInTable);
    this.refreshFormationTable();
  }

  // Activity
  private void refreshActivityTable() {
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
//        day = map.get(day); // TODO: fix this, dont set at first then set according to drag
    String day = "Monay";
    String hour = "18:00";

    try {
      this.addTimetableRelation(
          activityName,
          roomName,
          "",
          "",
          day + " " + hour
      );
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private void refreshTimetableRelationTable(String formationName) {
    ArrayList<Relation> allTimetableRelations = this.getAllTimetableRelations();
    ArrayList<Relation> relevantTimetableRelations = new ArrayList<Relation>();

    for (Relation allTimetableRelation : allTimetableRelations) {
      if (allTimetableRelation.formationName.equals(formationName) && allTimetableRelation.dateString.equals("")) {
        relevantTimetableRelations.add(allTimetableRelation);
      }
    }

    this.timetableRelationTableView.setItems(FXCollections.observableArrayList(relevantTimetableRelations));
  }

  @FXML
  void formationChangeHandler(Event event) {
    this.refreshTimetableRelationTable(this.formationNameRel.getText());
  }

  @FXML
  void handleDragDetected(Event event) {
    Dragboard db = timetableRelationTableView.startDragAndDrop(TransferMode.ANY);

    ClipboardContent cb = new ClipboardContent();

    String selectedName = this.timetableRelationTableView.getSelectionModel().getSelectedItem().toString();

    // TODO: is this still relevant?
    int indexInTable = -1;
    ArrayList<Relation> rels = this.getAllTimetableRelations();
    for (int i=0; i<rels.size(); i++) {
      if (rels.get(i).toString().equals(selectedName)) {
        indexInTable = i;
        break;
      }
    }

    cb.putString(rels.get(indexInTable).toString()); // TODO: Change this to table content serialized

    db.setContent(cb);

    event.consume();
  }

  @FXML
  void handleDragOver(DragEvent event) {
    if (event.getDragboard().hasString()) {
      event.acceptTransferModes(TransferMode.ANY);
//      System.out.println("Any transfer mode set!");
    } else {
      System.out.println("Error settings transfer mode set!");
    }
  }

  @FXML
  void handleDrop(DragEvent event) {
    String s = event.getDragboard().getString();

    // Find index in table
    int indexInTable = -1;
    ArrayList<Relation> rels = this.getAllTimetableRelations();
    for (int i=0; i<rels.size(); i++) {
      if (rels.get(i).toString().equals(s)) {
        indexInTable = i;
        break;
      }
    }

    Node target = (Node)event.getTarget();
    Integer colIndex = timetableGrid.getColumnIndex(target);
    Integer rowIndex = timetableGrid.getRowIndex(target);

    Relation r = rels.get(indexInTable);

    Map<Integer, String> map = new HashMap<Integer, String>();
    map.put(1, "a");
    map.put(2, "b");
    map.put(3, "c");
    map.put(4, "d");
    map.put(5, "e");
    String dateValue = map.get(colIndex);

    Map<Integer, String> map2 = new HashMap<Integer, String>();
    map2.put(1, "8");
    map2.put(2, "12");
    map2.put(3, "14");
    map2.put(4, "16");
    map2.put(5, "18");
    dateValue = dateValue + " " + map2.get(rowIndex);

    this.deleteRelation(indexInTable);
    this.refreshTimetableRelationTable(this.formationNameRel.getText());
    r.setDateString(dateValue);
    try {
      this.addTimetableRelation(
          r.getActivityName(),
          r.getRoomName(),
          r.getTeacherName(),
          r.getFormationName(),
          r.getDateString()
      );

//    System.out.printf("name is %s\n", target.toString());
//    System.out.printf("Dropped the load %s x:%f y:%f\n", s, event.getX(), event.getY());
//    System.out.printf("Dropped the load %s x:%d y:%d\n", s, colIndex, rowIndex);

      Text text = new Text();
      text.setText(r.getActivityName() + "\n" + r.getTeacherName());
      // TODO: add handlers from here as well
      timetableGrid.add(text, colIndex, rowIndex);

    } catch (Exception e) {
      System.out.println("Some exception occured!");
      System.out.println(e.getMessage());
    }

    event.consume();
  }
}

