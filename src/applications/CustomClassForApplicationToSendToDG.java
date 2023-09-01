/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applications;

import java.io.Serializable;

/**
 *
 * @author calsifer
 */
public class CustomClassForApplicationToSendToDG implements Serializable{
    private String applicantName;
    private String applicantid;
    private String applicationId;
    private String applicationBody;
    private boolean isapproved;

    public CustomClassForApplicationToSendToDG(String applicantName, String applicantid, String applicationId, String applicationBody, boolean isapproved) {
        this.applicantName = applicantName;
        this.applicantid = applicantid;
        this.applicationId = applicationId;
        this.applicationBody = applicationBody;
        this.isapproved = isapproved;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(String applicantid) {
        this.applicantid = applicantid;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationBody() {
        return applicationBody;
    }

    public void setApplicationBody(String applicationBody) {
        this.applicationBody = applicationBody;
    }

    public boolean isIsapproved() {
        return isapproved;
    }

    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }


    }

    

