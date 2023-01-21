import java.util.*;

public class PhysEdCourse extends Course {

    private int intGymNum;
    private double gymSetCost = 123.45;
    private double gymShoesCost = 234.56;

    public PhysEdCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, int intGymNumber) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.intGymNum = intGymNumber;
    }


    /**
     * getter method for gym number
     *
     * @return returns value of intGymNum
     *
     */
    public int getGymNumber() {
        return intGymNum;
    }


    /**
     * getter method for gym set cost
     *
     * @return returns value of gymSetCost
     *
     */
    public double getGymSetCost() {
        return gymSetCost;
    }

    /**
     * getter method for gym shoes cost
     *
     * @return returns value of gymShoesCost
     *
     */
    public double getGymShoesCost() {
        return gymShoesCost;
    }


}
