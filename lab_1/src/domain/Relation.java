package domain;

import java.io.Serializable;

public class Relation extends MyBaseObject implements Serializable {
    public String keyA;
    public String keyB;
    public String keyC;
    /*
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
        } else {
            this.keyC = "";
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

    @Override
    public String toString() {
        return this.keyA + "\t" + this.keyB + "\t" + this.keyC;
    }
}
