package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Exceptioncard implements cloneable{
    String holdersname;
    String cardnumber;
    String expirationdate;

    String name="swathi";
    String number="1248 9087 3456 9087";
    String date="12/24";
    static Logger l=Logger.getLogger("com.api.jar");
    Exceptioncard(){
        l.info("The user can give the \n1,Card Holders name\n2,Card Number\n3, Expiration Date to create a creditcard");
        l.info("\n Enter the Holders name,Card Number and Expiration Date :");
        Scanner sc=new Scanner(System.in);
        holdersname=sc.nextLine();
        cardnumber=sc.nextLine();
        expirationdate=sc.nextLine();
        l.info("The Card holders name,Card number and Expiration Date will be created...");

    }
    String cardno(){
        if(cardnumber.equals(number)){
            return "true";
        }
        else{
            return "false";
        }
    }
    Exceptioncard cloneTest()
    {
        try {
            return (Exceptioncard) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            l.info("Cloning not allowed");
            return this;
        }
    }
    public static void main(String[] args){
        Exceptioncard c1=new Exceptioncard();
        l.log(Level.INFO, () ->"1,Same Card number--> returns True\n2,Different Card number--> returns False\n Answeris  "+c1.cardno());
        Exceptioncard c2=c1.cloneTest();
        l.log(Level.INFO, () ->"\nThe cloning method it returns Original Holders name "+c2. holdersname);
        l.log(Level.INFO, () ->"\nThe cloning method it returns Original Card Number "+c2. cardnumber);
        l.log(Level.INFO, () ->"\nThe cloning method it returns Original Expiration Date "+c2.expirationdate);

    }
}
