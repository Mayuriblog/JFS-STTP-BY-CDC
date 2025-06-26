import java.util.*;
class ALEx2
{
	public static void main(String args[])
	{
		List<Integer> marks=new ArrayLIst<Integer>();
		marks.add(75);
		marks.add(65);
		marks.add(55);
		marks.add(45);
		marks.add(35);
		//retrieving data from ArrayLIst in 4 ways
		//1.finding size , iterating loop
		int size=marks.size();
		for(int i=0;i<size;i++)
		{
			int mark=marks.get(i); //auto unboxing
			System.out.println(mark);
		}
		System.out.println("********************************");
		//using Iterator
		Iterator<Integer> iter=marks.iterator();
		while(iter.hasNext())
		{
			int mark=iter.next();
			System.out.println(mark);
		}
		System.out.println("********************************");
	}
}