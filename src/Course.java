// package line
import java.util.*;


public class Course {
    
    private String strCode;
    private String strName;
    private ArrayList<String> prereqs;
    private int intEnrolledCnt;
    private boolean isAlternative;

    //javadoc
    public Course (String strCode, String strName, ArrayList<String> prereqsInput, int intEnrolledCnt) {
        this.strCode = strCode;
        this.strName = strName;
        this.prereqs = (ArrayList)prereqsInput.clone(); // double check if works or try clone
        this.intEnrolledCnt = intEnrolledCnt;
        this.isAlternative = false;
    }

    public void setAlternate() {
        this.isAlternative = true;
    }

    public String getName() {
        return  this.strName;
    }

    public String getCode() {
        return this.strCode;
    }

    public ArrayList<String> getPrereqs() {
        return prereqs;
    }

    public int getEnrolledCnt() {
        return intEnrolledCnt;
    }

    public boolean getIsAlternate() {
        return isAlternative;
    }

    public boolean hasPrereqs(ArrayList<String> coursesTaken) {
        for (String course : coursesTaken) {
            for (String prereqCourse : prereqs) {
                if (course.equals (prereqCourse)) {
                    return true;
                }
            }
        }
        return false;
    }
}
