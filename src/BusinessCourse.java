import java.util.*;

public class BusinessCourse extends Course {

    private double fairInvestment = 78.9;

    public BusinessCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt) {
        super (strCode, strName, prereqs, intEnrolledCnt);
    }

    public double getFairInvestCost() {
        return fairInvestment;
    }

}
