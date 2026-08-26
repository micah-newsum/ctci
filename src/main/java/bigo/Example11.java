package bigo;

public class Example11 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    /**
     * Time complexity: O(N)
     * There will be at most N function calls.
     * 
     * Space complexity: O(N)
     * There will be at most N function calls added to the call stack.
     * 
     * factorial(3)
     *      -> 3 * factorial(2) returns 6 to caller
     *          -> 2 * factorial(1) returns 2 to caller
     *              -> 1 * factorial(0) returns 1 to caller
     * @param n
     * @return
     */
    static int factorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
