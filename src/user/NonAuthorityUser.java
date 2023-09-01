/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import msc.AppendableObjectOutputStream;
import applications.Application;
/**
 *
 * @author calsifer
 */
public class NonAuthorityUser implements Serializable{
    private String name;
    private final Integer id;
    private final LocalDate dob;
    private final String nid;
    private String fatherName;
    private String motherName;
    private String password;
    private String contactNo;
    private String address;
    private String nationality;
    private String userType;
    private String email;

    public NonAuthorityUser(String name, Integer id, LocalDate dob, String nid, String fatherName, String motherName, String password, String contactNo, String address, String nationality, String userType, String email) {
        this.name = name;
        this.id = id;
        this.dob = dob;
        this.nid = nid;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.password = password;
        this.contactNo = contactNo;
        this.address = address;
        this.nationality = nationality;
        this.userType = userType;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getNid() {
        return nid;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }

    public String getNationality() {
        return nationality;
    }

    public String getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NonAuthorityUser{" + "name=" + name + ", id=" + id + ", dob=" + dob + ", nid=" + nid + ", fatherName=" + fatherName + ", motherName=" + motherName + ", password=" + password + ", contactNo=" + contactNo + ", address=" + address + ", nationality=" + nationality + ", userType=" + userType + ", email=" + email + '}';
    }



    


    
    

   
    
    
    
    public static Integer writeApplication(Application application, Integer i){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("ApplicationForms.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
                i++;
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
                i = 1;
            }
            oos.writeObject(application);
                        showAlert("New Application added successfully! \n Pending approval");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add new application");
            }
        }
        return i;
    }
    
    
        private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

     
}
