// SetEx4.java
/* HashSet and TreeSet are arranging elements in natural order, 
LinkedHashSet arranges in given order */
import java.util.*;
import java.util.stream.*;
class SetEx4 {
  public static void main(String rags[]) {
    //Set<Integer> set=new HashSet<Integer>();
    //Set<Integer> set=new LinkedHashSet<Integer>();
     Set<Integer> set=new TreeSet<Integer>();
    set.add(4);
    set.add(3);
    set.add(5);
    set.add(2);
    set.add(1);
    set.add(6);
    set.add(5);
    set.add(4);
    set.add(3);
    
    Iterator<Integer> iter=set.iterator();
    while(iter.hasNext()) {
      int i=iter.next();
      System.out.println(i);
    }
    System.out.println("****************");

  }
}