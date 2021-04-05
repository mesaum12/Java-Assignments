package java_assignments;
import java.util.*;
import java.lang.String;

class Patient
{
    private long SSN;
    private int patient_id;
    private String name,doctorAlloted;
    private float bloodPressure,temperature;//as a test result attributes
    public void setPatientDetails(int patient_id)
    {
        Scanner sc=new Scanner(System.in);
        this.patient_id = patient_id;
        System.out.print("Enter the name:");
        name=sc.nextLine();
        System.out.print("Enter the SSN:");
        SSN=sc.nextLong();
        System.out.print("Enter the doctor's name alloted to this patient:");
        sc.nextLine();//just to clear the buffer
        doctorAlloted=sc.nextLine();
        System.out.print("Enter the bloodPressure(in mm-Hg)");
        bloodPressure=sc.nextFloat();
        System.out.print("Enter the temperature(in Celsius)");
        temperature=sc.nextFloat();
    }
    public String getName()
    {
        return name;
    }
    public String getDoctorAlloted()
    {
        return doctorAlloted;
    }
    public void getTestDetails()
    {
        System.out.println("Name:"+name+"\nPatient Id:"+patient_id+"\nDoctorAlloted:"+
                doctorAlloted+"\nBlood Pressure:"+bloodPressure+"\nTemperature:"+temperature);
    }
    public long getSSN()
    {
        return SSN;
    }

}
class Doctor
{
     private String name;
     private ArrayList<Patient> patientList;//keeps the list of patients by their SSN
    // private int current_patient_count;
     Doctor()
     {
         patientList=new ArrayList<Patient>();//assuming maximum 10 patients per doctor
     }
     public String getName()
     {
         return name;
     }
     public void setName()//for setting the name of the doctor
     {
         System.out.println("Enter the name of the doctor");
         Scanner sc=new Scanner(System.in);
          name=sc.nextLine();
     }
     public void setPatientList(Patient pt)
     {
         //patientList[current_patient_count]=new Patient(pt);
         patientList.add(pt);//setting the patient details for the doctor

     }
     public void getPatientList()
     {
         for(int i=0;i<patientList.size();i++)
         {
            // System.out.println("Patient SSN:"+patientList[i]+"\n");
             patientList.get(i).getTestDetails();
         }
     }
}
public class Hospital {
    public static void main(String[] args) {

        Patient []patients;//for creating a list of the patients in the hospital
        Doctor []doctors;//for creating a list of the doctors in the hospital
        Scanner sc=new Scanner(System.in);
        boolean flag=false;
        long SSN_number;
        String doctors_name;


        System.out.println("Enter the maximum number of doctors");
        int maximum_number_of_doctors=sc.nextInt();
        doctors=new Doctor[maximum_number_of_doctors];
        System.out.println("Enter the doctor details");
        for(int i=0;i<maximum_number_of_doctors;i++)
        {
            doctors[i]=new Doctor();
            doctors[i].setName();
        }

        System.out.println("Enter the maximum number of  patients ");
        int maximum_number_of_patient=sc.nextInt();
        patients=new Patient[maximum_number_of_patient];
        System.out.println("Enter the patient details");
        //setting the patient details and updating it in the doctors list also
        for(int i=0;i<maximum_number_of_patient;i++)
        {
            patients[i]=new Patient();
            patients[i].setPatientDetails(i+1);
            for(int j=0;j<maximum_number_of_doctors;j++)
            {
                if(patients[i].getDoctorAlloted().equals(doctors[j].getName()))
                {
                    //System.out.println("I am here");
                    doctors[j].setPatientList(patients[i]);

                }
            }
        }

        while(true)
        {
            System.out.println("1.Get patient details using SSN:");
            System.out.println("2.Get patients list using doctor's name:");
            System.out.println("3.Exit");
            System.out.println("Enter your choice");
            int choice;
            choice=sc.nextInt();
            if(choice==3)
            {
                System.out.println("You chose to exit the program");
                break;
            }
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the SSN of the patient to get the details");
                    SSN_number=sc.nextLong();
                    for(int i=0;i<maximum_number_of_patient;i++)
                    {
                        if(patients[i].getSSN()==SSN_number)
                        {
                            patients[i].getTestDetails();flag=true;
                            break;
                        }
                    }
                    if(flag==false)
                        System.out.println("Sorry ,the patient is not admitted here as no match for SSN found");
                    break;
                case 2:
                    System.out.println("Enter the name of the doctor");
                    sc.nextLine();
                    doctors_name=sc.nextLine();
                    flag=false;
                    for(int i=0;i<maximum_number_of_doctors;i++)
                    {
                        if(doctors_name.equals(doctors[i].getName()))
                        {
                            doctors[i].getPatientList();
                            flag=true;
                            break;
                        }
                    }
                    if(flag==false)
                        System.out.println("No doctor found with the entered name ");
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }
}
