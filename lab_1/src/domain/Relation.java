package domain;

import java.io.Serializable;

public class Relation extends MyBaseObject implements Serializable {

    public String activityName;
    public String roomName;
    public String teacherName;
    public String formationName;
    public String dateString;

    public Relation(String activityName, String roomName, String teacherName, String formationName, String dateString) {
        super("Nothing really");

        this.activityName = activityName;
        this.roomName = roomName;
        this.teacherName = teacherName;
        this.formationName = formationName;
        this.dateString = dateString;
    }

    @Override
    public String toString() {
        return this.activityName + "\n" + this.roomName + "\n" + this.teacherName + "\n" + this.formationName  + "\n" + this.dateString;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getFormationName() {
        return formationName;
    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
}
