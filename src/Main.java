// package line

import java.io.*;
import java.util.*;


//header

//javadoc for all methods to be added
public class Main {
    
    static int int11courseCnt, intCreds, int12courseCnt;
    static String s, code = "", name = "", dept = "";
    static ArrayList<String> prereqs = new ArrayList<String>();
    List<ArtCourse> artArrayList = new ArrayList<ArtCourse>();
    List<BusinessCourse> businessArrayList = new ArrayList<BusinessCourse>();
    List<CAndWCourse> cAndWArrayList = new ArrayList<CAndWCourse>();
    List<EnglishCourse> englishArrayList = new ArrayList<EnglishCourse>();
    List<FrenchCourse> frenchArrayList = new ArrayList<FrenchCourse>();
    List<MathCourse> mathArrayList = new ArrayList<MathCourse>();
    List<PhysEdCourse> physedArrayList = new ArrayList<PhysEdCourse>();
    List<ReligionCourse> religionArrayList = new ArrayList<ReligionCourse>();
    List<ScienceCourse> scienceArrayList = new ArrayList<ScienceCourse>();
    List<TechCourse> techArrayList = new ArrayList<TechCourse>();

    public static void main(String[] args) throws IOException{

        BufferedReader key = new BufferedReader (new InputStreamReader (System.in));

        String strName, strLast, strInputClass;
        ArrayList <String> g11courseList = new ArrayList <String>();

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

        System.out.print ("What's one class on your selection? ");
        strInputClass = key.readLine();

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
        // create object example
        // error if dept is not initialized, consider
        //for now declaration as course - default

        
        

        
    }

    public void objectCreation (String dept) {
        if (dept.equals ("Arts")) {
            ArtCourse course = new ArtCourse(code, name, prereqs, 1);
            artArrayList.add (course);
        }
        else if (dept.equals ("Business Studies")) {
            BusinessCourse course = new BusinessCourse(code, name, prereqs, 1);
            businessArrayList.add (course);
        }
        else if (dept.equals ("Canadian and World Studies")) {
            CAndWCourse course = new CAndWCourse(code, name, prereqs, 1);
            cAndWArrayList.add (course);
        }
        else if (dept.equals ("English")) {
            EnglishCourse course = new EnglishCourse(code, name, prereqs, 1);
            englishArrayList.add (course);
        }
        else if (dept.equals ("French as a Second Language")) {
            FrenchCourse course = new FrenchCourse(code, name, prereqs, 1);
            frenchArrayList.add (course);
        }
        else if (dept.equals ("Health and Physical Education")) {
            PhysEdCourse course = new PhysEdCourse(code, name, prereqs, 1);
            physedArrayList.add (course);
        }
        else if (dept.equals ("Mathematics")) {
            MathCourse course = new MathCourse(code, name, prereqs, 1);
            mathArrayList.add (course);
        }
        else if (dept.equals("Religion")) {
            ReligionCourse course = new ReligionCourse(code, name, prereqs, 1);
            religionArrayList.add (course);
        }
        else if (dept.equals ("Science")) {
            ScienceCourse course = new ScienceCourse(code, name, prereqs, int12courseCnt, 1);
            scienceArrayList.add (course);
        }
        else {
            System.out.println ("this was the else: " + dept);
            TechCourse course = new TechCourse(code, name, prereqs, int11courseCnt, false);
            techArrayList.add (course);
        }
    }

    public String selectionValid (boolean tookEng) {
        if (intCreds + int12courseCnt < 30) {
            return "insufficient credits";
        }
        if (! tookEng) {
            return "no english";
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