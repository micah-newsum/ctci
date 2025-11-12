package additionalproblems;

import java.util.Arrays;

public class V1_12 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        System.out.println(intersection(a, b));
    }

    private static int intersection(int[] a, int[] b) {
        Arrays.sort(b); // assume merge sort runtime of O(b)*log(b)
        int intersect = 0;

        // O(a)
        for (int x : a) {
            // log(b)
            if (Arrays.binarySearch(b, x) >= 0) {
                intersect++;
            }
        }
        return intersect;
    }
}
