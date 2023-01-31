package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class ExceptionSimplepoint implements cloneable{
    String xcoordinates;
    String ycoordinates;
    String x="10.9";
    String y="2.0";
    static Logger l=Logger.getLogger("com.api.jar");
    ExceptionSimplepoint(){
        l.info("The user can fix the X and Y coordinates to create a point");
        l.info("\n Enter the X and Y Coordinates:");
        Scanner sc=new Scanner(System.in);
        xcoordinates=sc.nextLine();
        ycoordinates=sc.nextLine();
        l.info("The X and Y Coordinates of the point will be created...");

    }
    String point(){
        if(x.equals(xcoordinates)&&y.equals(ycoordinates)){
            return "true";
        }
        else{
            return "false";
        }
    }
    ExceptionSimplepoint cloneTest()
    {
        try {
            return (ExceptionSimplepoint) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
        l.info("Cloning not allowed");
            return this;
        }
    }

    public static void main(String[] args){
        ExceptionSimplepoint d=new ExceptionSimplepoint();
        l.log(Level.INFO, () ->"1,Same Coordinates--> returns True\n2,Different Coordinates--> returns False\n Answer is "+d.point());
        ExceptionSimplepoint d2=d.cloneTest();
        d2.point();
        l.log(Level.INFO, () ->"\nThe cloning method it returns X coordinates "+d2.xcoordinates);
        l.log(Level.INFO, () ->"\nThe cloning method it returns y coordinates "+d2.ycoordinates);
    }
}
