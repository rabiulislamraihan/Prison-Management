/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.ITOfficers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import mainpkg.FileToObList;
import user.AuthorityUser;

/**
 *
 * @author crypticx
 */
public class Ticket implements Serializable{
    private int ticketID;
    private String ticketTitle;
    private String ticketDetails;
    private LocalDate ticketOpenDate;
    private LocalDate ticketClosedDate;
    private String ticketSender;
    private String ticketMessage;
    private String ticketStatus;
    

    public Ticket(int ticketID, String ticketTitle, String ticketDetails, LocalDate ticketOpenDate, LocalDate ticketClosedDate, String ticketSender, String ticketStatus,String ticketMessage) {
        this.ticketID = ticketID;
        this.ticketTitle = ticketTitle;
        this.ticketDetails = ticketDetails;
        this.ticketOpenDate = ticketOpenDate;
        this.ticketClosedDate = ticketClosedDate;
        this.ticketSender = ticketSender;
        this.ticketMessage = ticketMessage;
        

        this.ticketStatus = ticketStatus;
    }



    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getTicketDetails() {
        return ticketDetails;
    }

    public void setTicketDetails(String ticketDetails) {
        this.ticketDetails = ticketDetails;
    }

    public LocalDate getTicketOpenDate() {
        return ticketOpenDate;
    }

    public void setTicketOpenDate(LocalDate ticketOpenDate) {
        this.ticketOpenDate = ticketOpenDate;
    }

    public LocalDate getTicketClosedDate() {
        return ticketClosedDate;
    }

    public void setTicketClosedDate(LocalDate ticketClosedDate) {
        this.ticketClosedDate = ticketClosedDate;
    }

    public String getTicketSender() {
        return ticketSender;
    }

    public void setTicketSender(String ticketSender) {
        this.ticketSender = ticketSender;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
    public void makeResolved(){
    this.ticketStatus = "Resolved";
    this.ticketClosedDate = LocalDate.now();
          
    }

    public void setTicketMessage(String ticketMessage) {
        this.ticketMessage = ticketMessage;
    }

    public String getTicketMessage() {
        return ticketMessage;
    }


}

