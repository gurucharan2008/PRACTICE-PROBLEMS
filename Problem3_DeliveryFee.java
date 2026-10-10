import java.util.Scanner;

abstract class Delivery {
    protected String type;
    protected double weight;
    protected double distance;

    public Delivery(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();

    public String getType() {
        return type;
    }
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class Problem3_DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Delivery[] deliveries = new Delivery[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            if (type.equals("STANDARD")) {
                deliveries[i] = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                deliveries[i] = new ExpressDelivery(weight, distance);
            } else {
                double customs = Double.parseDouble(parts[3]);
                deliveries[i] = new InternationalDelivery(weight, distance, customs);
            }
        }

        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            System.out.printf("%s: %.2f%n", d.getType(), fee);
            total += fee;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
