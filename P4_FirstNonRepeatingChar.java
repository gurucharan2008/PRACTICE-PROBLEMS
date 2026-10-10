import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Week 1 Practice - Problem 4: First Non-Repeating Character
 */
public class P4_FirstNonRepeatingChar {

    static char findFirstNonRepeatingChar(String text) {
        // LinkedHashMap preserves insertion order
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0'; // sentinel for "not found"
    }

    public static void main(String[] args) {
        String[] tests = {"swiss", "aabbcc"};

        for (String text : tests) {
            char result = findFirstNonRepeatingChar(text);
            if (result == '\0') {
                System.out.println("\"" + text + "\" → No Non-Repeating Character Found");
            } else {
                System.out.println("\"" + text + "\" → First Non-Repeating Character: '" + result + "'");
            }
        }
    }
}
