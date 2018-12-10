/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theorytasktwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HaithamGamal
 */
public class CheckAndCompile {

    String month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC" + "|jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec"+"|january|february|march|april|may|jun|july|august|september|october|november|december"+"|Janary|February|March|April|May|Jun|July|August|September|October|November|December)";
    String day = "(SATURDAY|SUNDAY|MONDAY|TUESDAY|WEDNESDAY|THURSDAY|FRIDAY" + "|saturday|sunday|monday|tuesday|wednesday|thursday|friday)";
    String daysInNumber = "(0?[1-9]|[12][0-9]|3[01])";
    String year = "(\\d{4})";
    String yearNumber = "(9[0-9])";
    String yrth = "(th)";
    String rd = "(rd)";
    String range = "(-)";
    String comma = "(\\,)";
    String space = " ";
    Matcher matcher;
    Pattern[] pattern;
    String[] regex = {daysInNumber + space + month + space + year, daysInNumber + range + month + range + year, month + space + daysInNumber + range + daysInNumber + comma + space + year, daysInNumber + range + daysInNumber + space + month + space + year, month + space + daysInNumber + comma + space + year, month + space + daysInNumber + yrth + comma + space + year, day + comma + space + daysInNumber + rd + space + month + comma + space + year, day + comma + space + daysInNumber + space + month + space + year, daysInNumber + space + space + space + space + space + space + month + space + daysInNumber + rd + "(From:)", day + comma + space + daysInNumber + space + month + space + yearNumber,daysInNumber+space+month+comma+space+year};

    {
        compileObject();

    }

    private void compileObject() {
        pattern = new Pattern[regex.length];

        for (int i = 0; i < regex.length; i++) {

            pattern[i] = Pattern.compile(regex[i]);

        }
    }

    public void recieveInput(String received) {

        
        label: for (int i = 0; i < regex.length; i++) {

            switch (i) {
                case 0:
                    matcher = pattern[0].matcher(received);
                   // System.out.println(pattern[0]);
                    while (matcher.find())
                        //    System.out.println(matcher.group());
                        System.out.print("  " + matcher.group(1) + " " + matcher.group(2).substring(0,3).toUpperCase() + " " + matcher.group(3));

                    break;
                case 1:
                    matcher = pattern[1].matcher(received);

                    while (matcher.find()) {
                        System.out.print(" " + matcher.group(1) + matcher.group(2) + matcher.group(3) + matcher.group(4) + matcher.group(5));

                    }

                    break;
                case 2:
                    matcher = pattern[2].matcher(received);

                    while (matcher.find()) {
                        String newDteFormat = "from" + " " + matcher.group(2) + matcher.group(3) + matcher.group(1) + " " + matcher.group(6) + "\n"
                                + "TO" + " " + matcher.group(4) + matcher.group(3) + matcher.group(1) + " " + matcher.group(6);
                        System.out.print("  " + newDteFormat);

                    }

                    break;
                case 3:
                    matcher = pattern[3].matcher(received);

                    while (matcher.find()) {
                        String newDteFormat = "from" + " " + matcher.group(1) + " " + matcher.group(4) + " " + matcher.group(5) + "\n"
                                + "To" + " " + matcher.group(3) + " " + matcher.group(4) + " " + matcher.group(5);
                        System.out.print("  " + newDteFormat);

                    }

                    break;
                case 4:
                    matcher = pattern[4].matcher(received);

                    while (matcher.find()) {
                        String newDteFormat = matcher.group(2) + "-" + matcher.group(1) + "-" + matcher.group(4);
                        System.out.println(" " + newDteFormat);

                    }
                    break;
                case 5:
                    matcher = pattern[5].matcher(received);

                    while (matcher.find()) {

                        String newDteFormat = matcher.group(2) + "-" + matcher.group(1) + "-" + matcher.group(5);
                        System.out.println(" " + newDteFormat);

                    }
                    break;
                case 6:
                    matcher = pattern[6].matcher(received);

                    while (matcher.find()) {
                        String newDteFormat = matcher.group(3) + "-" + matcher.group(5) + "-" + matcher.group(7);

                        System.out.println(" " + newDteFormat);
                    }
                    break;
                case 7:
                    matcher = pattern[7].matcher(received);

                    while (matcher.find()) {
                        String newDteFormat = matcher.group(3) + "-" + matcher.group(4) + "-" + matcher.group(5);

                        System.out.println(" " + newDteFormat);

                    }
                    break;
                case 8:
                    matcher = pattern[8].matcher(received);

                    while (matcher.find()) {
                        String newDteFormat = "From" + matcher.group(1) + matcher.group(2) + "To" + matcher.group(3) + matcher.group(2);

                        System.out.println(" " + newDteFormat);

                    }
                    break;
                case 9:
                    matcher = pattern[9].matcher(received);

                    while (matcher.find()) {

                        String newDteFormat = matcher.group(3) + "-" + matcher.group(4) + "-" + matcher.group(5);
                        System.out.println(" " + newDteFormat);

                    }
                    break;
                case 10:
                    matcher = pattern[10].matcher(received);

                    while (matcher.find()) {

                        String newDteFormat = matcher.group(1) + "-" + matcher.group(2) + "-" + matcher.group(4);
                        System.out.println(" " + newDteFormat);

                    }
                    break;

                default:
                    System.out.println("No Date Format Specified!");

            }

        }

    }

    public void readFile() throws FileNotFoundException, IOException {
        //FileReader frd = new FileReader("Conferences.txt");
        //BufferedReader bfread = new BufferedReader(frd);
        File conferences=new File("Conferences.txt");
          File conferences2=new File("Conferences2.txt");
           PrintWriter pwr=new PrintWriter("Conferences2.txt");
        Scanner input=new Scanner(conferences);
     
        int i = 0;
        String newFile = "";
        while (input.hasNextLine()) {
           String line=input.nextLine();
           pwr.write(line);
           checkReadFile(line);
            

            }
        
      pwr.close();
      input.close();
       
        

        
       
    }
   
    


    private void checkReadFile(String readLine) {
 for (int j = 0; j < regex.length; j++) {
  

            switch (j) {
                case 0:
                    
                    matcher = pattern[0].matcher(readLine);
                   // System.out.println(pattern[0]);
                    while (matcher.find()){
                           System.out.println(matcher.group());
                        System.out.print("  " + matcher.group(1) + " " + matcher.group(2).substring(0,3).toUpperCase() + " " + matcher.group(3));

                  }
                      break;
           
                case 1:
                    matcher = pattern[1].matcher(readLine);

                   while (matcher.find()) {
                        System.out.print(" " + matcher.group(1) + matcher.group(2) + matcher.group(3) + matcher.group(4) + matcher.group(5));

                   }

                    break;
                case 2:
                    matcher = pattern[2].matcher(readLine);

                   while (matcher.find()) {
                        String newDteFormat = "from" + " " + matcher.group(2) + matcher.group(3) + matcher.group(1) + " " + matcher.group(6) + "\n"
                                + "TO" + " " + matcher.group(4) + matcher.group(3) + matcher.group(1) + " " + matcher.group(6);
                        System.out.print("  " + newDteFormat);

                    }

                    break;
                case 3:
                    matcher = pattern[3].matcher(readLine);

                    while (matcher.find()) {
                        String newDteFormat = "from" + " " + matcher.group(1) + " " + matcher.group(4) + " " + matcher.group(5) + "\n"
                                + "To" + " " + matcher.group(3) + " " + matcher.group(4) + " " + matcher.group(5);
                        System.out.print("  " + newDteFormat);

                   }

                    break;
                case 4:
                    matcher = pattern[4].matcher(readLine);

                    while (matcher.find()) {
                      String   newDteFormat = matcher.group(2) + "-" + matcher.group(1) + "-" + matcher.group(4);
                        System.out.println(" " + newDteFormat);

                    }
                    break;
                case 5:
                    matcher = pattern[5].matcher(readLine);

                    while (matcher.find()) {

                      String    newDteFormat = matcher.group(2) + "-" + matcher.group(1) + "-" + matcher.group(5);
                        System.out.println(" " + newDteFormat);

                    }
                    break;
                case 6:
                    matcher = pattern[6].matcher(readLine);

                    while (matcher.find()) {
                     String  newDteFormat = matcher.group(3) + "-" + matcher.group(5) + "-" + matcher.group(7);

                        System.out.println(" " + newDteFormat);
                    }
                    break;
                case 7:
                    matcher = pattern[7].matcher(readLine);

                   while (matcher.find()) {
                  String     newDteFormat = matcher.group(3) + "-" + matcher.group(4) + "-" + matcher.group(5);

                        System.out.println(" " + newDteFormat);

                    }
                    break;
                case 8:
                    matcher = pattern[8].matcher(readLine);

                   while (matcher.find()) {
                    String  newDteFormat = "From" + matcher.group(1) + matcher.group(2) + "To" + matcher.group(3) + matcher.group(2);

                        System.out.println(" " + newDteFormat);

                    }
                    break;
                case 9:
                    matcher = pattern[9].matcher(readLine);

                    while (matcher.find()) {

                      String newDteFormat = matcher.group(3) + "-" + matcher.group(4) + "-" + matcher.group(5);
                        System.out.println(" " + newDteFormat);

                   }
                    break;
                case 10:
                    matcher = pattern[10].matcher(readLine);

                    while (matcher.find()) {

                     String   newDteFormat = matcher.group(1) + "-" + matcher.group(2) + "-" + matcher.group(4);
                        System.out.println(" " + newDteFormat);

                    }
                    break;

                default:
                    System.out.println("No Date Format Specified!");

            }
}
        
    }
}
