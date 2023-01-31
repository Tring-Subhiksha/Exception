package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
class MyException extends Exception{
    public MyException(String str){
        super(str);
    }
}
class Student{
    String stuname;
    String grade;
    double gpa;
    double gradeValue;
    double credit;
    double mark;
    Logger l = Logger.getLogger("com.api.jar");

    Student(){
        Scanner sc=new Scanner(System.in);

        l.info("\nEnter Your Name:");
        stuname=sc.nextLine();
        try {


            l.info("\nEnter the Grade level:");
            grade = sc.nextLine();
            if(grade.length()>2){
                throw new MyException("Greater than string length");
            }

        }catch (MyException ex){
            l.log(Level.INFO, () ->"\nException Occur:" +ex);
            System.exit(0);
        }



        l.info("\nEnter the Credit points:");
        credit=sc.nextDouble();
    }
    String showdetails()
    {
        l.log(Level.INFO, () ->"\nStudent Name:" +stuname);
        l.log(Level.INFO, () ->"\nGrade Level:" +grade);
        return stuname+" has a "+gpa+" GPA";
    }
    void checkgrade(){


        switch (grade) {
            case "A" -> gradeValue = 4.00;

            case "A-"-> gradeValue=3.35;
            case "B+" -> gradeValue = 3.00;
            case "C" -> gradeValue = 2.67;
            case "C+" -> gradeValue = 2.33;
            case "D" -> gradeValue = 2.00;
            default -> l.info("Invalid Grade");
        }
    }
    void updategpa(){
        mark=gradeValue*credit;
        gpa=mark/credit;
    }

    public static void main(String[] args){
        Logger l = Logger.getLogger("com.api.jar");
        Student s=new Student();

        s.checkgrade();
        s.updategpa();
        l.log(Level.INFO, () ->""+s.showdetails());

    }
}
