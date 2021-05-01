/*
Take a String input that contains multiple words. Do the following: i)
number of times ‘a’ appears ii) number of times “and” appears iii) whether
it starts with “The” or not iv) put the String into an array of characters v)
display the tokens in the String (tokens are the substrings separated by
space or @ or .)
 */

package java_assignments2;
import java.util.Scanner;
import java.lang.String;
class MyString
{
    private String str;//str may contain multiple words
    public void setStr(String s)
    {
        str=s;
    }
    public int getCountOfa()
    {
        int count=0;
        for(int i=0;i< str.length();i++)
        {
            if(str.charAt(i)=='a')
                count++;
        }
        return count;
    }
    public int getCountOfthe()
    {
        int count=0;

            for(int i=0;i<=str.length()-3;i++)
            {
                String temp;
                temp=str.substring(i,i+3);
                if(temp.equals("the")) count++;
            }
             return count;
    }
    public boolean checkStartsWithTheOrNot()
    {
        return str.startsWith("The");
    }
    public char[] getCharArray()
    {
        char []CharArray=str.toCharArray();
        return CharArray;
    }
    public void displayTokens()
    {
        String string[]=str.split("[ @.]");
        for (String str2:string)
            System.out.println(str2);
    }

}
public class Assign2_3 {
    public static void main(String[] args) {
        MyString mystr = new MyString();
        int choice;
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string :");
        str = sc.nextLine();
        mystr.setStr(str);//setting the string


        while (true) {
            System.out.println("1.Number of times 'a' appears");
            System.out.println("2.Number of times 'the' is present in the string");
            System.out.println("3.Check whether startswith 'The' or not?");
            System.out.println("4.Put the string into an array of characters");
            System.out.println("5.Display token separated by '@' , '.' or ' '  ");
            System.out.println("6.Exit ");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            if (choice == 6)
                break;
            switch (choice) {
                case 1:
                    System.out.println("The number of times 'a' appears in the string is" + mystr.getCountOfa());
                    break;
                case 2:
                    System.out.println("The number of times \"the\" appears in the string is " + mystr.getCountOfthe());
                    break;
                case 3:
                    if (mystr.checkStartsWithTheOrNot())
                        System.out.println("Yes , the string  starts with \"The\"");
                    else
                        System.out.println("No, the string doesn't starts with \"The\"");
                    break;
                case 4:
                    char[] array = mystr.getCharArray();
                    System.out.println("The character array is :");
                    for (int i = 0; i < array.length; i++)
                        System.out.println("Char[" + (i+1) + "]:" + array[i]);
                    break;
                case 5:
                    mystr.displayTokens();
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }

        }

    }
}


