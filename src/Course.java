// package line
import java.util.ArrayList;

public class Course {
    
    private String strCode;
    private String strName;
    private ArrayList<String> prereqs;
    private int intEnrolledCnt;

    //javadoc
    public Course (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt) {
        this.strCode = strCode;
        this.strName = strName;
        this.prereqs = prereqs; // double check if works or try clone
        this.intEnrolledCnt = intEnrolledCnt;
    }

    public String getName() {
        return  this.strName;
    }

    public String getCode() {
        return this.strCode;
    }

    public int intEnrolledCnt() {
        return intEnrolledCnt;
    }

    
}
