/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.MedicalOfficer;

import jailor.Prisoner;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author crypticx
 */
public class Prescription implements Serializable {
    private int prisonerID;
    private String prisonerLatestPrescrition;
    private LocalDate prisonerLastConsult;
    private String presciptionDetails;

    public Prescription(int prisonerID,  String prisonerLatestPrescrition, LocalDate prisonerLastConsult) {
        this.prisonerID = prisonerID;
        this.prisonerLatestPrescrition = prisonerLatestPrescrition;
        this.prisonerLastConsult = prisonerLastConsult;
    }

    public int getPrisonerID() {
        return prisonerID;
    }

    public void setPrisonerID(int prisonerID) {
        this.prisonerID = prisonerID;
    }

    public String getPrisonerLatestPrescrition() {
        return prisonerLatestPrescrition;
    }

    public void setPrisonerLatestPrescrition(String prisonerLatestPrescrition) {
        this.prisonerLatestPrescrition = prisonerLatestPrescrition;
    }

    public LocalDate getPrisonerLastConsult() {
        return prisonerLastConsult;
    }

    public void setPrisonerLastConsult(LocalDate prisonerLastConsult) {
        this.prisonerLastConsult = prisonerLastConsult;
    }

    public String getPresciptionDetails() {
        return presciptionDetails;
    }

    public void setPresciptionDetails(String presciptionDetails) {
        this.presciptionDetails = presciptionDetails;
    }
    






    
}
