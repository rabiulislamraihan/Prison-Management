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
public class CustomClassToSendApplicationToJailorForApproval implements Serializable{
    private final String applicationID;
    private final LocalDate applicationDate;
    private final String application;
    private  boolean isApproved;

    public CustomClassToSendApplicationToJailorForApproval(String applicationID, LocalDate applicationDate, String application, boolean isApproved) {
        this.applicationID = applicationID;
        this.applicationDate = applicationDate;
        this.application = application;
        this.isApproved = isApproved;
    }

    public String getApplicationID() {
        return applicationID;
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

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }


}
