import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return 2.0 * daysLate;
    }
}

class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = 5.0 * daysLate;
        return Math.min(fine, 50.0);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return 1.0 * daysLate;
    }
}

public class Problem3_LibraryFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LibraryItem[] items = new LibraryItem[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String title = parts[1];
            int days = Integer.parseInt(parts[2]);

            if (type.equals("BOOK")) {
                items[i] = new Book(title, days);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title, days);
            } else {
                items[i] = new Magazine(title, days);
            }
        }

        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
            total += fine;
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
