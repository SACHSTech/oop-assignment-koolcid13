// package line

import java.io.*;
import java.util.*;


//header

//javadoc for all methods to be added
public class Main {
    
    static int int11courseCnt, intCreds, int12courseCnt;
    static String s, code = "", name = "", dept = "";
    static ArrayList<String> prereqs = new ArrayList<String>();
    static ArrayList<String> g11courseList = new ArrayList <String>();
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


    public static void main(String[] args) throws IOException{

        BufferedReader key = new BufferedReader (new InputStreamReader (System.in));

        String strName, strLast, strInputClass;

        // intro lines
        System.out.print ("Enter your name please: ");
        strName = key.readLine(); 
        System.out.print ("Enter your last name please: ");
        strLast = key.readLine();
        System.out.print ("How many courses did you take last year: ");
        int11courseCnt = Integer.parseInt(key.readLine());

        for (int i = 1; i <= int11courseCnt; i ++) {
            String strInput;
            System.out.print ("Course number " + i + ": ");
            strInput = key.readLine();
            g11courseList.add (strInput);
        }

        System.out.print ("How many credits do you have so far: ");
        intCreds = Integer.parseInt(key.readLine());
        
        System.out.print ("How many courses are you planning on taking this year: ");
        int12courseCnt = Integer.parseInt(key.readLine());

        for (int i = 0; i < int12courseCnt; i++) {
            System.out.print ("What's one class on your selection? ");
            strInputClass = key.readLine();
    
            findCode(strInputClass);        
            objectCreation (dept);        
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
        }
        else if (dept.equals ("Canadian and World Studies")) {
            CAndWCourse course = new CAndWCourse(code, name, prereqs, intEnrolledRand);
            cAndWArrayList.add (course);
        }
        else if (dept.equals ("English")) {
            EnglishCourse course = new EnglishCourse(code, name, prereqs, intEnrolledRand);
            englishArrayList.add (course);
        }
        else if (dept.equals ("French as a Second Language")) {
            FrenchCourse course = new FrenchCourse(code, name, prereqs, intEnrolledRand);
            frenchArrayList.add (course);
        }
        else if (dept.equals ("Health and Physical Education")) {
            PhysEdCourse course = new PhysEdCourse(code, name, prereqs, intEnrolledRand);
            physedArrayList.add (course);
        }
        else if (dept.equals ("Mathematics")) {
            MathCourse course = new MathCourse(code, name, prereqs, intEnrolledRand);
            mathArrayList.add (course);
        }
        else if (dept.equals("Religion")) {
            ReligionCourse course = new ReligionCourse(code, name, prereqs, intEnrolledRand);
            religionArrayList.add (course);
        }
        else if (dept.equals ("Science")) {
            ScienceCourse course = new ScienceCourse(code, name, prereqs, int12courseCnt, intEnrolledRand);
            scienceArrayList.add (course);
        }
        else {
            TechCourse course = new TechCourse(code, name, prereqs, int11courseCnt, false);
            techArrayList.add (course);
        }
        prereqs.clear();
        // function to be checked later
    }

    public String selectionValid (boolean tookEng) {
        if (intCreds + int12courseCnt < 30) {
            return "insufficient credits";
        }
        if (! tookEng) {
            return "no english";
        }
        for (int i = 0; i < artArrayList.size(); i ++) {
            if (! artArrayList.get(i).hasPrereqs(g11courseList)) {
                return "prereqs not met";
            }
        }
        for (int i = 0; i < businessArrayList.size(); i ++) {
            if (! businessArrayList.get(i).hasPrereqs(g11courseList)) {
                return "prereqs not met";
            }
        }
        for (int i = 0; i < cAndWArrayList.size(); i ++) {
            if (! cAndWArrayList.get(i).hasPrereqs(g11courseList)) {
                return "prereqs not met";
            }
        }
        for (int i = 0; i < englishArrayList.size(); i ++) {
            if (! englishArrayList.get(i).hasPrereqs(g11courseList)) {
                return "prereqs not met";
            }
        }
        for (int i = 0; i < frenchArrayList.size(); i ++) {
            if (! frenchArrayList.get(i).hasPrereqs(g11courseList)) {
                return "prereqs not met";
            }
        }
        for (int i = 0; i < mathArrayList.size(); i ++) {
            if (! mathArrayList.get(i).hasPrereqs(g11courseList)) {
                return "prereqs not met";
            }
        }
        for (int i = 0; i < physedArrayList.size(); i ++) {
            if (! physedArrayList.get(i).hasPrereqs(g11courseList)) {
                return "prereqs not met";
            }
        }
        for (int i = 0; i < religionArrayList.size(); i ++) {
            if (! religionArrayList.get(i).hasPrereqs(g11courseList)) {
                return "prereqs not met";
            }
        }
        for (int i = 0; i < scienceArrayList.size(); i ++) {
            if (! scienceArrayList.get(i).hasPrereqs(g11courseList)) {
                return "prereqs not met";
            }
        }
        for (int i = 0; i < techArrayList.size(); i ++) {
            if (! techArrayList.get(i).hasPrereqs(g11courseList)) {
                return "prereqs not met";
            }
        }
        return "ok";
    }

    public boolean hasEnglish(String dep1, String dep2, String dep3, String dep4, String dep5, String dep6, String dep7, String dep8)  {
        if (dep1 != "English" && dep2 != "English" && dep3 != "English" && dep4 != "English" && dep5 != "English" && dep6 != "English" && dep7 != "English" && dep8 != "English") {
            return false;
        } 
        return true;
    }


}