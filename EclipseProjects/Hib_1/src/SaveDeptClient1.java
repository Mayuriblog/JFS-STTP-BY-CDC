import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SaveDeptClient1 {

  public static void main(String[] args) throws Exception {
    Session session=HSFactory.getSession();
    Transaction t=session.beginTransaction();
    try {
      Emp e1=new Emp(0, "ABC", 50000.00, "Designer", null);
      Emp e2=new Emp(0, "XYZ", 50000.00, "Developer", null);
      Emp e3=new Emp(0, "LMN", 50000.00, "Architect", null);
      List<Emp> empList=new ArrayList<Emp>();
      empList.add(e1); empList.add(e2); empList.add(e3); 
      Dept d1=new Dept(0, "Development", "Ameerpet", empList);
      session.save(d1);
      session.flush();
      t.commit();
      System.out.println("TX Success");
    } catch(Exception e) {
      t.rollback();
      System.out.println("TX Failed");
      e.printStackTrace();
    }
    session.close();
  }
}