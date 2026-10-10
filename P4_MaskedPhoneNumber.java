/**
 * Week 2 Practice - Problem 4: Masked Phone Number Formatter
 */
public class P4_MaskedPhoneNumber {

    static String maskPhoneNumber(String phone) {
        // Validate: exactly 10 digits
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Build masked version: XXXXXX-last4
        StringBuilder sb = new StringBuilder("XXXXXX-");
        sb.append(phone.substring(6)); // last 4 digits
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210")); // XXXXXX-3210
        System.out.println(maskPhoneNumber("98765"));      // Invalid phone number
    }
}
