/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.dg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;

/**
 *
 * @author USER
 */
public class DG implements Serializable {
    
    public static void ree(){
        System.out.println("Called");

}
    
    public static void addCell(Cell cell ) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("Cell.bin");
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(cell);

            showAlert("New cell added successfully!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                showAlert("Error: Failed to add new cell!");
            }
        }
    
}

    
    
  
    

    public static ArrayList<Cell> showCellDetails() {
        ArrayList<Cell> cellList = new ArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cell.bin"))) {
            while (true) {
                try {
                    Cell prisonCell = (Cell) ois.readObject(); 
                    System.out.println(prisonCell);
                    cellList.add(prisonCell);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Cell not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return cellList;
    }    
    


    public static ObservableList<Request> showRequests(){


        ObservableList<Request> tempList = FXCollections.observableArrayList();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RequestList.bin"))) {
            while (true) {
                try {
                    Request tempRequest = (Request) ois.readObject();
                    tempList.add(tempRequest);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Request Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Request.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }
        System.out.println(tempList);
        return tempList;
    
    }
        
    
    public static void approvedRequest(Request request){
               FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("ApprovedRequest.bin");
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(request);

            showAlert(" Request is approved and added in the file !");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                showAlert("Error: Failed to added in the file!");
             
    } 
    
        }
                                 
    
    }
    
     public static void declinedRequest(Request request ){
               FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("ApprovedRequest.bin");
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(request);

            showAlert(" Request is declined and added in the file !");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                showAlert("Error: Failed to added in the file!");
             
    } 
    
        }
                                 
    
    }
    
    
    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    

    public static ObservableList<PieChart.Data> requestPieChart() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObservableList<PieChart.Data> dataList = FXCollections.observableArrayList();

        int dgCount = 0;
        int trainerCount = 0;
        int visitorCount = 0;
        int logisticsCount = 0;
        int itCount = 0;
        int medicalCount = 0;
        int jailorCount = 0;
        int securityInchargeCount = 0;
        int financeCount = 0;
        int prisonGuardCount = 0;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RequestList.bin"))) {
            while (true) {
                Request temp = (Request) ois.readObject();
                
                System.out.println(temp.getRequestSender());
                

                switch (temp.getRequestSender()) {
                    case "Director General":
                  dgCount++;
                    break;
                    case "Trainer":
                       trainerCount++;
                        break;
                    case "Visitor Management Officer":
                       visitorCount++;
                       break;
                    case "Logistics officer":
                       logisticsCount++;
                        break;
                    case "IT Officer":
                       itCount++;
                        break;
                    case "Medical Workers":
                        medicalCount++;
                        break;
                    case "JAILOR":
                        jailorCount++;
                        break;
                    case "Security Incharge":
                        securityInchargeCount++;
                        break;
                    case "Finance and Accounting":
                        financeCount++;
                        break;
                    case "Prison Guard":
                        prisonGuardCount++;
                        break;
                   
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Request.bin File not Found");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        
        dataList.addAll(
            new PieChart.Data("Director General", dgCount),
            new PieChart.Data("Trainer", trainerCount),
            new PieChart.Data("Visitor Management Officer", visitorCount),
            new PieChart.Data("Logistics officer", logisticsCount),
            new PieChart.Data("IT Officer", itCount),
            new PieChart.Data("Medical Workers", medicalCount),
            new PieChart.Data("JAILOR", jailorCount),
            new PieChart.Data("Security Incharge", securityInchargeCount),
            new PieChart.Data("Finance and Accounting", financeCount),
            new PieChart.Data("Prison Guard", prisonGuardCount)
            
        );

        return dataList;
    }
    
    
}
    



