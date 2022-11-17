import java.util.*;

public class ScienceCourse extends Course {
    
    private LabProject lab;

    public ScienceCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, LabProject theLab) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.lab = theLab;
    }

}
