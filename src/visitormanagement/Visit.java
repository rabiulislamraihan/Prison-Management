/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visitormanagement;

/**
 *
 * @author calsifer
 */
import java.io.Serializable;
import java.time.LocalTime;
import java.time.LocalDate;

public class Visit implements Serializable{
    private Integer visitorid;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private LocalDate date;
    private boolean isApproved;

    public Visit(Integer visitorid, LocalTime checkIn, LocalTime checkOut, LocalDate date, boolean isApproved) {
        this.visitorid = visitorid;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.date = date;
        this.isApproved = isApproved;
    }

    public Integer getVisitorid() {
        return visitorid;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    @Override
    public String toString() {
        return "Visit{" + "visitorid=" + visitorid + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", date=" + date + ", isApproved=" + isApproved + '}';
    }


    }

    

