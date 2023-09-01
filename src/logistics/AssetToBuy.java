/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logistics;

import java.io.Serializable;

/**
 *
 * @author calsifer
 */
public class AssetToBuy implements Serializable{
    private String assetName;
    private int quantity;
    private String priority;
    private String need;
    private String status;
    private String type;

    public AssetToBuy(String assetName, int quantity, String priority,String need, String status, String type) {
        this.assetName = assetName;
        this.quantity = quantity;
        this.priority = priority;
        this.need = need;
        this.status = status;
        this.type = type;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Override
    public String toString() {
        return  "assetName=" + assetName + ", quantity=" + quantity + ", priority=" + priority + ", need=" + need + ", status=" + status ;
    }


    
    
}
