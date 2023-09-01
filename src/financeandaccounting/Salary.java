package financeandaccounting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import user.AuthorityUser;


public class Salary implements Serializable {
    
    private int employeeID;
    private String grade;
    private int ammount;
    private String month;
    private int bonus;

    public Salary(int employeeID, String grade, int ammount, String month, int bonus) {
        this.employeeID = employeeID;
        this.grade = grade;
        this.ammount = ammount;
        this.month = month;
        this.bonus = bonus;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    
    
}