import java.util.*;

public class ScienceCourse extends Course {
    
    private LabProject lab;
    private boolean needToMemorizeFormula;

    public ScienceCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, LabProject theLab, boolean formulaReq) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.lab = theLab;
        this.needToMemorizeFormula = formulaReq;
    }

    public boolean getMemorizationReq() {
        return needToMemorizeFormula;
    }

    public LabProject getLabProject() {
        return lab;
    }


}
