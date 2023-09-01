
package securityincharge;

import java.io.Serializable;
import user.AuthorityUser;

public class AssignedTasks implements Serializable {
    
    private Tasks tasks;
    private AuthorityUser authorityUser;
    private String taskCompletionDescription;

    public AssignedTasks(Tasks t, AuthorityUser u) {
        this.tasks = t;
        this.authorityUser = u;
        this.taskCompletionDescription = "";
    }

    public String getTaskCompletionDescription() {
        return taskCompletionDescription;
    }

    public void setTaskCompletionDescription(String taskCompletionDescription) {
        this.taskCompletionDescription = taskCompletionDescription;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public AuthorityUser getAuthorityUser() {
        return authorityUser;
    }

    public void setAuthorityUser(AuthorityUser authorityUser) {
        this.authorityUser = authorityUser;
    }
    

    

    @Override
    public String toString() {
        return "Task ID: " + this.tasks.getTaskId() + 
                ", Guard ID: " + this.authorityUser.getId() + 
                ", Task Name: " + this.tasks.getTaskname() + 
                ", Shift Name: " + this.tasks.getShift().getShift() + 
                ", Date: " + this.tasks.getShift().getDate().toString() + 
                ", Start Time: " + this.tasks.getShift().getStartTime() + 
                ", End Time: " + this.tasks.getShift().getEndTime() + 
                ", Status: " + this.tasks.getTaskStatus() + "\n";
    }
}
