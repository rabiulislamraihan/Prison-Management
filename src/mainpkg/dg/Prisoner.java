 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.dg;
import java.time.LocalDate;
import java.io.Serializable;

public class Prisoner implements Serializable {
    private final String name;
    private final int nid;
    private final LocalDate dateOfBirth;
    private final int prisoner_id;
    private final String sex;
    private String prisonCellBlock;
    private String Status;

    public Prisoner(String name, int nid, LocalDate dateOfBirth, int prisoner_id, String sex, String prisonCellBlock, String Status) {
        this.name = name;
        this.nid = nid;
        this.dateOfBirth = dateOfBirth;
        this.prisoner_id = prisoner_id;
        this.sex = sex;
        this.prisonCellBlock = prisonCellBlock;
        this.Status = Status;
    }

    public String getName() {
        return name;
    }

    public int getNid() {
        return nid;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPrisoner_id() {
        return prisoner_id;
    }

    public String getSex() {
        return sex;
    }

    public String getPrisonCellBlock() {
        return prisonCellBlock;
    }

    public void setPrisonCellBlock(String prisonCellBlock) {
        this.prisonCellBlock = prisonCellBlock;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return  "name=" + name ;
    }
    
    
}

    

    

    