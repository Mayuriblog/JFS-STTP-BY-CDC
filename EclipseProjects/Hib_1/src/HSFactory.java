import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HSFactory {
  static Session session;
  public static Session getSession() {
    try {
      if(session==null) {
        Configuration c=new Configuration();
        c.configure("/hibernate.cfg.xml");
        SessionFactory sf=c.buildSessionFactory();
        session=sf.openSession();
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return session;
  }
}