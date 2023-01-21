import java.util.*;

public class ScienceCourse extends Course {
    
    private LabProject lab;
    private boolean needToMemorizeFormula;

    public ScienceCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, LabProject theLab, boolean formulaReq) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.lab = theLab;
        this.needToMemorizeFormula = formulaReq;
    }

    /**
     * getter method for memorization requirement
     *
     * @return returns value of needToMemorizeFormula
     *
     */
    public boolean getMemorizationReq() {
        return needToMemorizeFormula;
    }


    /**
     * getter method for lab project class
     *
     * @return returns class of lab
     *
     */
    public LabProject getLabProject() {
        return lab;
    }


}
