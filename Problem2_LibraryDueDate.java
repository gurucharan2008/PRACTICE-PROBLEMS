import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract LocalDate calculateDueDate();

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(14);
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(3);
    }
}

public class Problem2_LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LibraryItem[] items = new LibraryItem[n];
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));

            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title);
            } else {
                items[i] = new Magazine(title);
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate().format(fmt));
        }
        sc.close();
    }
}
