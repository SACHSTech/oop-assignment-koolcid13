import java.util.*;

public class TechCourse extends Course {
    
    private boolean requiresDevice;

    public TechCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, boolean requiresDevice) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.requiresDevice = requiresDevice;
    }

    /**
     * getter method for device requirement
     *
     * @return returns value of requiresDevice
     *
     */
    public boolean getDeviceRequirement() {
        return requiresDevice;
    }

}
