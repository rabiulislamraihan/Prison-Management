

package jailor;

import java.io.Serializable;


public class Program implements Serializable {
    
    private final String programName;
    private final int programID;
    
    public Program(String programName, int programID) {
        this.programName = programName;
        this.programID = programID;
    }
    

    public String getProgramName() {
        return programName;
    }



    public int getProgramID() {
        return programID;
    }


}
