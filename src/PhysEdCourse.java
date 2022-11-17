import java.util.*;

public class PhysEdCourse extends Course {

    public PhysEdCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt) {
        super (strCode, strName, prereqs, intEnrolledCnt);
    }

    public double buyGymSet() {
        return 123.45;
    }

    public double buyGymShoes() {
        return 234.56;
    }


}
