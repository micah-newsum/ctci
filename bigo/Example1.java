package bigo;

public class Example1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        printSumAndProduct(array);
    }

    /**
     * The time complexity is O(N). The fact that we iterate through the array twice does not matter.
     * @param array
     */
    static void printSumAndProduct(int[] array) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }
        System.out.println(sum + ", "+ product);
    }
}
