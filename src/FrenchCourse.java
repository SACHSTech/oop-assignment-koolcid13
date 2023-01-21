import java.util.*;

public class FrenchCourse extends Course {

    private boolean willReadBook = true;

    public FrenchCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt) {
        super (strCode, strName, prereqs, intEnrolledCnt);
    }


    /**
     * getter method for book reading requirement
     *
     * @return returns value of willReadBook
     *
     */
    public boolean getBookReadingReq() {
        return willReadBook;
    }

}
