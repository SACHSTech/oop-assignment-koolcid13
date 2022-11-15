// package line

import java.io.*;
import java.util.*;
import java.util.ArrayList;
// other imports


//header (only works for grade 12)

//javadoc
public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader key = new BufferedReader (new InputStreamReader (System.in));

        String strName, strLast, strInputClass;
        int int11courseCnt, intCreds;
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


        System.out.print ("What's one class on your selection? ");
        strInputClass = key.readLine();

        //read file to find course data, search implemented
        File f = new File("src/CourseInfo.txt");
        BufferedReader freader = new BufferedReader (new FileReader(f));
        String s;
        while((s = freader.readLine()) != null) {
            String[] st = s.split("_");
            String code = st[0];
            if (! (code.equals(strInputClass))) {
                continue;
            }
            int num = Integer.parseInt(st[1]);

            ArrayList<String> prereqs = new ArrayList<String>();
            // change place of arraylist when made into method
            // add clear arraylist when made into method
            for (int i = 2; i < 2 + num; i ++) {
                prereqs.add(st[i]);
            }

        }
        
    }
    


}