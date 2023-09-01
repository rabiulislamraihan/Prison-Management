/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.DocumentProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.awt.Font;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import user.AuthorityUser;
import user.NonAuthorityUser;
import msc.AppendableObjectOutputStream;
import applications.Application;
import javax.mail.Multipart;
import mainpkg.ITOfficers.Notification;
import schedule.ScheduleApplication;
/**
 *
 * @author calsifer
 */
public class VisitormanagementOfficer extends AuthorityUser {

    public VisitormanagementOfficer(int id, String name, String password, String userType, LocalDate dob, LocalDate doj, String contactNo, String email) {
        super(id, name, password, userType, dob, doj, contactNo, email);
    }
    
    public static void addNonAauthorityUser(NonAuthorityUser nonAuthorityUser){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("NonAuthorityUserList.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(nonAuthorityUser);
            showAlert("New " + nonAuthorityUser.getUserType() +" added to waiting list successfully!"+ "\n" + "Waiting For approval");
                        
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add new" + nonAuthorityUser.getUserType());
            }
        }
    }
    
    
    
    public static ObservableList<NonAuthorityUser> viewSignUps(){
        ObservableList<NonAuthorityUser> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NonAuthorityUserList.bin"))) {
            while (true) {
                try {
                    NonAuthorityUser nonAuthorityUser = (NonAuthorityUser) ois.readObject();
                    tempList.add(nonAuthorityUser);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("NonAuthorityUser Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("NonAuthorityUserList.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
    
    
    public static void approveSignUp(NonAuthorityUser nonAuthorityUser){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("ApprovedNonAuthorityUser.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(nonAuthorityUser);
                        showAlert("New " + nonAuthorityUser.getUserType() +" added successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add new" + nonAuthorityUser.getUserType());
            }
        }
        
    }
    
    
    public static ObservableList<NonAuthorityUser> ShowApprovedNonAuthorityUser(){
        ObservableList<NonAuthorityUser> tempList = FXCollections.observableArrayList();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ApprovedNonAuthorityUser.bin"))) {
            while (true) {
                try {
                    NonAuthorityUser nonAuthorityUser = (NonAuthorityUser) ois.readObject();
                    tempList.add(nonAuthorityUser);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("NonAuthorityUser Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ApprovedNonAuthorityUser.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
    
        public static ObservableList<Application> viewApplication(){
        ObservableList<Application> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ApplicationForms.bin"))) {
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
            System.err.println("ApplicationForms.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
        
        
        public static ObservableList<Application> viewApprovedApplication(){
        ObservableList<Application> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ApprovedApplications.bin"))) {
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
            System.err.println("ApprovedApplications.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
    
        
        public static void sendToJailorApprovalWaiting(Application application){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("JailorApprovalWaiting.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(application);
                        showAlert("Application no " + application.getApplicationID() +" added successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add application no" + application.getApplicationID());
            }
        }
        
    }
    
    public static void makeAppointment(ScheduleApplication schedule){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("Schedule.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(schedule);
                        showAlert("Application no " + schedule.getApplication().getApplicationID() +" scheduled successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add application no" + schedule.getApplication().getApplicationID());
            }
        }
        
    }

        public static ObservableList<ScheduleApplication> viewSchedules(){
        ObservableList<ScheduleApplication> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Schedule.bin"))) {
            while (true) {
                try {
                    ScheduleApplication schedule = (ScheduleApplication) ois.readObject();
                    tempList.add(schedule);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Application Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Approved Applications.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }    
        
        

public static void generatePDFForApplication(ScheduleApplication schedule, String fileName) {
    try {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("PDF files", "*.pdf"));
        fc.getExtensionFilters().add(new ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
        

        fc.setInitialFileName(fileName);

        File f = fc.showSaveDialog(null);
        if (f != null) {
            PdfWriter pw = new PdfWriter(new FileOutputStream(f));
            PdfDocument pdf = new PdfDocument(pw);
            pdf.addNewPage();
            Document doc = new Document(pdf);
            doc.setLeftMargin(70);
            
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 
                        = "Permission Card\n\n" +
                "Name: " + getAppNameForID(schedule.getApplication().getNonAuthorityUserid()) + "\n" +
                "Date of Birth: " + getUserForID(schedule.getApplication().getNonAuthorityUserid()).getDob()+ "\n" +
                "National ID: " + getUserForID(schedule.getApplication().getNonAuthorityUserid()).getNid() + "\n" +
                "Father's Name: " + getUserForID(schedule.getApplication().getNonAuthorityUserid()).getFatherName() + "\n" +
                "Mother's Name: " + getUserForID(schedule.getApplication().getNonAuthorityUserid()).getMotherName() + "\n" +
                "Contact No: " + getUserForID(schedule.getApplication().getNonAuthorityUserid()).getContactNo() + "\n" +
                "Address: " + getUserForID(schedule.getApplication().getNonAuthorityUserid()).getAddress() + "\n" +
                "Nationality: " + getUserForID(schedule.getApplication().getNonAuthorityUserid()).getNationality() + "\n" +
                "Activity: " + schedule.getActivity() + "\n" +
                "Date: " + schedule.getDate() + "\n" +
                "Start Time: " + schedule.getStartTime() + "\n" +
                "End Time: " + schedule.getEndTime() +
                "Prisoner no: "+ schedule.getPrisonerID();
                
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Permission Card");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    //OR titleText.setBold();

                               
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(lineSpace);


            
            doc.close();
            
            showAlert("PDF saved successfully.");
        } else {
            showAlert("Saving as PDF: Cancelled.");
        }
    } catch (FileNotFoundException e) {
        showAlert("Error: File not found - " + e.getMessage());
    } catch (Exception e) {
        showAlert("Oops! Exception: " + e.toString() + " occurred.");
    }
} 

        
    public static ObservableList<Notification> showNotification() {
        ObservableList<Notification> notificationList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NotificationList.bin"))) {
            while (true) {
                try {
                    Notification tempNotification = (Notification) ois.readObject();
                    
                    if (tempNotification.getNotificationUserType().equals("Visitor Management Officer")){
                     System.out.println("Notification for User found");
                     System.out.println(tempNotification.getNotificationDetails());
                        
                    notificationList.add(tempNotification);
                    }
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return notificationList;
    }   
    
    
    
    public static String getAppNameForID(Integer applicantID) {
        
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NonAuthorityUserList.bin"))) {
            while (true) {
                try {
                    NonAuthorityUser nonAuthorityUser = (NonAuthorityUser) ois.readObject();
                    if(nonAuthorityUser.getId().equals(applicantID)){
                        return nonAuthorityUser.getName();
                        
                    }
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Application Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Approved Applications.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }
                
        return null;
        
        
        
    }
   
    
    public static NonAuthorityUser getUserForID(Integer applicantID) {
        
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NonAuthorityUserList.bin"))) {
            while (true) {
                try {
                    NonAuthorityUser nonAuthorityUser = (NonAuthorityUser) ois.readObject();
                    if(nonAuthorityUser.getId().equals(applicantID)){
                        return nonAuthorityUser;
                        
                    }
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Application Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Approved Applications.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }
                
        return null;
        
        
        
    }
    
    public static void sendEmail(String to, String subject, String messageText, String attachmentFilePath) {
        String from = "2222914@iub.edu.bd";
        String password = "OopPrison@"; 

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            FileInputStream attachmentInputStream = new FileInputStream(attachmentFilePath);
            ByteArrayOutputStream attachmentOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = attachmentInputStream.read(buffer)) != -1) {
                attachmentOutputStream.write(buffer, 0, bytesRead);
            }

            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new ByteArrayDataSource(attachmentOutputStream.toByteArray(), "application/octet-stream");
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName("attachment"); // The attachment filename (without extension)

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(messageText);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
    
    public static void sendEmailV2(String to, String subject, String messageText, String attachmentFilePath, String attachmentFileNameWithExtension) {
        String from = "2222914@iub.edu.bd";
        String password = "OopPrison@"; 

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
    });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);

        FileInputStream attachmentInputStream = new FileInputStream(attachmentFilePath);
        ByteArrayOutputStream attachmentOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = attachmentInputStream.read(buffer)) != -1) {
            attachmentOutputStream.write(buffer, 0, bytesRead);
        }

        MimeBodyPart attachmentPart = new MimeBodyPart();
        DataSource source = new ByteArrayDataSource(attachmentOutputStream.toByteArray(), "application/octet-stream");
        attachmentPart.setDataHandler(new DataHandler(source));
        attachmentPart.setFileName(attachmentFileNameWithExtension); // Use the provided filename with extension

        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText(messageText);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(textPart);
        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);

        Transport.send(message);
        System.out.println("Email sent successfully!");
    } catch (MessagingException | IOException e) {
        e.printStackTrace();
        System.err.println("Error sending email: " + e.getMessage());
    }
}

    
    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
