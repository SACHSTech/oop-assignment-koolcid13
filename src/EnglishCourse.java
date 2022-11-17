import java.util.*;

public class EnglishCourse extends Course {

    private String strNovel = "Interpreter of Maladies";
    private int intNumOfConferences;

    public EnglishCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, int intNumOfConferences) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.intNumOfConferences = intNumOfConferences;
    }

    public String getNovelName() {
        return strNovel;
    }

    public int getNumOfConferences() {
        return intNumOfConferences;
    }

}
