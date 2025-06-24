// VectorEx1.java
import java.util.*;
class VectorEx1 {
	public static void main(String rags[]) {
		Vector v=new Vector();
		v.add(new Integer(3));
		v.add("Kohli");
		v.add(new Double(2500.00));
		
		int size=v.size();
		for(int i=0;i<size;i++) {
			Object o=v.get(i);
			System.out.println(o);
		}
		System.out.println("**********************");
		Enumeration en=v.elements();
		while(en.hasMoreElements()) {
			Object o=en.nextElement();
			if(o instanceof Integer) {
				Integer in=(Integer)o;
				int j=in.intValue();
				System.out.println(j);
			} else if(o instanceof Double) {
				System.out.println(((Double)o).doubleValue());
			} else {
				System.out.println((String)o);
			}
		}	
		System.out.println("**********************");
		Iterator it=v.iterator();
		while(it.hasNext()) {
			Object o=it.next();
			System.out.println(o);
		}
	}
}
