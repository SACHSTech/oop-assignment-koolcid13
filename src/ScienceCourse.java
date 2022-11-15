import java.util.*;

public class ScienceCourse extends Course {
    
    private int intNumberOfLabs;

    public ScienceCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, int intNumberOfLabs) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.intNumberOfLabs = intNumberOfLabs;
    }

    public int getLabNum() {
        return intNumberOfLabs;
    }
}
