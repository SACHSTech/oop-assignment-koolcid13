import java.util.*;

public class BusinessCourse extends Course {

    private double fairInvestment = 78.9;

    public BusinessCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt) {
        super (strCode, strName, prereqs, intEnrolledCnt);
    }

    /**
     * getter method for fair investment costs
     *
     * @return returns value of fairInvestment
     *
     */
    public double getFairInvestCost() {
        return fairInvestment;
    }

}
