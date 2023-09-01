/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import inventory.InventoryItem;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import logistics.AssetToBuy;
import logistics.PurchaseRequest;
import msc.AppendableObjectOutputStream;
import vendor.Vendor;

/**
 *
 * @author calsifer
 */
public class LogisticsOfficer {
    
    
    
    public static ObservableList<InventoryItem> viewInventory(){
        ObservableList<InventoryItem> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("InventoryItemList.bin"))) {
            while (true) {
                try {
                    InventoryItem inventoryItem = (InventoryItem) ois.readObject();
                    tempList.add(inventoryItem);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("InventoryItem Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("InventoryItemList.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
        
        
        public static void addToInventory(InventoryItem inventoryItem){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("InventoryItemList.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(inventoryItem);
                        showAlert("New " + inventoryItem.getItemName()+" added successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add new" + inventoryItem.getItemName());
            }
        }
        
    }
        
    public static void makePurchaseReq(PurchaseRequest purchaseRequest){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("PurchaseRequestList.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(purchaseRequest);
                        showAlert(purchaseRequest.toString() +" added successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add" + purchaseRequest.toString());
            }
        }
        
    }
    

    public static ObservableList<PurchaseRequest> viewPurchaseReq(){
        ObservableList<PurchaseRequest> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PurchaseRequestList.bin"))) {
            while (true) {
                try {
                    PurchaseRequest purchaseRequest = (PurchaseRequest) ois.readObject();
                    tempList.add(purchaseRequest);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("PurchaseRequest Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("PurchaseRequestList.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
    
public static ObservableList<AssetToBuy> viewAssetsToBuy(PurchaseRequest purchaseRequest){
        ObservableList<AssetToBuy> tempList = FXCollections.observableArrayList(); 

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PurchaseRequestList.bin"))) {
            while (true) {
                try {

                    PurchaseRequest purchaseRequest1 = (PurchaseRequest) ois.readObject();

                    if(purchaseRequest1.getRequestId() == purchaseRequest.getRequestId()){
                        tempList.addAll(purchaseRequest.getItems());
                        break;
                    }
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("PurchaseRequest Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("PurchaseRequestList.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }

    
    public static void addVendor(Vendor vendor){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("VendorList.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(vendor);
                        showAlert(vendor.getName() +" added successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add" + vendor.getName());
            }
        }
        
    }
    
    
        public static ObservableList<Vendor> viewVendor(){
        ObservableList<Vendor> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("VendorList.bin"))) {
            while (true) {
                try {
                    Vendor vendor = (Vendor) ois.readObject();
                    tempList.add(vendor);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Vendor Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("VendorList.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
        }
        
        
        public static ObservableList<List<AssetToBuy>> viewAllAssetToBuy(){
        ObservableList<List<AssetToBuy>> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PurchaseRequestList.bin"))) {
            while (true) {
                try {
                    PurchaseRequest purchaseRequest = (PurchaseRequest) ois.readObject();
                    tempList.add(purchaseRequest.getItems());
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Vendor Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("VendorList.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
        }
    
       private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
         
}
