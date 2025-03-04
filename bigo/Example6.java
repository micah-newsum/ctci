public class Example6 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reverse(array);
    }

    /**
     * The algorithm runs in O(N) time. The fact that it only 
     * goes through half of the array (in terms of iterations) does
     * not impact big O time.
     * @param array
     */
    static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int otherIdx = array.length - i - 1;
            int temp = array[i];
            array[i] = array[otherIdx];
            array[otherIdx] = temp;
        }
        
        StringBuilder arrayString = new StringBuilder(5);
        for (int i = 0; i < array.length; i++){
            arrayString.append(Integer.toString(array[i]));
            if (i < array.length - 1) {
                arrayString.append(", ");
            }
        }
        System.out.println(arrayString.toString());
    }
}
