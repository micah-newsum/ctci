public class Example5 {
    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 4, 5};
        int[] arrayB = {2, 1};
        printUnorderedPairs(arrayA, arrayB);       
    }

    /**
     * 100,000 units of work (inner most for loop) is still constant, 
     * so the runtime in O(AB)
     * @param arrayA
     * @param arrayB
     */
    static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                for (int k = 0; k < 100000; k++) {
                    System.out.println(arrayA[i]+","+arrayB[j]);
                }
            }
        }
    }
}
