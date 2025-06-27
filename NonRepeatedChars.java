// NonRepeatedChars.java
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
public class NonRepeatedChars {
    public static void main(String[] args) {
        String input = "swissmississippi";

        // Step 1: Count character frequencies
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // Step 2: Filter non-repeated characters
        List<Character> nonRepeated = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Output
        System.out.println("Non-repeated characters: " + nonRepeated);
    }
}
/*
Explanation:
input.chars() converts the string to an IntStream.

.mapToObj(c -> (char) c) converts the int values to characters.

groupingBy(..., LinkedHashMap::new, ...) preserves insertion order.

.filter(entry -> entry.getValue() == 1) keeps only characters that appear once.
*/