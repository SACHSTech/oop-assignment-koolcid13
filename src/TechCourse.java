public class TechCourse {
    
    private boolean requiresDevice;

    public TechCourse (String strCode, String strName, ArrayList<String> prereqs, int intEnrolledCnt, boolean requiresDevice) {
        super (strCode, strName, prereqs, intEnrolledCnt);
        this.requiresDevice = requiresDevice;
    }

    public boolean getDeviceRequirement() {
        return requiresDevice;
    }

}
