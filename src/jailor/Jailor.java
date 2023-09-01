/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package jailor;

import applications.Application;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import msc.AppendableObjectOutputStream;

public class Jailor {
    
    
public static void update(Prisoner p, String prisoncell, String status) {
    ArrayList <Prisoner> list = new ArrayList<>();
    ObjectInputStream ois = null;
    try {
         Prisoner c;
         ois = new ObjectInputStream(new FileInputStream("Prisoner.bin"));

        while(true){
            c = (Prisoner) ois.readObject();
            if(c.getPrisoner_id() == p.getPrisoner_id()) {
                c.setPrisonCellBlock(prisoncell);
                c.setStatus(status);
            }
            list.add(c);
        }
    }
    catch(RuntimeException e){
        e.printStackTrace();
    }
    catch (Exception ex) {
        try {
            if(ois!=null)
                ois.close();
        } catch (IOException ex1) {  }           
    }
    
    for (int i = 0; i < list.size(); i ++) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Prisoner.bin");
            if(i != 0){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(list.get(i));

        } catch (IOException ex) {
            Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
    
    
public static Prisoner getPrisonerByPrisonerID(int prisonerID) {
    Prisoner p = null;
    ObjectInputStream ois = null;
        try {
             Prisoner c;
             ois = new ObjectInputStream(new FileInputStream("Prisoner.bin"));
             
            while(true){
                c = (Prisoner) ois.readObject();
                if(c.getPrisoner_id() == prisonerID) {
                    p = c;
                    break;
                }
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return p;
} 

public static Prisoner getPrisonerByNID(int NID) {
    Prisoner p = null;
    ObjectInputStream ois = null;
        try {
             Prisoner c;
             ois = new ObjectInputStream(new FileInputStream("Prisoner.bin"));
             
            while(true){
                c = (Prisoner) ois.readObject();
                if(c.getNid().equals(NID)) {
                    p = c;
                    break;
                }
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return p;
} 
    
    
public static ObservableList <Prisoner> ViewPrisonerlist() {
    ObservableList <Prisoner> list = FXCollections.observableArrayList();
    ObjectInputStream ois = null;
        try {
             Prisoner c;
             ois = new ObjectInputStream(new FileInputStream("Prisoner.bin"));
             
            while(true){
                c = (Prisoner) ois.readObject();
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
    return list;
}
        
public static void addNewPrisoner(Prisoner p){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Prisoner.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(p);

        } catch (IOException ex) {
            Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
    
    public static void addProgram (Program p){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Program.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(p);

        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static ArrayList <Program> ProgramList() {
        ArrayList <Program> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             Program c;
             ois = new ObjectInputStream(new FileInputStream("Program.bin"));
             
            while(true){
                c = (Program) ois.readObject();
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
    return list;
}
    
    
    public static void AddRehabilitation (Rehabilitation p){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Rehabilitation.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(p);

        } catch (IOException ex) {
            Logger.getLogger(Rehabilitation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Rehabilitation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static ArrayList <Rehabilitation> getRehabilitationList() {
        ArrayList <Rehabilitation> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             Rehabilitation c;
             ois = new ObjectInputStream(new FileInputStream("Rehabilitation.bin"));
             
            while(true){
                c = (Rehabilitation) ois.readObject();
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
    return list;
    }    
    
    public static void AddReleasePlan (ReleasePlan p){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("ReleasePlan.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(p);

        } catch (IOException ex) {
            Logger.getLogger(ReleasePlan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ReleasePlan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static ArrayList <ReleasePlan> getReleasePlan() {
        ArrayList <ReleasePlan> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             ReleasePlan c;
             ois = new ObjectInputStream(new FileInputStream("ReleasePlan.bin"));
             
            while(true){
                c = (ReleasePlan) ois.readObject();
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
    return list;
    }    
    
    public static void sendRequest(Request request) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("RequestList.bin");
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(request);

            showAlert("Request is added successfully in the list!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                showAlert("Error: Failed to add request in the list!");
            }
        }
    }
    
    
    public static ObservableList<Application> viewPendingApplication(){
        ObservableList<Application> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("JailorApprovalWaiting.bin"))) {
            while (true) {
                try {
                    Application application = (Application) ois.readObject();
                    tempList.add(application);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Application Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("JailorApprovalWaiting.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
    
    public static void jailorApproval(Application application){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("ApprovedApplications.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(application);
                        showAlert("Application no " + application.getApplicationID() +" approved successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to approve application no" + application.getApplicationID());
            }
        }
    } 


    
}
    
