/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applications;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author calsifer
 */
public class Application implements Serializable{
    private String applicationID;
    private Integer nonAuthorityUserid;
    private LocalDate applicationDate;
    private String application;
    private boolean isApproved;

    public Application(String applicationID, Integer nonAuthorityUserid, LocalDate applicationDate, String application, boolean isApproved) {
        this.applicationID = applicationID;
        this.nonAuthorityUserid = nonAuthorityUserid;
        this.applicationDate = applicationDate;
        this.application = application;
        this.isApproved = isApproved;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public Integer getNonAuthorityUserid() {
        return nonAuthorityUserid;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public String getApplication() {
        return application;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public void setNonAuthorityUserid(Integer nonAuthorityUserid) {
        this.nonAuthorityUserid = nonAuthorityUserid;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    @Override
    public String toString() {
        return "Application{" + "applicationID=" + applicationID + ", nonAuthorityUserid=" + nonAuthorityUserid + ", applicationDate=" + applicationDate + ", application=" + application + ", isApproved=" + isApproved + '}';
    }


    }

   


    

