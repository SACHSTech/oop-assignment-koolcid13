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


    /**
     * setter method for needs coat
     *
     */
    public void setNeedsCoat() {
        this.NeedsCoat = true;
    }

    /**
     * setter method for if the lab has post-lab
     *
     */
    public void setHasPostLab() {
        this.hasPostLab = true;
    }


    /**
     * getter method for coat requirement
     * 
     * @return returns the value of NeedsCoat
     *
     */
    public boolean getCoatReq() {
        return NeedsCoat;
    }


    /**
     * getter method for post lab requirement
     * 
     * @return returns the value of hasPostLab
     *
     */
    public boolean getPostLabReq() {
        return hasPostLab;
    }

    /**
     * getter method for room number
     * 
     * @return returns the value of introomNum
     *
     */
    public int getRoomNum() {
        return intRoomNum;
    }


    /**
     * getter method for lab time
     * 
     * @return returns the value of dblTime
     *
     */
    public double getTime() {
        return dblTime;
    }

    /**
     * determines whether lab is short enough and lab room is big enough to be available to public
     * 
     * @return returns true if conditions met, false otherwise
     *
     */
    public boolean availableToEveryone() {
        if (isShort() && roomIsBig()) { // lab project only available to everyone if conditions are met
            return true;
        }
        return false;
    }


    /**
     * determines if lab is short enough
     * 
     * @return returns true if lab is short enough, false otherwise
     *
     */
    private boolean isShort() {
        if (this.hasPostLab == false && this.dblTime < 45) { // if lab doesn't have post lab and takes less than 45 minutes, is considered short
            return true;
        }
        return false;
    }


    /**
     * determines if room is big enough
     * 
     * @return returns true if room is big, false otherwise
     *
     */
    private boolean roomIsBig() {
        if (this.intRoomNum % 100 == 2) { // assumed that floor two classes are bigger
            return true;
        }
        return false;
    }
}
