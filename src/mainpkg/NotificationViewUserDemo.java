/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import mainpkg.ITOfficers.Notification;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author crypticx
 */
public class NotificationViewUserDemo {
    
      public static ObservableList<Notification> showNotification() {
        ObservableList<Notification> notificationList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NotificationList.bin"))) {
            while (true) {
                try {
                    Notification tempNotification = (Notification) ois.readObject();
                    System.out.println(tempNotification.getNotificationUserType());
                    if (tempNotification.getNotificationUserType().equals("Medical Workers")){
                        ////Change According UserType
                        
                    notificationList.add(tempNotification);
                    }
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

        return notificationList;
    }
    
}
