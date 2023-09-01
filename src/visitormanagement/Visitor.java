/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visitormanagement;

import java.io.Serializable;
import java.time.LocalDate;
import user.NonAuthorityUser;
/**
 *
 * @author calsifer
 */
public class Visitor extends NonAuthorityUser implements Serializable{
    private LocalDate visitDate;
    private boolean isApproved;
    
    public Visitor(LocalDate visitDate, boolean isApproved, String name, Integer id, LocalDate dob, String nid, String fatherName, String motherName, String password, String contactNo, String address, String nationality, String userType, String email) {
        super(name, id, dob, nid, fatherName, motherName, password, contactNo, address, nationality, userType, email);
        this.visitDate = visitDate;
        this.isApproved = isApproved;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    @Override
    public String toString() {
        return "Visitor{" + "visitDate=" + visitDate + ", isApproved=" + isApproved + '}';
    }




}