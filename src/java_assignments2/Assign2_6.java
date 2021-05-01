/*
For every person in an institute details like name, address (consists of
premises number, street, city, pin and state), phone number, e-mail id are
maintained. A person is either a student or a faculty. For student roll

number and course of study are also be maintained. For faculty employee
id, department and specialisation are to be stored. One should be able to
view the object details and set the attributes. For address, one may change
it partially depending on the choice. Design and implement the classes.
 */

package java_assignments2;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;

class Address
{
    private int premises_number;
    private String street_name;
    private String city;
    private String state;
    private long PIN;
    Address()
    {
        premises_number=0;
        street_name=null;
        city=null;
        state=null;
        PIN=11111;
    }
    public void setAddress()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the premises number:");
        premises_number=sc.nextInt();
        System.out.print("Enter the street name: ");
        sc.nextLine();
        street_name=sc.nextLine();
        System.out.print("Enter the city:");
        //sc.nextLine();
        city=sc.nextLine();
        System.out.print("Enter the state:");
        //sc.nextLine();
        state=sc.nextLine();
        System.out.print("Enter the PIN Code:");
        PIN=sc.nextLong();
    }
    public void changeAddress()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the new street name:");
        //sc.nextLine();
        street_name=sc.nextLine();
        System.out.print("Enter the new premises number:");
        premises_number=sc.nextInt();
    }
    @Override
    public String toString() {
        return "******Address********\n" +
                "premises_number=" + premises_number +
                "\nstreet_name='" + street_name  +
                "\ncity=" + city +
                "\nstate=" + state +
                "\nPIN=" + PIN ;
    }
}
abstract class Person
{
    protected String name;
    protected Address address;
    protected String phone_number;
    protected String email_id;
    public void setDetails(String name,Address address,String phone_number,String email_id)
    {
        this.name=name;
        this.address=address;
        this.phone_number=phone_number;
        this.email_id=email_id;
    }
    public void showDetails()
    {
        System.out.println("Name:"+name+"\n"+address+"\nPhoneNumber:"+phone_number+"\nemail-id:"+email_id);
    }
}
class Student extends Person
{
    private long roll_number;
    private String course;

    @Override
    public void setDetails(String name, Address address, String phone_number, String email_id) {
        super.setDetails(name, address, phone_number, email_id);
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the roll number of the student:");
        roll_number=sc.nextLong();
        System.out.print("Enter the course name of the student:");
        sc.nextLine();
        course=sc.nextLine();
    }

    @Override
    public void showDetails() {
        System.out.println("RollNumber:"+roll_number+"\nCourse:"+course);
        super.showDetails();

    }
    public long getRollNumber()
    {
        return roll_number;
    }
    public  Address getAddress()
    {
        return address;
    }
}
class Faculty extends Person
{
  private String employee_id;
  private String department;
  private String Specialisation;

    @Override
    public void setDetails(String name, Address address, String phone_number, String email_id) {
        super.setDetails(name, address, phone_number, email_id);
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the employee-id:");
        //sc.nextLine();
        employee_id=sc.nextLine();
        System.out.print("Enter the department for the faculty:");
        //sc.nextLine();
        department=sc.nextLine();
        System.out.print("Enter the Specialisation:");
        //sc.nextLine();
        Specialisation=sc.nextLine();
    }

    @Override
    public void showDetails() {
        System.out.println("EmployeeId:"+employee_id);
        super.showDetails();
        System.out.println("Department:"+department+"\nSpecialisation:"+Specialisation);
    }
    public String getEmployee_id()
    {
        return employee_id;
    }
    public Address getAddress()
    {
        return address;
    }
}
class Operations {
    ArrayList<Faculty> faculty_list = new ArrayList<>();
    ArrayList<Student> student_list = new ArrayList<>();

    Operations() {
        System.out.println(" ");
    }

    void addFacultyOrStudent(int choice) {
        Scanner sc = new Scanner(System.in);
        Address ad = new Address();
        String name, phone_num, email;
        if (choice == 1) {
            Faculty f = new Faculty();
            System.out.println("-------Set faculty address-----");
            ad.setAddress();
            System.out.print("Enter the name:");
            //sc.nextLine();
            name = sc.nextLine();
            System.out.print("Enter the phone number:");
            //sc.nextLine();
            phone_num = sc.nextLine();
            System.out.print("Enter the email id:");
            //sc.nextLine();
            email = sc.nextLine();
            f.setDetails(name, ad, phone_num, email);
            faculty_list.add(f);
        }
         else if (choice == 2) {
            Student s = new Student();
            System.out.println("---------Set the address details--------");
            ad.setAddress();
            System.out.print("Enter the name:");
            //sc.nextLine();
            name = sc.nextLine();
            System.out.print("Enter the phone number:");
            //sc.nextLine();
            phone_num = sc.nextLine();
            System.out.print("Enter the email id:");
            //sc.nextLine();
            email = sc.nextLine();
            s.setDetails(name, ad, phone_num, email);
            student_list.add(s);
        }
         else
            System.out.println("Please enter a valid choice");

    }

    void displayFacultyOrStudent(int choice) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        if (choice == 1) {
            String emp_id;
            System.out.print("Enter the employee id :");
            //sc.nextLine();
            emp_id = sc.nextLine();
            for (Faculty f : faculty_list) {
                if (f.getEmployee_id().equals(emp_id)) {
                    flag = true;
                    f.showDetails();
                    break;
                }
            }

        } else if (choice == 2) {
            long roll_num;
            System.out.print("Enter the roll number of the student:");
            roll_num = sc.nextLong();
            for (Student s : student_list) {
                if (s.getRollNumber() == roll_num) {
                    flag = true;
                    s.showDetails();
                    break;
                }
            }

        } else
            System.out.println("Please enter a valid choice");
        if(!flag)
        {
            System.out.println("The given faculty or student doesn't exist");
        }

    }
    public void changeAddress(int temp)
    {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        if(temp==1)
        {
            String emp_id;
            System.out.print("Enter the employee id :");
            //sc.nextLine();
            emp_id = sc.nextLine();
            for (Faculty f : faculty_list) {
                if (f.getEmployee_id().equals(emp_id)) {
                    flag = true;
                    f.getAddress().changeAddress();
                    break;
                }
            }
        }
        else if(temp==2)
        {
            long roll_num;
            System.out.print("Enter the roll number of the student:");
            roll_num = sc.nextLong();
            for (Student s:student_list) {
                if (s.getRollNumber()==roll_num) {
                    flag = true;
                    s.getAddress().changeAddress();
                    break;
                }
            }
        }
        else
            System.out.println("Please enter a valid choice");
    }
    public void displayList(int choice)
    {
        if(choice==1)
        {
            for(Faculty f:faculty_list)
            {
                System.out.println();
                f.showDetails();
            }
        }
        else if(choice==2)
        {
            for(Student s:student_list)
            {
                System.out.println();
                s.showDetails();
            }
        }
        else
            System.out.println("Please enter a valid choice");
    }
}
public class Assign2_6 {
    public static void main(String[] args) {
        Operations op = new Operations();
        Scanner sc = new Scanner(System.in);
        int choice, temp;

        while (true) {
            System.out.println();
            System.out.println("1.Add faculty");
            System.out.println("2.Add Student ");
            System.out.println("3.Display faculty details");
            System.out.println("4.Display student details");
            System.out.println("5.Change the address (for faculty or student)");
            System.out.println("6.Display the faculty list ");
            System.out.println("7.Display the student list ");
            System.out.println("8.Exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            if (choice == 8)
                break;
            switch (choice) {
                case 1:
                    op.addFacultyOrStudent(1);
                    break;
                case 2:
                    op.addFacultyOrStudent(2);
                    break;
                case 3:
                    op.displayFacultyOrStudent(1);
                    break;
                case 4:
                    op.displayFacultyOrStudent(2);
                    break;
                case 5:
                    System.out.println("Enter 1 for faculty and 2 for student");
                    temp = sc.nextInt();
                    op.changeAddress(temp);
                    break;
                case 6:
                     op.displayList(1);
                     break;
                case 7:
                     op.displayList(2);
                     break;
                default:
                    System.out.println("Please enter a valid choice");
             }

        }
    }
}