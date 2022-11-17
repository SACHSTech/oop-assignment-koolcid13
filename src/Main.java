// package line

import java.io.*;
import java.util.*;


//header

//javadoc for all methods to be added
public class Main {
    
    static int intLastcourseCnt, intCreds, int12courseCnt;
    static double dblStudentCost = 0, dblLastAvg;
    static String s, code, name, dept;
    static boolean hasExemption;
    static ArrayList<String> prereqs = new ArrayList<String>();
    static ArrayList<String> prevCourseList = new ArrayList <String>();
    static List<ArtCourse> artArrayList = new ArrayList<ArtCourse>();
    static List<BusinessCourse> businessArrayList = new ArrayList<BusinessCourse>();
    static List<CAndWCourse> cAndWArrayList = new ArrayList<CAndWCourse>();
    static List<EnglishCourse> englishArrayList = new ArrayList<EnglishCourse>();
    static List<FrenchCourse> frenchArrayList = new ArrayList<FrenchCourse>();
    static List<MathCourse> mathArrayList = new ArrayList<MathCourse>();
    static List<PhysEdCourse> physedArrayList = new ArrayList<PhysEdCourse>();
    static List<ReligionCourse> religionArrayList = new ArrayList<ReligionCourse>();
    static List<ScienceCourse> scienceArrayList = new ArrayList<ScienceCourse>();
    static List<TechCourse> techArrayList = new ArrayList<TechCourse>();
    static Retreat retreat1 = new Retreat("09/23/22", 1, "Camp Robin Hood");
    static Retreat retreat2 = new Retreat("01/01/23", 2, "Code Ninjas");
    static LabProject bioLab = new LabProject(true, true, 224, 75);
    static LabProject physLab = new LabProject(false, true, 222, 55);
    static LabProject chemLab = new LabProject(false, true, 220, 70);


    public static void main(String[] args) throws IOException{

        BufferedReader key = new BufferedReader (new InputStreamReader (System.in));

        String strName, strLast, strInputClass;

        // intro lines
        System.out.print ("Enter your name please: ");
        strName = key.readLine(); 
        System.out.print ("Enter your last name please: ");
        strLast = key.readLine();
        System.out.print ("How many courses have you take so far: ");
        intLastcourseCnt = Integer.parseInt(key.readLine());
        System.out.print ("What was your average last year: ");
        dblLastAvg = Integer.parseInt(key.readLine());
        System.out.print ("Do you by any chance have a religion exemption? Type in true or false");
        hasExemption = Boolean.parseBoolean(key.readLine());
        

        

        for (int i = 1; i <= intLastcourseCnt; i ++) {
            String strInput;
            System.out.print ("Course number " + i + ": ");
            strInput = key.readLine();
            prevCourseList.add (strInput);
        }

        System.out.print ("How many credits do you have so far: ");
        intCreds = Integer.parseInt(key.readLine());
        
        System.out.print ("How many courses are you planning on taking this year: ");
        int12courseCnt = Integer.parseInt(key.readLine());

        for (int i = 0; i < int12courseCnt; i++) {
            System.out.print ("What's one class on your selection? ");
            strInputClass = key.readLine();
    
            findCode(strInputClass);     
        }
        
    }

    public static void findCode (String strInputClass) throws FileNotFoundException, IOException{
        //read file to find course data, search implemented
        File f = new File("src/CourseInfo.txt");
        BufferedReader freader = new BufferedReader (new FileReader(f));
        while((s = freader.readLine()) != null) {
            String[] st = s.split("_");
            code = st[0];
            if (! (code.equals(strInputClass))) {
                continue;
            }
            int num = Integer.parseInt(st[1]);

            // add clear arraylist when made into method
            for (int i = 2; i < 2 + num; i ++) {
                prereqs.add(st[i]);
            }
            // change declaration when made into method
            name = st[2 + num];
            dept = st[3 + num];
            
            objectCreation(dept);
            break;
        }

        
    }

    public static void objectCreation (String dept) {
        
        Random random = new Random();
        int intEnrolledRand = random.nextInt (30);

        if (dept.equals ("Arts")) {
            ArtCourse course = new ArtCourse(code, name, prereqs, intEnrolledRand);
            artArrayList.add (course);
        }
        else if (dept.equals ("Business Studies")) {
            BusinessCourse course = new BusinessCourse(code, name, prereqs, intEnrolledRand);
            businessArrayList.add (course);
            if (businessArrayList.size() == 1) {
                dblStudentCost += (businessArrayList.get(0).getFairInvestCost());
            }
        }
        else if (dept.equals ("Canadian and World Studies")) {
            CAndWCourse course = new CAndWCourse(code, name, prereqs, intEnrolledRand);
            cAndWArrayList.add (course);
        }
        else if (dept.equals ("English")) {
            EnglishCourse course;
            int intNumOfConferences = 4;
            if (dblLastAvg > 88.88) {
                System.out.println ("Because your average mark from last year is greater than 88.88 you are given the advantage of one less conference session in English");
                course = new EnglishCourse(code, name, prereqs, intEnrolledRand, intNumOfConferences - 1);
            }
            course = new EnglishCourse(code, name, prereqs, intEnrolledRand, intNumOfConferences);
            englishArrayList.add (course);
        }
        else if (dept.equals ("French as a Second Language")) {
            FrenchCourse course = new FrenchCourse(code, name, prereqs, intEnrolledRand);
            frenchArrayList.add (course);
        }
        else if (dept.equals ("Health and Physical Education")) {
            int intRoomNum;
            if (name.contains("fitness") || name.contains("Fitness")) {
                intRoomNum = 2;
            }
            else {
                intRoomNum = 1;
            }
            PhysEdCourse course = new PhysEdCourse(code, name, prereqs, intEnrolledRand, intRoomNum);
            physedArrayList.add (course);
            if (physedArrayList.size() == 1) {
                dblStudentCost += (physedArrayList.get(0).buyGymSet());
                dblStudentCost += (physedArrayList.get(0).buyGymShoes());

            }
        }
        else if (dept.equals ("Mathematics")) {
            MathCourse course = new MathCourse(code, name, prereqs, intEnrolledRand);
            mathArrayList.add (course);
        }
        else if (dept.equals("Religion")) {
            ReligionCourse course = new ReligionCourse(code, name, prereqs, intEnrolledRand, retreat2);
            // choose between retreat 1 and 2
            religionArrayList.add (course);
        }
        else if (dept.equals ("Science")) {
            LabProject labAdd;
            boolean requiresFormulaMemo;
            if (name.equals("Biology")) {
                labAdd = bioLab;
                requiresFormulaMemo = false;
            }
            else if (name.equals("Physics")) {
                labAdd = physLab;
                requiresFormulaMemo = true;
            }
            else {
                labAdd = chemLab;
                requiresFormulaMemo = true;
            }
            ScienceCourse course = new ScienceCourse(code, name, prereqs, intEnrolledRand, labAdd, requiresFormulaMemo);
            scienceArrayList.add (course);
        }
        else {
            TechCourse course = new TechCourse(code, name, prereqs, intLastcourseCnt, false);
            techArrayList.add (course);
        }
        prereqs.clear();
        // function to be checked later
    }

    public static String selectionValid () {
        if (intCreds + int12courseCnt < 30) {
            return "insufficient credits";
        }
        if (! hasEnglish()) {
            return "no english";
        }
        if (!hasReligion() && !hasExemption) {
            return "no religion";
        }
        if (! prereqsMet()) {
            return "not enough prereqs";
        }
        return "ok";
    }

    
    public static boolean hasEnglish() {
        if (englishArrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean hasReligion() {
        if (religionArrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean prereqsMet() {
        for (int i = 0; i < artArrayList.size(); i ++) {
            if (! artArrayList.get(i).hasPrereqs(prevCourseList)) {
                return false;
            }
        }
        for (int i = 0; i < businessArrayList.size(); i ++) {
            if (! businessArrayList.get(i).hasPrereqs(prevCourseList)) {
                return false;
            }
        }
        for (int i = 0; i < cAndWArrayList.size(); i ++) {
            if (! cAndWArrayList.get(i).hasPrereqs(prevCourseList)) {
                return false;
            }
        }
        for (int i = 0; i < englishArrayList.size(); i ++) {
            if (! englishArrayList.get(i).hasPrereqs(prevCourseList)) {
                return false;
            }
        }
        for (int i = 0; i < frenchArrayList.size(); i ++) {
            if (! frenchArrayList.get(i).hasPrereqs(prevCourseList)) {
                return false;
            }
        }
        for (int i = 0; i < mathArrayList.size(); i ++) {
            if (! mathArrayList.get(i).hasPrereqs(prevCourseList)) {
                return false;
            }
        }
        for (int i = 0; i < physedArrayList.size(); i ++) {
            if (! physedArrayList.get(i).hasPrereqs(prevCourseList)) {
                return false;
            }
        }
        for (int i = 0; i < religionArrayList.size(); i ++) {
            if (! religionArrayList.get(i).hasPrereqs(prevCourseList)) {
                return false;
            }
        }
        for (int i = 0; i < scienceArrayList.size(); i ++) {
            if (! scienceArrayList.get(i).hasPrereqs(prevCourseList)) {
                return false;
            }
        }
        for (int i = 0; i < techArrayList.size(); i ++) {
            if (! techArrayList.get(i).hasPrereqs(prevCourseList)) {
                return false;
            }
        }
        return true;
    }


}