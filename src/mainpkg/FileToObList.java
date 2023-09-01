package mainpkg;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileToObList {

    public static <T extends Serializable> ObservableList<T> readObjectsFromFile(String filename) {
        ObservableList<T> objectList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    T tempObject = (T) ois.readObject();
                    objectList.add(tempObject);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return objectList;
    }
    
//    ObservableList<Notification> notifications = FileIOUtils.readObjectsFromFile("NotificationList.bin");
//
//    // Use the notifications as needed
//    for (Notification notification : notifications
//
//    
//        ) {
//            System.out.println(notification);
//    }
        public static <T> void writeObjectsToFile(ObservableList<T> objectList, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (T object : objectList) {
                oos.writeObject(object);
            }
        } catch (IOException e) {
            System.err.println("IO exception: " + e.getMessage());
        }
    }
}

