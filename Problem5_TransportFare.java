import java.util.Scanner;

abstract class Transport {
    protected String type;
    protected double distance;

    public Transport(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public abstract double calculateFare();

    public String getType() {
        return type;
    }
}

class Bus extends Transport {
    public Bus(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2 + 0.10 * distance;
        return Math.min(fare, 10);
    }
}

class Train extends Transport {
    public Train(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class Problem5_TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Transport[] journeys = new Transport[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double dist = Double.parseDouble(parts[1]);

            if (type.equals("BUS")) {
                journeys[i] = new Bus(dist);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new Train(dist);
            } else {
                double factor = Double.parseDouble(parts[2]);
                journeys[i] = new Metro(dist, factor);
            }
        }

        for (Transport t : journeys) {
            double fare = t.calculateFare();
            System.out.printf("%s: %.2f%n", t.getType(), fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
