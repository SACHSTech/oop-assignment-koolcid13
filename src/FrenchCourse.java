import java.util.*;

public class FrenchCourse extends Course {

    private boolean willReadBook = true;

    public FrenchCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt) {
        super (strCode, strName, prereqs, intEnrolledCnt);
    }

    public boolean getBookReadingReq() {
        return willReadBook;
    }

}
