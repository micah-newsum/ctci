public class Example4 {
    public static void main(String[] args) {
        int[] arrayA = { 12, 3, 9 };
        int[] arrayB = { 6, 4, 2 };
        printUnorderedPairsTwoArrays(arrayA, arrayB);
    }

    /**
     * For each element of arrayA, the inner for loop goes through b iterations,
     * where b = arrayB.length. If a = arrayA.length, then the runtime is O(ab)
     * 
     * @param arrayA
     * @param arrayB
     */
    static void printUnorderedPairsTwoArrays(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] < arrayB[j]) {
                    System.out.println(arrayA[i] + ", " + arrayB[j]);
                }
            }
        }
    }
}
