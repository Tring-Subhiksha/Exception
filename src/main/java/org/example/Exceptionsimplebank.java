package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Exceptionsimplebank
{
    String username;
    long balance;
    long accnumber;
    static Logger l=Logger.getLogger(".com.api.jar");
    Exceptionsimplebank(String name, long number, long bal){
        username=name;
        accnumber=number;
        balance=bal;
    }
    void deposit()
    {
        Scanner c=new Scanner(System.in);
        l.info("Enter the amount to deposit your account:");
        long amt=c.nextLong();
        balance=balance+amt;

        l.log(Level.INFO, () ->"The deposit of the amount is:"+balance);
        l.info("\n");

    }
    void withdraw(long amt2)
    {
        if(balance>=amt2)
        {
            balance=balance-amt2;
            l.log(Level.INFO, () ->"The Withdraw of the amount is:"+balance);
        }
        else{
            l.info("The Amount is less than your Balance \tTransaction failed");
        }

    }
    void currbalance(){
        l.log(Level.INFO, () ->"The current balance of your account:" +balance);
    }
    void display(){
        l.log(Level.INFO, () ->"The Accounts holder name is "+username);
        l.log(Level.INFO, () ->"\nThe Accounts number of the User account is "+accnumber);
        l.log(Level.INFO, () ->"\nThe Balance of your account is "+balance);
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);

        l.info("Enter a Account Holder Name:");
        String h=s.nextLine();
        long a = 0;
        try {
            l.info("Enter the Account Number:");
             a = s.nextLong();
        }
        catch(Exception e){
            l.info("Enter integer only...");
            System.exit(0);
        }
        l.info("Enter the Balance amount:");
        long b=s.nextLong();
        Exceptionsimplebank ac=new Exceptionsimplebank(h,a,b);

        while(true){
            l.info("\n Bank Transaction details\n1.Show your account details\n2.Deposit your amount\n3.Withdraw your amount\n4.Check current balance of your account\n5.Exit\n");
            l.info("\nEnter your choice:");
            int ch=s.nextInt();

            switch (ch) {
                case 1 -> ac.display();
                case 2 -> ac.deposit();
                case 3 -> {
                    l.info("Enter the amount to Withdraw your account:");
                    Scanner c = new Scanner(System.in);
                    long amt = c.nextLong();
                    ac.withdraw(amt);
                }
                case 4 -> ac.currbalance();
                case 5 -> {
                    l.info("\nExiting...");
                    System.exit(0);
                }
                default -> l.info("Please enter correct choice");
            }
        }
    }
}