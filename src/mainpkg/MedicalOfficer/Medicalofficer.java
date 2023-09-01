/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.MedicalOfficer;

import static jailor.Jailor.showAlert;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.FileToObList;
import mainpkg.ITOfficers.Notification;
import msc.AppendableObjectOutputStream;
import user.AuthorityUser;

/**
 *
 * @author crypticx
 */
public class Medicalofficer extends AuthorityUser {
    
    public Medicalofficer(int id, String name, String password, String userType, LocalDate dob, LocalDate doj, String contactNo, String email) {
        super(id, name, password, userType, dob, doj, contactNo, email);
    }

    public static void addPresciption(Prescription newPrescription){
                
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("PrescriptionList.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newPrescription);
                        showAlert(" Presccription added successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add new" );
            }
        }
    
    
    }
public static ObservableList<Prescription> showAllPresciption(){

   return FXCollections.observableArrayList(FileToObList.readObjectsFromFile("PrescriptionList.bin"));
        
        
        
                
                }
    
}
