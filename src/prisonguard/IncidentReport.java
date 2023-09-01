/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonguard;

import java.io.Serializable;
import java.time.LocalDate;


public class IncidentReport implements Serializable {
    private String report;
    private LocalDate incidentDate;

    public IncidentReport(String Report, LocalDate IncidentDate) {
        this.report = Report;
        this.incidentDate = IncidentDate;
    }
    
    

    public String getReport() {
        return report;
    }

    public void setReport(String Report) {
        this.report = Report;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate IncidentDate) {
        this.incidentDate = IncidentDate;
    }
}
