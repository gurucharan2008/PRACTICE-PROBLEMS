/**
 * Week 2 Practice - Problem 5: Bank Transaction Reference Generator & Validator
 * Valid: 3 letters (bank) + 6 digits (ddMMyy) + 5 digits (seq) = 14 chars
 */
public class P5_BankTransactionReference {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        String bank = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bank + rest;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length (must be exactly 14 characters)";
        }

        // First 3 must be letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Remaining 11 must be digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be digits only";
            }
        }

        // Format: [BANK] DATE: dd/MM/yy | SEQ: 12345
        // positions: 0-2 bank, 3-4 dd, 5-6 MM, 7-8 yy, 9-13 seq
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(reference.substring(0, 3));
        sb.append("] DATE: ");
        sb.append(reference.substring(3, 5)); // dd
        sb.append("/");
        sb.append(reference.substring(5, 7)); // MM
        sb.append("/");
        sb.append(reference.substring(7, 9)); // yy
        sb.append(" | SEQ: ");
        sb.append(reference.substring(9, 14)); // seq

        return sb.toString();
    }

    public static void main(String[] args) {
        String n1 = normalizeReference("  hdf03022600042  ");
        System.out.println(validateAndFormat(n1));
        // [HDF] DATE: 03/02/26 | SEQ: 00042

        String n2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(n2));
        // Invalid: bank code must be 3 letters
    }
}
