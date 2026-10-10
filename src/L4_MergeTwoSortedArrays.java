public class L4_MergeTwoSortedArrays {
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            result[k++] = arr1[i++];
        }
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        L4_MergeTwoSortedArrays solution = new L4_MergeTwoSortedArrays();
        int[] result1 = solution.mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        System.out.print("Sample 1: ");
        for (int num : result1) System.out.print(num + " ");
        System.out.println();

        int[] result2 = solution.mergeSortedArrays(new int[]{}, new int[]{1, 2, 3});
        System.out.print("Sample 2: ");
        for (int num : result2) System.out.print(num + " ");
        System.out.println();
    }
}
