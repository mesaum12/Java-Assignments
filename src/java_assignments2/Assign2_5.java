/*
Each customer of a bank has customer id, name, and current loan amount
and phone number. One can change the attributes like name, phone
number. A customer may ask for loan of certain amount. It is granted
provided the sum of current loan amount and asked amount does not
exceed credit limit (fixed amount for all customer). A customer may be a
privileged amount. For such customers credit limit is higher. Once a loan is
sanctioned necessary updates should be made. Any type of customer
should be able to find his credit limit, current loan amount and amount of
loan he can seek. Design and implement the classes.
 */

package java_assignments2;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import java.lang.Exception;

class Customer
{
    private long customer_id;
    private String name;
    private float current_loan_amount;
    private String phone_number;
    private float personal_credit_Limit;//depends on whether the customer is privileged or not
    private static float common_credit_limit_of_customer;
    private int privileged_customer_or_not;
    public void setDetails()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the customer-id:");
        customer_id=sc.nextLong();
        System.out.print("Enter the name of the customer:");
        sc.nextLine();
        name=sc.nextLine();

        System.out.print("Enter 1.Privileged , 2.Non-privileged: ");
        privileged_customer_or_not=sc.nextInt();

        if(privileged_customer_or_not==1)
        {
            System.out.print("Enter the credit limit for customer(privileged):");
            personal_credit_Limit=sc.nextFloat();
        }
        else personal_credit_Limit=common_credit_limit_of_customer;
        try
        {
            System.out.println("Enter the current loan amount sanctioned to the customer:");
            current_loan_amount=sc.nextFloat();
            if(current_loan_amount>personal_credit_Limit)
            {
                current_loan_amount=0;
                throw new Exception("The loan amount can't be greater than credit limit");
            }
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        System.out.print("Enter the phone number of the customer:");
        sc.nextLine();
        phone_number=sc.nextLine();
    }
    public long getCustomer_id()
    {
        return customer_id;
    }
    public void setNewName(String name)
    {
        this.name=name;
    }
    public void setNewPhoneNumber(String phone_number)
    {
        this.phone_number=phone_number;
    }
    public void issueLoanToTheCustomer(float amount)
    {
        if(current_loan_amount+amount<=personal_credit_Limit)
        {
            current_loan_amount+=amount;
            System.out.println("Congrats,Your Loan is sanctioned successfully!");
            return;
        }
        System.out.println("Oops! Loan amount can't be sanctioned");
    }
    public static void setCommon_credit_limit_of_customer(float amount)
    {
        common_credit_limit_of_customer=amount;
    }
    public float amountOfLoanCanBeSeeked()
    {
        if(current_loan_amount<personal_credit_Limit)
            return personal_credit_Limit-current_loan_amount;
        else
            return 0;
    }
    public float getPersonal_credit_Limit()
    {
        return personal_credit_Limit;
    }

    @Override
    public String toString() {
        return "****---Details----****\nCustomerId:"+customer_id+"\nName:"+name+"\nCurrentLoanAmount:"+
                current_loan_amount+"\nPhoneNumber:"+phone_number+"\nPersonalCreditLimit:"+personal_credit_Limit+
                "\nPrivileged:(1)Yes (2)No:"+privileged_customer_or_not+"\n";
    }
}
class CustomerOperations
{
    private ArrayList<Customer> list;
    CustomerOperations()
    {
        System.out.println("*************** User have the following choices *****************");
        list=new ArrayList<>();
    }
    public void addCustomer()
    {
        Customer c=new Customer();
        c.setDetails();
        list.add(c);
    }
    public void setCreditLimits(float amt)
    {
        Customer.setCommon_credit_limit_of_customer(amt);
    }
    public  void displayList()
    {
        for(Customer c:list)
        {
            System.out.println();
            System.out.println(c);
        }
    }
    public void changeName(long id,String name)
    {
        boolean flag=false;
        for(Customer c: list)
        {
            if(c.getCustomer_id()==id)
            {
                c.setNewName(name);
                flag=true;
                break;
            }
        }
        if(!flag)
            System.out.println("The customer with entered id doesn't exist");
    }
    public void changePhoneNumber(long id,String phone_num)
    {
        boolean flag=false;
        for(Customer c: list)
        {
            if(c.getCustomer_id()==id)
            {
                c.setNewPhoneNumber(phone_num);
                flag=true;
                break;
            }
        }
        if(!flag)
            System.out.println("The customer with entered id doesn't exist");
    }
    public void sanctionLoan(long id,float amount)
    {
        boolean flag=false;
        for(Customer c: list)
        {
            if(c.getCustomer_id()==id)
            {
                flag=true;
                c.issueLoanToTheCustomer(amount);
                break;
            }
        }
        if(!flag)
            System.out.println("The customer with entered id doesn't exist");
    }
    public void checkLoan(long id)
    {
        boolean flag=false;
        for(Customer c: list)
        {
            if(c.getCustomer_id()==id)
            {
                flag=true;
                float temp=c.amountOfLoanCanBeSeeked();
                if(temp>0);
                {
                    System.out.println("Loan can be taken ");
                }
                if(temp<=0)
                    System.out.println("Loan can't be taken");

                break;
            }
        }
        if(!flag)
            System.out.println("The customer with entered id doesn't exist");
    }
    public void getCreditLimit(long id)
    {
        boolean flag=false;
        for(Customer c:list)
        {
            if(c.getCustomer_id()==id)
            {
                flag=true;
                System.out.println("Credit Limit:"+c.getPersonal_credit_Limit());
                break;
            }
        }
        if(!flag)
        {
            System.out.println("The customer with the entered id doesn't exist");
        }
    }
    public void getLoanAmount(long id)
    {
         boolean flag=false;
         for(Customer c:list)
         {
             if(c.getCustomer_id()==id)
             {
                 flag=true;
                 System.out.println("Loan Amount:"+c.amountOfLoanCanBeSeeked());
                 break;
             }
         }
         if(!flag)
         {
             System.out.println("The customer with the entered id doesn't exist");
         }
    }
    public void removeId(long id)
    {
        boolean flag=false;
        for(Customer c:list)
        {
            if(c.getCustomer_id()==id)
            {
                flag=true;
                list.remove(c);
                break;
            }
        }
        if(!flag)
        {
            System.out.println("The customer with the entered id doesn't exist");
        }
    }
}
public class Assign2_5 {

    public static void main(String[] args) {

        CustomerOperations C=new CustomerOperations();
        Scanner sc=new Scanner(System.in);
        String name,phone_number;
        float loan_amt,credit_lim;
        long id;
        System.out.print("Enter the commom credit limit for the bank:");
        credit_lim=sc.nextFloat();
        C.setCreditLimits(credit_lim);

        while(true)
        {
            System.out.println();
            System.out.println("1.Add customer ");
            System.out.println("2.Change the name of the customer");
            System.out.println("3.Change the phone number of the customer");
            System.out.println("4.Sanction loan to a particular customer");
            System.out.println("5.Check whether a customer can avail loan ");
            System.out.println("6.Get the credit limit for a customer");
            System.out.println("7.Get the loan amount which can be given to a customer ");
            System.out.println("8.Remove customer account ");
            System.out.println("9.Display the list of all the customers");
            System.out.println("10.Exit ");

            int choice ;
            System.out.println("Enter your choice");

            choice=sc.nextInt();
            if(choice==10)
                break;

            switch (choice)
            {
                case 1:
                      C.addCustomer();
                      break;
                case 2:
                     System.out.print("Enter the customer id whose name is to be changed:");
                     id=sc.nextLong();
                     System.out.print("Enter the new name of the customer:");
                     sc.nextLine();
                     name=sc.nextLine();
                     C.changeName(id,name);
                     break;
                case 3:
                    System.out.print("Enter the customer id whose phone_number is to be changed:");
                    id=sc.nextLong();
                    System.out.print("Enter the new phone_number of the customer:");
                    sc.nextLine();
                    phone_number=sc.nextLine();
                    C.changePhoneNumber(id,phone_number);
                    break;
                case 4:
                    System.out.print("Enter the id of the customer to sanction loan:");
                    id=sc.nextLong();
                    System.out.print("Enter the loan amount:");
                    loan_amt=sc.nextFloat();
                    C.sanctionLoan(id,loan_amt);
                    break;
                case 5:
                    System.out.print("Enter the id of the customer to check :");
                    id=sc.nextLong();
                    C.checkLoan(id);
                    break;
                case 6:
                    System.out.print("Enter the customer id to get the credit limit:");
                    id=sc.nextLong();
                    C.getCreditLimit(id);
                    break;
                case 7:
                    System.out.print("Enter the customer id to get the loan amount:");
                    id=sc.nextLong();
                    C.getLoanAmount(id);
                    break;
                case 8:
                    System.out.print("Enter the customer id to remove:");
                    id=sc.nextLong();
                    C.removeId(id);
                    break;
                case 9:
                    C.displayList();
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
         }

    }
}
