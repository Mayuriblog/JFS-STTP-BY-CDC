/*
2. flatMap() Example:
The flatMap() operation transforms each element of a stream into a stream of zero or more elements, and then concatenates these resulting streams into a single, flat stream. It's used for one-to-many transformations and flattening nested structures. 
*/
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("red", "green"),
            Arrays.asList("blue", "yellow", "orange"),
            Arrays.asList("purple")
        );

        // Flatten the list of lists into a single list of all colors
        List<String> allColors = listOfLists.stream()
                                            .flatMap(List::stream) // Converts each inner list to a stream and flattens them
                                            .collect(Collectors.toList());

        System.out.println("List of lists: " + listOfLists);
        System.out.println("All colors: " + allColors); 
        // Output: All colors: [red, green, blue, yellow, orange, purple]
    }
}