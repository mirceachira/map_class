package repository;

import domain.MyBaseObject;
import utils.CustomInvalidValueException;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class FileRepository<CustomObject extends MyBaseObject> {

    private String fileName;
    private boolean isCsvFile;

    private Class<CustomObject> CustomObjectClass;

    public FileRepository(Class<CustomObject> myClass, String fileName) {
        this.CustomObjectClass = myClass;
        this.fileName = fileName;
        File configFile = new File("settings.properties");

        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);

            String fileType = props.getProperty("fileType");
            this.isCsvFile = fileType.equals("csv");

            reader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateFile(ArrayList<CustomObject> entries) {
        if (this.isCsvFile) {
            try {
                FileWriter fs = new FileWriter(this.fileName, false);
                PrintWriter writer = new PrintWriter(fs);

                for (int i = 0; i < entries.size(); i++) {
                    writer.printf("%s\n", entries.get(i));
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fos = new FileOutputStream(this.fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(entries);
                oos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addEntry(CustomObject newEntry) {
        ArrayList<CustomObject> list = this.getAllEntries();
        list.add(newEntry);
        this.updateFile(list);
    }

    public ArrayList<CustomObject> getAllEntries() {
        ArrayList<CustomObject> entries = new ArrayList<CustomObject>();

        if (this.isCsvFile) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(this.fileName));
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        CustomObject entry = this.CustomObjectClass.getConstructor(String.class).newInstance(line);
                        entries.add(entry);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileInputStream fis = new FileInputStream(this.fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ArrayList<CustomObject> list = (ArrayList<CustomObject>) ois.readObject();

                ois.close();

                return list;
            } catch (FileNotFoundException e) {
//                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return entries;
    }

    public CustomObject getByIndex(int index) {
        return this.getAllEntries().get(index);
    }

    public void setAtIndex(CustomObject newObject, int index) {
        ArrayList<CustomObject> list = this.getAllEntries();
        list.set(index, newObject);
        this.updateFile(list);
    }

    public void deleteIndex(int index) {
        ArrayList<CustomObject> list = this.getAllEntries();
        list.remove(index);
        this.updateFile(list);
    }
}
