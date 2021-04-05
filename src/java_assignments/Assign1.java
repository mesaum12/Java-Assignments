package java_assignments;
import java.util.*;
import java.lang.String;

//creating the STUDENT class
class STUDENT
{
    protected int roll;
    protected String dept_name;
    protected int []marks;
    protected String name,course,adm_date;
    protected String ID;
    protected static int []number_of_students={0,0,0,0};
    public void setAdm_date()
    {
        System.out.println("Enter the date of admission in format dd/mm/yyyy");
        Scanner sc=new Scanner(System.in);
        //sc.nextLine();
        adm_date=sc.nextLine();

    }
    public void setName()
    {
        System.out.println("Enter the name of the student");
        Scanner sc=new Scanner(System.in);
        //sc.nextLine();
        name=sc.nextLine();

    }
    public void setMarks()
    {
        System.out.println("Enter the marks of the student in  five subjects");
        Scanner sc=new Scanner(System.in);
        marks=new int[5];
        for(int i=0;i<5;i++)
        {
            System.out.print("Marks["+(i+1)+"]:");
            marks[i]=sc.nextInt();
        }
    }
    public void setCourse()
    {
        System.out.println("Enter the name of the course");
        Scanner sc=new Scanner(System.in);
        //sc.nextLine();
        course=sc.nextLine();

    }
    public void getId()
    {
        Integer r=roll;
        if(roll<10)
            ID="00"+r.toString();
        else if(roll<100)
            ID="0"+r.toString();
        else
        ID=r.toString();
    }
    public int getTotalScore()
    {
        int total_score=0;
        for(int x:marks)total_score+=x;
        return total_score;
    }
    public String toString()
    {
        return ("Name:"+name+"\nID:"+ID+"\nCourse:"+course+"\nTotal Marks:"+this.getTotalScore()+"\n");
    }
    public String returnId()
    {
        return ID;
    }
    public String getName()
    {
        return name;
    }
    public String getDeptName()
    {
        return dept_name;
    }
}
//Inheriting the STUDENT class and using it to set the department of the STUDENT
class DepartmentNameOfStudent extends STUDENT
{
    HashMap<Integer,String>h_map;
    DepartmentNameOfStudent()
    {
        h_map=new HashMap<Integer,String>();
        //considering a maximum of four departments for our system
        h_map.put(1,"BCSE");
        h_map.put(2,"BETC");
        h_map.put(3,"BMECH");
        h_map.put(4,"BELEC");
    }
    @Override public void getId()
    {
        System.out.println("Enter the name of the dept");
        Scanner sc=new Scanner(System.in);
        dept_name=sc.nextLine();

        if(dept_name.equals(h_map.get(1)))
            roll=++number_of_students[0];
        else if(dept_name.equals(h_map.get(2)))
            roll=++number_of_students[1];
        else if(dept_name.equals(h_map.get(3)))
            roll=++number_of_students[2];
        else
            roll=++number_of_students[3];
        super.getId();
        String str_adm_yr=adm_date.substring(adm_date.length()-2);
        ID=dept_name+str_adm_yr+ID;//creating a student id based on dept,roll number and year of admission
    }
}
class CompareByScore implements Comparator<STUDENT>
{
    public int compare(STUDENT s1,STUDENT s2)
    {
        return s1.getTotalScore()-s2.getTotalScore();
    }
}
class StudentOperations
{
    //STUDENT s[];//reference to an array of student objects
    ArrayList<STUDENT> Student_list;
    private static int current_stud_count=0;
    StudentOperations()
    {
        Student_list=new ArrayList<>();//since the number of dept is 4 and
        // number of students in each dept is 100 maximum
    }
    public void getAdmission()
    {
        DepartmentNameOfStudent s=new DepartmentNameOfStudent();

         //calling the methods of the class DepartmentNameOfStudent
        s.setAdm_date();
        s.setName();
        s.setCourse();
        s.setMarks();
        s.getId();
        Student_list.add(s);
        current_stud_count++;
        System.out.println("Current_stud_count:"+current_stud_count);
    }
    public void removeStudent()
    {
        System.out.println("Enter the name of the student to be removed");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        for(int i=0;i<Student_list.size();i++)
        {
            if(name.equals(Student_list.get(i).getName()))
            {
                Student_list.remove(i);
                System.out.println("The student named:"+name+" is removed from the list");
                System.gc();//checking for free memory
                System.out.println("Free Memory in bytes:"+Runtime.getRuntime().freeMemory());
                break;
            }
        }
    }
    public void displaySorted()
    {
        //sorting the student list according to score
        Collections.sort(Student_list,new CompareByScore());
        for(int i=0;i<Student_list.size();i++)
            System.out.println(Student_list.get(i));
    }
    public void displayParticularDeptStudents()
    {
        ArrayList<STUDENT> St=new ArrayList<STUDENT>();
        System.out.println("Enter the dept name");
        Scanner sc=new Scanner(System.in);

        String dept=sc.nextLine();
        for(int i=0;i<Student_list.size();i++)
        {

            if(Student_list.get(i).getDeptName().equals(dept))
            {
                St.add(Student_list.get(i));
            }
        }
        Collections.sort(St,new CompareByScore());
        for(int i=0;i<St.size();i++)
            System.out.println(St.get(i));
    }

}

public class Assign1 {
    public static void main(String []args)
    {
        StudentOperations s=new StudentOperations();
        int choice;
        while(true)
        {
            System.out.println("1.Take admission ");
            System.out.println("2.Display sorted list of all the students of all the departments in sorted order");
            System.out.println("3.Display the students of a particular department");
            System.out.println("4.Remove a particular student and check for free memory");
            System.out.println("5.Exit from the program");
            System.out.println("Enter your choice");

            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();

            if(choice==5) break;

            switch(choice)
            {
                case 1:
                    s.getAdmission();
                    break;
                case 2:
                    s.displaySorted();
                    break;
                case 3:
                    s.displayParticularDeptStudents();
                    break;
                case 4:
                    s.removeStudent();
                    break;
                default:
                    System.out.println("Please enter a valid choice");

            }
        }
    }
}
