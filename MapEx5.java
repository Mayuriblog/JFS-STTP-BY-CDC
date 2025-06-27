/*
Map:
----------
Map is a part Collection API, but not part of Collection interface heirarchy. 
Map like Hashtable stores key and value pairs as entries (one-one entry).

In Map key must be unique, value can duplicate.
Only one null key and any number of null values are allowed.
Duplicate keys are overriden in Map.

HashMap - unique, unordered keys
LinkedHashMap - unique, given ordered keys
TreeMap - unique, natural ordered keys
*/
// MapEx5.java
import java.util.*;
import java.util.stream.*;
class MapEx5 {
  public static void main(String rags[]) {
    // Map<String,Integer> marks=new HashMap<String,Integer>();
    // Map<String,Integer> marks=new LinkedHashMap<String,Integer>();
    Map<String,Integer> marks=new TreeMap<String,Integer>();
    
    // int 75 will be taken as Integer, converting int into Integer is called auto-boxing
    marks.put("Social", 75); 
    marks.put("Science", 85); 
    marks.put("Maths", 75); 
    marks.put("English", 90); 
    marks.put("Telugu", 80); 
    marks.put("Hindi", 75);
    marks.put("Maths", 90); 
    
    Set<String> keys=marks.keySet();
    Iterator<String> iter=keys.iterator();
    while(iter.hasNext()) {
      String key=iter.next();
      int value=marks.get(key);
      System.out.println(key+" "+value);
    }
    System.out.println("******************");
    
    for(String key:keys) {
      int value=marks.get(key);
      System.out.println(key+" "+value);
    }
    
    
    
    
  }
}