/*
The map() and flatMap() operations are fundamental to working with streams, particularly in languages like Java, and serve distinct purposes in data transformation.
1. map() Example:
The map() operation transforms each element of a stream into a single, corresponding element of a new stream. It's used for one-to-one transformations.
*/
// StreamMapExample.java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Transform each word to its uppercase equivalent
        List<String> upperCaseWords = words.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());

        System.out.println("Original words: " + words);
        System.out.println("Uppercase words: " + upperCaseWords); 
        // Output: Uppercase words: [APPLE, BANANA, CHERRY]
    }
}