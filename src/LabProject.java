public class LabProject {
    
    private boolean NeedsCoat;
    private boolean hasPostLab;
    private int intRoomNum;
    private double dblTime;

    public LabProject (int roomNum, double duration) {
        this.NeedsCoat = false;
        this.hasPostLab = false;
        this.intRoomNum = roomNum;
        this.dblTime = duration;
    }

    public void setNeedsCoat() {
        this.NeedsCoat = true;
    }

    public void setHasPostLab() {
        this.hasPostLab = true;
    }

    public boolean getCoatReq() {
        return NeedsCoat;
    }

    public boolean getPostLabReq() {
        return hasPostLab;
    }

    public int getRoomNum() {
        return intRoomNum;
    }

    public double getTime() {
        return dblTime;
    }

    public boolean availableToEveryone() {
        if (isShort() && roomIsBig()) { // lab project only available to everyone if conditions are met
            return true;
        }
        return false;
    }

    private boolean isShort() {
        if (this.hasPostLab == false && this.dblTime < 45) { // if lab doesn't have post lab and takes less than 45 minutes, is considered short
            return true;
        }
        return false;
    }

    private boolean roomIsBig() {
        if (this.intRoomNum % 100 == 2) { // assumed that floor two classes are bigger
            return true;
        }
        return false;
    }
}
