import java.util.Scanner;

abstract class Plot {
    protected String owner;
    protected String shape;

    public Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }

    public abstract double calculateArea();

    public String getOwner() {
        return owner;
    }

    public String getShape() {
        return shape;
    }
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length, width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base, height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Problem1_GardenPlot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Plot[] plots = new Plot[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String shape = parts[0];
            String owner = parts[1];

            if (shape.equals("CIRCLE")) {
                double radius = Double.parseDouble(parts[2]);
                plots[i] = new CirclePlot(owner, radius);
            } else if (shape.equals("RECTANGLE")) {
                double length = Double.parseDouble(parts[2]);
                double width = Double.parseDouble(parts[3]);
                plots[i] = new RectanglePlot(owner, length, width);
            } else {
                double base = Double.parseDouble(parts[2]);
                double height = Double.parseDouble(parts[3]);
                plots[i] = new TrianglePlot(owner, base, height);
            }
        }

        for (Plot p : plots) {
            double area = p.calculateArea();
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.getShape(), area);
            total += area;
        }
        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
