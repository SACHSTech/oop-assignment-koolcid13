// package line
import java.util.*;


public class Course {
    
    private String strCode;
    private String strName;
    private ArrayList<String> prereqs;
    private int intEnrolledCnt;
    private boolean isAlternative;

    
    public Course (String strCode, String strName, ArrayList<String> prereqsInput, int intEnrolledCnt) {
        this.strCode = strCode;
        this.strName = strName;
        this.prereqs = (ArrayList)prereqsInput.clone();
        this.intEnrolledCnt = intEnrolledCnt;
        this.isAlternative = false;
    }

    /**
     * seter method for isAlternative, changed to true for alt courses
     *
     */
    public void setAlternate() {
        this.isAlternative = true;
    }

    /**
     * getter method for name
     *
     * @return returns value of strName
     *
     */
    public String getName() {
        return  this.strName;
    }


    /**
     * getter method for code
     *
     * @return returns value of strCode
     *
     */
    public String getCode() {
        return this.strCode;
    }


    /**
     * getter method for prereqs
     *
     * @return returns value of prereqs
     *
     */
    public ArrayList<String> getPrereqs() {
        return prereqs;
    }


    /**
     * getter method for enrolled count
     *
     * @return returns value of intEnrolledCnt
     *
     */
    public int getEnrolledCnt() {
        return intEnrolledCnt;
    }

    /**
     * getter method for isAlternate
     *
     * @return returns value of isAlternate
     *
     */
    public boolean getIsAlternate() {
        return isAlternative;
    }

    /**
     * method to determine whether the prerequisites of a course have been taken
     *
     * @param coursesTaken arrayList containing the courses taken
     * @return returns true if prerequisites taken, false if not
     *
     */
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
