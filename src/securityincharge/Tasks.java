
package securityincharge;

import java.io.Serializable;

public class Tasks implements Serializable {
    private final int taskId;
    private final String taskname;
    private String taskStatus;
    private String description;
    private Shift shift;

    public Tasks(int taskId, String taskname, String taskStatus, String description, Shift shift) {
        this.taskId = taskId;
        this.taskname = taskname;
        this.taskStatus = taskStatus;
        this.description = description;
        this.shift = shift;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
    
    public int getTaskId() {
        return taskId;
    }
    

    public String getTaskname() {
        return taskname;
    }
    
    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

}
    