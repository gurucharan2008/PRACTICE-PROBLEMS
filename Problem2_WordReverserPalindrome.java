import java.util.Scanner;

public class Problem2_WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String word = sc.nextLine().trim();
            if (word.isEmpty()) continue;

            StringBuilder sb = new StringBuilder(word);
            String reversed = sb.reverse().toString();

            boolean isPalindrome = word.equalsIgnoreCase(reversed);
            String status = isPalindrome ? "palindrome" : "not a palindrome";

            System.out.println(reversed + " - " + status);
        }
        sc.close();
    }
}
