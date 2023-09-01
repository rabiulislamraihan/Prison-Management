/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

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
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.FileToObList;
import mainpkg.ITOfficers.Ticket;
import mainpkg.dg.Request;
import msc.AppendableObjectOutputStream;
import static securityincharge.SecurityInCharge.showAlert;

/**
 *
 * @author calsifer
 */
public class AuthorityUser extends User implements Serializable{
    public LocalDate dob;
    public  LocalDate doj;
    protected String contactNo;
    protected String email;

    public AuthorityUser(int id, String name, String password, String userType,LocalDate dob, LocalDate doj, String contactNo, String email) {
        super(id, name, password, userType);
        this.dob = dob;
        this.doj = doj;
        this.contactNo = contactNo;
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "AuthorityUser{" + "dob=" + dob + ", doj=" + doj + ", contactNo=" + contactNo + ", email=" + email + '}';
    }

public void addTicket(Ticket ticket) {
    ObservableList<Ticket> existingTickets = FXCollections.observableArrayList(FileToObList.readObjectsFromFile("TicketList.bin"));
    existingTickets.add(ticket);
    FileToObList.writeObjectsToFile(existingTickets, "TicketList.bin");
}

    
    private static int ticketCounter = 1; 

  

    protected int generateTicketID() {
        return ticketCounter++;
    }

    public void requestHelpDesk(String title, String description, String userSender) {
        Ticket newTicket = new Ticket(
            generateTicketID(),   
            title,
            description,
            LocalDate.now(),     
            null,               
            userSender,               
            "Pending" ,  
                null
        );
        addTicket(newTicket);

 
}
    public void sendRequest(Request newRequest){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("RequestList.bin");
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            System.out.println(newRequest);
            oos.writeObject(newRequest);

            showAlert("Request is added successfully in the list!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                showAlert("Error: Failed to add request in the list!");
            }
        }
    
    
    }
    
    
public ObservableList<Request> showRequestHistory() {
    ObservableList<Request> tempList = FXCollections.observableArrayList();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ApprovedRequest.bin"))) {
        while (true) {
            try {
                Request tempRequest = (Request) ois.readObject();
                if (tempRequest.getRequestSender().equals(userType)) {
                    tempList.add(tempRequest);
                }
            } catch (EOFException e) {
                break;
            } catch (ClassNotFoundException e) {
                System.err.println("Request Class not Found");
            }
        }
    } catch (FileNotFoundException e) {
        showAlert("No Approved Request FOund");
        System.err.println("ApprovedRequest.bin File not Found");
    } catch (IOException e) {
        System.err.println("IO exception" + e.getMessage());
    }
    
    System.out.println(tempList);
    return tempList;
}

 
}
