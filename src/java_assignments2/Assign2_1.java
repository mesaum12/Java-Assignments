package java_assignments2;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.Math;
import java.lang.String;
//creating the bank account class with the various attributes required
class BankAcct
{
    private long account_number;
    private String date_of_deposit;//taking the date of deposit to get the year difference
    private float balance;
    private float years_from_deposit;
    private static float Interest_rate;
    private float  interest_amount;
    BankAcct(float interest_rate)
    {
        Interest_rate=interest_rate;
    }
    public void set_details()
    {
        System.out.println("Enter the account number of the account holder:");
        Scanner sc=new Scanner(System.in);
        account_number=sc.nextLong();
        System.out.println("Enter the balance to be deposited:");
        balance=sc.nextFloat();
        System.out.println("Enter the date of deposit in the format dd/mm/yyyy:");
        sc.nextLine();
        date_of_deposit=sc.nextLine();
        setInterestAmount();
        //10
        // sc.close();
    }
    public static void setInterestRate()
    {
        System.out.println("Enter the new interest rate:");
        Scanner sc=new Scanner(System.in);
        Interest_rate=sc.nextFloat();
        //sc.close();
    }
    public static float getInterestRate()
    {
        return Interest_rate;
    }
    public float getBalance()
    {
        return balance;
    }
    public void setInterestAmount()
    {
        long difference;
        Date d=new Date();//take the current system date
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
        String current_Date=formatter.format(d);//now the current date is in the format dd/MM/yyyy
        try
        {
            Date d1= formatter.parse(current_Date);
            Date d2=formatter.parse(date_of_deposit);
            difference=d1.getTime()-d2.getTime();
            System.out.println("The time difference between the dates is :"+difference/1000+"s");
            years_from_deposit=(float)difference/(1000l*3600*24*365);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //System.out.println("The years is :"+years_from_deposit);
        System.out.println("Duration (in years) till now -->"+years_from_deposit);
        double compound_interest;
        compound_interest=balance*Math.pow((100+Interest_rate)/100, years_from_deposit);
        interest_amount=(float)compound_interest;

    }
    public float getInterest_amount()
    {
        return interest_amount;
    }
    public long getAccount_number()
    {
        return account_number;
    }
    @Override
    public java.lang.String toString() {
          return "AccountNumber:"+account_number+"\nDateOfDeposit:"+date_of_deposit+"\nBalance:"+balance+
                  "\nInterestAmount:"+interest_amount;
    }
}
public class Assign2_1 {
    public static void main(String[] args) {
        //initialising the bank account list
        LinkedList<BankAcct> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int choice;
        float rate;
        long account_number;
        boolean flag;

        System.out.println("Enter the default interest rate:");
        rate = sc.nextFloat();

        while (true) {
            System.out.println();
            System.out.println("1.Add a bank account");
            System.out.println("2.Display details of a bank account");
            System.out.println("3.Change the interest rate of the bank account");
            System.out.println("4.Display interest rate of the bank account");
            System.out.println("5.Remove a bank account");
            System.out.println("6.Get Balance for a particular bank account");
            System.out.println("7.Display the list of the bank account");
            System.out.println("8.Exit ");
            System.out.println("Enter your choice");

            choice = sc.nextInt();
            if (choice == 8)
                break;
            else {
                switch (choice) {
                    case 1:
                        BankAcct bank_acc = new BankAcct(rate);
                        bank_acc.set_details();
                        list.add(bank_acc);
                        break;
                    case 2:
                        System.out.println("Enter the account number");
                        account_number = sc.nextLong();
                        flag = false;
                        for (BankAcct b : list) {
                            if (b.getAccount_number() == account_number) {
                                System.out.println("Account Number: "+b.getAccount_number());
                                System.out.println("Balance: "+b.getBalance());
                                System.out.println("InterestAmount: "+b.getInterest_amount());
                                flag = true;
                                break;
                            }
                        }
                        if (!flag)
                            System.out.println("Account number doesn't exist");
                        break;
                    case 3:
                        BankAcct.setInterestRate();
                        for (BankAcct b : list) {
                            b.setInterestAmount();
                        }
                        break;

                    case 4:
                        System.out.println(BankAcct.getInterestRate());
                        break;

                    case 5:
                        System.out.println("Enter the account number to be removed");
                        account_number = sc.nextLong();
                        flag = false;
                        for (BankAcct b : list) {
                            if (b.getAccount_number() == account_number) {
                                list.remove(b);
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            System.out.println("The account number doesn't exist");
                        }
                        break;
                    case 6:
                        System.out.println("Enter the account number:");
                        account_number = sc.nextLong();
                        flag = false;
                        for (BankAcct b : list) {
                            if (b.getAccount_number() == account_number) {
                                System.out.println(b.getBalance());
                                flag = true;
                                break;
                            }

                        }
                        if (!flag) {
                            System.out.println("The account number doesn't exist");

                        }
                        break;
                        case 7:
                            for(BankAcct b:list)
                            {
                                System.out.println();
                                System.out.println(b);
                            }
                         break;
                    default:
                        System.out.println("Please enter a valid choice");

                }
            }
        }
    }
}









