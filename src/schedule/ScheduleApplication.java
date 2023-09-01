/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedule;

import applications.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import user.NonAuthorityUser;

/**
 *
 * @author calsifer
 */
public class ScheduleApplication implements Serializable{
    private LocalDate date;
    private String startTime;
    private String endTime;
    private String activity;
    private Application application;
    private Integer prisonerID;

    public ScheduleApplication(LocalDate date, String startTime, String endTime, String activity, Application application, Integer prisonerID) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activity = activity;
        this.application = application;
        this.prisonerID = prisonerID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }


    

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Integer getPrisonerID() {
        return prisonerID;
    }

    public void setPrisonerID(Integer prisonerID) {
        this.prisonerID = prisonerID;
    }

    @Override
    public String toString() {
        return "ScheduleApplication{" + "date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + ", activity=" + activity + ", application=" + application + ", prisonerID=" + prisonerID + '}';
    }



    }
    
    
    

    
