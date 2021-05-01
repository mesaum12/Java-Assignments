/*
Consider a wrapper class for a numeric basic type. Check the support for
the following: conversion from i) basic type to object ii) object to basic type
iii) basic type to String iv) String (holding numeric data) to numeric object
v) object to String.
 */



package java_assignments2;
import java.util.Scanner;
import java.lang.Integer;
class Conversions
{
    public Conversions()
    {
        System.out.println();
        System.out.println("---------------User have the following choices-------------------");
        System.out.println();
    }
    public Integer basicToWrapper(int data)
    {
        Integer x;
        x=Integer.valueOf(data);
        return x;
    }
    public int wrapperToBasic(Integer i)
    {
        int data=i.intValue();
        return data;
    }
    public String basicToString(int data)
    {
        return Integer.valueOf(data).toString();
    }
    public Integer stringToWrapper(String str)
    {
        return Integer.valueOf(str);
    }
    public String wrapperToString(Integer i)
    {
        return i.toString();
    }
}
//let us consider the wrapper class for integer
public class Assign2_4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int data;
        String str;
        Integer x;

        Conversions c=new Conversions();

        while(true)
        {
            System.out.println("1.Basic type to object");
            System.out.println("2.Object to basic type");
            System.out.println("3.Basic type to String");
            System.out.println("4.String (holding numeric value) to numeric object");
            System.out.println("5.Object to String");
            System.out.println("6.Exit");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            if(choice==6)
                break;
            switch(choice)
            {
                case 1:
                      System.out.println("Enter the value of the basic data type");
                      data=sc.nextInt();
                      System.out.println("The value of the  integer is "+c.basicToWrapper(data));
                      break;
                case 2:
                     System.out.println("Enter the value to be converted into wrapper class");
                     data=sc.nextInt();
                     System.out.println("The value of the object (Integer wrapper object)"
                             +c.wrapperToBasic(Integer.valueOf(data)));
                     break;
                case 3:
                      //basic type to string
                      System.out.println("Enter the data ");
                      data=sc.nextInt();
                      System.out.println("The basic data type is converted to string with value"+c.basicToString(data));
                      break;
                case 4:
                      System.out.println("Enter the string to be converted to wrapper object");
                      sc.nextLine();
                      str=sc.nextLine();
                      System.out.println("The value of the wrapper class object is "+c.stringToWrapper(str));
                      break;

                case 5:
                      System.out.println("Enter the data ");
                      data=sc.nextInt();
                      System.out.println("The value of the data converted to " +
                              "wrapper class object is "+c.wrapperToString(Integer.valueOf(data)));
                      break;
                default:
                    System.out.println("Please enter a valid choice");


            }
        }
    }
}
