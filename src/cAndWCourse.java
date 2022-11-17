import java.util.*;

public class CAndWCourse extends Course {

    private double fieldTripCost = 45.67;

    public CAndWCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt) {
        super (strCode, strName, prereqs, intEnrolledCnt);
    }

    public double getTripCost() {
        return fieldTripCost;
    }

}
