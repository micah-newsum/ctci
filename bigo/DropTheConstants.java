public class DropTheConstants {
   public static void main(String[] args) {
    int[] array = {1, 2, 10, 4, -5};
    printMinMaxSingleForLoop(array);
    printMinMaxTwoForLoops(array);
   }

   /**
    * The time complexity of this algorithm is O(N)
    * @param array
    */
   static void printMinMaxSingleForLoop(int[] array) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i : array) {
        if (i < min) min = i;
        if (i > max) max = i;
    }
    printMinMax(min, max);
   }

   /**
    * The time complexity of this algorithm is O(N).
    * One may be tempted to say O(2N) because of the 2 (non-nested) for loops
    * but this is incorrect.
    * @param array
    */
   static void printMinMaxTwoForLoops(int[] array) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i : array) {
        if (i < min) min = i;
    }
    for (int i : array) {
        if (i > max) max = i;
    }
    printMinMax(min, max);
   }

   private static void printMinMax(int min, int max) {
    System.out.printf("min: %d, max: %d\n", min, max);
   }
}
