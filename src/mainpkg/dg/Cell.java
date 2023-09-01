/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.dg;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Cell implements Serializable{
    
    private int cellNo ;
    private String blockNo;
    private int wingNo;
    private int cellCapacity;
    private String cellType;

    public Cell(int cellNo, String blockNo, int wingNo, int cellCapacity, String cellType) {
        this.cellNo = cellNo;
        this.blockNo = blockNo;
        this.wingNo = wingNo;
        this.cellCapacity = cellCapacity;
        this.cellType = cellType;
    }

    public int getCellNo() {
        return cellNo;
    }
    
    

    public void setCellNo(int cellNo) {
        this.cellNo = cellNo;
    }

    public String getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(String blockNo) {
        this.blockNo = blockNo;
    }

    public int getWingNo() {
        return wingNo;
    }

    public void setWingNo(int wingNo) {
        this.wingNo = wingNo;
    }

    public int getCellCapacity() {
        return cellCapacity;
    }

    public void setCellCapacity(int cellCapacity) {
        this.cellCapacity = cellCapacity;
    }

    public String getCellType() {
        return cellType;
    }

    public void setCellType(String cellType) {
        this.cellType = cellType;
    }

    @Override
    public String toString() {
        return "Cell{" + "cellNo=" + cellNo + ", blockNo=" + blockNo + ", wingNo=" + wingNo + ", cellCapacity=" + cellCapacity + ", cellType=" + cellType + '}';
    }
    
    
    
    
}
