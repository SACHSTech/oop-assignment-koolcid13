// package line

import java.io.*;
import java.util.ArrayList;
// other imports


//header (only works for grade 12)

//javadoc
public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader key = new BufferedReader (new InputStreamReader (System.in));

        String strName, strLast;
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

    
    }
    


}