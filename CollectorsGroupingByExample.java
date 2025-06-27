import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class CollectorsGroupingByExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Collect elements into a List
        List<String> collectedNames = names.stream()
                                            .filter(name -> name.startsWith("A"))
                                            .collect(Collectors.toList());
        System.out.println("Names starting with 'A': " + collectedNames); // Output: [Alice]

        // Grouping elements by length
        java.util.Map<Integer, List<String>> namesByLength = names.stream()
                                                                  .collect(Collectors.groupingBy(String::length));
        System.out.println("Names grouped by length: " + namesByLength); 
		// Output: {3=[Bob], 5=[Alice, David], 7=[Charlie]}
    }
}