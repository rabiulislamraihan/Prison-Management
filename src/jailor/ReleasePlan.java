package jailor;

import java.io.Serializable;
import java.time.LocalDate;


public class ReleasePlan implements Serializable {
    
    private Prisoner prisoner;
    private String description;
    LocalDate proposedReleasedate;

    public ReleasePlan(Prisoner p, String Description, LocalDate proposedReleasedate) {
        this.prisoner = p;
        this.description = Description;
        this.proposedReleasedate = proposedReleasedate;
    }

    public Prisoner getP() {
        return prisoner;
    }

    public void setP(Prisoner p) {
        this.prisoner = p;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public LocalDate getProposedReleasedate() {
        return proposedReleasedate;
    }

    public void setProposedReleasedate(LocalDate proposedReleasedate) {
        this.proposedReleasedate = proposedReleasedate;
    }
}
