/*
Intermediate operations in Java 8 Streams transform 
a stream into another stream. They are "lazy",
 meaning they only execute when a terminal operation is called.
 Common examples include 
filter, map, distinct, sorted, limit, skip, and flatMap.
*/
// StreamIntermediateOperations.java
import java.util.*;
import java.util.stream.*;
class StreamIntermediateOperations {
	public static void main(String rags[]) {
		
		/*1. filter():
			Selects elements based on a predicate (boolean-valued function). 
		*/
		System.out.println("\nPrinting the name start with A using filter method");
		System.out.println("------------------------------------");
				List<String> names1=Arrays.asList("Ankit", "Anikate",
				"Anmol", "Bhairav", "Balu", "Candy", "Chinna", "Deva","Ankit");
				names1.stream()
				.filter(name -> name.startsWith("A"))
				.forEach(System.out::println);
				
		System.out.println("\nPrinting the name start with A in the list wise");	
		System.out.println("------------------------------------");		
				String names2[]={"Ankit", "Anikate", "Anmol", 
				"Bhairav", "Balu", "Candy", "Chinna", "Deva","Ankit"};
				List<String> nameList1=Arrays.stream(names2)
				.filter(name-> name.startsWith("A"))
				.collect(Collectors.toList());
				System.out.println(nameList1);
		
		System.out.println
		("\nPrinting the name start with A or start with C with Uppercase in the sorted list wise");	
		System.out.println("------------------------------------");	
				String names3[]={"Ankit", "Anikate", "Anmol", 
				"Bhairav", "Balu", "Candy", "Chinna", "Deva","Ankit"};
				List<String> nameList2=Arrays.stream(names3)
				.filter(name-> name.startsWith("A") || name.startsWith("C"))
				.distinct()
				.sorted()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
				System.out.println(nameList2);
		
		
		/*
		2. map():
		Transforms each element of the stream into another object using a function.
		*/
		System.out.println
		("\nPrinting the multiples of 2 for each number in the given list ");	
		System.out.println("------------------------------------");	
				List<Integer> numbers1=Arrays.asList(10, 20, 11, 28, 23, 25, 15, 18);
				System.out.println(numbers1);
				System.out.println("++++++++++++++++++++++++++++++++");	
				/*numbers1.stream().map(n -> n * 2)
				.forEach(System.out::println);*/
				List<Integer> numbers11=numbers1.stream()
				.map(n -> n * 2).collect(Collectors.toList());
				System.out.println(numbers11);
		
		/*
		3. sorted(): Sorts the stream elements. 
		*/
		System.out.println
		("\nPrint the given numbers in the sorted list ");	
		System.out.println("------------------------------------");	
				List<Integer> unsortedNumbers = Arrays.asList(5, 2, 8, 1, 9);
				List<Integer> sortedNumbers = unsortedNumbers.stream()
													 .sorted()
													 .collect(Collectors.toList());
				System.out.println(sortedNumbers);
		/*
		4. distinct(): Removes duplicate elements.
		*/
		System.out.println
		("\nPrint the  numbers in the list without duplicates ");	
		System.out.println("------------------------------------");	
				List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
				List<Integer> distinctNumbers = numbersWithDuplicates.stream()
															.distinct()
															.collect(Collectors.toList());
				System.out.println(distinctNumbers);
		/*
		5. limit(): Returns a stream consisting of the first n elements.
		*/
		
		System.out.println
		("\nPrint the numbers for the first n elements in the list ");	
		System.out.println("------------------------------------");	
				List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
				List<Integer> firstThree = numbers2.stream()
													  .limit(3)
													  .collect(Collectors.toList());
				System.out.println(firstThree); 
		/*
		6. skip(): Skips the first n elements. 
		*/
		System.out.println
		("\n Skips the first n elements and Print the remaining numbers in the list ");	
		System.out.println("------------------------------------");	
			List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			List<Integer> skippedNumbers = numbers3.stream()
												 .skip(3)
												 .collect(Collectors.toList());
											 
			System.out.println(skippedNumbers);
		/*
		7. flatMap(): Flattens a stream of collections into a single stream. 
		*/
		System.out.println
		("\nFlattens a stream of collections into a single stream.");	
		System.out.println("------------------------------------");	
			List<List<Integer>> listOfLists = Arrays.asList(
				Arrays.asList(1, 2),
				Arrays.asList(3, 4),
				Arrays.asList(5, 6)
			);
			List<Integer> flattenedList = listOfLists.stream()
													 .flatMap(List::stream)
													 .collect(Collectors.toList());
			System.out.println(flattenedList);
	   /*
		8. peek(): Performs an action on each element but 
		doesn't modify the stream (primarily used for debugging). 
		*/
		System.out.println
		("\nPerforms an action on each element but  doesn't modify the stream ");	
		System.out.println("------------------------------------");
			List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);
			List<Integer> peekedNumbers = 
			numbers4.stream()
			.peek(n -> System.out.println("Processing: " + n))
											  .collect(Collectors.toList());
			System.out.println(peekedNumbers);				  	
			// This will print "Processing: 1", "Processing: 2", etc.,
			//before collecting the original numbers
	}
}
/*  output +++++++++++++++++++++++++++++++++++++++++++++ 
E:\JFS_STTP_BY_CDC>java StreamIntermediateOperations

Printing the name start with A using filter method
------------------------------------
Ankit
Anikate
Anmol
Ankit

Printing the name start with A in the list wise
------------------------------------
[Ankit, Anikate, Anmol, Ankit]

Printing the name start with A or start with C with Uppercase in the sorted list wise
------------------------------------
[ANIKATE, ANKIT, ANMOL, CANDY, CHINNA]

Printing the multiples of 2 for each number in the given list
------------------------------------
[10, 20, 11, 28, 23, 25, 15, 18]
++++++++++++++++++++++++++++++++
[20, 40, 22, 56, 46, 50, 30, 36]

Print the given numbers in the sorted list
------------------------------------
[1, 2, 5, 8, 9]

Print the  numbers in the list without duplicates
------------------------------------
[1, 2, 3, 4, 5]

Print the numbers for the first n elements in the list
------------------------------------
[1, 2, 3]

 Skips the first n elements and Print the remaining numbers in the list
------------------------------------
[4, 5, 6, 7, 8, 9, 10]

Flattens a stream of collections into a single stream.
------------------------------------
[1, 2, 3, 4, 5, 6]

Performs an action on each element but  doesn't modify the stream
------------------------------------
Processing: 1
Processing: 2
Processing: 3
Processing: 4
Processing: 5
[1, 2, 3, 4, 5]

E:\JFS_STTP_BY_CDC>
*/
/*
stream intermediate functions example
https://www.geeksforgeeks.org/java/intermediate-methods-of-stream-in-java/
*/