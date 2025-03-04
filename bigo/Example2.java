public class Example2 {
    public static void main(String[] args) {
       int[] array = {1, 2, 3, 4, 5};
       printPairs(array); 
    }
    /**
     * The inner for loop has O(N) iterations and it is called O(N) times. Therefore,
     * the runtime is O(N^2).
     * 
     * Another way we can see this is by inspecting what the "meaning" of the code is.
     * It is printing all pairs (two-element sequences). There are O(N^2) pairs; therefore, 
     * the runtime is O(N^2).
     * @param array
     */
    static void printPairs(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                System.out.println(array[i]+", "+array[j]);
            }
        }
    }
}
