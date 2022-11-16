// package line

import java.io.*;
import java.util.*;

import org.junit.platform.engine.support.discovery.SelectorResolver.Match;

//header

//javadoc for all methods
public class Main {
    
    static int int11courseCnt, intCreds, int12courseCnt;
    public static void main(String[] args) throws IOException{

        BufferedReader key = new BufferedReader (new InputStreamReader (System.in));

        String strName, strLast, strInputClass;
        ArrayList <String> g11courseList = new ArrayList <String>();
        ArrayList<String> prereqs = new ArrayList<String>();
        List<Course> probCourses = new ArrayList<Course>();


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
        String s, code = "", name = "", dept = "";
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
        if (dept.equals ("Arts")) {
            ArtCourse course = new ArtCourse(code, name, prereqs, 1);
        }
        else if (dept.equals ("Business Studies")) {
            BusinessCourse course = new BusinessCourse(code, strName, prereqs, 1);
        }
        else if (dept.equals ("Canadian and World Studies")) {
            cAndWCourse course = new cAndWCourse(code, strName, prereqs, 1);
        }
        else if (dept.equals ("English")) {
            EnglishCourse course = new EnglishCourse(code, strName, prereqs, 1);
        }
        else if (dept.equals ("French as a Second Language")) {
            FrenchCourse course = new FrenchCourse(code, strName, prereqs, 1);
        }
        else if (dept.equals ("Health and Physical Education")) {
            PhysEdCourse course = new PhysEdCourse(code, strName, prereqs, 1);
        }
        else if (dept.equals ("Mathematics")) {
            MathCourse course = new MathCourse(code, strName, prereqs, 1);
        }
        else if (dept.equals("Religion")) {
            ReligionCourse course = new ReligionCourse(code, strName, prereqs, 1);
        }
        else if (dept.equals ("Science")) {
            ScienceCourse course = new ScienceCourse(code, strName, prereqs, int12courseCnt, 1);
        }
        else {
            System.out.println ("this was the else: " + dept);
            TechCourse course = new TechCourse(code, strName, prereqs, int11courseCnt, false);
        }

         
        System.out.println (course.hasPrereqs(g11courseList));
        
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