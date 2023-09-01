/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nonauthorityuser;

/**
 *
 * @author calsifer
 */
import java.io.Serializable;
import java.time.LocalDate;
import prisoner.Prisoner;
import visitormanagement.Visitor;

public class PermissionCard implements Serializable{
    private String cardID;
    private Visitor owner;
    private LocalDate validFrom;
    private LocalDate validUntil;
    private Prisoner prisoner;

    public PermissionCard(String cardID, Visitor owner, LocalDate validFrom, LocalDate validUntil, Prisoner prisoner) {
        this.cardID = cardID;
        this.owner = owner;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.prisoner = prisoner;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public Visitor getOwner() {
        return owner;
    }

    public void setOwner(Visitor owner) {
        this.owner = owner;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public Prisoner getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    @Override
    public String toString() {
        return "PermissionCard{" + "cardID=" + cardID + ", owner=" + owner + ", validFrom=" + validFrom + ", validUntil=" + validUntil + ", prisoner=" + prisoner + '}';
    }


    }

    

