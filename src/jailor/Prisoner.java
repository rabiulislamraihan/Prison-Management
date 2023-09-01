

package jailor;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;

public class Prisoner implements Serializable {
    private final String name;
    private final String nid;
    private final LocalDate dateOfBirth;
    private final int prisoner_id;
    private String gender;
    private String prisonCellBlock;
    private String status;
    private ArrayList<CaseDetail> caseList = new ArrayList<>();

    public Prisoner(String name, String nid, LocalDate dateOfBirth, int prisoner_id, String gender, String prisonCellBlock, String Status) {
        this.name = name;
        this.nid = nid;
        this.dateOfBirth = dateOfBirth;
        this.prisoner_id = prisoner_id;
        this.gender = gender;
        this.prisonCellBlock = prisonCellBlock;
        this.status = Status;
    }

    public String getName() {
        return name;
    }

    public String getNid() {
        return nid;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPrisoner_id() {
        return prisoner_id;
    }

    public String getGender() {
        return gender;
    }

    public String getPrisonCellBlock() {
        return prisonCellBlock;
    }

    public String getStatus() {
        return status;
    }

    public void setPrisonCellBlock(String prisonCellBlock) {
        this.prisonCellBlock = prisonCellBlock;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }

    public ArrayList<CaseDetail> getCaseList() {
        return caseList;
    }

    public void setCaseList(ArrayList<CaseDetail> CaseList) {
        this.caseList = CaseList;
    }
    
}