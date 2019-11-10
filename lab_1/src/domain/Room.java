package domain;

import utils.CustomInvalidValueException;

import java.io.Serializable;

public class Room extends MyBaseObject implements Serializable {
        private String name;

    public Room(String name) {
        super(name);
        this.name = name;
    }

    public void validateName(String name) throws  CustomInvalidValueException {
        if (name.length() <= 1) {
            throw new CustomInvalidValueException();
        }
    }
    public boolean setName(String name) {
        try {
            this.validateName(name);
            this.name = name;
        } catch (CustomInvalidValueException e) {
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
