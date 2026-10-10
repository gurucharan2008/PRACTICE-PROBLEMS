public class L5_RotateArray {
    public int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return nums;
        }

        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
        // Optionally copy back, but returning new array as per signature
        return newArray;
    }

    public static void main(String[] args) {
        L5_RotateArray solution = new L5_RotateArray();
        int[] result1 = solution.rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.print("Sample 1: ");
        for (int num : result1) System.out.print(num + " ");
        System.out.println();

        int[] result2 = solution.rotateArray(new int[]{1, 2}, 3);
        System.out.print("Sample 2: ");
        for (int num : result2) System.out.print(num + " ");
        System.out.println();
    }
}
