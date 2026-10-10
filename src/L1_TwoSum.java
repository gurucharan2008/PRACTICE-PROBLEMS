public class L1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // should not reach here as per problem
    }

    public static void main(String[] args) {
        L1_TwoSum solution = new L1_TwoSum();
        int[] result1 = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Sample 1: [" + result1[0] + ", " + result1[1] + "]");
        int[] result2 = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("Sample 2: [" + result2[0] + ", " + result2[1] + "]");
    }
}
