/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonguard;

import java.io.Serializable;
import java.util.Date;
import user.AuthorityUser;


public class EmployeeAttandance implements Serializable {
    
    private int employeeID;
    private String employeeName;
    private Date entry;
    private Date exit;

    public EmployeeAttandance(AuthorityUser au, Date entry, Date exit) {
        this.employeeID = au.getId();
        this.employeeName = au.getName();
        this.entry = entry;
        this.exit = exit;
    }
    
    
    

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.employeeID = EmployeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.employeeName = EmployeeName;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public Date getExit() {
        return exit;
    }

    public void setExit(Date exit) {
        this.exit = exit;
    }

    @Override
    public String toString() {
        return "Employee ID: " + Integer.toString(employeeID) + 
                ", Employee Name: " + employeeName + 
                ", Entry: " + entry + 
                ", Exit: " + exit + "\n";
    }
}
