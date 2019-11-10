package domain;

public class MyBaseObject {


    public MyBaseObject(String line) {}

    public MyBaseObject fromText(String fileRow) { return new MyBaseObject(fileRow); }

    public String getName() {
        return "not what I want";
    }
}
