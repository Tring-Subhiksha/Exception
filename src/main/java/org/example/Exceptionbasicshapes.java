package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Exceptionbasicshapes {
    double triangle;
    double rectangle;
    double circle;
    double lengthtri1;
    double lengthtri2;
    double lengthtri3;
    double lengthrect;
    double widthrect;
    double radiuscircle;
    double breadthtri;
    double heighttri;
    Scanner sc2=new Scanner(System.in);
    static Logger l=Logger.getLogger(".com.api.jar");


    Exceptionbasicshapes(int ch)
    {
        if(ch==1)
        {
            l.info("Enter your choice to perform area operation for the shapes?\n1.Area for Rectangle\n2.Area for Triangle\n3.Area for Circle\n");
            int a;
            try {
                a = sc2.nextInt();
                l.info("Continue execution");
                this.areashapes(a);
            }
            catch(InputMismatchException e)
            {
                l.info("Exception raised" +e);
                System.exit(0);
            }

        }
        else if(ch==2){
            l.info("Enter your choice to perform Perimeter operation for the shapes?\n1.Perimeter for Rectangle\n2.Perimeter for Triangle\n3.Perimeter for Circle\n");
            int b=sc2.nextInt();
            this.perimetershapes(b);
        }
        else{
            l.info("Please Enter correct choice");
        }
    }
    void areashapes(int shape)
    {
        if(shape==1)
        {
            l.info("Enter the length and width of a Rectangle");
            lengthrect=sc2.nextDouble();
            widthrect=sc2.nextDouble();
            rectangle=lengthrect*widthrect;
            l.log(Level.INFO, () ->"The Area of Rectangle is:"+rectangle);
        }
        if(shape==2){
            l.info("Enter the breadth and height of a Triangle");
            breadthtri=sc2.nextDouble();
            heighttri=sc2.nextDouble();
            triangle=(breadthtri*heighttri)/2;
            l.log(Level.INFO, () ->"The Area of Triangle is:"+triangle);
        }
        if(shape==3){
            l.info("Enter the radius for a circle");
            radiuscircle=sc2.nextDouble();
            circle=Math.PI*radiuscircle*radiuscircle;
            l.log(Level.INFO, () ->"The Area of Circle is:"+circle);
        }
    }
    void perimetershapes(int shape) {
        if (shape == 1) {
            l.info("Enter the length and width of a Rectangle");
            lengthrect = sc2.nextDouble();
            double breadthrect = sc2.nextDouble();
            rectangle = 2 * (lengthrect + breadthrect);
            l.log(Level.INFO, () -> "The Perimeter of Rectangle is:" + rectangle);
        }
        if (shape == 2) {
            l.info("Enter the breadth and height of a Triangle");
            lengthtri1 = sc2.nextDouble();
            lengthtri2 = sc2.nextDouble();
            lengthtri3 = sc2.nextDouble();
            triangle = lengthtri1 * lengthtri2 * lengthtri3;
            l.log(Level.INFO, () -> "The Perimeter of Triangle is:" + triangle);
        }
        if (shape == 3) {
            l.info("Enter the radius for a circle");
            radiuscircle = sc2.nextDouble();
            circle = 2 * Math.PI * radiuscircle;
            l.log(Level.INFO, () -> "The Perimeter of Circle is:" + circle);
        }
    }
    void display(){
        l.info("shapes are created");
    }
        public static void main(String[]args){
            Scanner sc=new Scanner(System.in);
            l.info("Which choice you want to choose? \n1.Area for shapes\n2.Perimeter for shapes\n");
            int ch=sc.nextInt();
            Exceptionbasicshapes s=new Exceptionbasicshapes(ch);
            s.display();
        }
    }