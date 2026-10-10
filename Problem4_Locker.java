public class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.combination.equals(currentCode)) {
            this.combination = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Rejected: wrong current code");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    // No getter for combination

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
        // Cannot read the code from outside
    }
}
