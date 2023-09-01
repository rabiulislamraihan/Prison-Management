/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author calsifer
 */
public class InventoryItem implements Serializable{
    private int id;
    private String itemName;
    private String description;
    private int quantity;
    private LocalDate lastUpdated;

    public InventoryItem(int id, String itemName, String description, int quantity, LocalDate lastUpdated) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.quantity = quantity;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "id=" + id + ", itemName=" + itemName + ", description=" + description + ", quantity=" + quantity + ", lastUpdated=" + lastUpdated + '}';
    }
    
    
}
