/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.dg;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Request implements Serializable {
    private int requestID;
    private String requestType;
    private String requestSender;
    private LocalDate requestTime;
    private String requestDescription;
    private Boolean requestStatus;
    private String requestResponse;

    public Request(int requestID, String requestType, String requestSender, LocalDate requestTime, String requestDescription, Boolean requestStatus, String requestResponse) {
        this.requestID = requestID;
        this.requestType = requestType;
        this.requestSender = requestSender;
        this.requestTime = requestTime;
        this.requestDescription = requestDescription;
        this.requestStatus = requestStatus;
        this.requestResponse = requestResponse;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestSender() {
        return requestSender;
    }

    public void setRequestSender(String requestSender) {
        this.requestSender = requestSender;
    }

    public LocalDate getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDate requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public Boolean getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestResponse() {
        return requestResponse;
    }

    public void setRequestResponse(String requestResponse) {
        this.requestResponse = requestResponse;
    }

  
    
    
}
    
    
    
    
    
    
    
  