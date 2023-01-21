import java.util.*;

public class MathCourse extends Course {

    private int intTables;

    public MathCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        if (intEnrolledCnt % 5 == 0) {
            this.intTables = intEnrolledCnt / 5;
        }
        else {
            this.intTables = (intEnrolledCnt + 5) / 5;
        }
    }


    /**
     * getter method for number of tables
     *
     * @return returns value of intTables
     *
     */
    public int getNumOfTables() {
        return intTables;
    }
}
