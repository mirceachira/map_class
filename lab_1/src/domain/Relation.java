package domain;

import java.io.Serializable;

public class Relation extends MyBaseObject implements Serializable {
    public String keyA;
    public String keyB;

    public Relation(String line) {
        super(line);

        String[] lineData = line.split(",");

        this.keyA = lineData[0];
        this.keyB = lineData[1];
    }

    public Relation(String keyA, String keyB) {
        super("Nothing really");
        this.keyA = keyA;
        this.keyB = keyB;
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

    @Override
    public String toString() {
        return this.keyA + "," + this.keyB;
    }
}
