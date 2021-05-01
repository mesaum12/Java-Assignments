/*
Design a Metric class that supports Kilometre to Mile conversion with
distance in Kilometre as argument and Mile to Kilometre conversion with
distance in mile as argument. Assume, one Mile equals 1.5 Kilometre.
*/




package java_assignments2;
import java.util.Scanner;

class Metric
{
    private final static float kilo_to_mile_factor=1.5f;
    public float kilometreToMile(float kilometre)
    {
        return kilometre/kilo_to_mile_factor;
    }
    public float mileToKilometre(float mile)
    {
        return mile*kilo_to_mile_factor;
    }

}

public class Assign2_2 {
    public static void main(String[] args) {
        Metric m=new Metric();
        float kilometre,mile;
        int choice;
        while(true)
        {
            System.out.println("1.Kilometre to Mile ");
            System.out.println("2.Mile to Kilometre ");
            System.out.println("3.Exit");
            System.out.println("Enter your choice");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            if(choice==3)
                break;
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the distance in kilometre");
                    kilometre=sc.nextFloat();
                    System.out.println("Miles: "+m.kilometreToMile(kilometre));
                    break;
                case 2:
                     System.out.println("Enter the distance in mile");
                     mile=sc.nextFloat();
                     System.out.println("Kilometres: "+m.mileToKilometre(mile));
                     break;

                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }

}
