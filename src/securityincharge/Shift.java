
package securityincharge;

import java.io.Serializable;
import java.time.LocalDate;


public class Shift implements Serializable {
    private LocalDate date;
    private String shiftName;
    private String startTime;
    private String endTime;

    public Shift(LocalDate date, String shift, String startTime, String endTime) {
        this.date = date;
        this.shiftName = shift;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getShift() {
        return shiftName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setshiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
}
