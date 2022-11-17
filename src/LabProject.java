public class LabProject {
    
    private boolean NeedsCoat;
    private boolean hasPostLab;
    private int intRoomNum;
    private double dblTime;

    public LabProject (boolean coatReq, boolean postLabReq, int roomNum, double duration) {
        this.NeedsCoat = coatReq;
        this.hasPostLab = postLabReq;
        this.intRoomNum = roomNum;
        this.dblTime = duration;
    }

}
