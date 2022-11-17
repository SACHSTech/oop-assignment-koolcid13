import java.util.*;

public class BusinessCourse extends Course {

    public BusinessCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt) {
        super (strCode, strName, prereqs, intEnrolledCnt);
    }

    public double businessFairInvest() {
        return 78.9;
    }

}
