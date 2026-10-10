import java.util.Scanner;

abstract class Booking {
    protected String mode;
    protected double distance;
    protected static final double BOOKING_FEE = 50.0;

    public Booking(String mode, double distance) {
        this.mode = mode;
        this.distance = distance;
    }

    public abstract double calculateBaseFare();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    public String getMode() {
        return mode;
    }
}

class BusBooking extends Booking {
    public BusBooking(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateBaseFare() {
        return 2.0 * distance;
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateBaseFare() {
        return 1.5 * distance;
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distance) {
        super("FLIGHT", distance);
    }

    @Override
    public double calculateBaseFare() {
        return 2500 + 4.0 * distance;
    }
}

public class Problem5_TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String mode = parts[0];
            double distance = Double.parseDouble(parts[1]);

            if (mode.equals("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else {
                bookings[i] = new FlightBooking(distance);
            }
        }

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f%n", b.getMode(), b.calculateTotal());
        }
        sc.close();
    }
}
