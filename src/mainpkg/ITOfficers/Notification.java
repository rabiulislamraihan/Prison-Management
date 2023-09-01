/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.ITOfficers;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author crypticx
 */
public class Notification implements Serializable{
    private int notificationID;
    private String notificationDetails;
    private LocalDate notificationDate;
    private String notificationUserType;

    public Notification(int notificationID, String notificationDetails, LocalDate notificationDate, String notificationUserType) {
        this.notificationID = notificationID;
        this.notificationDetails = notificationDetails;
        this.notificationDate = notificationDate;
        this.notificationUserType = notificationUserType;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public String getNotificationDetails() {
        return notificationDetails;
    }

    public LocalDate getNotificationDate() {
        return notificationDate;
    }

    public String getNotificationUserType() {
        return notificationUserType;
    }

    @Override
    public String toString() {
        return "Notification{" + "notificationID=" + notificationID + ", notificationDetails=" + notificationDetails + ", notificationDate=" + notificationDate + ", notificationUserType=" + notificationUserType + '}';
    }
    
}
