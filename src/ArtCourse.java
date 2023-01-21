import java.util.*;

public class ArtCourse extends Course {

    private double courseEssentialsCost = 111.11;
    
    public ArtCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt) {
        super (strCode, strName, prereqs, intEnrolledCnt);
    }

    /**
     * getter method for essential costs
     *
     * @return returns value of courseEssentialsCost
     *
     */
    public double getEssentialsCost() {
        return courseEssentialsCost;
    }


}
