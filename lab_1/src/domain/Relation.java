package domain;

import java.io.Serializable;

public class Relation extends MyBaseObject implements Serializable {
    public String keyA; // name of first thing, usually activity
    public String keyB; // name of second thing, duh
    public String keyC; // name of third thing, relevant for timetableRelationship
                        // for storing teacher name
    public String keyD; // name of fourth thing, relevant for timetableRelationship
                        // for storing a start date (ex: 'd 12')

    /*
     Old note, should be removed I think.. but am too lazy to check...
     TODO: In case of room to formation keyC is a start date (ex: 'd 12'), therefore room id and date should be
     TODO: unique together ie you can't have two different activities in the same room at the same time
    */

    public Relation(String line) {
        super(line);

        String[] lineData = line.split(",");

        this.keyA = lineData[0];
        this.keyB = lineData[1];

        if (lineData.length == 3) {
            this.keyC = lineData[2];
        } else if (lineData.length == 4){
            this.keyC = lineData[3];
        } else {
            this.keyD = "";
        }
    }

    public Relation(String keyA, String keyB) {
        super("Nothing really");
        this.keyA = keyA;
        this.keyB = keyB;
        this.keyC = "";
    }

    public Relation(String keyA, String keyB, String keyC) {
        super("Nothing really");
        this.keyA = keyA;
        this.keyB = keyB;
        this.keyC = keyC;
    }

    public Relation(String keyA, String keyB, String keyC, String keyD) {
        super("Nothing really");
        this.keyA = keyA;
        this.keyB = keyB;
        this.keyC = keyC;
        this.keyD = keyD;
    }

    public String getKeyA() {
        return keyA;
    }

    public void setKeyA(String keyA) {
        this.keyA = keyA;
    }

    public String getKeyB() {
        return keyB;
    }

    public void setKeyB(String keyB) {
        this.keyB = keyB;
    }

    public String getKeyC() {
        return keyC;
    }

    public void setKeyC(String keyC) {
        this.keyC = keyC;
    }

    public String getKeyD() {
        return keyD;
    }

    public void setKeyD(String keyD) {
        this.keyD = keyD;
    }

    @Override
    public String toString() {
        return this.keyA + "\t" + this.keyB + "\t" + this.keyC + "\t" + this.keyD;
    }
}
