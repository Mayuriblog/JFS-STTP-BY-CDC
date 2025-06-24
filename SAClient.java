import java.util.*;
class SAClient {
  public static void main(String rags[]) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter name");
    String name=sc.nextLine();
    System.out.println("Enter age");
    int age=sc.nextInt();
    sc.nextLine();
    
    try {
      SwimmerAdmission sa=new SwimmerAdmission();
      sa.admission(name, age);
    } catch(NotAllowedToSwimException ex1) {
      ex1.printStackTrace();
    }  
    
  }
}