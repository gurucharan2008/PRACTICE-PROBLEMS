import java.util.Scanner;

abstract class Payment {
    protected double amount;
    protected String type;

    public Payment(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public String getType() {
        return type;
    }
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super("CARD", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02; // 2% fee
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super("WALLET", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01; // 1% fee
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super("BANKTRANSFER", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount; // no fee
    }
}

public class Problem1_PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Payment[] payments = new Payment[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double amt = Double.parseDouble(parts[1]);

            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amt);
            } else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amt);
            } else {
                payments[i] = new BankTransferPayment(amt);
            }
        }

        for (Payment p : payments) {
            double adjusted = p.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", p.getType(), adjusted);
            total += adjusted;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
