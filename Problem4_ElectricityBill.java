import java.util.Scanner;

abstract class Connection {
    protected int units;
    protected String type;

    public Connection(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public abstract double calculateBill();

    public String getType() {
        return type;
    }
}

class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return 5.0 * units;
        } else {
            return 5.0 * 100 + 7.0 * (units - 100);
        }
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return 8.0 * units + 100;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        double bill = 6.0 * units;
        return Math.max(bill, 1000.0);
    }
}

public class Problem4_ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Connection[] connections = new Connection[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            if (type.equals("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else {
                connections[i] = new FactoryConnection(units);
            }
        }

        for (Connection c : connections) {
            double bill = c.calculateBill();
            System.out.printf("%s: %.2f%n", c.getType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
