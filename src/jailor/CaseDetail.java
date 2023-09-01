package jailor;

import java.time.LocalDate;
import java.io.Serializable;

public class CaseDetail implements Serializable {
    private final String crime;
    private final int caseNo;
    private final int actNo;
    private final LocalDate timeServeStart;
    private LocalDate timeServeEnds;
    private final String sentenceDuration;

    public CaseDetail(String crime, int caseNo, int actNo, LocalDate timeServeStart, LocalDate timeServeEnds, String sentenceDuration) {
        this.crime = crime;
        this.caseNo = caseNo;
        this.actNo = actNo;
        this.timeServeStart = timeServeStart;
        this.timeServeEnds = timeServeEnds;
        this.sentenceDuration = sentenceDuration;
    }

    public String getCrime() {
        return crime;
    }

    public int getCaseNo() {
        return caseNo;
    }

    public int getActNo() {
        return actNo;
    }

    public LocalDate getTimeServeStart() {
        return timeServeStart;
    }

    public LocalDate getTimeServeEnds() {
        return timeServeEnds;
    }

    public String getSentenceDuration() {
        return sentenceDuration;
    }

    public void setTimeServeEnds(LocalDate timeServeEnds) {
        this.timeServeEnds = timeServeEnds;
    }

    @Override
    public String toString() {
        return "CaseDetail{" + "crime=" + crime + ", caseNo=" + caseNo + ", actNo=" + actNo + ", timeServeStart=" + timeServeStart + ", timeServeEnds=" + timeServeEnds + ", sentenceDuration=" + sentenceDuration + '}';
    }

    
    
    
}
