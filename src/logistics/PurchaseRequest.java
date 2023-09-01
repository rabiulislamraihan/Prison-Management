/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logistics;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author calsifer
 */
public class PurchaseRequest implements Serializable{
    private int requestId;
    private LocalDate requestDate;
    private String requestedBy;
    private List<AssetToBuy> items; 

    public PurchaseRequest(int requestId, LocalDate requestDate, String requestedBy, ObservableList<AssetToBuy> items) {
        this.requestId = requestId;
        this.requestDate = requestDate;
        this.requestedBy = requestedBy;
        this.items = new ArrayList<>(items);
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public List<AssetToBuy> getItems() {
        return items;
    }

    public void setItems(List<AssetToBuy> items) {
        this.items = items;
    }

    

    @Override
    public String toString() {
        return  "requestId: " + requestId + ", requestDate: " + requestDate + ", requestedBy: " + requestedBy + ", items: " + items ;
    }





    
}
