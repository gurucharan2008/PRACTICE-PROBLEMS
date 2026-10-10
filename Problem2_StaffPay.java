import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class Problem2_StaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Staff[] staffs = new Staff[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];

            if (type.equals("FULLTIME")) {
                double salary = Double.parseDouble(parts[2]);
                staffs[i] = new FullTimeStaff(name, salary);
            } else if (type.equals("HOURLY")) {
                double hours = Double.parseDouble(parts[2]);
                double rate = Double.parseDouble(parts[3]);
                staffs[i] = new HourlyStaff(name, hours, rate);
            } else {
                double stipend = Double.parseDouble(parts[2]);
                staffs[i] = new InternStaff(name, stipend);
            }
        }

        for (Staff s : staffs) {
            double pay = s.calculatePay();
            System.out.printf("%s: %.2f%n", s.getName(), pay);
            total += pay;
        }
        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
