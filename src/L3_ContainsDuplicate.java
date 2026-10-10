public class L3_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L3_ContainsDuplicate solution = new L3_ContainsDuplicate();
        System.out.println("Sample 1: " + solution.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println("Sample 2: " + solution.containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}
