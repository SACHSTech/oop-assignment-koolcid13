// package line

import java.io.*;
import java.util.*;


//header

//javadoc for all methods to be added
public class Main {
    
    static int intLastcourseCnt, intCreds, int12courseCnt, intReligionSemPreference;
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
    static LabProject bioLab = new LabProject(224, 75);
    static LabProject physLab = new LabProject(222, 55);
    static LabProject chemLab = new LabProject(220, 70);
    static Course altCourse1, altCourse2;


    public static void main(String[] args) throws IOException{

        BufferedReader key = new BufferedReader (new InputStreamReader (System.in));

        String strName, strLast, strInputClass;

        // intro lines
        System.out.print ("Enter your name please: ");
        strName = key.readLine(); 
        System.out.print ("Enter your last name please: ");
        strLast = key.readLine();
        System.out.print ("How many courses have you taken so far: ");
        intLastcourseCnt = Integer.parseInt(key.readLine());
        System.out.print ("What was your average last year: ");
        dblLastAvg = Integer.parseInt(key.readLine());
        System.out.print ("Do you by any chance have a religion exemption? Type in true or false: ");
        hasExemption = Boolean.parseBoolean(key.readLine());
        

        

        for (int i = 1; i <= intLastcourseCnt; i ++) {
            String strInput;
            System.out.print ("Course number " + i + " from previous years: ");
            strInput = key.readLine();
            prevCourseList.add (strInput);
        }

        System.out.print ("How many credits do you have so far: ");
        intCreds = Integer.parseInt(key.readLine());
        
        System.out.print ("How many courses are you planning to take this year: ");
        int12courseCnt = Integer.parseInt(key.readLine());

        for (int i = 0; i < int12courseCnt; i++) {
            System.out.print ("Please enter the course code for selection " + (i + 1) + " on your selection list: ");
            strInputClass = key.readLine();
    
            findCode(strInputClass, 0);     
        }

        System.out.println ("Please enter two course codes as your alternate options.");
        System.out.print ("First alternate: ");
        strInputClass = key.readLine();
        findCode(strInputClass, 1);
        System.out.print("Second alternate: ");
        strInputClass = key.readLine();
        findCode(strInputClass, 2);

        System.out.print ("If you have a religion or philosophy course on your selection list, please indicate which semester you'd prefer for the course: ");
        intReligionSemPreference = Integer.parseInt(key.readLine());

        System.out.println ("Dear " + strName + " " + strLast + ",");
        if (selectionValid().equals("ok")) {
            System.out.println ("You have earned your initial approval from our system and are encouraged to wait until further notice regarding your timetable.");
            printCourseDetails();
        }
        else {
            System.out.println ("It has come to the attention of our system that your course selection does not meet the requirements fully. For further information, please contact your guidance.");
        }
        
    }

    public static void findCode (String strInputClass, int alternateNum) throws FileNotFoundException, IOException {
        // read file to find course data, search implemented
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
            
            objectCreation(dept, alternateNum);
            break;
        }

        
    }

    public static void objectCreation (String dept, int alternateNum) {
        
        Random random = new Random();
        int intEnrolledRand = random.nextInt (30);
    
        if (alternateNum == 1) {
            altCourse1 = new Course (code, name, prereqs, intEnrolledRand);
            altCourse1.setAlternate();
        }
        else if (alternateNum == 2) {
            altCourse2 = new Course(code, name, prereqs, intEnrolledRand);
            altCourse2.setAlternate();
        }

        //student is not added under the classes, happens at timetable level

        if (dept.equals ("Arts")) {
            ArtCourse course = new ArtCourse(code, name, prereqs, intEnrolledRand);
            artArrayList.add (course);
            if (artArrayList.size() == 1) {
                dblStudentCost += (artArrayList.get(0).getEssentialsCost());
            }
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
            dblStudentCost += cAndWArrayList.get(cAndWArrayList.size() - 1).getTripCost();
        }
        else if (dept.equals ("English")) {
            intEnrolledRand = random.nextInt (15);
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
                dblStudentCost += (physedArrayList.get(0).getGymSetCost());
                dblStudentCost += (physedArrayList.get(0).getGymShoesCost());

            }
        }
        else if (dept.equals ("Mathematics")) {
            MathCourse course = new MathCourse(code, name, prereqs, intEnrolledRand);
            mathArrayList.add (course);
        }
        else if (dept.equals("Religion")) {
            intEnrolledRand = random.nextInt (30);
            ReligionCourse course;
            if (intReligionSemPreference == 1) {
                course = new ReligionCourse(code, name, prereqs, intEnrolledRand, retreat1);
            }
            else {
                course = new ReligionCourse(code, name, prereqs, intEnrolledRand, retreat2);
            }
            // choose between retreat 1 and 2
            religionArrayList.add (course);
        }
        else if (dept.equals ("Science")) {
            LabProject labAdd;
            boolean requiresFormulaMemo;
            if (name.equals("Biology")) {
                labAdd = bioLab;
                labAdd.setHasPostLab();
                labAdd.setNeedsCoat();
                requiresFormulaMemo = false;
            }
            else if (name.equals("Physics")) {
                labAdd = physLab;
                labAdd.setHasPostLab();
                requiresFormulaMemo = true;
            }
            else {
                labAdd = chemLab;
                labAdd.setHasPostLab();
                labAdd.setNeedsCoat();
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
    }

    public static String selectionValid () {
        if (! prereqsMet()) {
            return "not enough prereqs";
        }
        if (intCreds + int12courseCnt < 30) {
            return "insufficient credits";
        }
        if (! hasEnglish()) {
            return "no english";
        }
        if (!hasReligion() && !hasExemption) {
            return "no religion";
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
            if (!mathArrayList.get(i).hasPrereqs(prevCourseList) && !mathArrayList.get(i).getCode().equals("MCV4U1")) {
                return false;
            }
            else if (mathArrayList.get(i).getCode().equals("MCV4U1")) {
                boolean hasAdvFunctions = false;
                for (int j = 0; j < mathArrayList.size(); j ++) {
                    if (mathArrayList.get(j).getCode().equals("MHF4U1")) {
                        hasAdvFunctions = true;
                    }
                }
                if (hasAdvFunctions == false) {
                    return false;
                }
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


    public static void printCourseDetails() {
        System.out.println ("");
        System.out.println ("");
        System.out.println ("YOUR APPROVED COURSES WILL BE AS FOLLOWED:");


        for (int i = 0; i < artArrayList.size(); i ++) {
            System.out.println (artArrayList.get(i).getName() + ", " + artArrayList.get(i).getCode());
            System.out.println ("");
        }
        
        for (int i = 0; i < businessArrayList.size(); i ++) {
            System.out.println (businessArrayList.get(i).getName() + ", " + businessArrayList.get(i).getCode());
            System.out.println ("");
        }

        for (int i = 0; i < cAndWArrayList.size(); i ++) {
            System.out.println (cAndWArrayList.get(i).getName() + ", " + cAndWArrayList.get(i).getCode());
            System.out.println ("");
        }

        for (int i = 0; i < englishArrayList.size(); i ++) {
            System.out.println (englishArrayList.get(i).getName() + ", " + englishArrayList.get(i).getCode());
            System.out.println ("In this course you will be reading " + englishArrayList.get(i).getNovelName() + ".");
            System.out.println ("You will also have a total of " + englishArrayList.get(i).getNumOfConferences() + " conferences.");
            System.out.println ("");
        }

        for (int i = 0; i < frenchArrayList.size(); i ++) {
            System.out.println (frenchArrayList.get(i).getName() + ", " + frenchArrayList.get(i).getCode());
            if (frenchArrayList.get(i).getBookReadingReq() == true) {
                System.out.println("In this course, you WILL also read books.");
            }
            System.out.println ("");
        }

        for (int i = 0; i < mathArrayList.size(); i ++) {
            System.out.println (mathArrayList.get(i).getName() + ", " + mathArrayList.get(i).getCode());
            System.out.println ("");
        }

        for (int i = 0; i < physedArrayList.size(); i ++) {
            System.out.println (physedArrayList.get(i).getName() + ", " + physedArrayList.get(i).getCode());
            System.out.println ("Your gym number is going to be " + physedArrayList.get(i).getGymNumber() + ".");
            System.out.println ("");
        }

        for (int i = 0; i < religionArrayList.size(); i ++) {
            System.out.println (religionArrayList.get(i).getName() + ", " + religionArrayList.get(i).getCode());
            System.out.println ("Your retreat will take place on " + religionArrayList.get(i).getRetreat().getDate() + ", during semester " + religionArrayList.get(i).getRetreat().getSemester() + " and the location will be " + religionArrayList.get(i).getRetreat().getLocation() + ".");
            System.out.println ("");

        }

        for (int i = 0; i < scienceArrayList.size(); i ++) {
            System.out.println (scienceArrayList.get(i).getName() + ", " + scienceArrayList.get(i).getCode());
            if (scienceArrayList.get(i).getMemorizationReq() == true) {
                System.out.println("By the way, you will have to memorize formulae for this class.");
            }    
            System.out.println ("Your lab will be at room " + scienceArrayList.get(i).getLabProject().getRoomNum() + ".");       
            if (scienceArrayList.get(i).getLabProject().getCoatReq() == true) {
                System.out.println ("You will need a lab coat for your lab project.");
            }
            if (scienceArrayList.get(i).getLabProject().availableToEveryone() == true) {
                System.out.println ("This lab is open to students from other schools.");
            }
            System.out.println ("");
        }

        for (int i = 0; i < techArrayList.size(); i ++) {
            System.out.println (techArrayList.get(i).getName() + ", " + techArrayList.get(i).getCode());
            if (techArrayList.get(i).getDeviceRequirement() == true) {
                System.out.println ("You will need your own device for this course.");
            }
            System.out.println ("");
        }

    }
}