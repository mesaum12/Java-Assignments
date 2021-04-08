package java_assignments;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.lang.Math;
public class QuoteOfTheDay{
    private static String[] quotes= {
            "The greatest glory in living lies not in never falling, " +
                    "but in rising every time we fall. -Nelson Mandela",
            "The way to get started is to quit talking and begin doing. -Walt Disney",
            "If you set your goals ridiculously high and it's a failure, you will fail above " +
                    "everyone else's success. -James Cameron",
            "Life is what happens when you're busy making other plans. -John Lennon",
            "If you look at what you have in life, you'll always have more. If you look at what you don't have in life," +
                    " you'll never have enough. -Oprah Winfrey",
            "When you reach the end of your rope, tie a knot in it and hang on. -Franklin D. Roosevelt",
            "Never let the fear of striking out keep you from playing the game. -Babe Ruth",
            "I failed my way to success. -Thomas Edison",
            " It does not matter how slowly you go as long as you do not stop. -Confucius"
    };
      private static String[] special_days={
            //0 for 15th August
            //1 for Republic Day
            //2 for teacher's day
            //3 for Children's day
            "Freedom is never dear at any price. It is the breath of life. What would a man not pay " +
                    "for living? – Mahatma Gandhi","Freedom is never dear at any price. It is the breath of life. " +
            "What would a man not pay for living? – Mahatma Gandhi"
            ,"The best teachers teach from the heart, not from the book.","Children are the gifts of God; " +
            "let them fly with their thoughts."
    };
    public static void main(String[] args)
    {
        System.out.println("1.Enter manual date");
        System.out.println("2.Take user's date ");
        System.out.println("Enter your choice");
        Scanner sc=new Scanner(System.in);
        int choice;
        choice=sc.nextInt();
        String date;
        if(choice==1)
        {
            System.out.println("Enter the date to print the quote in format dd/mm/yyyy");
            date=sc.nextLine();
        }
        else if(choice==2)
        {
          SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
          Date date2=new Date();
          date=formatter.format(date2);
          System.out.println("The current date and time is:"+date);
        }
        else
        {
            //date="01/01/2021"
            System.out.println("Please enter a valid choice");
            return;
        }
        if(date.contains("15/08"))
            System.out.println(special_days[0]);
        else if(date.contains("26/01"))
            System.out.println(special_days[1]);
        else if(date.contains("05/09"))
            System.out.println(special_days[2]);
        else if(date.contains("14/11"))
            System.out.println(special_days[3]);
        else
        {
            int temp=(int)(Math.random()*(quotes.length));
            System.out.println(quotes[temp]);
        }
    }
}
