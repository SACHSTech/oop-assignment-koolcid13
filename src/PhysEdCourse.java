import java.util.*;

public class PhysEdCourse extends Course {

    private int intGymNum;

    public PhysEdCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, int intGymNumber) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.intGymNum = intGymNumber;
    }

    public int getGymNumber() {
        return intGymNum;
    }

    public double buyGymSet() {
        return 123.45;
    }

    public double buyGymShoes() {
        return 234.56;
    }


}
