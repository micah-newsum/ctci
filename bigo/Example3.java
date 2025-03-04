public class Example3 {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        printUnorderedPairs(array);
    }

    /**
     * There are several ways to derive the runtime of this algorithm.
     * One way is to count the iterations. For example, the first time through,
     * j runs for N - 1 steps. The second time, N - 2 steps. Then, N - 3 steps. And
     * so on.
     * Therefore, the sum total of steps is (N - 1) + (N - 2) + (N - 3) + ... + 2 +
     * 1
     * which is equal to 1 + 2 + 3 + ... + N - 1, and the sum of 1 through N - 1 is
     * N(N - 1)/2. Therefore, the runtime will be O(N^2)
     * 
     * @param array
     */
    static void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.println("(" + array[i] + "," + array[j] + ")");
            }
        }
    }
}
