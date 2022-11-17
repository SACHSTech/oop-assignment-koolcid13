public class Retreat {

    private String strDate;
    private int intSem;
    private String strLocation;

    public Retreat (String date, int semNum, String location) {
        this.strDate = date;
        this.intSem = semNum;
        this.strLocation = location;
    }

    public String getDate() {
        return strDate;
    }

    public int getSemester() {
        return intSem;
    }

    public String getLocation() {
        return strLocation;
    }

}
