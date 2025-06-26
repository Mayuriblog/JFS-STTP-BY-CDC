import java.util.*;
import java.util.stream.*;
class ALEx2
{
	public static void main(String args[])
	{
		List<Integer> marks=new ArrayList<Integer>();
		marks.add(75);
		marks.add(65);
		marks.add(56);
		marks.add(44);
		marks.add(34);
		//retrieving data from ArrayLIst in 4 ways
		
		//1.finding size , iterating loop
		
		int size=marks.size();
		for(int i=0;i<size;i++)
		{
			int mark=marks.get(i); //auto unboxing
			System.out.println(mark);
		}
		System.out.println("********************************");
		
		//2.using Iterator
		
		Iterator<Integer> iter=marks.iterator();
		while(iter.hasNext())
		{
			int mark=iter.next();
			System.out.println(mark);
		}
		System.out.println("********************************");
		
		//3.using for each loop
		for(int mark:marks)
		{
			System.out.println(mark);
		}
		System.out.println("********************************");
		
		//4. using streams
		marks.stream().forEach(System.out::println);
		System.out.println("********************************");
		marks.stream().filter(mark->mark%2==0).sorted().forEach(System.out::println);
		System.out.println("********************************");
		
		//using collect() terminal function
		List<Integer> sortedMarks=marks.stream()
		.sorted().collect(Collectors.toList());
		
		System.out.println(sortedMarks);
	}
}