import java.util.*;

public class EnglishCourse extends Course {

    private String strNovel = "Interpreter of Maladies";
    private int intNumOfConferences = 3;

    public EnglishCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, int intNumOfConferences) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.intNumOfConferences = intNumOfConferences;
    }


    /**
     * getter method for novel name
     *
     * @return returns value of strNovel
     *
     */
    public String getNovelName() {
        return strNovel;
    }

    /**
     * getter method for number of conferences
     *
     * @return returns value of intNumOfConferences
     *
     */
    public int getNumOfConferences() {
        return intNumOfConferences;
    }

}
