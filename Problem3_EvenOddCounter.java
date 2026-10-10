import java.util.Scanner;

public class Problem3_EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        // Expect something like [3, 8, 12, 5, 7, 10]
        line = line.replace("[", "").replace("]", "").trim();
        String[] parts = line.split(",\\s*");

        int even = 0;
        int odd = 0;

        for (String part : parts) {
            if (part.isEmpty()) continue;
            int num = Integer.parseInt(part);
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
