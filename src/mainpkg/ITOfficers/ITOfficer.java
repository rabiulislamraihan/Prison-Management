/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.ITOfficers;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.FileToObList;

import user.AuthorityUser;



public class ITOfficer extends AuthorityUser implements Serializable{

    public ITOfficer(int id, String name, String password, String userType, LocalDate dob, LocalDate doj, String contactNo, String email) {
        super(id, name, password, userType, dob, doj, contactNo, email);
    }

    public static boolean sendNotification(int notificationID, String notificationDetails,LocalDate currentDate, String userType) {
        Notification newNotification = new Notification(notificationID, notificationDetails, currentDate,userType);

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("NotificationList.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(newNotification);
            oos.close();
            return true;
        } catch (IOException ex) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }
            }
        }

        return false;
    }

    public static ObservableList<Notification> showNotification() {
    ObservableList<Notification> notifications = FileToObList.readObjectsFromFile("NotificationList.bin");
        System.out.println(notifications);
    return notifications;


}
public static ObservableList<AuthorityUser> showUsers(){
        
        ObservableList<AuthorityUser> userList = FileToObList.readObjectsFromFile("AuthorityUserList.bin");
        System.out.println(userList);
        return userList;
        
    }

public static void deleteUser(AuthorityUser deleteUser) {
    ObservableList<AuthorityUser> userList = FileToObList.readObjectsFromFile("AuthorityUserList.bin");

    // Use the removeIf() method to remove the specified user from the list
    if (userList.removeIf(user -> user.getId() == deleteUser.getId())){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("AuthorityUserList.bin"))) {
        // Just write a single null object to clear the file
        oos.writeObject(null);
    } catch (IOException e) {
        System.err.println("IO exception: " + e.getMessage());
    }
    }

    FileToObList.writeObjectsToFile(userList, "AuthorityUserList.bin");
    
}

public static ObservableList<Ticket> showTicket(){
        ObservableList<Ticket> ticketList = FileToObList.readObjectsFromFile("TicketList.bin");
        System.out.println(ticketList);
    return ticketList;

}

public static ObservableList<Ticket> showClosedTicket(){
        ObservableList<Ticket> ticketList = FileToObList.readObjectsFromFile("ResolvedTicketList.bin");
        System.out.println(ticketList);
    return ticketList;

}



    public static void pendingToResolved(Ticket resolvedTicket) throws IOException {
        System.out.println("CLICKED");
        ObservableList<Ticket> ticketList = FileToObList.readObjectsFromFile("TicketList.bin");
        
        ObservableList<Ticket> resolvedList = FileToObList.readObjectsFromFile("ResolvedTicketList.bin");
        System.out.println(resolvedTicket);

        for(Ticket temp:ticketList){
            if (temp.getTicketID() == resolvedTicket.getTicketID()){
              int indexDeleteTicket = ticketList.indexOf( temp);
             resolvedTicket.makeResolved();

            resolvedList.add(resolvedTicket);

  try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ResolvedTicketList.bin"))) {
                oos.writeObject(null);
                FileToObList.writeObjectsToFile(resolvedList, "ResolvedTicketList.bin");
            }

            ticketList.remove(indexDeleteTicket);

            try (ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("TicketList.bin"))) {
                oos2.writeObject(null);
                FileToObList.writeObjectsToFile(ticketList, "TicketList.bin");
        }
    }
            }
            
            

            
            }
      
       
    }

