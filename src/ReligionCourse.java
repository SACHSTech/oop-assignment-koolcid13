import java.util.*;

public class ReligionCourse extends Course {

    private Retreat retreat;

    public ReligionCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, Retreat retreatObj) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.retreat = retreatObj;
    }

    public Retreat getRetreat() {
        return retreat;
    }

}
