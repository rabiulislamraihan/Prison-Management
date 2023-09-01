/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financeandaccounting;

import java.io.Serializable;

/**
 *
 * @author raiha
 */
public class Budget implements Serializable {
    private String Month;
    private int Year;
    private int Food;
    private int HealthCare;
    private int Tools;
    private int Furniture;
    private int Clothes;
    private int BudgetRemaining;

    public Budget(String Month, int Year, int Food, int HealthCare, int Tools, int Furniture, int Clothes, int BudgetRemaining) {
        this.Month = Month;
        this.Year = Year;
        this.Food = Food;
        this.HealthCare = HealthCare;
        this.Tools = Tools;
        this.Furniture = Furniture;
        this.Clothes = Clothes;
        this.BudgetRemaining = BudgetRemaining;
    }
    
    

    public String getMonth() {
        return Month;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getFood() {
        return Food;
    }

    public void setFood(int Food) {
        this.Food = Food;
    }

    public int getHealthCare() {
        return HealthCare;
    }

    public void setHealthCare(int HealthCare) {
        this.HealthCare = HealthCare;
    }

    public int getTools() {
        return Tools;
    }

    public void setTools(int Tools) {
        this.Tools = Tools;
    }

    public int getFurniture() {
        return Furniture;
    }

    public void setFurniture(int Furniture) {
        this.Furniture = Furniture;
    }

    public int getClothes() {
        return Clothes;
    }

    public void setClothes(int Clothes) {
        this.Clothes = Clothes;
    }

    public int getBudgetRemaining() {
        return BudgetRemaining;
    }

    public void setBudgetRemaining(int BudgetRemaining) {
        this.BudgetRemaining = BudgetRemaining;
    }
    
    
    
    
    
    
}
