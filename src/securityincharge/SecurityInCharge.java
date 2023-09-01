
package securityincharge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import msc.AppendableObjectOutputStream;
import prisonguard.PrisonGuard;
import user.AuthorityUser;


public class SecurityInCharge {
    public static void addTask(Tasks t) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Tasks.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(t);

        } catch (IOException ex) {
            Logger.getLogger(Tasks.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Tasks.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void addAssignedTask(AssignedTasks t) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("AssignedTasks.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(t);

        } catch (IOException ex) {
            Logger.getLogger(AssignedTasks.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AssignedTasks.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList <AuthorityUser> getPrisoneGuardList() {
        ArrayList <AuthorityUser> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             AuthorityUser c;
             ois = new ObjectInputStream(new FileInputStream("AuthorityUserList.bin"));
             
            while(true){
                c = (AuthorityUser) ois.readObject();
                if(c.getUserType().equals("Prison Guard")) {
                    list.add(c);
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
    return list;
}
    
    
    public static ArrayList <Tasks> getTasksList() {
        ArrayList <Tasks> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             Tasks c;
             ois = new ObjectInputStream(new FileInputStream("Tasks.bin"));
             
            while(true){
                c = (Tasks) ois.readObject();
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
    
    public static ArrayList <AssignedTasks> getAssignedTasksList() {
        ArrayList <AssignedTasks> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             AssignedTasks c;
             ois = new ObjectInputStream(new FileInputStream("AssignedTasks.bin"));
             
            while(true){
                c = (AssignedTasks) ois.readObject();
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
    
    
    public static void sendUpdates(AssignedTasks at) {
        ArrayList <AssignedTasks> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             AssignedTasks c;
             ois = new ObjectInputStream(new FileInputStream("AssignedTasks.bin"));
             
            while(true){
                c = (AssignedTasks) ois.readObject();
                if(c.getTasks().getTaskId() == at.getTasks().getTaskId() && c.getAuthorityUser().getId() == at.getAuthorityUser().getId()) {
                    list.add(at);
                }
                else list.add(c);
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
        File file = new File("AssignedTasks.bin");
        file.delete();
        
        for (int i = 0; i < list.size(); i ++) {
            
            File f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;


            try {
                f = new File("AssignedTasks.bin");
                if(f.exists()){
                    fos = new FileOutputStream(f,true);
                    oos = new AppendableObjectOutputStream(fos);                
                }
                else{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);               
                }
                oos.writeObject(list.get(i));

            } catch (IOException ex) {
                Logger.getLogger(PrisonGuard.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(PrisonGuard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    public static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
     
     
     public static boolean PrisonGuardExistence(int EmployeeID) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             AuthorityUser c;
             ois = new ObjectInputStream(new FileInputStream("AuthorityUserList.bin"));
             
            while(true){
                c = (AuthorityUser) ois.readObject();
                if(c.getId() == EmployeeID && c.getUserType().equals("Prison Guard")) {
                    result = true;
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
        return result;
    }
    
    
    public static boolean PrisonGuardentried(int EmployeeID) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             PrisonGuardAttandance c;
             ois = new ObjectInputStream(new FileInputStream("PrisonGuardAttandance.bin"));
             
            while(true){
                c = (PrisonGuardAttandance) ois.readObject();
                if(c.getEmployeeID() == EmployeeID) {
                    if(c.getExit() == null) {
                        result = true;
                        break;
                    }
                    
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
        return result;
    }
    
    public static PrisonGuardAttandance AddAttandance (int EmployeeID) {
        ObjectInputStream ois = null;
        AuthorityUser oc = null;
        try {
             AuthorityUser c;
             ois = new ObjectInputStream(new FileInputStream("AuthorityUserList.bin"));
             
            while(true){
                c = (AuthorityUser) ois.readObject();
                if(c.getId() == EmployeeID && c.getUserType().equals("Prison Guard")) {
                    oc = c;
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
        
        PrisonGuardAttandance ea = new PrisonGuardAttandance(oc, new Date(), null);
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        

        try {
            f = new File("PrisonGuardAttandance.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(ea);

        } catch (IOException ex) {
            Logger.getLogger(PrisonGuard.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PrisonGuard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return ea;
    }

    public static void UpdateExit(int EmployeeID) {
        ArrayList<PrisonGuardAttandance> list = new ArrayList<>();
        
        ObjectInputStream ois = null;
        try {
             PrisonGuardAttandance c;
             ois = new ObjectInputStream(new FileInputStream("PrisonGuardAttandance.bin"));
             
            while(true){
                c = (PrisonGuardAttandance) ois.readObject();
                if(c.getEmployeeID() == EmployeeID) c.setExit(new Date());
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
        
        
        
        File f = new File("PrisonGuardAttandance.bin");
        f.delete();
        for (int i = 0; i < list.size(); i ++) {
            
            f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;


            try {
                f = new File("PrisonGuardAttandance.bin");
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
                Logger.getLogger(PrisonGuard.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(PrisonGuard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
}
