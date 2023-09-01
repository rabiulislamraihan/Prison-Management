
package financeandaccounting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import msc.AppendableObjectOutputStream;
import user.AuthorityUser;


public class FinanceAndAccountOfficer {

    
    
    public static ArrayList<AuthorityUser> getSelectedEmployee(String UserType) {
        ArrayList<AuthorityUser> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             AuthorityUser c;
             ois = new ObjectInputStream(new FileInputStream("AuthorityUserList.bin"));
             
            while(true){
                c = (AuthorityUser) ois.readObject();
                if(c.getUserType().equals(UserType)) {
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
    public static void paySalary(Salary s) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Salary.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(s);

        } catch (IOException ex) {
            Logger.getLogger(Salary.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Salary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
    public static boolean EmployeeExistence(int EmployeeID) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             AuthorityUser c;
             ois = new ObjectInputStream(new FileInputStream("AuthorityUserList.bin"));
             
            while(true){
                c = (AuthorityUser) ois.readObject();
                if(c.getId() == EmployeeID) {
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
}
