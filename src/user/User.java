/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.ITOfficers.Notification;

/**
 *
 * @author calsifer
 */
public abstract class User implements Serializable{
    protected int id;
    protected String name;
    protected String password;
    protected String userType;

    public User(int id, String name, String password, String userType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", password=" + password + ", userType=" + userType ;
    }
    
    
    
    public static ObservableList<Notification> showNotification(User user) {
        ObservableList<Notification> notificationList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NotificationList.bin"))) {
            while (true) {
                try {
                    Notification tempNotification = (Notification) ois.readObject();
                    
                    if (tempNotification.getNotificationUserType().equals(user.userType)){
                     System.out.println("Notification for User found");
                     System.out.println(tempNotification.getNotificationDetails());
                        
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
