public class Retreat {

    private String strDate;
    private int intSem;
    private String strLocation;

    public Retreat (String date, int semNum, String location) {
        this.strDate = date;
        this.intSem = semNum;
        this.strLocation = location;
    }


    /**
     * getter method for date
     *
     * @return returns value of strDate
     *
     */
    public String getDate() {
        return strDate;
    }


    /**
     * getter method for semester
     *
     * @return returns value of intSem
     *
     */
    public int getSemester() {
        return intSem;
    }

    /**
     * getter method for location of retreat
     *
     * @return returns value of strLocation
     *
     */
    public String getLocation() {
        return strLocation;
    }

}
