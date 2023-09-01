package jailor;

import java.io.Serializable;


public class Rehabilitation implements Serializable {
    private final int programID;
    private final String programName;
    private final String prisonerID;
    private final String prisonerName;

    public Rehabilitation(Program pr, Prisoner p) {
        this.prisonerID = p.getNid();
        this.prisonerName = p.getName();
        this.programID = pr.getProgramID();
        this.programName = pr.getProgramName();
    }

    public int getProgramID() {
        return programID;
    }



    public String getProgramName() {
        return programName;
    }



    public String getPrisonerID() {
        return prisonerID;
    }



    public String getPrisonerName() {
        return prisonerName;
    }



    @Override
    public String toString() {
        return "Prisoner ID: " + this.prisonerID + 
                " Name: " + this.prisonerName +
                " Program ID + " + this.programID +
                " Program Name: " + this.programName;
    }
}
