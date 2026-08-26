package bigo;

public class AddVersusMultiply {
    public static void main(String[] args){
        int [] arrA = {1, 2, 3, 4, 5};
        int[] arrB = {6, 7, 8 , 9, 10, 11, 12};
        add(arrA, arrB);
        multiply(arrA, arrB);
    }
    
    /**
     * We do A chunks work then B chunks of work. Therefore, the total amount of work is O(A + B).
     * @param arrA
     * @param arrB
     */
    static void add(int [] arrA, int[] arrB) {
        for (int i : arrA) System.out.println(i);
        for (int j : arrB) System.out.println(j);
    }

    /**
     * We do B chunks of work for each element in A. Therefore, the total amount of work is O(A * B).
     * @param arrA
     * @param arrB
     */
    static void multiply(int [] arrA, int[] arrB) {
        for (int i : arrA) {
            for (int j : arrB) {
                System.out.printf("%d, %d\n", i, j);
            }
        }
    }
}
