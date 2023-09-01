/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonguard;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
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
import javafx.stage.FileChooser;
import msc.AppendableObjectOutputStream;
import securityincharge.AssignedTasks;
import user.AuthorityUser;


public class PrisonGuard {
    
    public static void addIncidentReport(IncidentReport i) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;


        try {
            f = new File("IncidentReport.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(i);

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
    
    public static void DownloadAttandance() {
        ArrayList <EmployeeAttandance> list = new ArrayList<>();
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             EmployeeAttandance c;
             ois = new ObjectInputStream(new FileInputStream("EmployeeAttandance.bin"));
             
            while(true){
                c = (EmployeeAttandance) ois.readObject();
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
        
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));

            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                String filePath = file.getAbsolutePath();

                PdfWriter pdfWriter = new PdfWriter(filePath);
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                Document document = new Document(pdfDocument);
                
                for (EmployeeAttandance x : list) {

                    Paragraph paragraph = new Paragraph(x.toString());
                    document.add(paragraph);
                }
                document.close();
            }
        } catch (Exception e) {
        }
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
    
    
    public static boolean entried(int EmployeeID) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             EmployeeAttandance c;
             ois = new ObjectInputStream(new FileInputStream("EmployeeAttandance.bin"));
             
            while(true){
                c = (EmployeeAttandance) ois.readObject();
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
    
    public static EmployeeAttandance AddAttandance (int EmployeeID) {
        ObjectInputStream ois = null;
        AuthorityUser oc = null;
        try {
             AuthorityUser c;
             ois = new ObjectInputStream(new FileInputStream("AuthorityUserList.bin"));
             
            while(true){
                c = (AuthorityUser) ois.readObject();
                if(c.getId() == EmployeeID) {
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
        
        EmployeeAttandance ea = new EmployeeAttandance(oc, new Date(), null);
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        

        try {
            f = new File("EmployeeAttandance.bin");
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
        ArrayList<EmployeeAttandance> list = new ArrayList<>();
        
        ObjectInputStream ois = null;
        try {
             EmployeeAttandance c;
             ois = new ObjectInputStream(new FileInputStream("EmployeeAttandance.bin"));
             
            while(true){
                c = (EmployeeAttandance) ois.readObject();
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
        
        
        
        File f = new File("EmployeeAttandance.bin");
        f.delete();
        for (int i = 0; i < list.size(); i ++) {
            
            f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;


            try {
                f = new File("EmployeeAttandance.bin");
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
}
