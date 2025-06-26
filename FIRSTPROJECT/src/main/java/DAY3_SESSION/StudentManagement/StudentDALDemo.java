package DAY3_SESSION.StudentManagement;
import java.util.*;
public class StudentDALDemo {
    public static  void main(String args[])
    {
        StudentDAL dao=new StudentDALImpl();
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("\n -- Student Management Menu --");
            System.out.println("\n 1. Add Student");
            System.out.println("\n 2. View Student By Id");
            System.out.println("\n 3. View All Students");
            System.out.println("\n 4. Update Student Marks");
            System.out.println("\n 5. Delete Student");
            System.out.println("\n 6. Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter id: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name: ");
                    String name=sc.nextLine();
                    System.out.println("Enter marks: ");
                    double marks=sc.nextDouble();
                    sc.nextLine();
                    dao.addStudent(new Student(id,name,marks));
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.println("Enter student id to search: ");
                    id=sc.nextInt();
                    sc.nextLine();
                    Student student=dao.getStudentById(id);
                    if(student!=null)
                    {
                        System.out.println(student);
                    }
                    else
                    {
                        System.out.println("student not found ");
                    }
                    break;
                case 3:
                    System.out.println("All Students: ");
                    dao.getAllStudents().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Enter Student Id to update marks: ");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter marks: ");
                    marks=sc.nextDouble();
                    sc.nextLine();
                    boolean updated=dao.updateStudentMarks(id,marks);
                    if(updated)
                    {
                        System.out.println("student updated successfully ");
                    }
                    else {
                        System.out.println("student not found ");
                    }
                    break;
                case 5:
                    System.out.println("Enter student Id to delete: ");
                    id=sc.nextInt();
                    sc.nextLine();
                    boolean deleted=dao.deleteStudent(id);
                    if(deleted)
                    {
                        System.out.println("Student deleted. ");
                    }
                    else {
                        System.out.println("student not found ");
                    }
                    break;
                case 6:
                    System.out.println("Exiting Program");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
