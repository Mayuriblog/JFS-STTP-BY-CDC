/*
Set:
----
List, Set, Map are 3 interfaces in java.util package comes under Collection API. But only List and Set comes under the heirarchy of Collection interface.

List is a ordered collection, that means values are stored at index 0,1,2,3,4,5,6....

Set is a unique, unordered collection, the value hashCode act as a index in this collection, hence order changes.

unique, unordered=> HashSet
unique, ordered=> LinkedHashSet
unique, natural ordered=> TreeSet
*/
// SetEx3.java
import java.util.*;
import java.util.stream.*;
class SetEx3 {
	public static void main(String rags[]) {
		//Set<String> set=new HashSet<String>();
		Set <String> set=new LinkedHashSet<String>();
		//Set<String> set=new TreeSet<String>();
		set.add("Krishna Chaitanya");
		set.add("Navothna");
		set.add("Venu Malagavelli");
		set.add("Madhusudhan Reddy");
		set.add("Viswanath Allamraju");
		set.add("Shiva Raj");
		set.add("Veeranjaneyulu");
		set.add("Madhusudhan Reddy");
		set.add("Viswanath Allamraju");
		
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			String name=iter.next();
			//System.out.println(name+"--------->"+name.hashCode());
			System.out.println(name);
		}
		System.out.println("****************");

	}
} 




