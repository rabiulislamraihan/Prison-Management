/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendor;

import java.io.Serializable;

/**
 *
 * @author calsifer
 */
public class Vendor implements Serializable{
    private int vendorId;
    private String name;
    private String contactPerson;
    private String email;
    private String phone;
    private String type;
    
    public Vendor(int vendorId, String name, String contactPerson, String email, String phone, String type) {
        this.vendorId = vendorId;
        this.name = name;
        this.contactPerson = contactPerson;
        this.email = email;
        this.phone = phone;
        this.type = type;
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVendorId() {
        return vendorId;
    }

    public String getName() {
        return name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "vendorId=" + vendorId + ", name=" + name + ", contactPerson=" + contactPerson + ", email=" + email + ", phone=" + phone + ", type=" + type ;
    }


    
}