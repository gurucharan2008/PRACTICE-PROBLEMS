/**
 * Week 1 Practice - Problem 2: Palindrome Checker (3 Approaches)
 */
public class P2_PalindromeChecker {

    // Approach 1: Iterative — compare from both ends
    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive
    static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return isPalindromeRecursiveHelper(text, left + 1, right - 1);
    }

    // Approach 3: Array reversal
    static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        char[] reversed = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return text.equals(new String(reversed));
    }

    static String label(boolean result) {
        return result ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        String[] tests = {"madam", "hello"};

        for (String text : tests) {
            System.out.println("Input: \"" + text + "\"");
            System.out.println("Iterative: " + label(isPalindromeIterative(text))
                    + " | Recursive: " + label(isPalindromeRecursive(text))
                    + " | Array Reversal: " + label(isPalindromeArrayReversal(text)));
            System.out.println();
        }
    }
}
