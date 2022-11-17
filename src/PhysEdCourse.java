import java.util.*;

public class PhysEdCourse extends Course {

    private int intGymNum;
    private double gymSetCost = 123.45;
    private double gymShoesCost = 234.56;

    public PhysEdCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, int intGymNumber) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.intGymNum = intGymNumber;
    }

    public int getGymNumber() {
        return intGymNum;
    }

    public double buyGymSet() {
        return gymSetCost;
    }

    public double buyGymShoes() {
        return gymShoesCost;
    }


}
